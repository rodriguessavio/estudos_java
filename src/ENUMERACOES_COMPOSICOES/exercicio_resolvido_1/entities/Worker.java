package ENUMERACOES_COMPOSICOES.exercicio_resolvido_1.entities;

import ENUMERACOES_COMPOSICOES.exercicio_resolvido_1.entities.HourContract;
import ENUMERACOES_COMPOSICOES.exercicio_resolvido_1.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private double baseSalary;

    private Departament departament;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker() {
    }

    public Worker(String name, WorkerLevel level, double baseSalary, Departament departament) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departament = departament;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    //O método abaixo não pode existir, pois ele substitui a lista que definimos lá em cima por outra
    //    public void setContracts(List<HourContract> contracts) {
    //        this.contracts = contracts;
    //    }

    public void addContract(HourContract contract){
        contracts.add(contract);
    }

    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }

    public double income(Integer year, Integer month){
        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        for (HourContract c : contracts){
            //Para cada contrato será setado no calendário a data do contrato
            cal.setTime(c.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = cal.get(Calendar.MONTH) + 1;
            if(year == c_year && month == c_month){
                sum += c.totalValue();
            }
        }
        return sum;
    }
}
