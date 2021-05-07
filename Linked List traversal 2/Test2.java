import java.io.*;

class Test2
{
    void main()throws IOException//implements all the above functions
    {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        List2 ob=new List2();
        int ch=0;
        System.out.print("Menu\n1.Insert\n2.Count\n3.Remove\n4.Reverse\n5.Display\n6.Exit\n");
        while(ch!=6)//menu driven options
        {
            System.out.print("Enter your choice: ");
            ch=Integer.parseInt(br.readLine());

            if(ch== 1)
            {
                System.out.print("Enter number: ");
                int x=Integer.parseInt(br.readLine());
                ob.insert(x);
            }
            if(ch== 2)
            {
                int y=ob.count();
                System.out.println("No. of nodes = "+y);
            }
            if(ch== 3)
            {
                System.out.print("Enter number to be removed: ");
                int z=Integer.parseInt(br.readLine());
                boolean b=ob.remove(z);
                if(b==true)
                {
                    System.out.println(z+" was removed");
                }
                else
                {
                    System.out.println("Number not there");
                }
            }
            if(ch== 4)
            {
                ob.reverse();
            }
            if(ch== 5)
            {
                ob.display();
            }
            if(ch== 6)
            {
                System.exit(6);
            }
        }
    }
}
