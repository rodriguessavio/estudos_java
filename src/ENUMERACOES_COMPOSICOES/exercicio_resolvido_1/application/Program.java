package ENUMERACOES_COMPOSICOES.exercicio_resolvido_1.application;

import ENUMERACOES_COMPOSICOES.exercicio_resolvido_1.entities.Departament;
import ENUMERACOES_COMPOSICOES.exercicio_resolvido_1.entities.HourContract;
import ENUMERACOES_COMPOSICOES.exercicio_resolvido_1.entities.Worker;
import ENUMERACOES_COMPOSICOES.exercicio_resolvido_1.enums.WorkerLevel;

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

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base Salary: ");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departament(departmentName));
        System.out.print("How many contratcs to this worker? ");
        int n = sc.nextInt();

        for(int i = 1 ; i <= n ; i++){
            System.out.print("Enter contract #"+i+" data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();

            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();

        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        //significa a partir da posição 3:
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name" + worker.getName());
        System.out.println("Department" + worker.getDepartament().getName());
        System.out.println("Income for "+ monthAndYear + ": "+ String.format("%.2f", worker.income(year, month)));

        sc.close();
    }
}
