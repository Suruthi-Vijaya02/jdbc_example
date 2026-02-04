package dao;

import model.course;
import util.dbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class courseDAO {

    // INSERT
    public void insert(course c) {
        String sql = "INSERT INTO course(course_id, start_date, duration, course_name, credits, teacher_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, c.getCourse_id());
            ps.setDate(2, c.getStart_date());
            ps.setInt(3, c.getDuration());
            ps.setString(4, c.getCourse_name());
            ps.setInt(5, c.getCredits());
            ps.setInt(6, c.getTeacher_id());

            ps.executeUpdate();
            System.out.println("Course inserted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // GET BY ID
    public course getById(int id) {
        String sql = "SELECT * FROM course WHERE course_id = ?";
        course c = null;

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new course();
                c.setCourse_id(rs.getInt("course_id"));
                c.setStart_date(rs.getDate("start_date"));
                c.setDuration(rs.getInt("duration"));
                c.setCourse_name(rs.getString("course_name"));
                c.setCredits(rs.getInt("credits"));
                c.setTeacher_id(rs.getInt("teacher_id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }

    // GET ALL
    public List<course> getAll() {
        String sql = "SELECT * FROM course";
        List<course> list = new ArrayList<>();

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                course c = new course();
                c.setCourse_id(rs.getInt("course_id"));
                c.setStart_date(rs.getDate("start_date"));
                c.setDuration(rs.getInt("duration"));
                c.setCourse_name(rs.getString("course_name"));
                c.setCredits(rs.getInt("credits"));
                c.setTeacher_id(rs.getInt("teacher_id"));

                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // UPDATE
    public void update(course c) {
        String sql = "UPDATE course SET start_date=?, duration=?, course_name=?, credits=?, teacher_id=? WHERE course_id=?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDate(1, c.getStart_date());
            ps.setInt(2, c.getDuration());
            ps.setString(3, c.getCourse_name());
            ps.setInt(4, c.getCredits());
            ps.setInt(5, c.getTeacher_id());
            ps.setInt(6, c.getCourse_id());

            ps.executeUpdate();
            System.out.println("Course updated!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void delete(int id) {
        String sql = "DELETE FROM course WHERE course_id = ?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Course deleted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
