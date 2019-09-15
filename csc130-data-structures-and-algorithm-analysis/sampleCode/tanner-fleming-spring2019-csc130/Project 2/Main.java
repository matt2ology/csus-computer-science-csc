/*
 * Author: Pawan Chandra & Pawan Khatri
 * Date: June 11, 2018
 */

import java.util.Random;

public class Main {
    public static void main(String[]args) {

       int min = 1000;
       int max = 5000;
       int bigNum;

       Random rand = new Random();
       BinarySearchTree b = new BinarySearchTree();
       AvlTree2 c = new AvlTree2();
       int num = rand.nextInt(99-10)+10;
       
       //BST is of height 5
       while(b.height()!=5) { 
           b.insert(num);  //This loop inserts random integers 10-99 until the
           num = rand.nextInt(99-10)+10;
           TreePrinter t = new TreePrinter(b);
           t.print("Binary Search Tree:"); //Randomize number again
       }

        TreePrinter t = new TreePrinter(b);
        t.print("Binary Search Tree with a height of 5:");//Prints Tree


      while(b.height()!=-1) {// This loop removes
            b.remove(b.getRoot());
            t.print("Root Deletion: ");
      }

      AvlTree a = new AvlTree();
      TreePrinter p;
      
      for(int i=0; i<35; i++) {
          //Inserts 35 random integers into an AVL tree
           a.insert(num);
           num = rand.nextInt(99 - 10) + 10;
           p = new TreePrinter(a);
           p.print("AVL Tree: ");//Prints AVL tree
       }

       bigNum = rand.nextInt(max-min);//Randomize large number
       int sameBigNum = bigNum;
       long startTime = System.currentTimeMillis();
       
       while(bigNum>0) {//Inserts some large number n into a BST
           num = rand.nextInt(99999-10000);
           b.insert(num);
           bigNum--;
       }
       t.print("BST");
       
       long endTime = System.currentTimeMillis();//Creates variable to store time difference
       System.out.println("Binary Search Tree took " + (endTime - startTime) + " milliseconds");  //Print
       long startTime2 = System.currentTimeMillis();

       while(sameBigNum>0) {//Inserts same large number n into a AVL tree
           c.insert(num);
           num = rand.nextInt(99999-1000);
           sameBigNum--;
       }
       long endTime2 = System.currentTimeMillis();
       System.out.println("AVL Tree took " + (endTime2 - startTime2) + " milliseconds");        //Prints time difference
       
    }
}