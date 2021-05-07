import java.io.*;
class Binary6//basic operations of a binary tree
{
    NODE root;
    Binary6()//default constructor
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

    boolean searchnode(NODE B,int s)//to search for a particular node
    {
        if(B!=null)
        {
            if(s==B.data)
                return true;
            else if(s<B.data)
                return searchnode(B.left,s);
            else if(s>B.data)
                return searchnode(B.right,s);
        }
        return false;
    }

    NODE delete(NODE B,int m)//to delete a particular node if present
    {
        NODE N=new NODE();
        if(B!=null)
        {            
            if(m<B.data)
            {
                B.left=delete(B.left,m);
            }
            else
            if(m>B.data)     
            {
                B.right=delete(B.right,m);   
            }
            else
            {
                if(B.left==B.right)
                    return null;
                else if(B.left==null)
                    return B.right;
                else if(B.right==null)
                    return B.left;
                else
                {
                    N=B.right;
                    while(N.left!=null)                    
                        N=N.left;                    
                    N.left=B.left;
                    return B.right;
                }
            }
        }
        return B;
    }

    int countnode(NODE B)//to count number of nodes 
    {
        if(B!=null)
            return 1+countnode(B.left)+countnode(B.right);        
        else
            return 0;        
    }

    int height(NODE B)//to find height of the tree
    {
        if(B!=null)
        {
            if(B.left==null&&B.right==null)
            {
                return 1;
            }
            else
            {
                if(height(B.left)>height(B.right))
                    return 1+height(B.left);
                else
                    return 1+height(B.right);
            }
        }
        return 0;
    }
}
public class Test6//test class
{
    void main()throws IOException//to implement above functions
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int ch=0;
        Binary6 T=new Binary6();
        do
        {
            System.out.println("Menu\n1.Insert\n2.Display in in-order\n3.Search\n4.Delete a node\n5.Count nodes\n6.Height of tree\n7.Exit");
            System.out.print("Enter choice:");
            ch=Integer.parseInt(br.readLine());
            if(ch==1)
            {
                System.out.print("Enter no: ");
                int x=Integer.parseInt(br.readLine());
                T.root=T.insert(T.root,x);
            }
            else
            if(ch==2)
                T.inorder(T.root);
            else
            if(ch==3)
            {
                System.out.print("Enter search value: ");
                int x=Integer.parseInt(br.readLine());
                boolean b=T.searchnode(T.root,x);
                System.out.println(b==true?"No. exists":"Does not exist");
            }
            else
            if(ch==4)
            {
                System.out.print("Enter no: ");
                int x=Integer.parseInt(br.readLine());
                if(T.searchnode(T.root,x)!=true)
                    System.out.println("Not found");
                else
                    T.root=T.delete(T.root,x);
            }
            else 
            if(ch==5)
                System.out.println("No. of nodes = "+T.countnode(T.root));
            else
            if(ch==6)
                System.out.println("Height of tree = "+T.height(T.root));
            else
            if(ch!=7)
                System.out.println("Invalid choice");
        }while(ch!=7);
    }
}                          
