import java.util.Stack;
public class MyStackRunner
{
   public static void main(String args[])
   {
    MyStack mine = new MyStack();
    Stack<Square> javas = new Stack<>();
    Square s = new Square(0, 0, 2);

    mine.push(s);
    javas.push(s);
    //System.out.println(mine);
    System.out.println(javas);
   //  mine.peek();
   //  javas.peek();
   //  System.out.println(mine);
   //  System.out.println(javas);
   //  mine.push(7);
   //  mine.pop();
   //  mine.pop();
   //  System.out.println(mine);
    
   }

}