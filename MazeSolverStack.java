public class MazeSolverStack extends MazeSolver
{
    
    public MazeSolverStack(Maze maze)
    {
        super(maze);
    }
    
    @Override
    public void makeEmpty()
    {
       this.list = new MyStack();
    }

    @Override
    public boolean isEmpty()
    {
        return this.list.isEmpty();
    }

    @Override
    public void add(Square s)
    {
        this.list.push(s);
    }

    @Override
    public Square next()
    {
        return this.list.peek();
    }
    

}