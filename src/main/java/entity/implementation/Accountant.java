package entity.implementation;

import entity.Employee;
import entity.Position;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by bulov on 22.02.2017.
 */
public class Accountant extends Position {
    private StringBuilder report = new StringBuilder();

    public Accountant() {
        super("Accountant", 3500);
    }

    private int count = 0;
    public void paySalary(List<Employee> employees, LocalDate startDate, LocalDate endDate){

        LocalDate end = endDate.minusDays(1);
        Employee employeeCheck = null;

        report.append("\n" + startDate + " - " + end + "\n");
        count++;

        for(Employee employee: employees){

            if(employeeCheck == employee) continue;
            employeeCheck = employee;

            double salary = employee.getSalary();
            for(Position position: employee.getPositions()){
                switch (position.getName()){
                    case "Programmer":
                    case "Designer":
                    case "Tester":
                        if(employee.getHoursWorked()!=0){ double salaryForWeek = (position.getRate() * employee.getHoursWorked());
                            salary += salaryForWeek;
                            report.append("Pay " + salaryForWeek + "$ " + employee.getFirstName()
                                + " for work in position " + position.getName() + "\n");
                        break;
                        }
                    case "Director":
                    case "Accountant":
                    case "Manager":
                        if(count==3){
                            salary += position.getRate();
                            report.append("Pay " + position.getRate() + "$ " + employee.getFirstName()
                                    + " for work in position " + position.getName() + "\n");
                        }
                        break;
                }
            }
            employee.setSalary(salary);
        }
    }

    public StringBuilder getReport() {
        return report;
    }

    void makeStatements() {

    }
}
