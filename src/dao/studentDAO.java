package dao;


import model.student;
import util.dbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class studentDAO {

    // INSERT
    public void insert(student s) {
        String sql = "INSERT INTO student(stu_id, name, email, mobile_no, dob, department_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, s.getStu_id());
            ps.setString(2, s.getName());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getMobile_no());
            ps.setDate(5, s.getDob());
            ps.setInt(6, s.getDepartment_id());

            ps.executeUpdate();
            System.out.println("Student inserted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // GET BY ID
    public student getById(int id) {
        String sql = "SELECT * FROM student WHERE stu_id = ?";
        student s = null;

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                s = new student();
                s.setStu_id(rs.getInt("stu_id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setMobile_no(rs.getString("mobile_no"));
                s.setDob(rs.getDate("dob"));
                s.setDepartment_id(rs.getInt("department_id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }

    // GET ALL
    public List<student> getAll() {
        String sql = "SELECT * FROM student";
        List<student> list = new ArrayList<>();

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                student s = new student();
                s.setStu_id(rs.getInt("stu_id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setMobile_no(rs.getString("mobile_no"));
                s.setDob(rs.getDate("dob"));
                s.setDepartment_id(rs.getInt("department_id"));
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // UPDATE
    public void update(student s) {
        String sql = "UPDATE student SET name=?, email=?, mobile_no=?, dob=?, department_id=? WHERE stu_id=?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getMobile_no());
            ps.setDate(4, s.getDob());
            ps.setInt(5, s.getDepartment_id());
            ps.setInt(6, s.getStu_id());

            ps.executeUpdate();
            System.out.println("Student updated!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void delete(int id) {
        String sql = "DELETE FROM student WHERE stu_id = ?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Student deleted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
