import java.io.*;
class Binary4//class for binary tree
{
    NODE root;
    Binary4()//default constructor
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

    void inorder(NODE B)//to display nodes in inorder
    {
        if(B!=null)
        {
            inorder(B.left);
            System.out.println(B.data);
            inorder(B.right);
        }
    }

    int biggest(NODE B)//to display the biggest node
    {
        if(B!=null)
        {
            if(B.right==null)            
                return B.data;            
            else            
                return biggest(B.right);            
        }
        return -1;
    }
    
    int smallest(NODE B)//to display the smallest node
    {
        if(B!=null)
        {
            if(B.left==null)            
                return B.data;            
            else            
                return smallest(B.left);            
        }
        return -1;
    }

    void path(NODE B,int d)//to display the path traversed to a particular node
    {
        if(B!=null)
        {
            System.out.println(B.data);
            if(d<B.data)            
                path(B.left,d);            
            else 
            if(d>B.data)           
                path(B.right,d);            
            else 
            if(d==B.data)            
                return;            
        }
    }

    void onlynodes(NODE B,char ch)//to display certain types of nodes
    {
        if(ch=='l')//to display nodes with only left children
        {
            if(B!=null)
            {
                if(B.left!=null&&B.right==null)
                    System.out.println(B.data);
                onlynodes(B.left,ch);
                onlynodes(B.right,ch);
            }
        }
        else
        if(ch=='r')//to display nodes with only right values
        {
            if(B!=null)
            {
                if(B.left==null&&B.right!=null)
                    System.out.println(B.data);
                onlynodes(B.left,ch);
                onlynodes(B.right,ch);
            }
        }
        else
        if(ch=='b')//to display nodes with both left and right
        {
            if(B!=null)
            {
                if(B.left!=null&&B.right!=null)
                    System.out.println(B.data);
                onlynodes(B.left,ch);
                onlynodes(B.right,ch);
            } 
        }
        else
        if(ch=='o')//to display leaf nodes
        {
            if(B!=null)
            {
                if(B.left==null&&B.right==null)
                    System.out.println(B.data);
                onlynodes(B.left,ch);
                onlynodes(B.right,ch);
            }
        }
        else
            System.out.println("Invalid choice");
    }
}
public class Test4//test class
{
    void main()throws IOException//implements above functions
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int ch;
        Binary4 T=new Binary4();
        do
        {
            System.out.println("Menu\n1.Insert\n2.Display in in-order\n3.Biggest Node\n4.Smallest Node\n5.Path\n6.Types of nodes\n7.Exit");
            System.out.print("Enter your choice:");
            ch=Integer.parseInt(br.readLine());
            if(ch==1)
            {
                System.out.print("Enter no. to be entered:");
                int x=Integer.parseInt(br.readLine());
                T.root=T.insert(T.root,x);
            }
            else
            if(ch==2)
                T.inorder(T.root);
            else
            if(ch==3)
                System.out.println(T.biggest(T.root)==-1?"Empty tree":T.biggest(T.root));
            else
            if(ch==4)
                System.out.println(T.smallest(T.root)==-1?"Empty tree":T.smallest(T.root));
            else
            if(ch==5)
            {
                System.out.print("Enter value: ");
                int x=Integer.parseInt(br.readLine());
                T.path(T.root,x);
            }
            else
            if(ch==6)
            {
                System.out.print("[l]Only Left\n[r]Only right\n[b]Both\n[o]Leaf nodes\nEnter your choice: ");
                char c=br.readLine().charAt(0);
                T.onlynodes(T.root,c);
            }
            else
            if(ch!=7)
                System.out.println("Invalid choice");
        }while(ch!=7);
    }
}
