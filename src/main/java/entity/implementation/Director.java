package entity.implementation;

import entity.Employee;
import entity.Position;

import static service.ProjectUtils.random;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Created by bulov on 22.02.2017.
 */
public class Director extends Position {
    StringBuilder report = new StringBuilder();
    LocalDate day;

    public Director() {
        super("Director", 5000);
    }

    public void giveCommand(List<Employee> employees, LocalTime workTime, LocalDate day) {
        this.day = day;
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

    private void checkEmployeesAndGiveWork(List<Employee> employees, String position, LocalTime workTime){
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
//                    System.out.println(employee.getFirstName()+" working time out.");
                    continue;
                }

                if (employee.isBusy()
                        && employee.getEndDoCommand().isBefore(workTime)
                        || employee.isBusy() && employee.getEndDoCommand().equals(workTime)) {
                    employee.setBusy(false);
//                    System.out.println(employee.getFirstName()+" is not busy now.");
                }

                if (employee.isBusy()){
//                    System.out.println(employee.getFirstName() + " is busy now");
                    continue;
                }

                count++;
                workForPosition(employee, position, workTime);
                break;
            }

        }
        if (count==0) report.append(day.format(DateTimeFormatter.ISO_DATE) + " Give work for freelancer\n");
    }

    private void workForPosition(Employee employee, String position, LocalTime workTime){
        long hoursWorked = employee.getHoursWorked();
        report.append(day.format(DateTimeFormatter.ISO_DATE) + " ");
        DateTimeFormatter formatter = DateTimeFormatter.ISO_TIME;
        Position pos = employee.getPositions().stream()
                .filter(p -> p.getName().equals(position))
                .findFirst()
                .get();
        hoursWorked += ChronoUnit.HOURS.between(employee.getEndDoCommand(), workTime);
        employee.setHoursWorked(hoursWorked);

        switch (pos.getName()) {
            case "Accountant":
                ((Accountant) pos).makeStatements();
                employee.setBusy(true);
                employee.setEndDoCommand(workTime);
                report.append(employee.getFirstName() + " "
                        + employee.getLastName()
                        + " make statements from " + workTime.format(formatter)
                        + " to " + employee.getEndDoCommand().format(formatter) + "\n");
                break;
            case "Designer":
                ((Designer) pos).drawLayout();
                employee.setBusy(true);
                employee.setEndDoCommand(workTime);
                report.append(employee.getFirstName() + " "
                        + employee.getLastName()
                        + " draw layout from " + workTime.format(formatter)
                        + " to " + employee.getEndDoCommand().format(formatter) + "\n");
                break;
            case "Manager":
                ((Manager) pos).sellService();
                employee.setBusy(true);
                employee.setEndDoCommand(workTime);
                report.append(employee.getFirstName() + " "
                        + employee.getLastName()
                        + " sell service from " + workTime.format(formatter)
                        + " to " + employee.getEndDoCommand().format(formatter) + "\n");
                break;
            case "Programmer":
                ((Programmer) pos).writeCode();
                employee.setBusy(true);
                employee.setEndDoCommand(workTime);
                report.append(employee.getFirstName() + " "
                        + employee.getLastName()
                        + " write code " + workTime.format(formatter)
                        + " to " + employee.getEndDoCommand().format(formatter) + "\n");
                break;
            case "Tester":
                ((Tester) pos).testingProgramm();
                employee.setBusy(true);
                employee.setEndDoCommand(workTime);
                report.append(employee.getFirstName() + " "
                        + employee.getLastName()
                        + " testing program from " + workTime.format(formatter)
                        + " to " + employee.getEndDoCommand().format(formatter) + "\n");
                break;
            default:
                report.append("Give " + pos.getName().toLowerCase() +  " work for freelancer\n");
        }
    }

    public StringBuilder getReport() {
        return report;
    }
}






















