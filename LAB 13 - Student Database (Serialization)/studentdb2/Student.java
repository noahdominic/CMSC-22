package studentdb_serialization;

import java.io.Serializable;

/**
 * Created by enmargaret, jezamarts, && noahdominic
 *
 * Modified by Noah Dominic on 04/11/2016.
 */

public class Student implements Serializable{
    private String studentNumber;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private String course;
    private int yearLevel;
    private String crushName;
    private Course faveSubject;

    public Student(){
        studentNumber = firstName = lastName = crushName = null;
        middleInitial = 0;
        yearLevel = 0;
    }

    public Student(String studentNumber, String firstName, char middleInitial, String lastName, String course, int yearLevel, String crushName, Course faveSubject){
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.course = course;
        this.yearLevel = yearLevel;
        this.crushName = crushName;
        this.faveSubject = faveSubject;

    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCourse() {
        return course;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public String getCrushName() {
        return crushName;
    }

    public Course getFaveSubject() {
        return faveSubject;
    }

    public String toString(){
        return "Student Number: " + studentNumber + "\nName: " + lastName + ", "
                + firstName + " " + middleInitial + ".\nProgram: " + course + "\nYear: " + yearLevel + "\nCrushName: "
                + crushName + "FaveCourse: " + faveSubject.courseCode + " (" + faveSubject.courseDescription + ")";
    }

}

