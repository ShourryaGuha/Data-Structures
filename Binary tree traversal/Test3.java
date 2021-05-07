import java.io.*;
class Binary//class for a binary tree
{
    NODE root;
    Binary()//default constructor
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
    

    void preorder(NODE B)//to display nodes in preorder
    {
        if(B!=null)
        {
            System.out.println(B.data);
            preorder(B.left);
            preorder(B.right);
        }
    }

    void inorder(NODE B)//to display nodes in inorder
    {
        if(B!=null)
        {
            inorder(B.left);
            System.out.println(B.data);
            inorder(B.right);
        }
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
}

public class Test3//test class
{
    void main()throws IOException//implements all above functions
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int ch=0;
        Binary T=new Binary();
        while(ch>0)
        {
            System.out.println("Menu\n1.Insert\n2.Display in pre-order\n3.Display in in-order\n4.Display in post-order\n5.Exit");
            System.out.print("Enter your choice:");
            ch=Integer.parseInt(br.readLine());
            if(ch==1)
            {
                System.out.print("Enter number:");
                int x=Integer.parseInt(br.readLine());
                T.root=T.insert(T.root,x);
            }
            else
            if(ch==2)
                T.preorder(T.root);
            else
            if(ch==3)            
                T.inorder(T.root);            
            else
            if(ch==4)            
                T.postorder(T.root);            
            else
            if(ch!=5)           
                System.out.println("Invalid choice");        
        }
    }
}
