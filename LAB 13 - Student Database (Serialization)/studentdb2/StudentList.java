package studentdb_serialization;

/**
 * Created by enmargaret, jezamarts, && noahdominic
 *
 * Modified by Noah Dominic on 04/11/2016.
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class StudentList {

    public static void main(String[] args) {
        List<Student> stdl = new LinkedList<Student>();
        Student stdinput;
        BufferedReader br = null;
        Scanner in = new Scanner(System.in);

        String studentNumber;   //1
        String firstName;       //2
        char middleInitial;     //3
        String lastName;        //4
        String course;          //5
        int yearLevel;          //6
        String crushName;       //7
        Course faveSubject;     //8

        FileInputStream fis;
        ObjectInputStream ois;
        FileOutputStream fos;
        ObjectOutputStream oos;

        try {
            File file = new File("db.ser");

            if (file.length() == 0) {
                System.out.println("EMPTY FILE");
            } else {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                stdl = (List<Student>) ois.readObject();
            }

            int choice = 0;
            while(choice!=6){
                int flag=1;
                System.out.print("\n1.\tRegister a Student\n2.\tSearch Student\n3.\tDelete Student\n4.\tSave Information\n5.\tDisplay Students\n6.\tExit\nChoose which you want to do: ");
                choice = in.nextInt();

                if(choice == 1){
                    while(flag!=0){
                        System.out.print("Student number: ");
                        studentNumber = in.next();
                        for(Student temp : stdl){
                            if(studentNumber.compareTo(temp.getStudentNumber()) == 0){
                                flag = 0;
                                break;
                            }
                        }
                        if(flag == 1){
                            Scanner input = new Scanner(System.in);

                            System.out.print("Last Name: ");
                            lastName = input.nextLine();

                            System.out.print("Middle Initial: ");
                            middleInitial = input.nextLine().charAt(0);

                            System.out.print("First Name: ");
                            firstName = input.nextLine();

                            System.out.print("Program: ");
                            course = input.nextLine();

                            System.out.print("Year: ");
                            yearLevel = input.nextInt();

                            input = new Scanner(System.in);

                            System.out.print("Crush name: ");
                            crushName = input.nextLine();

                            System.out.print("Favourite Course - Course Code: ");
                            String courseCode = input.nextLine();

                            System.out.print("                 - Course Description: ");
                            String courseDescription = input.nextLine();

                            faveSubject = new Course(courseCode, courseDescription);

                            stdinput = new Student(studentNumber, lastName, middleInitial, firstName, course, yearLevel, crushName, faveSubject);
                            stdl.add(stdinput);
                            flag = 0;
                            System.out.println("Student added!\n");
                            display(stdl);
                            //accept inputs for register
                        }
                        else{
                            System.out.println("Student number already exists!\n");
                            flag = 1;
                            //student number already exists
                        }
                        int ch = 0;
                        while(ch < 1 || ch > 2){
                            System.out.print("\nAdd another student? <1> for YES / <2> for NO: ");
                            ch = in.nextInt();
                            if(ch == 1){
                                flag = 1;
                            }
                            else {
                                flag = 0;
                            }
                        }
                    }
                }
                else if (choice == 2){
                    while(flag!=0){
                        boolean dne = true;
                        System.out.print("\nEnter student number: ");
                        String stnum = in.next();
                        for(Student temp : stdl) {
                            if(stnum.compareTo(temp.getStudentNumber()) == 0){
                                System.out.println(temp);
                                dne = false;
                                break;
                            }
                        }
                        if(dne){
                            System.out.println("Student does not exist!");
                        }
                        int ch = 0;
                        while(ch < 1 || ch > 2){
                            System.out.print("\nSearch another student? <1> for YES / <2> for NO: ");
                            ch = in.nextInt();
                            if(ch == 1){
                                flag = 1;
                            }
                            else{
                                flag = 0;
                            }
                        }
                    }
                }
                else if(choice == 3){
                    while(flag!=0){
                        int j = 0;
                        boolean dne = true;
                        System.out.print("\nEnter student number: ");
                        String stnum = in.next();
                        for(Student temp : stdl){
                            if(stnum.compareTo(temp.getStudentNumber()) == 0){
                                stdl.remove(j);
                                dne = false;
                                break;
                            }
                            j++;
                        }
                        if(dne){
                            System.out.println("Student does not exist!");
                        }
                        int ch = 0;
                        while(ch < 1 || ch > 2){
                            System.out.print("\nRemove another student? <1> for YES / <2> for NO: ");
                            ch = in.nextInt();
                            if(ch == 1){
                                flag = 1;
                            }
                            else{
                                flag = 0;
                            }
                        }
                    }
                }
                else if(choice == 4){
                    try {
                        File fout = new File("db.ser");
                        fos = new FileOutputStream(fout);
                        oos = new ObjectOutputStream(fos);

                        oos.writeObject(stdl);

                        oos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if(choice == 5){
                    display(stdl);
                }
                else if(choice == 6){
                    System.out.println("Program has been ended.");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ce){
            ce.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void display(List<Student> l){
        for(Student temp: l){
            System.out.println(temp+"\n");

        }
    }
}

