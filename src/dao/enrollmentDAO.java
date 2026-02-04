package dao;

import model.enrollment;
import util.dbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class enrollmentDAO {

    // INSERT
    public void insert(enrollment e) {
        String sql = "INSERT INTO enrollment(student_id, course_id, enroll_date, grade) VALUES (?, ?, ?, ?)";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, e.getStudent_id());
            ps.setInt(2, e.getCourse_id());
            ps.setDate(3, e.getEnroll_date());
            ps.setString(4, String.valueOf(e.getGrade()));

            ps.executeUpdate();
            System.out.println("Enrollment inserted!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // GET BY STUDENT & COURSE (Composite Key)
    public enrollment get(int studentId, int courseId) {
        String sql = "SELECT * FROM enrollment WHERE student_id = ? AND course_id = ?";
        enrollment e = null;

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ps.setInt(2, courseId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                e = new enrollment();
                e.setStudent_id(rs.getInt("student_id"));
                e.setCourse_id(rs.getInt("course_id"));
                e.setEnroll_date(rs.getDate("enroll_date"));
                e.setGrade(rs.getString("grade").charAt(0));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }

    // GET ALL
    public List<enrollment> getAll() {
        String sql = "SELECT * FROM enrollment";
        List<enrollment> list = new ArrayList<>();

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                enrollment e = new enrollment();
                e.setStudent_id(rs.getInt("student_id"));
                e.setCourse_id(rs.getInt("course_id"));
                e.setEnroll_date(rs.getDate("enroll_date"));
                e.setGrade(rs.getString("grade").charAt(0));

                list.add(e);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }

    // UPDATE GRADE + DATE
    public void update(enrollment e) {
        String sql = "UPDATE enrollment SET enroll_date=?, grade=? WHERE student_id=? AND course_id=?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDate(1, e.getEnroll_date());
            ps.setString(2, String.valueOf(e.getGrade()));
            ps.setInt(3, e.getStudent_id());
            ps.setInt(4, e.getCourse_id());

            ps.executeUpdate();
            System.out.println("Enrollment Updated!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // DELETE
    public void delete(int studentId, int courseId) {
        String sql = "DELETE FROM enrollment WHERE student_id=? AND course_id=?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ps.setInt(2, courseId);

            ps.executeUpdate();
            System.out.println("Enrollment deleted!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
