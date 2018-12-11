/*=============================================================================
AUTHOR: Matthew Mendoza
CSc 020: Programming Concepts and Methodology II - Spring 2018
LAB ASSIGNMENT 5: Class Inheritance
LAST EDIT DATE: 02/22/2018
CsusStudent.java
=============================================================================*/
/**
 * This class defines CsusStudent's profile including: name, id, address, 
 * phone, and email
*/
public class CsusStudent {
    // class attributes
    private String studentName;
    private int studentId;
    private String studentAddress;
    private String studentPhone;
    private String studentEmail;

    // constructor
    public CsusStudent(String newName, int newID, String newAddress, 
                    String newPhone_number, String newEmail) {
        setName(newName);
        setID(newID);
        setAddress(newAddress);
        setPhone(newPhone_number);
        setEmail(newEmail);
    }

    // setName
    public void setName(String newName) {
        studentName = newName;
    }

    // getName 
    public String getName() {
        return studentName;
    }

    // setID
    public void setID(int newID) {
        studentId = newID;
    }

    // getID 
    public int getID() {
        return studentId;
    }

    // setAddress
    public void setAddress(String newAddress) {
        studentAddress = newAddress;
    }

    // getAddress
    public String getAddress() {
        return studentAddress;
    }

    // setPhone
    public void setPhone(String newPhone_number) {
        studentPhone = newPhone_number;
    }

    // getPhone
    public String getPhone() {
        return studentPhone;
    }

    // setEmail
    public void setEmail(String newEmail) {
        studentEmail = newEmail;
    }

    // getEmail
    public String getEmail() {
        return studentEmail;
    }

    // Override toSTring method
    /** Return a string value by combining all values from class's attributes*/
    public String toString() {
        return String.format(
            "Name: %s\n" + 
            "StudentID: %s\n" + 
            "Address: %s\n" + 
            "Phone Number: %s\n" + 
            "Email: %s\n",
            getName(), 
            getID(), 
            getAddress(), 
            getPhone(), 
            getEmail());
    } //END OF toString METHOD
}
