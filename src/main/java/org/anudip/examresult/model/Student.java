package org.anudip.examresult.model;

public class Student {

    private int studentId;
    private String studentName;
    private String department;
    private int semester;

    public Student() {
    }

    public Student(int studentId, String studentName,
                   String department, int semester) {

        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
        this.semester = semester;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Student ID   : " + studentId +
               "\nStudent Name : " + studentName +
               "\nDepartment   : " + department +
               "\nSemester     : " + semester;
    }
}