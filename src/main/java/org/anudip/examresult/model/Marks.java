package org.anudip.examresult.model;

public class Marks {

    private int resultId;
    private int studentId;

    private int subject1;
    private int subject2;
    private int subject3;
    private int subject4;
    private int subject5;

    private int total;
    private double percentage;

    public Marks() {
    }

    public Marks(int studentId, int subject1, int subject2,
                 int subject3, int subject4, int subject5) {

        this.studentId = studentId;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
        this.subject4 = subject4;
        this.subject5 = subject5;

        calculateResult();
    }

    public void calculateResult() {

        total = subject1 + subject2 + subject3
                + subject4 + subject5;

        percentage = total / 5.0;
    }

    public int getResultId() {
        return resultId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getSubject1() {
        return subject1;
    }

    public int getSubject2() {
        return subject2;
    }

    public int getSubject3() {
        return subject3;
    }

    public int getSubject4() {
        return subject4;
    }

    public int getSubject5() {
        return subject5;
    }

    public int getTotal() {
        return total;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {

        return "\n----- EXAMINATION RESULT -----" +
               "\nStudent ID : " + studentId +
               "\nSubject 1  : " + subject1 +
               "\nSubject 2  : " + subject2 +
               "\nSubject 3  : " + subject3 +
               "\nSubject 4  : " + subject4 +
               "\nSubject 5  : " + subject5 +
               "\nTotal      : " + total +
               "\nPercentage : " + percentage + "%";
    }
}