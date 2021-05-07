import java.io.*;

class Binary5//class for basic binary tree functions
{
    NODE root;
    Binary5()//default constructor
    {
        root=null;
    }

    NODE insert(NODE B,int k)//to insert a node in the tree
    {
        if(B==null)
        {
            B=new NODE();
            B.data=k;
        }
        else
        if(k<B.data)        
            B.left=insert(B.left,k);        
        else
        if(k>B.data)        
            B.right=insert(B.right,k);        
        return B;
    }
    
    void postorder(NODE B)//to display nodes in postorder
    {
        if(B!=null)
        {
            postorder(B.left);
            postorder(B.right);
            System.out.println(B.data); 
        }
    }
    
    int sumnode(NODE B)//to return sum of all nodes
    {
        if(B!=null)        
            return B.data+sumnode(B.left)+sumnode(B.right);        
        else        
            return 0;        
    }
    
    void mirror(NODE B)//to convert the tree to its mirror image
    {
        if(B!=null)
        {
            mirror(B.left);
            mirror(B.right);
            NODE T=B.left;
            B.left=B.right;
            B.right=T;
        }
        return;
    }
    
    void leafnode(NODE B)//to display all leaf nodes
    {
        if(B!=null)
        {
            if(B.left==null&&B.right==null)
                System.out.println(B.data);
            leafnode(B.left);
            leafnode(B.right);
        }
    }
}
public class Test5//test class
{
    void main()throws IOException//to implement above functions
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int ch;
        Binary5 T=new Binary5();
        do
        {
            System.out.println("Menu\n1.Insert\n2.Display in post-order\n3.Sum\n4.Mirror\n5.Display leaf nodes\n6.Exit");
            System.out.print("Enter your choice:");
            ch=Integer.parseInt(br.readLine());
            if(ch==1)
            {
                System.out.print("Enter no: ");
                int x=Integer.parseInt(br.readLine());
                T.root=T.insert(T.root,x);
            }
            else
            if(ch==2)
                T.postorder(T.root);
            else
            if(ch==3)
            {
                int sum=T.sumnode(T.root);
                System.out.println("Sum = "+sum);
            }
            else
            if(ch==4)
                T.mirror(T.root);
            else
            if(ch==5)
                T.leafnode(T.root);
            else
            if(ch!=6)
                System.out.println("Invalid choice");
        }while(ch!=6);
    }
}
