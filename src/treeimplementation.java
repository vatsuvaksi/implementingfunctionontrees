
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


class node   //creates a node class
    {
        int data;
        node right;
        node left;
    }
     class tree
    {
        public node creatingtree(node root, int data)  // creates the binary search tree
        {

            if (root == null) return createnewnode(data);
            else if (data > root.data)  root.right=creatingtree(root.right, data);
            else if (data < root.data)  root.left=creatingtree(root.left, data);
            return root ;

        }
        node createnewnode(int d)  //creates new node to add to tree (called by creatingtree)
        {
            node n=new node();
            n.data=d;
            n.left=null;
            n.right=null;
            return n;
        }


    }




 public class treeimplementation
 {
     static void implementingbfs(node root)    //this function implements breadth first search on the tree(gives the nodes level by level)
     {
     Queue<node> qu=new LinkedList<node>();
         qu.add(root);
         while (!qu.isEmpty())
         {
             node temp = qu.poll(); //poll() function removes the first element and stores it to the temp variable
             System.out.println(temp.data + " ");
             if (temp.left != null) qu.add(temp.left);
             if (temp.right != null) qu.add(temp.right);


         }
     }
     static void preorder(node root) //depth first implementation as preorder
     {
         if(root == null) return;
         System.out.print(root.data+" ");
         preorder(root.left);
         preorder(root.right);
     }
     static void inorder(node root) //depth first implementation as inorder
     {
         if(root == null) return;

         inorder(root.left);
         System.out.print(root.data+" ");
         inorder(root.right);
     }
     static void postorder(node root) //depth first implementation as prostorder
 {
     if(root == null) return;

     postorder(root.left);
     postorder(root.right);
     System.out.print(root.data+" ");
 }
//public static int sum=0;
 static int sumofallnodes(node root)
 {

     if(root==null) return 0;
     else
         return root.data+sumofallnodes(root.left)+sumofallnodes(root.right);
 }

 static int diffofevenoddlevel(node root) // this function gives the difference of nodes of even level and odd level
 {
     if(root==null) return 0;
     else
         return root.data-diffofevenoddlevel(root.left)-diffofevenoddlevel(root.right);

 }
 static int numberofnodesintree(node root)
 {
     if (root==null) return 0;
     else return 1+numberofnodesintree(root.left)+numberofnodesintree(root.right);
 }
// public static int c=0;
 static int numberofleafnodes(node root)
 {
     if (root ==null) return 0;
     if(root.left==null&&root.right==null) return 1;
     else return numberofleafnodes(root.left)+numberofleafnodes(root.right);

 }
     static int hieghtofbst(node root)
     {
         if(root==null) return 0;
         else
         {
             int leftdepth=hieghtofbst(root.left);
             int rightdepth=hieghtofbst(root.right);
             if(leftdepth>rightdepth) return leftdepth+1;
             else return rightdepth+1;

         }
     }
     static void printatlevel(node root,int d) //prints the nodes of a specific level
     {
         if (root==null) return;
         if(d==1)
         {
             System.out.print(root.data+" ");
             return;
         }
         else if(d>1)
         {
             printatlevel(root.left,d-1);
             printatlevel(root.right,d-1);
         }

     }
     static void printalllevelswithoutusingrecursion(node root) //prints all level without using recursion
     {
         if (root==null ) return ;
         else
         {

             int hieght=hieghtofbst(root);
             for(int i=1;i<=hieght;i++)
             {
                 printatlevel(root,i);
                 System.out.println();
             }
         }
     }
     static void PrintReverseLevelorderTraversal(node root)
     {
         if (root==null ) return ;
         else
         {

             int hieght=hieghtofbst(root);
             for(int i=hieght;i>=1;i--)
             {
                 printatlevel(root,i);
                 System.out.println();
             }
         }
     }
    static void implementingbfsreverse(node root) //breadth first search is implemented but in reverse order
     {
         Queue<node> quu=new LinkedList<node>();
         LinkedList<node> reverse=new LinkedList<node>();
         quu.add(root);
         while(!quu.isEmpty())
         {
             node temp=quu.poll();
             reverse.add(temp);
             if(temp.left!=null) quu.add(temp.left);
             if(temp.right!=null) quu.add(temp.right);
         }
         for(int i=reverse.size()-1;i>=0;i--) System.out.println(reverse.get(i).data);


     }
 static int maxlevel=0;
     static void leftelementsofbinarytree(node root, int level) // gives the leftmost elements of binary tree that is it gives the view of the tree from the left
     {
         if (root==null) return;
         if(level>=maxlevel)
         {

             System.out.print(root.data+" ");
             maxlevel++;
         }
         leftelementsofbinarytree(root.left,level+1);
         leftelementsofbinarytree(root.right,level+1);

     }

     static void rightelementsofbinarytree(node root,int level)// gives the right most elements of the binary tree that is the view from the right hand side of the treee
     {
         if (root ==null)
             return;
         if(level>=maxlevel)
         {
             System.out.print(root.data +" ");
             maxlevel++;
         }
         rightelementsofbinarytree(root.right,level+1);
         rightelementsofbinarytree(root.left,level+1);
     }

    static void  leafnodes(node root) // it gives the leaf nodes of the tree
    {
        if (root==null) return;
        else if (root.left==null&&root.right==null) {
            System.out.print(root.data+" ");
        return;
        }
        leafnodes(root.left);
        leafnodes(root.right);

    }
    static node mirrortree(node root) // retruns the mirror image of the  tree
    {
        if(root==null) return null;

            node t=root.left;
            root.left=root.right;
            root.right=t;
         mirrortree(root.left);
         mirrortree(root.right);
         return root;




    }
    static void getverticalsumofbinarytree(node root) // gives the vertical sum of the tree separately
    {
        if(root==null) return ;
        HashMap<Integer,Integer> m=new HashMap<>();
        verticalsum(root,0,m);
        if(m!=null)
            System.out.print(m.values());




    }
    public static void verticalsum(node root,int l,HashMap<Integer,Integer> map) // calculates the sum of vertial nodes that is nodes above or below each other
    {
        if(root==null) return;
        verticalsum(root.left,l-1,map);
        int sum=(map.get(l)==null)?0:map.get(l);
        map.put(l,sum+root.data);
        verticalsum(root.right,l+1,map);




    }
     static  public int dist = -1; //distance initialize as -1 so that i
     static int findDistance(node root, int x)
     {
         // Base case
         if (root == null)
             return -1;




         // Check if x is present at root or in left
         // subtree or right subtree.
         if ((root.data == x) || (dist = findDistance(root.left, x)) >= 0 || (dist = findDistance(root.right, x)) >= 0)
             return dist + 1;

         return dist;
     }
//good leaf pair function not done



     public static void main(String args[])
    {
        node root = null;

        tree a=new tree();


        root = a.creatingtree(root, 8);
        root = a.creatingtree(root, 3);
        root = a.creatingtree(root, 6);
        root = a.creatingtree(root, 10);
        root = a.creatingtree(root, 4);
        root = a.creatingtree(root, 7);
        root = a.creatingtree(root, 1);
        root = a.creatingtree(root, 14);
        root = a.creatingtree(root, 13);
        implementingbfs(root);
        System.out.println();
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        System.out.println(sumofallnodes(root));
        System.out.println();
        System.out.println(diffofevenoddlevel(root));
        System.out.println();
        System.out.println(numberofnodesintree(root));
        System.out.println();
        System.out.println(numberofleafnodes(root));
        System.out.println();
        System.out.println(hieghtofbst(root));
        System.out.println();
        printatlevel(root,3);
        System.out.println();
        printalllevelswithoutusingrecursion(root);

        System.out.println();
        PrintReverseLevelorderTraversal(root);
        implementingbfsreverse(root);


    }
}