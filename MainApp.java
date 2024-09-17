import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainApp {

    // Mock database to store email and password for each role
    private static Map<String, String> studentAccounts = new HashMap<>();
    private static Map<String, String> professorAccounts = new HashMap<>();
    private static final String ADMIN_EMAIL = "admin@example.com";
    private static final String ADMIN_PASSWORD = "admin123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pre-populating some data for students and professors
        studentAccounts.put("student@example.com", "studentPass");
        professorAccounts.put("professor@example.com", "professorPass");

        System.out.println("Enter your role (student/professor/admin): ");
        String role = scanner.nextLine().toLowerCase(); // Convert to lowercase for easier comparison

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        switch (role) {
            case "student":
                if (validateLogin(studentAccounts, email, password)) {
                    Main student = new Main();
                    Main.Stud1();  // Assuming this is the entry point for student functionalities
                } else {
                    System.out.println("Invalid student email or password!");
                }
                break;

            case "professor":
                if (validateLogin(professorAccounts, email, password)) {
                    Professor1 professor = new Professor1();
                    professor.select_option();  // Assuming this is the entry point for professor functionalities
                } else {
                    System.out.println("Invalid professor email or password!");
                }
                break;

            case "admin":
                if (email.equals(ADMIN_EMAIL) && password.equals(ADMIN_PASSWORD)) {
                    Admin admin = new Admin();
                    admin.select();  // Assuming this is the entry point for admin functionalities
                } else {
                    System.out.println("Invalid admin email or password!");
                }
                break;

            default:
                System.out.println("Invalid role! Please try again.");
                break;
        }

        scanner.close();
    }

    // Method to validate login based on role
    public static boolean validateLogin(Map<String, String> accounts, String email, String password) {
        return accounts.containsKey(email) && accounts.get(email).equals(password);
    }
}