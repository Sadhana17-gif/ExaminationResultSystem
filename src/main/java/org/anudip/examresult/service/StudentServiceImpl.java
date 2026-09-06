package org.anudip.examresult.service;

import org.anudip.examresult.model.Student;
import org.anudip.examresult.model.Marks;
import org.anudip.examresult.repository.StudentRepository;
import org.anudip.examresult.repository.StudentRepositoryImpl;
import org.anudip.examresult.exception.StudentNotFoundException;

public class StudentServiceImpl implements StudentService {

    private StudentRepository repository = new StudentRepositoryImpl();

    @Override
    public boolean addStudent(Student student) {
        return repository.addStudent(student);
    }

    @Override
    public boolean addMarks(Marks marks) {
        return repository.addMarks(marks);
    }

    @Override
    public Student getStudentResult(int studentId)
            throws StudentNotFoundException {

        Student student = repository.getStudentById(studentId);

        if (student == null) {
            throw new StudentNotFoundException(
                    "Student not found with ID: " + studentId);
        }

        return student;
    }

    @Override
    public Marks getMarks(int studentId)
            throws StudentNotFoundException {

        Marks marks = repository.getMarksByStudentId(studentId);

        if (marks == null) {
            throw new StudentNotFoundException(
                    "Marks not found for student ID: " + studentId);
        }

        return marks;
    }
}