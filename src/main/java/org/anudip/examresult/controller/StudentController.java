package org.anudip.examresult.controller;

import org.anudip.examresult.model.Student;
import org.anudip.examresult.model.Marks;
import org.anudip.examresult.service.StudentService;
import org.anudip.examresult.service.StudentServiceImpl;
import org.anudip.examresult.exception.StudentNotFoundException;

public class StudentController {

    private StudentService studentService =
            new StudentServiceImpl();

    public boolean addStudent(Student student) {
        return studentService.addStudent(student);
    }

    public boolean addMarks(Marks marks) {
        return studentService.addMarks(marks);
    }

    public Student getStudentResult(int studentId)
            throws StudentNotFoundException {

        return studentService.getStudentResult(studentId);
    }

    public Marks getMarks(int studentId)
            throws StudentNotFoundException {

        return studentService.getMarks(studentId);
    }
}