// package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

class Course {
    private String coursecode;
    private String title;
    private String professor;
    private int credits;
    private String prerequisites;
    private String schedule;
    private int semester;

    public Course(String coursecode, String title, String professor, int credits, String prerequisites, String schedule, int semester) {
        this.coursecode = coursecode;
        this.title = title;
        this.professor = professor;
        this.credits = credits;
        this.prerequisites = prerequisites;
        this.schedule = schedule;
        this.semester = semester;
    }

    public String getcourse_code() {
        return coursecode;
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

    public int getSemester() {
        return semester;
    }

    public void viewCourse() {
        System.out.println("Course Code: " + coursecode);
        System.out.println("Title: " + title);
        System.out.println("Professor: " + professor);
        System.out.println("Credits: " + credits);
        System.out.println("Prerequisites: " + prerequisites);
        System.out.println("Schedule: " + schedule);
    }
}

class Student {
    private int student_id;
    private int curr_semester;
    private int cgpa;
    private int gpa;
    private int sgpa;
    private ArrayList<Course> registeredCourses;
    private ArrayList<Course> completedCourses;
    private int totalCredits;

    public Student(String email, String password, int student_id, int curr_semester, int cgpa, int gpa, int sgpa) {

        this.student_id = student_id;
        this.curr_semester = curr_semester;
        this.cgpa = cgpa;
        this.gpa = gpa;
        this.sgpa = sgpa;
        this.registeredCourses = new ArrayList<>();
        this.completedCourses = new ArrayList<>();
        this.totalCredits = 0;
    }

    public void viewAvailableCourses(List<Course> availableCourses) {
        if (availableCourses.isEmpty()) {
            System.out.println("No available courses to display.");
        } else {
            for (Course course : availableCourses) {
                course.viewCourse();
                System.out.println();  // For spacing between courses
            }
        }
    }

    public void registerCourse(Course course) {
        if (course.getSemester() != curr_semester) {
            System.out.println("You can only register for courses in your current semester.");
            return;
        }

        if (!course.getPrerequisites().isEmpty() && !prerequisiteMet(course)) {
            System.out.println("Cannot register for " + course.getTitle() + ". Prerequisites not met.");
            return;
        }

        if (course.getCredits() + totalCredits > 20) {
            System.out.println("Cannot register for " + course.getTitle() + ". Credit limit exceeded.");
            return;
        }

        registeredCourses.add(course);
        totalCredits += course.getCredits();
        System.out.println("Registered for " + course.getTitle());
    }

    public boolean prerequisiteMet(Course course) {
        // Logic for checking prerequisites can be added here
        return true; // Simplified for now
    }

    public void viewSchedule() {
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered for the current semester.");
            return;
        }

        System.out.println("Weekly Schedule for Semester " + curr_semester + ":");
        for (Course course : registeredCourses) {
            System.out.println(course.getTitle() + " - " + course.getSchedule() + " (Professor: " + course.getProfessor() + ")");
        }
    }

    public void trackProgress() {
        if (completedCourses.isEmpty()) {
            System.out.println("No courses completed yet.");
            return;
        }

        double totalGradePoints = 0;
        int totalCredits = 0;

        System.out.println("Completed Courses and Grades:");
        for (Course course : completedCourses) {
            System.out.println(course.getTitle() + " - Grade: A"); // Simplified
            totalGradePoints += 4 * course.getCredits();  // Assuming grade is 4 for 'A'
            totalCredits += course.getCredits();
        }

        sgpa = (int)(totalGradePoints / totalCredits);  // SGPA calculation
        System.out.println("Current SGPA: " + sgpa);

        // CGPA can be calculated similarly
        cgpa = (cgpa + sgpa) / 2;
        System.out.println("Current CGPA: " + cgpa);
    }

    public void dropCourse(String coursecode) {
        boolean found = false;

        for (Course course : registeredCourses) {
            if (course.getcourse_code().equals(coursecode)) {
                registeredCourses.remove(course);
                totalCredits -= course.getCredits();
                System.out.println("Dropped course: " + course.getTitle());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Course not found or not registered.");
        }
    }

    public void submitComplaint(String description) {
        ComplaintSystem complaintSystem = new ComplaintSystem();
        complaintSystem.submitComplaint(description);
    }

    public void Stud1() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Stud1'");
    }
}

class Complaint {
    String description;
    String status;

    Complaint(String description) {
        this.description = description;
        this.status = "Pending";
    }

    public void updateStatus(String status) {
        this.status = status;
        System.out.println("Complaint status updated to: " + status);
    }

    public String toString() {
        return "Complaint: " + description + ", Status: " + status;
    }
}

// ComplaintSystem Class
class ComplaintSystem {
    Map<Integer, Complaint> complaints = new HashMap<>();
    int idCounter = 1;

    public void submitComplaint(String description) {
        complaints.put(idCounter, new Complaint(description));
        System.out.println("Complaint submitted: " + description);
        idCounter++;
    }

    public void updateComplaintStatus(int id, String status) {
        if (complaints.containsKey(id)) {
            complaints.get(id).updateStatus(status);
        } else {
            System.out.println("Complaint not found.");
        }
    }

    public void viewComplaints() {
        for (Map.Entry<Integer, Complaint> entry : complaints.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", " + entry.getValue());
        }
    }
}

public class Main {
    public static void Stud1() {
        // Setup sample student, courses, and complaints
        Student student = new Student("student@example.com", "password", 1, 1, 8, 9, 7);
        List<Course> availableCourses = new ArrayList<>();

        availableCourses.add(new Course("CS101", "Intro to Programming", "Dr. Smith", 4, "", "Mon-Wed 10 AM", 1));
        availableCourses.add(new Course("CS102", "Mathematics I", "Prof. John", 4, "", "Tue-Thu 11 AM", 1));

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for Course");
            System.out.println("3. View Schedule");
            System.out.println("4. Track Progress");
            System.out.println("5. Drop Course");
            System.out.println("6. Submit Complaint");
            System.out.println("7. Exit");

            int option = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    student.viewAvailableCourses(availableCourses);
                    break;
                case 2:
                    System.out.println("Enter course code to register:");
                    String coursecode = sc.nextLine();
                    boolean foundCourse = false;
                    for (Course course : availableCourses) {
                        if (course.getcourse_code().equals(coursecode)) {
                            student.registerCourse(course);
                            foundCourse = true;
                            break;
                        }
                    }
                    if (!foundCourse) {
                        System.out.println("Course not found.");
                    }
                    break;
                case 3:
                    student.viewSchedule();
                    break;
                case 4:
                    student.trackProgress();
                    break;
                case 5:
                    System.out.println("Enter course code to drop:");
                    String codeToDrop = sc.nextLine();
                    student.dropCourse(codeToDrop);
                    break;
                case 6:
                    System.out.println("Enter your complaint description:");
                    String complaintDesc = sc.nextLine();
                    student.submitComplaint(complaintDesc);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}