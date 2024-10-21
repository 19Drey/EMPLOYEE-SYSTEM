package estreraa;

import java.util.Scanner;

public class EmployeeSystem {

    public void addTimeRecord() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Employee ID: ");
        int empId = sc.nextInt();
        System.out.print("Department: ");
        String dept = sc.next();
        System.out.print("Time In (yyyy-mm-dd hh:mm:ss): ");
        String timeIn = sc.next();
        System.out.print("Time Out (yyyy-mm-dd hh:mm:ss): ");
        String timeOut = sc.next();

        String sql = "INSERT INTO EmployeeTime (emp_id, time_in, time_out, department) VALUES (?, ?, ?, ?)";

        conf.addRecord(sql, empId, timeIn, timeOut, dept);
    }

    public void viewPayslip() {
        config conf = new config();
        String qry = "SELECT * FROM EmployeeTime";
        String[] hdrs = {"ID", "Employee ID", "Time In", "Time Out", "Department"};
        String[] clmn = {"id", "emp_id", "time_in", "time_out", "department"};

        conf.viewRecords(qry, hdrs, clmn);
    }

    public void updateTimeRecord() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Record ID: ");
        int id = sc.nextInt();

        System.out.print("New Time In (yyyy-mm-dd hh:mm:ss): ");
        String nTimeIn = sc.next();
        System.out.print("New Time Out (yyyy-mm-dd hh:mm:ss): ");
        String nTimeOut = sc.next();
        System.out.print("New Department: ");
        String nDept = sc.next();

        String qry = "UPDATE EmployeeTime SET time_in = ?, time_out = ?, department = ? WHERE emp_id = ?";

        config conf = new config();
        conf.updateRecord(qry, nTimeIn, nTimeOut, nDept, id);
    }

    public void deleteTimeRecord() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Record ID to delete: ");
        int id = sc.nextInt();

        String qry = "DELETE FROM EmployeeTime WHERE id = ?";

        config conf = new config();
        conf.deleteRecord(qry, id);
    }
}
