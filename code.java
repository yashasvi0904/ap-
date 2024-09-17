package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

abstract class User {
    protected String email;
    protected String password;
    protected String role;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public abstract void login();
}
class course{
  private string coursecode;
   private String title;
    private String professor;
    private int credits;
    private String prerequisites;
    private String schedule;

    public Course(String courseCode, String title, String professor, int credits, String prerequisites, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.professor = professor;
        this.credits = credits;
        this.prerequisites = prerequisites;
        this.schedule = schedule;

    }
    public String getcourse_code() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getProfessor() {
        return professor;
    }

    public int getCredits() {
        return credits;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public String getSchedule() {
        return schedule;
    }


    public void viewCourse() {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Title: " + title);
        System.out.println("Professor: " + professor);
        System.out.println("Credits: " + credits);
        System.out.println("Prerequisites: " + prerequisites);
        System.out.println("Schedule: " + schedule);
    }
}
class student extend user{
    private int student_id;
    private int curr_semester;
    private int cgpa;
    private int gpa;
    private int sgpa;

    public void student(int student_id,int curr_semester,int cgpa,int gpa, int sgpa){
        this.student_id= student_id;
        this.curr_semester=curr_semester;
        this.cgpa= cgpa;
        this.gpa= gpa;
        this.sgpa=sgpa;
    }
    public void view_available_course(ArrayList<{
        for( course: Course){
            course.viewCourse;
        
    


