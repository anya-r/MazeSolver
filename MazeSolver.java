import java.util.*;


abstract class MazeSolver

{
    protected Maze maze;
    protected MyStack list;
    protected MyQueue<Square> queue;
    String status = "Unsolved";

    public MazeSolver(Maze maze)
    {
        this.maze = maze;
        this.makeEmpty();
        Square s = maze.getStart();
        System.out.println("BREAK 1");


        this.add(s);
        System.out.println("BP 2");
        
    }

    abstract void makeEmpty();
    
    abstract boolean isEmpty();

    abstract void add(Square s);
    
    abstract Square next();



    public boolean isSolved()
    {        
        Square s = maze.getExit();
        if (s.getStatus() == Square.EXPLORED)
        {
            return true;
        }
        return false;
    }

    public void step()
    {
        
        Square s = this.next();
        if (this.isEmpty())
        {
            System.out.println("Exit is unreachable");
            this.status = "Unsolvable";
        }
        else if (s.getType() == Square.EXIT)
        {
            System.out.println("Maze is Solved!");
            this.status = "Solved";
            Square x = this.maze.getExit();
            x.setPrevious(s);
        }
        else
        {
            List<Square> neighbors = maze.getNeighbors(s);
            
            s.setStatus(Square.WORKING);
            list.pop();
            for (int i = 0; i < neighbors.size(); i++)
            {
                Square temp = neighbors.get(i);
                if (temp.getType() != Square.WALL && temp.getType() != Square.START)
                {
                    if (temp.getStatus() == Square.UNKNOWN)
                    {
                        list.push(temp);
                        temp.setPrevious(s);   
                    }
                    else
                    {
                        temp.setStatus(Square.EXPLORED);
                        isSolved();
                    }
                    
                }
            }

        }
    }
    


    public String getPath()
    {
        if (!this.status.equals("Solved"))
        {
            MyStack path = new MyStack();
            Square current = this.maze.getExit();
            while (current != maze.getStart()) 
            {
                path.push(current);
                current.setStatus(Square.ON_EXIT_PATH);
                current = current.getPrevious();
            }
            while (path.size() > 0)
            {
                this.status += (path.pop()).getCoordinates();
            }
            return this.status;
        }
        else
            return this.status;
	}


    public void solve()
    {
        while(!this.isSolved())
            this.step();
    }
    
}