package workModel;

import entity.Employee;
import entity.Position;
import entity.implementation.Accountant;
import office.Office;

import java.time.DayOfWeek;
import java.time.LocalDate;
import static service.ProjectUtils.*;


/**
 * Created by bulov on 23.02.2017.
 */
public class WorkWeek {
    private WorkDay workDay;
    private LocalDate endMonth;
    private Accountant accountant;


    WorkWeek(int month){
        this.workDay = new WorkDay(month);
        this.endMonth = workDay.getDay().plusMonths(1);
    }

    void workOneWeek(){
        LocalDate startDay = workDay.getDay();
        LocalDate endDay;

        while(workDay.getDay().getDayOfWeek()!= DayOfWeek.SATURDAY
                && workDay.getDay().getDayOfWeek()!= DayOfWeek.SUNDAY
                && workDay.getDay().isBefore(endMonth)){
            workDay.workOneDay();
        }
        endDay = workDay.getDay();

        accountant = getOneAccountant();
        if (getWorkDays(startDay, endDay)!=0) {
            accountant.paySalary(workDay.getOffice().getEmployees(), startDay, endDay);
        }

        getOffice().getEmployees().forEach(e -> e.setHoursWorked(0));
        workDay.setDay(workDay.getDay().plusDays(1));
    }

    private Accountant getOneAccountant(){
        for (Employee employee: workDay.getOffice().getEmployees()){
            for (Position position: employee.getPositions()) {
                if (position.getName().equals("Accountant")) return (Accountant) position;
            }
        }
        return null;
    }

    public LocalDate getDay() {
        return workDay.getDay();
    }

    public LocalDate getEndMonth() {
        return endMonth;
    }

    public Office getOffice(){
        return workDay.getOffice();
    }

    public WorkDay getWorkDay() {
        return workDay;
    }

    public Accountant getAccountant() {
        return accountant;
    }
}
