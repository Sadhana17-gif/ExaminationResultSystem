package org.anudip.examresult.repository;

import org.anudip.examresult.model.Student;
import org.anudip.examresult.model.Marks;
public interface StudentRepository {

    boolean addStudent(Student student);

    boolean addMarks(Marks marks);

    Student getStudentById(int studentId);

    Marks getMarksByStudentId(int studentId);
}