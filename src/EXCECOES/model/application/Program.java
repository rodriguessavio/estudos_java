package EXCECOES.model.application;

import EXCECOES.model.entities.Account;
import EXCECOES.model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data:");

        System.out.println("Number: ");
        Integer number = sc.nextInt();

        System.out.println("Holder: ");
        sc.nextLine();
        String holder = sc.nextLine();

        System.out.println("Initial Balance: ");
        Double balance = sc.nextDouble();
        sc.nextLine();

        System.out.println("Withdraw limit: ");
        Double withdrawLimit = sc.nextDouble();
        System.out.println("\n\n");


        Account acc1 = new Account(number, holder, balance, withdrawLimit);

        System.out.println("Enter amount for withdraw: ");
        Double withdraw = sc.nextDouble();

        try{
            acc1.withdraw(withdraw);
            System.out.println("New balance: " + acc1.getBalance());
            sc.close();
        }catch(DomainException e){
            System.out.println(e.getMessage());
        }

    }
}
