package LIST;

public class Dados {
    public int id;
    public String name;
    private double salary;

    Dados(int id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }
}
