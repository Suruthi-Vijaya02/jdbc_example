package main;
import dao.courseDAO;
import dao.enrollmentDAO;
import dao.studentDAO;
import model.student;
import model.course;
import model.enrollment;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        studentDAO studentDao = new studentDAO();
        courseDAO courseDao = new courseDAO();
        enrollmentDAO enrollDao = new enrollmentDAO();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== STUDENT MANAGEMENT SYSTEM ======");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Add Course");
            System.out.println("4. View All Courses");
            System.out.println("5. Enroll Student");
            System.out.println("6. View Enrollments");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();  // consume extra newline

            switch (choice) {

                // -------------------------------------------------
                case 1:
                    student s = new student();

                    System.out.print("Enter Student ID: ");
                    s.setStu_id(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    s.setName(sc.nextLine());

                    System.out.print("Enter Email: ");
                    s.setEmail(sc.nextLine());

                    System.out.print("Enter Mobile No: ");
                    s.setMobile_no(sc.nextLine());

                    System.out.print("Enter DOB (yyyy-mm-dd): ");
                    s.setDob(Date.valueOf(sc.nextLine()));

                    System.out.print("Enter Department ID: ");
                    s.setDepartment_id(sc.nextInt());

                    studentDao.insert(s);
                    break;

                // -------------------------------------------------
                case 2:
                    List<student> students = studentDao.getAll();
                    System.out.println("\n--- STUDENT LIST ---");
                    for (student st : students) {
                        System.out.println(
                                st.getStu_id() + " | " +
                                st.getName() + " | " +
                                st.getEmail() + " | " +
                                st.getMobile_no() + " | " +
                                st.getDob() + " | Dept: " + st.getDepartment_id()
                        );
                    }
                    break;

                // -------------------------------------------------
                case 3:
                    course c = new course();

                    System.out.print("Enter Course ID: ");
                    c.setCourse_id(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Course Name: ");
                    c.setCourse_name(sc.nextLine());

                    System.out.print("Enter Credits: ");
                    c.setCredits(sc.nextInt());

                    System.out.print("Enter Teacher ID: ");
                    c.setTeacher_id(sc.nextInt());

                    courseDao.insert(c);
                    break;

                // -------------------------------------------------
                case 4:
                    List<course> courses = courseDao.getAll();
                    System.out.println("\n--- COURSE LIST ---");
                    for (course cc : courses) {
                        System.out.println(
                                cc.getCourse_id() + " | " +
                                cc.getCourse_name() + " | Credits: " +
                                cc.getCredits() + " | Teacher: " + cc.getTeacher_id()
                        );
                    }
                    break;

                // -------------------------------------------------
                case 5:
                    enrollment e = new enrollment();

                    System.out.print("Enter Student ID: ");
                    e.setStudent_id(sc.nextInt());

                    System.out.print("Enter Course ID: ");
                    e.setCourse_id(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Enroll Date (yyyy-mm-dd): ");
                    e.setEnroll_date(Date.valueOf(sc.nextLine()));

                    System.out.print("Enter Grade (A/B/C...): ");
                    e.setGrade(sc.next().charAt(0));

                    enrollDao.insert(e);
                    break;

                // -------------------------------------------------
                case 6:
                    List<enrollment> enList = enrollDao.getAll();
                    System.out.println("\n--- ENROLLMENT LIST ---");
                    for (enrollment en : enList) {
                        System.out.println(
                                "Student: " + en.getStudent_id()
                                + " | Course: " + en.getCourse_id()
                                + " | Date: " + en.getEnroll_date()
                                + " | Grade: " + en.getGrade()
                        );
                    }
                    break;

                // -------------------------------------------------
                case 0:
                    System.out.println("Exiting program...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
