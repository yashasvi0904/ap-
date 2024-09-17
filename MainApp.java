import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter your role (student/professor/admin): ");
        String role = scanner.nextLine().toLowerCase(); // Convert to lowercase for easier comparison

        switch (role) {
            // case "student":
            //     Student student = new Student();
            //     student.display();
            //     break;
            case "professor":
                Professor1 professor = new Professor1();
                professor.select_option();
                break;
            case "admin":
                Admin admin = new Admin();
                admin.select();
                break;
            default:
                System.out.println("Invalid role! Please try again.");
                break;
        }

        scanner.close();
    }
}