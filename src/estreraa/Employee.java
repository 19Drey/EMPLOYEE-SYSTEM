package estreraa;

import static estreraa.MainSystem.mainMenu;
import java.util.Scanner;

public class Employee {

    public void EmployeeTime() {
        Scanner sc = new Scanner(System.in);
        String response;

        do {
            System.out.println("1. ADD TIME IN/OUT");
            System.out.println("2. VIEW PAYSLIP");
            System.out.println("3. UPDATE TIME");
            System.out.println("4. DELETE TIME RECORD");
             System.out.println("5. Back to main menu");

            System.out.print("Enter action: ");
            int action = sc.nextInt();

            EmployeeSystem system = new EmployeeSystem();
            switch (action) {
                case 1:
                    system.addTimeRecord();
                    break;
                case 2:
                    system.viewPayslip();
                    break;
                case 3:
                    system.updateTimeRecord();
                    break;
                case 4:
                    system.deleteTimeRecord();
                    break;
                case 5:
                    mainMenu();
                default:
                    System.out.println("Invalid action.");
                    break;
            }

            System.out.print("Do you want to continue? (yes/no): ");
            response = sc.next();

        } while (response.equalsIgnoreCase("yes"));
        System.out.println("Thank you, See you!!");
    }
}
