package HERANCA;

public class Program {
    public static void main(String[] args) {
        Account acc = new Account(1001, "Alex", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        //UPCASTING
        //Atribuir um objeto do tipo BusinessAccount e atribui-lo para uma variável do tipo account
        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(1003, "John", 0.0, 200.0);
        Account acc3 = new SavingsAccount(1004, "Jane", 0.0, 300.0);

        //DOWNCASTING

        //Da seguinte forma não é possível, já que não sabe-se se é seguro BusinessAccount acc4 = acc2;
        //Deve ser realizado um casting manual!
        BusinessAccount acc4 = (BusinessAccount)acc2;
        acc4.loan(100.0);

        //Isso não é possível, já que o acc5 é originalmente um SavingsAccount: BusinessAccount acc5 = (BusinessAccount)acc3;
        //Antes de fazer um downcasting deve ser realizado um teste utilizando istance of

        if(acc3 instanceof BusinessAccount){
            BusinessAccount acc5 = (BusinessAccount)acc3;
            acc5.loan(100.0);
        }

        if(acc3 instanceof SavingsAccount){
            SavingsAccount acc5 = (SavingsAccount) acc3;
            acc5.updateBalance();
            System.out.println("Balance after update: " + acc5.getBalance());
        }
    }
}
