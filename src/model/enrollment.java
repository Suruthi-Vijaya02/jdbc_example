package model;

import java.sql.Date;

public class enrollment {
    private int student_id;
    private int course_id;
    private Date enroll_date;
    private char grade;

    public int getStudent_id() {
        return student_id;
    }
    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getCourse_id() {
        return course_id;
    }
    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public Date getEnroll_date() {
        return enroll_date;
    }
    public void setEnroll_date(Date enroll_date) {
        this.enroll_date = enroll_date;
    }

    public char getGrade() {
        return grade;
    }
    public void setGrade(char grade) {
        this.grade = grade;
    }
}
