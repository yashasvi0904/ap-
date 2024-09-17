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
    public String getCourseCode() {
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


    public void viewCourseDetails() {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Title: " + title);
        System.out.println("Professor: " + professor);
        System.out.println("Credits: " + credits);
        System.out.println("Prerequisites: " + prerequisites);
        System.out.println("Schedule: " + schedule);
    }
}


