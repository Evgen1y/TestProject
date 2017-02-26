package entity.implementation;

import entity.Employee;
import entity.Position;

import java.time.LocalTime;
import java.util.List;

/**
 * Created by bulov on 22.02.2017.
 */
public class Accountant extends Position {

    public Accountant() {
        super("Accountant", 3500);
    }

    void makeStatements() {

    }

    int count = 0;
    public void paySalary(List<Employee> employees, int workDays){
        count++;
        for(Employee employee: employees){
            double salary = employee.getSalary();
            for(Position position: employee.getPositions()){
                switch (position.getName()){
                    case "Programmer":
                    case "Designer":
                    case "Tester":
                        salary += (position.getRate() * employee.getWorkingHours()) * workDays;
                        System.out.println("Pay " + salary + "$ " + employee.getFirstName()
                                + " for work in position " + position.getName());
                        break;
                    case "Director":
                    case "Accountant":
                    case "Manager":

                        if(count==3){
                            salary += position.getRate();
                            System.out.println("Pay" + position.getRate() + "$ " + employee.getFirstName()
                                    + " for work in position " + position.getName());
                        }
                        break;

                }

            }
            employee.setSalary(salary);

        }

    }
}
