package INTERFACE.application;

import INTERFACE.entities.Contract;
import INTERFACE.entities.Installment;
import INTERFACE.services.ContractService;
import INTERFACE.services.PayPalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre com os dados do contrato: ");
        System.out.println("Número: ");
        Integer number = scanner.nextInt();
        System.out.println("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(scanner.next(), fmt);
        System.out.println("Valor do contrato: ");
        Double valueContract = scanner.nextDouble();

        Contract contract = new Contract(number, date, valueContract);

        System.out.println("Entre com o número de parcelas: ");
        Integer months = scanner.nextInt();

        PayPalService payPalService = new PayPalService();

        ContractService contractService = new ContractService(payPalService);
        contractService.processContract(contract, months);

        System.out.println("Parcelas: ");

        for (Installment q : contract.getInstallments()) {
            System.out.println(q.getDueDate().format(fmt) + " - " + q.getAmount());
        }
        scanner.close();
    }
}
