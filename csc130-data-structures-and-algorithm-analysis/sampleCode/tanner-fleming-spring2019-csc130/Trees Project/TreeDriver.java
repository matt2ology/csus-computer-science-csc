/*
      Tanner Fleming & Justin Roldan
      Project 3 - working with Trees
      
      This class will be the driver used to randomize the integers for the tree and testing our print, etc
      Furthermore, we will use this class to test the runtime of each tree      
*/
import java.util.Random;

public  class TreeDriver {
     
      
   public static void main(String[] args) {
         runtimeTester();
      }   
      
     
     
     
   public static void runtimeTester() {
         BinarySearchTree bst = new BinarySearchTree();
         AVLTree avl = new AVLTree();
         Random r = new Random();
         int num = r.nextInt(99)+1;
         
         long startTime1 = System.currentTimeMillis();
         //BST Tree at height 3
         while(bst.getBSTHeight() != 3) {
             bst.insert(num); 
             num = r.nextInt(99) +1;
             bst.treeLevels();
       } 
         long endTime1 = System.currentTimeMillis();
         System.out.println("BST at height 1 took " + (endTime1 - startTime1) + " milliseconds");
         //AVL Tree at height 3
         while(avl.getBSTHeight() != 3) {
             avl.insert(num);
             num = r.nextInt(99) +1;
             avl.treeLevels();
       }      
       
         System.out.println("AVL Tree at height 1 took " + (endTime1 - startTime1) + " milliseconds");
         
         long startTime2 = System.currentTimeMillis();
         //BST Tree at height 4
         while(bst.getBSTHeight() != 4) {
             bst.insert(num); 
             num = r.nextInt(99) +1;
             bst.treeLevels();
       } 
         long endTime2 = System.currentTimeMillis();
         System.out.println("BST at height 1 took " + (endTime2 - startTime1) + " milliseconds");
        
         //AVL Tree at height 4
         while(avl.getBSTHeight() != 4) {
            avl.insert(num);
            num = r.nextInt(99) +1;
            avl.treeLevels();
       }  
       
         System.out.println("AVL Tree at height 1 took " + (endTime2 - startTime2) + " milliseconds");
         
         long startTime3 = System.currentTimeMillis();
         //BST Tree at height 5
         while(bst.getBSTHeight() != 5) {
             bst.insert(num); 
             num = r.nextInt(99) +1;
             bst.treeLevels();
       } 
         long endTime3 = System.currentTimeMillis();
         System.out.println("BST at height 1 took " + (endTime3 - startTime3) + " milliseconds");
        
         //AVL Tree at height 5
         while(avl.getBSTHeight() != 5) {
            avl.insert(num);
            num = r.nextInt(99) +1;
            avl.treeLevels();
       }  
       
         System.out.println("AVL Tree at height 1 took " + (endTime3 - startTime3) + " milliseconds");
         
         
      
  }           
      
   
   
   
}





