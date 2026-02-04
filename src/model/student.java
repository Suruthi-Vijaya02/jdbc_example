package model;

import java.sql.Date;

public class student {
    private int stu_id;
    private String name;
    private String email;
    private String mobile_no;
    private Date dob;
    private int department_id;

    public int getStu_id() {
        return stu_id;
    }
    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_no() {
        return mobile_no;
    }
    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getDepartment_id() {
        return department_id;
    }
    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }
}
