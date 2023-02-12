public class MazeSolverQueue extends MazeSolver
{

    public MazeSolverQueue(Maze maze)
    {
        super(maze);
    }
    
    @Override
    public void makeEmpty()
    {
        this.queue.clear();
    }

    @Override
    public boolean isEmpty()
    {
        return this.queue.isEmpty();
    }

    @Override
    public void add(Square s)
    {
        this.queue.offer(s);
    }

    @Override
    public Square next()
    {
        return this.queue.peek();
    }
}
