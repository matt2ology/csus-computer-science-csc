/**
   This program demonstrates the Course class.
*/

public class CourseDemo
{
   public static void main(String[] args)
   {
      // Create an Instructor object.
      Instructor myInstructor =
          new Instructor("John", "Doe", "ABC010");
      
      // Create a TextBook object.
      TextBook myTextBook =
          new TextBook("Building Java Programs",
                       "Stuart Reges", "Pearson");
                       
      // Create a Course object.
      Course myCourse = 
         new Course("Programming Concepts and Methodology II", myInstructor,
                    myTextBook);
      
      // Display the course information.
      System.out.println(myCourse);
   }
}