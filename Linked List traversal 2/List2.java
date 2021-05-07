class List2
{
    Node2 start;
    List2()//default constructor
    {
        start=null;
    }

    void insert(int x)//inserts element at the back of the list
    {
        Node2 temp= new Node2();
        temp.data=x;
        if(start==null)//checks if list is empty
            start=temp;
        else
        {
            Node2 T=new Node2();
            T=start;
            while(T.next!=null)           
                T=T.next;                            
            T.next=temp;
        }
    }

    int count()//counts the number of nodes in the list
    {
        int ct=0;
        Node2 T=new Node2();
        T=start;
        while(T!=null)
        {
            ct++;
            T=T.next;   
        }
        return ct;
    }

    boolean remove(int x)//removes an element from the list if it is present
    {
        Node2 T1=new Node2();        
        T1=start;
        boolean flag=false;
        if(start==null)//checks if list is empty 
            return flag; 
        if(T1.next==null)
        {
            if(T1.data==x)
            {
                flag=true;
                start=null;
            }
        }
        else 
        if(T1.data==x)
        {
            flag=true;
            start=T1.next;
            T1=null;
        }
        else
        {
            while(T1!=null)
            {
                if(T1.next.data==x)//creates a new link and removes element
                {
                    flag=true;
                    Node2 T2=new Node2();
                    T2=T1.next;
                    T1.next=T1.next.next;
                    T2=null;
                    break;
                }
                T1=T1.next;
            }
        }
        return flag;
    }

    void reverse()//reverses order of nodes in the list
    { 
        Node2 T=new Node2();
        T=start;
        while(T!=null)
        {
            Node2 temp=new Node2();
            temp.data=T.data;
            temp.next=start;
            start=temp;
            T=T.next;
        }
        if(start==null)
            return;
        T=start;
        while(T.data!=T.next.data)
            T=T.next;
        T.next=null;
    }

    void display()//displays all nodes in the list
    {
        if(start==null)        
            System.out.println("Empty list");   
        else
        {
            Node2 T=new Node2();
            T=start;
            while(T!=null)
            {
                System.out.println(T.data);
                T=T.next;
            }
        }
    }
}
