package application;

import enitities.enums.WorkLevel;
import entities.Department;
import entities.HourContract;
import entities.Worker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        System.out.print("Enter department´s name: ");
        String deparmentName = sc.nextLine();
        System.out.println("Enter worker date: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base Salary: ");
        double baseSalary = sc.nextDouble();
        //instanciou um novo obj do tipo Worker, os dados sao nome, uma instancia de workerLevel, valor de salario,
        // novo obj do tipo departamento e o nome do departamento vai ser o que eu digitei
        Worker worker = new Worker(workerName, WorkLevel.valueOf(workerLevel), baseSalary,
                new Department(deparmentName));

        System.out.print("How many contracts to this worker? ");

        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter contract #" + i + "data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.println("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.println("Duration (hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

        sc.close();
    }
}
