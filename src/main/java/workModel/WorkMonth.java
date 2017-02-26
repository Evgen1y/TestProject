package workModel;

import entity.Employee;
import entity.Position;
import entity.implementation.Accountant;
import office.Office;

import java.time.LocalDate;

/**
 * Created by bulov on 23.02.2017.
 */
public class WorkMonth {
    WorkWeek workWeek;

    public WorkMonth(int month) {
        workWeek = new WorkWeek(month);
        while (workWeek.getDay().isBefore(workWeek.getEndMonth())){
            workWeek.workOneWeek();
        }

    }



    public Office getOffice(){
        return workWeek.getOffice();
    }
}
