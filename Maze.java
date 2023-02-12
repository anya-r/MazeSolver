import java.io.*;
import java.util.*;


public class Maze
{
    private Square[][] maze;
    private Square start;
    private Square exit;

    public Maze()
    {
        
    }

    public boolean loadMaze(String fileName)
    {

        try {
            Scanner input = new Scanner(new File(fileName));
            int row = input.nextInt();
            int col = input.nextInt();
            maze = new Square[row][col];
            while (input.hasNextInt())
            {
                for (int r = 0; r < maze.length; r++)
                {
                    for (int c = 0; c < maze[0].length; c++)
                    {
                        int x = input.nextInt();
                        if (x == 2)
                            start = new Square(r, c, x);
                        if (x == 3)
                            exit = new Square(r, c, x);
                        maze[r][c] = new Square(r, c, x);
                    }
                }
            }


        }
        catch (Exception s) {  
            System.out.println("File does not exist");
            return false;
        }
        return true;

    }
    public List<Square> getNeighbors(Square s)
    {
        List<Square> neighbors = new ArrayList<Square>();
        int r = s.getRow();
        int c = s.getCol();
        if (c < maze[0].length - 1)
        neighbors.add(maze[r][c+1]);
        if (r > 0)
            neighbors.add(maze[r - 1][c]);
        if (c > 0)
            neighbors.add(maze[r][c-1]);
        if (r < maze.length - 1)
            neighbors.add(maze[r + 1][c]);
	
        return neighbors;
        
    }
    public Square getStart()
    {
        
        return start;
    }

    public Square getExit()
    {
        return exit;
    }

    public void reset()
    {
        for (int r = 0; r < maze.length; r++)
        {
            for (int c = 0; c < maze[0].length; c++)
            {
                maze[r][c].reset();
            }
        }
    }

    public String toString()
    {
        String grid = "";
        for (int r = 0; r < maze.length; r++)
        {
            for (int c = 0; c < maze[0].length; c++)
            {
               grid += maze[r][c].toString();
            }
            grid += "\n";
        }
        return grid;
    }

    



    
    
} 