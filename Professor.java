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
            System.out.println("course Name"+ courseName + " "+"Syallbus" + syllabus + " "+"Class Timings" + classTimings + " "+"Credits" + credits + " "+"Prerequisites" + prerequisites
                    + " "+ "Enrollment Limit" + enrollmentLimit + " "+ "Office Hours" + officeHours);

        }
    }
    class Student {
        public String name;
        public String academicStanding;
        public String contactDetails;

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
    

        public static void editCourse() {
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < courses.size(); i++) {
                System.out.println(courses.get(i).courseName());
            }
            System.out.println("Enter the course name");

            String courseName = sc.nextLine();

            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).courseName().equals(courseName)) {
                    System.out.println("Enter the option");
                    System.out.println("1. Edit Syallbus");
                    System.out.println("2. Edit Class Timings");
                    System.out.println("3. Edit Credits");
                    System.out.println("4. Edit Prerequisites");
                    System.out.println("5. Edit Enrollment Limit");
                    System.out.println("6. Edit Office Hours");
                    int option = sc.nextInt();
                    sc.nextLine();
                    if (option == 1) {
                        System.out.println("Enter the Syallbus");
                        String syllabus = sc.nextLine();
                        courses.get(i).syallbus_edit(syllabus);
                    }

                    if (option == 2) {
                        System.out.println("Enter the Class Timings");
                        String classTimings = sc.nextLine();
                        courses.get(i).classTimings_edit(classTimings);
                    }

                    if (option == 3) {
                        System.out.println("Enter the Credits");
                        int credits = sc.nextInt();
                        courses.get(i).credits_edit(credits);
                    }

                    if (option == 4) {
                        System.out.println("Enter the Prerequisites");
                        String prerequisites = sc.nextLine();
                        courses.get(i).prerequisites_edit(prerequisites);
                    }

                    if (option == 5) {
                        System.out.println("Enter the Enrollment Limit");
                        int enrollmentLimit = sc.nextInt();
                        courses.get(i).enrollmentLimit_edit(enrollmentLimit);
                    }

                    if (option == 6) {
                        System.out.println("Enter the Office Hours");
                        String officeHours = sc.nextLine();
                        courses.get(i).officeHours_edit(officeHours);
                    }

                    sc.close();
                    courses.get(i).display();
                    break;
                }
            }

        }

        public static void enrolledStudents() {
            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(i).name + " " + students.get(i).academicStanding + " "
                        + students.get(i).contactDetails);
            }
            System.out.println("Thanks for using the professor portal");


        }
}
        
        


    
