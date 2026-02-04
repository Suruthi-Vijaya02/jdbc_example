package model;

import java.sql.Date;

public class teacher {
    private int teacher_id;
    private String teacher_name;
    private Date hire_date;
    private int department_id;

    public int getTeacher_id() {
        return teacher_id;
    }
    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }
    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public Date getHire_date() {
        return hire_date;
    }
    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public int getDepartment_id() {
        return department_id;
    }
    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }
}
