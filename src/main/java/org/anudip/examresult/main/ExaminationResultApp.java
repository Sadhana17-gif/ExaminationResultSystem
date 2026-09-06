package org.anudip.examresult.main;

import java.util.Scanner;

import org.anudip.examresult.controller.StudentController;
import org.anudip.examresult.exception.StudentNotFoundException;
import org.anudip.examresult.model.Marks;
import org.anudip.examresult.model.Student;
import org.anudip.examresult.util.DBConnection;

public class ExaminationResultApp {

    public static void main(String[] args) {

        // Test database connection
        DBConnection.getConnection();

        Scanner sc = new Scanner(System.in);
        StudentController controller = new StudentController();

        while (true) {

            System.out.println("\n===== EXAMINATION RESULT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Marks");
            System.out.println("3. View Student Result");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int studentId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String studentName = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter Semester: ");
                    int semester = sc.nextInt();

                    Student student = new Student(
                            studentId,
                            studentName,
                            department,
                            semester
                    );

                    if (controller.addStudent(student)) {
                        System.out.println("Student added successfully.");
                    } else {
                        System.out.println("Failed to add student.");
                    }

                    break;

                case 2:

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Subject 1 Mark: ");
                    int subject1 = sc.nextInt();

                    System.out.print("Enter Subject 2 Mark: ");
                    int subject2 = sc.nextInt();

                    System.out.print("Enter Subject 3 Mark: ");
                    int subject3 = sc.nextInt();

                    System.out.print("Enter Subject 4 Mark: ");
                    int subject4 = sc.nextInt();

                    System.out.print("Enter Subject 5 Mark: ");
                    int subject5 = sc.nextInt();

                    Marks marks = new Marks(
                            id,
                            subject1,
                            subject2,
                            subject3,
                            subject4,
                            subject5
                    );

                    if (controller.addMarks(marks)) {
                        System.out.println("Marks added successfully.");
                    } else {
                        System.out.println("Failed to add marks.");
                    }

                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    int searchId = sc.nextInt();

                    try {

                        Student result =
                                controller.getStudentResult(searchId);

                        Marks resultMarks =
                                controller.getMarks(searchId);

                        System.out.println("\n===== STUDENT RESULT =====");

                        System.out.println("Student ID   : "
                                + result.getStudentId());

                        System.out.println("Name         : "
                                + result.getStudentName());

                        System.out.println("Department   : "
                                + result.getDepartment());

                        System.out.println("Semester     : "
                                + result.getSemester());

                        System.out.println("\nSubject 1    : "
                                + resultMarks.getSubject1());

                        System.out.println("Subject 2    : "
                                + resultMarks.getSubject2());

                        System.out.println("Subject 3    : "
                                + resultMarks.getSubject3());

                        System.out.println("Subject 4    : "
                                + resultMarks.getSubject4());

                        System.out.println("Subject 5    : "
                                + resultMarks.getSubject5());

                        System.out.println("Total        : "
                                + resultMarks.getTotal());

                        System.out.println("Percentage   : "
                                + resultMarks.getPercentage());

                    } catch (StudentNotFoundException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 4:

                    System.out.println("Thank you!");

                    sc.close();

                    return;

                default:

                    System.out.println("Invalid choice.");
            }
        }
    }
}