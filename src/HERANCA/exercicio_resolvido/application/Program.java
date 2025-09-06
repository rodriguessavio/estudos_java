package HERANCA.exercicio_resolvido.application;

import HERANCA.exercicio_resolvido.entities.Employee;
import HERANCA.exercicio_resolvido.entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Employee> Employees = new ArrayList<>();

        System.out.println("Enter the number of employees: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < n ; i++){
            System.out.println("Employee #"+(i+1)+" data: \n");
            System.out.println("Outsourced (y/n): ");
            String outsourced_response = scanner.nextLine();

            System.out.println("Name ");
            String name = scanner.next();
            System.out.println("Hours");
            Integer hours = scanner.nextInt();
            System.out.println("Value per hour");
            Double valuePerHour = scanner.nextDouble();

            if(outsourced_response.equals("y")){
                System.out.println("Additional charge: ");
                double additionalCharge = scanner.nextDouble();
                Employee a = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
                Employees.add(a);
            } else {
                Employee a = new Employee(name, hours, valuePerHour);
                Employees.add(a);
            }
            scanner.nextLine();
        }

        System.out.println("PAYMENTS: ");
        for(Employee e: Employees){
            System.out.println(e.getName() +" - $"+ e.payment());
        }

        scanner.close();
    }
}
