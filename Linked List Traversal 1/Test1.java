import java.io.*;
public class Test1
{
    void main()throws IOException//implements above classes and functions
    {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        List1 ob=new List1();
        int ch=0;
        System.out.print("Menu\n1.Insert\n2.Search\n3.Display\n4.Exit\n ");

        while(ch!=4)
        {
            
            System.out.println("Enter your choice:");
            ch=Integer.parseInt(br.readLine());

            if(ch==1)
            {
                System.out.print("Enter number: ");
                int x=Integer.parseInt(br.readLine());
                ob.insert(x);
            }

            else if(ch==2)
            {
                System.out.print("Enter search element: ");
                int y=Integer.parseInt(br.readLine());
                boolean b=ob.search(y);
                if(b==true)
                {
                    System.out.println("Number exists in list");

                }
                else
                {
                    System.out.println("Number does not exist in list");
                }
            }
            else if(ch==3)
            {
                ob.display();
            }
            else if(ch==4)
            {
                System.exit(4);
            }

        }
    }
}

