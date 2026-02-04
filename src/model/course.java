package model;

import java.sql.Date;

public class course {
    private int course_id;
    private Date start_date;
    private int duration;
    private String course_name;
    private int credits;
    private int teacher_id;

    public int getCourse_id() {
        return course_id;
    }
    public void setCourse_id(int course_id) {
               this.course_id = course_id;
    }

    public Date getStart_date() {
        return start_date;
    }
    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCourse_name() {
        return course_name;
    }
    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getTeacher_id() {
        return teacher_id;
    }
    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }
}
