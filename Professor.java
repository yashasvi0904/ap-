/**
 * Student
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    class Course {
        private String courseName;
        private String syllabus;
        private String classTimings;
        private int credits;
        private String prerequisites;
        private int enrollmentLimit;
        private String officeHours;

        public Course(String courseName, String syllabus, String classTimings, int credits,
                String prerequisites, int enrollmentLimit, String officeHours) {
            this.courseName = courseName;
            this.syllabus = syllabus;
            this.classTimings = classTimings;
            this.credits = credits;
            this.prerequisites = prerequisites;
            this.enrollmentLimit = enrollmentLimit;
            this.officeHours = officeHours;
        }
    

        public String courseName() {
            return courseName;
        }

        public void syallbus_edit(String syllabus) {
            this.syllabus = syllabus;
        }

        public void classTimings_edit(String classTimings) {
            this.classTimings = classTimings;
        }

        public void credits_edit(int credits) {
            this.credits = credits;
        }

        public void prerequisites_edit(String prerequisites) {
            this.prerequisites = prerequisites;
        }

        public void enrollmentLimit_edit(int enrollmentLimit) {
            this.enrollmentLimit = enrollmentLimit;
        }

        public void officeHours_edit(String officeHours) {
            this.officeHours = officeHours;
        }

        public void display() {
            System.out.println(courseName + " " + syllabus + " " + classTimings + " " + credits + " " + prerequisites
                    + " " + enrollmentLimit + " " + officeHours);

        }
    }
    class Student {
        private String name;
        private String academicStanding;
        private String contactDetails;

        public Student(String name, String academicStanding, String contactDetails) {
            this.name = name;
            this.academicStanding = academicStanding;
            this.contactDetails = contactDetails;
        }
    }

    public class Professor {
        static List<Course> courses = new ArrayList<>();
        static List<Student> students = new ArrayList<>();

        public static void main(String[] args) {
            courses.add(new Course("Computer Science 101", "Intro to Programming", "Mon-Wed 10 AM", 3,
                    "None", 30, "Tue 2-4 PM"));

            courses.add(new Course("Computer Science 201", "Algorithms", "Mon-Wed 3 PM", 3, "Computer Science 101", 30,
                    "Tue 3-5 PM"));

            courses.add(
                    new Course("Computer Science 301", "Data Structures", "Mon-Wed 5 PM", 3, "Computer Science 201", 30,
                            "Tue 5-7 PM"));

            students.add(new Student("Yashasvi", "Good", "1234567890"));
            students.add(new Student("Sarthak", "Good", "1234567890"));
            students.add(new Student("Shreyas", "Good", "1234567890"));

            Scanner sc = new Scanner(System.in);
            System.out.println("Select the option");
            System.out.println("1. Edit Course");

            System.out.println("2. Enrolled Students");

            System.out.println("3. Exit");

            int option = sc.nextInt();
            if (option == 1) {
                editCourse();
            }

            if (option == 2) {
                enrolledStudents();
            }

            if (option == 3) {
                System.exit(0);
            }
        }
    }

    public static void editCourse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the course name");
        String courseName = sc.nextLine();
        
        


    
