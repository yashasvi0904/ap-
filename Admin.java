import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Course Class
class Course {
    private String Coursename;

    Course(String Coursename) {
        this.Coursename = Coursename;
    }

    public String Coursename() {
        return Coursename;
    }

    public String toString() {
        return Coursename;
    }

    // Nested class for Course Catalog
    static class Catalog {
        List<Course> courses = new ArrayList<>();

        public void addCourse(String Coursename) {
            courses.add(new Course(Coursename));
            System.out.println(Coursename + " added to catalog.");
        }

        public void removeCourse(String Coursename) {
            courses.removeIf(course -> course.Coursename.equals(Coursename));
            System.out.println(Coursename + " removed from catalog.");
        }

        public void viewCourses() {
            System.out.println("Course Catalog: ");
            for (Course course : courses) {
                System.out.println(course.Coursename());
            }
        }
    }
}

// Student Class
class Student {
    String name;
    String grade;
    String personal_info;

    Student(String name, String grade, String personal_info) {
        this.name = name;
        this.grade = grade;
        this.personal_info = personal_info;
    }

    public void updateGrade(String grade) {
        this.grade = grade;
        System.out.println(name + "'s grade updated to " + grade);
    }

    public void updatepersonal_info(String personal_info) {
        this.personal_info = personal_info;
        System.out.println(name + "'s personal info updated.");
    }

    public String toString() {
        return name + " - Grade: " + grade + ", Info: " + personal_info;
    }
}

// Professor Class
class Professor {
    String name;

    Professor(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public void select1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Professor Menu:");
        System.out.println("1. Assign to Course");
        System.out.println("2. View Courses");
        System.out.println("3. Exit");

        int option = sc.nextInt();
        sc.nextLine(); // Consume newline

        switch (option) {
            case 1:
                assignToCourse();
                break;
            case 2:
                viewCourses();
                break;
            case 3:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void assignToCourse() {
        Course.Catalog catalog = new Course.Catalog();
        catalog.addCourse("Mathematics");
        catalog.addCourse("Physics");

        catalog.viewCourses();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the course to assign:");
        String Coursename = sc.nextLine();

        Course course = new Course(Coursename);
        System.out.println("Enter professor name:");
        String professorName = sc.nextLine();
        Professor professor = new Professor(professorName);

        CourseAssignment assignment = new CourseAssignment();
        assignment.assignProfessor(course, professor);
        sc.close();
    }

    private void viewCourses() {
        Course.Catalog catalog = new Course.Catalog();
        catalog.addCourse("Mathematics");
        catalog.addCourse("Physics");
        catalog.viewCourses();
    }

    public void select_option() {
        
        throw new UnsupportedOperationException("Unimplemented method 'select_option'");
    }
}

// CourseAssignment Class
class CourseAssignment {
    public void assignProfessor(Course course, Professor professor) {
        System.out.println(professor + " has been assigned to the course: " + course.Coursename());
    }
}

// Complaint Class
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
    int id_number = 1;

    public void submitComplaint(String description) {
        complaints.put(id_number, new Complaint(description));
        System.out.println("Complaint submitted: " + description);
        id_number++;
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

    public void filterComplaintsByStatus(String status) {
        complaints.values().stream()
            .filter(complaint -> complaint.status.equals(status))
            .forEach(System.out::println);
    }
}

// Admin Class
public class Admin {
    public void select() {
        Course.Catalog catalog = new Course.Catalog();
        ComplaintSystem complaintSystem = new ComplaintSystem();
        Scanner sc = new Scanner(System.in);
        boolean working = true;
        
        while (working) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Manage Course Catalog");
            System.out.println("2. Manage Students");
            System.out.println("3. Assign Professor to Courses");
            System.out.println("4. View Complaints");
            System.out.println("5. Exit");

            System.out.print("Select an option: ");
            int option = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    manageCourseCatalog(catalog, sc);
                    break;

                case 2:
                    manageStudents(sc);
                    break;

                case 3:
                    Professor professor = new Professor("Default");
                    professor.select1(); // Professor will manage course assignment
                    break;

                case 4:
                    manageComplaints(complaintSystem, sc);
                    break;

                case 5:
                    working = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        sc.close();
    }

    private void manageCourseCatalog(Course.Catalog catalog, Scanner sc) {
        System.out.println("Course Catalog Menu:");
        System.out.println("1. Add Course");
        System.out.println("2. Remove Course");
        System.out.println("3. View Courses");
        System.out.print("Select an option: ");
        
        int courseoption = sc.nextInt();
        sc.nextLine(); // Consume newline

        switch (courseoption) {
            case 1:
                System.out.print("Enter course name to add: ");
                String CoursenameToAdd = sc.nextLine();
                catalog.addCourse(CoursenameToAdd);
                break;
            case 2:
                System.out.print("Enter course name to remove: ");
                String CoursenameToRemove = sc.nextLine();
                catalog.removeCourse(CoursenameToRemove);
                break;
            case 3:
                catalog.viewCourses();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private void manageStudents(Scanner sc) {
        System.out.println("Student Menu:");
        System.out.println("Feature for managing students will be added.");
    }

    private void manageComplaints(ComplaintSystem complaintSystem, Scanner sc) {
        System.out.println("Complaint Menu:");
        System.out.println("1. Submit Complaint");
        System.out.println("2. Update Complaint Status");
        System.out.println("3. View Complaints");
        System.out.print("Select an option: ");
        
        int complaintOption = sc.nextInt();
        sc.nextLine(); // Consume newline

        switch (complaintOption) {
            case 1:
                System.out.print("Enter complaint description: ");
                String description = sc.nextLine();
                complaintSystem.submitComplaint(description);
                break;
            case 2:
                System.out.print("Enter complaint ID: ");
                int id = sc.nextInt();
                sc.nextLine(); // Consume newline
                System.out.print("Enter new status: ");
                String status = sc.nextLine();
                complaintSystem.updateComplaintStatus(id, status);
                break;
            case 3:
                complaintSystem.viewComplaints();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}