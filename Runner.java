public class Runner
{
    public static void main(String[] args) 
    {
        Maze x = new Maze();
        x.loadMaze("maze-2");
        System.out.println(x.toString());
        Square s = new Square(0, 0, 0);
        System.out.println(x.getNeighbors(s));
       

    }
}