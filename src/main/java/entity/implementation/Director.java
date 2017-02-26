package entity.implementation;

import entity.Employee;
import entity.Position;

import static service.ProjectUtils.random;

import java.time.LocalTime;
import java.util.List;

/**
 * Created by bulov on 22.02.2017.
 */
public class Director extends Position {

    public Director() {
        super("Director", 5000);
    }

    public void giveCommand(List<Employee> employees, LocalTime workTime) {
        int i = random(5, 1);
        String position = null;
        switch (i) {
            case 1:
                position = "Accountant";
                break;
            case 2:
                position = "Designer";
                break;
            case 3:
                position = "Manager";
                break;
            case 4:
                position = "Programmer";
                break;
            case 5:
                position = "Tester";
        }
        checkEmployeesAndGiveWork(employees, position, workTime);
    }

    public void checkEmployeesAndGiveWork(List<Employee> employees, String position, LocalTime workTime){
        int count = 0;
        Employee employeeCheck = null;
        for (Employee employee : employees) {
            if (employeeCheck == employee){
                continue;
            }
            employeeCheck = employee;

            if (employee.getPositions().stream()
                    .anyMatch(p -> p.getName().equals(position))){

                if (employee.getEndWorking().isBefore(workTime)){
                    System.out.println(employee.getFirstName()+" working time out.");
                    continue;
                }

                if (employee.isBusy()
                        && employee.getEndDoCommand().isBefore(workTime)
                        || employee.isBusy() && employee.getEndDoCommand().equals(workTime)) {
                    employee.setBusy(false);
                    System.out.println(employee.getFirstName()+" is not busy now.");
                }

                if (employee.isBusy()){
                    System.out.println(employee.getFirstName() + " is busy now");
                    continue;
                }

                count++;
                workForPosition(employee, position, workTime);
                break;
            }

        }
        if (count==0) System.out.println("Find freelancer");
    }

    private void workForPosition(Employee employee, String position, LocalTime workTime){
        Position pos = employee.getPositions().stream()
                .filter(p -> p.getName().equals(position))
                .findFirst()
                .get();

        switch (pos.getName()) {
            case "Accountant":
                System.out.println(employee.getFirstName()+" work");
                ((Accountant) pos).makeStatements();
                employee.setBusy(true);
                employee.setEndDoCommand(workTime);
                break;
            case "Designer":
                System.out.println(employee.getFirstName()+" work");
                ((Designer) pos).drawLayout();
                employee.setBusy(true);
                employee.setEndDoCommand(workTime);
                break;
            case "Manager":
                System.out.println(employee.getFirstName()+" work");
                ((Manager) pos).sellService();
                employee.setBusy(true);
                employee.setEndDoCommand(workTime);
                break;
            case "Programmer":
                System.out.println(employee.getFirstName()+" work");
                ((Programmer) pos).writeCode();
                employee.setBusy(true);
                employee.setEndDoCommand(workTime);
                break;
            case "Tester":
                System.out.println(employee.getFirstName()+" work");
                ((Tester) pos).testingProgramm();
                employee.setBusy(true);
                employee.setEndDoCommand(workTime);
                break;
            default:
                System.out.println("Give work for freelancer");
        }
    }
}






















