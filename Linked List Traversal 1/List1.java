class List1
{
    Node1 start;
    List1()//default constructor
    {
        start=null;
    }

    void insert(int x)//inserts data in ascending order
    {
        Node1 T=new Node1();
        T.data=x;
        if(start==null)//checks if list is empty
        {
            start=T;
        }
        else
        if(x<start.data)//checks if x is less than the first element
        {
            T.next=start;
            start=T;
        }
        else
        {
            Node1 T1=new Node1();
            Node1 T2=new Node1();
            T1=start;
            T2=start;
            while(T2!=null)
            {
                if(x>=T1.data&&x<T2.data)
                {
                    T1.next=T;
                    T.next=T2;
                    break;
                }
                T1=T2;
                T2=T2.next;
            }
            if(T2==null)
            {
                T1.next=T;
            }
        }
    }

    boolean search(int x)//checks if x is present in the list
    {        
        boolean flag=false;
        Node1 T=new Node1();
        T=start;
        while(T!=null)
        {
            if(T.data==x)
            {
                flag=true;
                break;
            }
            else
            {
                T=T.next;
            }            
        }
        return flag;
    }

    void display()//displays all the elements of the list
    {
        Node1 T=new Node1();
        T=start;
        if(start==null)
        {
            System.out.println("Empty list");   
        }
        else
        {
            while(T!=null)
            {
                System.out.println(T.data);
                T=T.next;
            }
        }
    }
}
