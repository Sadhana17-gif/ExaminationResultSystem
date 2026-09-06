package org.anudip.examresult.service;

import org.anudip.examresult.model.Student;
import org.anudip.examresult.model.Marks;
import org.anudip.examresult.exception.StudentNotFoundException;

public interface StudentService {

    boolean addStudent(Student student);

    boolean addMarks(Marks marks);

    Student getStudentResult(int studentId)
            throws StudentNotFoundException;

    Marks getMarks(int studentId)
            throws StudentNotFoundException;
}