/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author DINH
 */
public class Student implements Comparable<Student>{
    private String studentID;
    private String fullName;
    private String dateOfBirth;
    private String gender;
    private String password;
 /*----------------------------------------------------------*/

    public Student() {
    }

    public Student(String studentID, String fullName, String dateOfBirth, String gender, String password) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.password = password;
    }
     /*----------------------------------------------------------*/

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     /*----------------------------------------------------------*/

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", password=" + password + '}';
    }
      
    @Override
    public int compareTo (Student input) {
        return this.fullName.compareToIgnoreCase(input.fullName);
    }
     /*----------------------------------------------------------*/
     public void login(String IDinput,String Passwordinput){
       if (IDinput.equals(studentID)==true){
           if (Passwordinput.equals(password)==true){
               System.out.println("Login successful");
           }else{
               System.out.println("Wrong ID or Password!");
           }
                   
       }else{
           System.out.println("Student not exist!");
       }
    }
     /*----------------------------------------------------------*/
    
    public static void main(String[] args) {

        ArrayList <Student> students = new ArrayList<>(); 
        Student student1= new Student ("1001", "Tran Van A", "20/10/2003", "Male", "@1");
        Student student2= new Student("1002", "Nguyen Thi B", "5/1/2003", "Female", "@2");
        Student student3= new Student("1003", "Tran Van C", "3/12/2003", "Male", "@3");
        Student student4= new Student("1004", "Nguyen Thi D", "8/11/2003", "Female", "@4");
        Student student5= new Student("1005", "Nguyen Van E", "3/7/2003", "Male", "@5");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        Collections.sort(students, new Comparator<Student>(){
        @Override
            public int compare(Student student1, Student student2) {
                return Integer.compare(Integer.parseInt(student1.getStudentID()),Integer.parseInt(student2.getStudentID()));
            }
        });    
        for (Student student : students){
            System.out.println(student.toString()); 
        }            
    }
}
