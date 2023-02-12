import java.util.*;
public class MyStack implements StackADT
{
    private Square[] stack;
    private int size;
   
    public MyStack()
    {
        this(8);
    }
   
    public MyStack(int initCap)
    {
        stack = new Square[initCap];
        size = 0;
    }
   
    public boolean isEmpty()
    {
        if (size == 0)
            return true;
        return false;
    }
   
    public Square peek()
    {
        if (isEmpty())
            throw new EmptyStackException();
        return stack[size - 1];
    }
   
    public Square pop()
    {
        if (isEmpty())
            throw new EmptyStackException();
        Square temp = stack[size - 1];
        stack[size - 1] = null;
        size--;
        return temp;
    }
    public void push(Square item)
    {
        if(size == stack.length)
            doubleCapacity();
        stack[size] = item;
        size++;
    
    }
    private void doubleCapacity()
    {
        Square[] doubleStack = new Square[stack.length * 2];
        for (int i = 0; i < stack.length; i++)
        {
            doubleStack[i] = stack[i];
        }
        stack = doubleStack;
    }

    @Override
    public String toString()
    {
        String str = "";
        for (int i = size - 1; i >= 0;  i--)
        {
            str += stack[i] + "\n";
        }
        return str;
    
    }

    public void clear()
    {
        while(size != 0)
        {
            stack[size - 1] = null;
            size--;
        }
    }

    public int size()
    {
        return size;
    }



}
