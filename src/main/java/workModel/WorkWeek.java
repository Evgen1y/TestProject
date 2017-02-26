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

    public WorkWeek(int month){
        this.workDay = new WorkDay(month);
        this.endMonth = workDay.getDay().plusMonths(1);
    }

    public void workOneWeek(){
        LocalDate startDay = workDay.getDay();
        LocalDate endDay;
        Accountant accountant;
        while(workDay.getDay().getDayOfWeek()!= DayOfWeek.SATURDAY
                && workDay.getDay().getDayOfWeek()!= DayOfWeek.SUNDAY
                && workDay.getDay().isBefore(endMonth)){
            System.out.println(workDay.getDay().getDayOfWeek());
            workDay.workOneDay();
        }
        endDay = workDay.getDay();
        getWorkDays(startDay, endDay);
        accountant = getOneAccountant();
        if (getWorkDays(startDay, startDay)!=0) {
            accountant.paySalary(workDay.getOffice().getEmployees(), getWorkDays(startDay, endDay));
        }
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
}
