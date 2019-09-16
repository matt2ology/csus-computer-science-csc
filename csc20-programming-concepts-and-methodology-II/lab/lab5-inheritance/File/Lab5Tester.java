// Lab5 tester class
public class Lab5Tester {
    public static void main(String[] args) {   
        CsusStudent student = new CsusStudent("John Doe", 123, "123 Somewhere", "415-555-1212", "johndoe@somewhere.com");      
        Csc20Student csc20Student = new Csc20Student("John Doe", 123, "123 Somewhere", "415-555-1212", "johndoe@somewhere.com",true,15);        
        System.out.println(student + "\n");
        System.out.println(csc20Student + "\n");
    }
}