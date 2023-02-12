
public class Square
{
    //position types
    final static int EMPTY = 0; //an empty space
	final static int WALL  = 1; //a wall
	final static int START = 2; //the start 
	final static int EXIT  = 3; //the exit

	//These values indicate the status of a particular Square while the maze is being solved, for the GUI
	final static char WORKING      = 'o'; //currently on the work list (the stack)
	final static char EXPLORED     = '.'; //done, already explored
	final static char ON_EXIT_PATH = 'x'; //on the exit path, used in a later lab
	final static char UNKNOWN      = '_'; //not known / visited yet (empty cells only)

	private int  row, col; //r, c location in the maze
	private int  type;     //type of this square, e.g. empty, wall, etc.
	private char status; 
    private Square previous;


    
    public Square(int row, int col, int type)
    {
        this.row = row;
        this.col = col;
        this.type = type;
        this.previous = null;
    }

    public String toString()
    {
        String x = status + "";
        if (status == WORKING)
            return x;
        if (status == EXPLORED)
            return x;
        if(type == EMPTY)
            return "_";
        else if(type == WALL)
            return "#";
        else if(type == START)
            return "S";
        else 
            return "E";
       
        
    }

    @Override
    public boolean equals(Object obj)
    {
        Square other = (Square) obj;
        if ((this.row == other.row) && (this.col == other.col))
            return true;
        return false;

    }
    
    public int getRow()
    {
        return row;
    }
    public int getCol()
    {
        return col;
    }
    public int getType()
    {
        return type;
    }
    public char getStatus()
    {
        return status;
    }
    public void setStatus(char status)
    {
        this.status = status;
    }

    
    public Square reset()
    {
        this.status = '_';
        previous = null;
        return this;
        
        
    }
    public void setPrevious(Square x)
    {
        this.previous = x;
    }
    public Square getPrevious()
    {
        return this.previous;
    }

    public String getCoordinates()
    {
        String x = "[";
        x += this.getRow() + ", ";
        x += this.getCol();
        x += "]";
        return x;
    }



}
