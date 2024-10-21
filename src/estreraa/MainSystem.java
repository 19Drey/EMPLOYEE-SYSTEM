package estreraa;

import java.util.Scanner;

public class MainSystem {

    public static void main(String[] args) {
        // Start the main menu loop
        mainMenu();
    }

    // Main Menu Method
    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        String response;

        do {
            System.out.println("\nWelcome to the Employee Management System:");
            System.out.println("1. Manage Employee Information");
            System.out.println("2. Manage Employee Time Records");
            System.out.println("3. Exit");
            System.out.print("Enter option (1-3): ");
            int mainAction = sc.nextInt();

            if (mainAction == 1) {
                // Call the Employee Information System
                EmployeeS employeeSystem = new EmployeeS();
                employeeSystem.EmployeeInfo();
            } else if (mainAction == 2) {
                // Call the Employee Time Record System
                Employee employeeTimeSystem = new Employee();
                employeeTimeSystem.EmployeeTime();
            } else if (mainAction == 3) {
                System.out.println("Exiting the system. Thank you!");
                return;  // Exit the program
            } else {
                System.out.println("Invalid option. Please try again.");
            }

            System.out.print("Do you want to continue using the system? (yes/no): ");
            response = sc.next();
        } while (response.equalsIgnoreCase("yes"));

        System.out.println("Thank you for using the Employee Management System!");
    }
}
