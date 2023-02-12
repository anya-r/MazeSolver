public class MyQueue<T> implements QueueADT<T>
{
    MyLinkedList<T> queue;

    public MyQueue()
    {
        queue = new MyLinkedList<>();
    }
    public MyQueue(T... vals)
    {
        queue = new MyLinkedList<>(vals);
    }

    public boolean isEmpty()
    {
        if (queue.size() == 0)
            return true;
        return false;

    }
    public void offer(T item)
    {
        queue.add(item, queue.size());

    }
    public T poll()
    {
        T temp = queue.remove(0);
        return temp;

    }

    public int size()
    {
        return queue.size();
    }

    public void clear()
    {
        while (size() > 0)
        {
            queue.remove(0);
        }

    }

    public T peek()
    {
        T temp = queue.get(0);
        return temp;

    }
    
    public static void main(String[] args) {
        MyQueue<Integer> x = new MyQueue<>();
        System.out.println(x.isEmpty());
        while (x.size() > 0)
        {
            System.out.print(x.poll() + " ");
        }

       
       



    }
}
