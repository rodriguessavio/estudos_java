package LIST;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Dados> dadosUsuarios = new ArrayList<>();

        System.out.println("How many emplyoees will be registered?");
        int n = scanner.nextInt();

        for(int i = 1 ; i <= n ; i++){
            System.out.println("Emplyoee #"+i+": ");
            System.out.println("ID: ");
            int id = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Name: ");
            String name = scanner.nextLine();
            System.out.println("Salary: ");
            double salary = scanner.nextDouble();
            Dados obj = new Dados(id, name, salary);
            dadosUsuarios.add(obj);
        }

        System.out.println("Enter the employee id that will have salary increase: ");
        int idUsuario = scanner.nextInt();

        Integer result = dadosUsuarios.stream().filter(x -> x.id == idUsuario).map(x->x.id).findFirst().orElse(null);

        if(result == null){
            System.out.println("User not exister!!!");
            return;
        }

        System.out.println("Enter the percentage: ");
        double percentage = scanner.nextInt();



        System.out.println("List of Employee: ");
        if( result != null){
            for (Dados usuario : dadosUsuarios){
                if(usuario.id == result){
                    double valor = ((percentage/100) * usuario.getSalary());
                    double valor_total = valor + usuario.getSalary();
                    usuario.setSalary(valor_total);
                }
                System.out.println(usuario.id + "," + usuario.name + "," + usuario.getSalary());
            }
        }





    }
}