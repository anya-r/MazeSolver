public class MyLinkedList<T> 
{
    
    //2
    private ListNode head;
    private ListNode tail;
    private int size;

    private class ListNode
    {
		T val; //does a private inner class need private instance variables?
		ListNode next;

		public ListNode(T val) 
        { 
            this.val = val; 
        }

        @Override
		public String toString() 
        {
            return "" + this.val; 
        } 
        //for printing / debug 
	}

    public MyLinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }
    public MyLinkedList(T val)
    {
        head = new ListNode(val);
        size = 1;
        tail = head;
    }
    
    public MyLinkedList(T... vals)
	{
		if (head == null) 
            head = new ListNode(vals[0]);
        size++;
		ListNode current = head;

		for (int i = 1; i < vals.length; i++) {
			current.next = new ListNode(vals[i]);
			current = current.next;
            size++;
		}
	}
   
    //3
    public void add(T newVal)
    {
        if (isEmpty())
        {
            head = new ListNode(newVal);
            tail = head;
        }
        else
        {
            tail.next = new ListNode(newVal);
            tail = tail.next;
        }
        size++;
        
    }
    //4
    public boolean contains(T target)
    {
        ListNode temp = head;
        if (temp.val.equals(target))
            return true;
        while(temp.next != null)
        {
            if (temp.next.val.equals(target))
                return true;
            temp = temp.next;
        }
        return false;
    }
    //5
    public T get(int index)
    {
        ListNode temp = head;
        
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        else
        {
            while (index != 0)
            {
                temp = temp.next;
                index--;
            }
        }
        return temp.val;

    }
    //6
    public int indexOf(T target)
    {
        ListNode temp = head;
        int index = 0;
        while(temp != null)
        {
            if (temp.val.equals(target))
                return index;
            temp = temp.next;
            index++;
        }
        return -1;

    }
    //7 fog? or maybe dew

    //8 - ******
    public void set(T newVal, int index)
    {
        ListNode temp = head;
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        while (index != 0)
        {
            temp = temp.next;
            index--;
        }
        temp.val = newVal;
        
    }
    //9
    public int size()
    {
        return size;
    }
    public int sizeRecursive(ListNode current)
    {
        if (current.equals(null))
            return 0;
        else
            return 1 + sizeRecursive(current.next);

    }

    //10
    public boolean isEmpty()
    {
        if (head == null)
            return true;
        return false;
    }
    
    //11
    public T remove(int index)
    {
        //index out of bounds
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        // if empty
        if (isEmpty())
            return null;
       
        ListNode curr = head;
    
            if (index == 0) {
                size--;
                head = curr.next;
                return curr.val;
            }
    
            ListNode temp = null;
            for (int i = 1; i <= index; i++) {
                temp = curr;
                curr = curr.next;
            }
    
            temp.next = curr.next;
            size--;
    
            return curr.val;
    }
    //12
    public void add(T newVal, int index)
    {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        ListNode temp = head;
        ListNode add = new ListNode(newVal);
        if (index == 0)
        {
            add.next = head;
            head = add;
        }
        else
        {
            index--;
            while (index > 0)
            {
                temp = temp.next;
                index--;
            }
            add.next = temp.next;
            temp.next = add;

        }
        tail = temp.next;
        size++;
    }
    
    
    //13
    public String toString()
    {
        if (isEmpty())
            return "[]";
        String x = "[";
        ListNode temp = head;
        while (temp.next != null)
        {
            x += temp;
            if (temp.next != null)
            {
                x += ", ";
            }
            temp = temp.next;
        }
        x += temp;
        x += "]";
        return x;
    }

    //test
    public static void main(String[] args) {
		MyLinkedList<Double>  x = new MyLinkedList<>(1.0, 2.0, 3.0);
        System.out.println(x.size());
       
       
       
    }

}

