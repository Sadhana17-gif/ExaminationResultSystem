package org.anudip.examresult.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.anudip.examresult.model.Student;
import org.anudip.examresult.model.Marks;
import org.anudip.examresult.util.DBConnection;

public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public boolean addStudent(Student student) {

        String sql = "INSERT INTO students "
                   + "(student_id, student_name, department, semester) "
                   + "VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, student.getStudentId());
            ps.setString(2, student.getStudentName());
            ps.setString(3, student.getDepartment());
            ps.setInt(4, student.getSemester());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addMarks(Marks marks) {

        String sql = "INSERT INTO results "
                   + "(student_id, subject1, subject2, subject3, "
                   + "subject4, subject5, total, percentage) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, marks.getStudentId());
            ps.setInt(2, marks.getSubject1());
            ps.setInt(3, marks.getSubject2());
            ps.setInt(4, marks.getSubject3());
            ps.setInt(5, marks.getSubject4());
            ps.setInt(6, marks.getSubject5());
            ps.setInt(7, marks.getTotal());
            ps.setDouble(8, marks.getPercentage());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Student getStudentById(int studentId) {

        String sql = "SELECT * FROM students WHERE student_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Student(
                    rs.getInt("student_id"),
                    rs.getString("student_name"),
                    rs.getString("department"),
                    rs.getInt("semester")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Marks getMarksByStudentId(int studentId) {

        String sql = "SELECT * FROM results WHERE student_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Marks(
                    rs.getInt("student_id"),
                    rs.getInt("subject1"),
                    rs.getInt("subject2"),
                    rs.getInt("subject3"),
                    rs.getInt("subject4"),
                    rs.getInt("subject5")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}