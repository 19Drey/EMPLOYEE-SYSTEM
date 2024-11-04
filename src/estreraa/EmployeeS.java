package estreraa;

import static estreraa.MainSystem.mainMenu;
import java.util.Scanner;

public class EmployeeS {
public void EmployeeInfo() {
        Scanner sc = new Scanner(System.in);
        String response;

        EmployeeSystem system = new EmployeeSystem();
        do {
            System.out.println("Employee Management System:");
            System.out.println("1. ADD EMPLOYEE");
            System.out.println("2. VIEW ALL EMPLOYEES");
            System.out.println("3. UPDATE EMPLOYEE");
            System.out.println("4. DELETE EMPLOYEE");
            System.out.println("5. Back to main menu");
            System.out.println("Enter action (1-5): ");
            int action = sc.nextInt();
            
            switch (action) {
                case 1:
                    addEmployee(); 
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    mainMenu();
                default:
                    System.out.println("Invalid action. Please select a valid option.");
                    break;
            }

            System.out.print("Do you want to perform another action? (yes/no): ");
            response = sc.next();

        } while (response.equalsIgnoreCase("yes"));

        System.out.println("Thank you for using the Employee Management System!");
    }

    public void addEmployee() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();

        System.out.print("First Name: ");
        String firstName = sc.next();

        System.out.print("Last Name: ");
        String lastName = sc.next();

        System.out.print("Email: ");
        String email = sc.next();

        System.out.print("Department ID: ");
        int deptId = sc.nextInt();

        String sql = "INSERT INTO Employee (first_name, last_name, email, dept_id) VALUES (?, ?, ?, ?)";

        conf.addRecord(sql, firstName, lastName, email, deptId);
    }

    public void viewEmployees() {
        config conf = new config();
        String qry = "SELECT * from Employee";
        String[] hdrs = {"Employee ID", "First Name", "Last Name", "Email", "Department"};
        String[] clmn = {"emp_id", "first_name", "last_name", "email", "dept_id"};

        conf.viewRecords(qry, hdrs, clmn);
    }

    public void updateEmployee() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID to Update: ");
        int empId = sc.nextInt();

        System.out.print("New First Name: ");
        String newFirstName = sc.next();

        System.out.print("New Last Name: ");
        String newLastName = sc.next();

        System.out.print("New Email: ");
        String newEmail = sc.next();

        System.out.print("New Department ID: ");
        int newDeptId = sc.nextInt();

        String qry = "UPDATE Employee SET first_name = ?, last_name = ?, email = ?, dept_id = ? WHERE emp_id = ?";

        config conf = new config();
        conf.updateRecord(qry, newFirstName, newLastName, newEmail, newDeptId, empId);
    }

    public void deleteEmployee() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID to delete: ");
        int empId = sc.nextInt();

        String qry = "DELETE FROM Employee WHERE emp_id = ?";

        config conf = new config();
        conf.deleteRecord(qry, empId);
    }
}
