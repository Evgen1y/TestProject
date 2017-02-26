


import entity.Employee;
import entity.Position;
import entity.implementation.*;
import office.Office;
import workModel.WorkDay;
import workModel.WorkMonth;
import workModel.WorkWeek;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static service.ProjectUtils.*;


/**
 * Created by bulov on 21.02.2017.
 */
public class Main {

    public static void main(String[] args) {

        WorkMonth workMonth = new WorkMonth(3);

        System.out.println(workMonth.getOffice().getDirectors().size());
        System.out.println(workMonth.getOffice().getEmployees().size());
        System.out.println(workMonth.getOffice().getEmployees());



    }
}

