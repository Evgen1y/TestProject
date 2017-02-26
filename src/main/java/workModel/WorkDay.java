package workModel;


import entity.Employee;
import entity.implementation.Director;
import office.Office;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by bulov on 23.02.2017.
 */
public class WorkDay {
    private Office office = new Office();
    private LocalDate day;
    private List<Employee> directors = office.getDirectors();
    private List<Employee> notDirectors = office.getEmployeesNotDirectors();
    private LocalTime workingTime = LocalTime.of(8, 0);

    WorkDay(int month) {
        this.day = LocalDate.of(2017, month, 1);
    }

    void workOneDay(){
        if(!day.getDayOfWeek().equals(DayOfWeek.SATURDAY) || !day.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            for (int hour = workingTime.getHour(); hour <= 16; hour++, workingTime = workingTime.plusHours(1)) {
                System.out.println(workingTime.toString());
                directorGiveCommand();
            }
            workingTime = LocalTime.of(8, 0);
        }
        System.out.println(day.toString());
        day = day.plusDays(1);
        newTimeInNewDay(office.getEmployees());
        //office.getEmployees().forEach(System.out::println);
    }

    private void directorGiveCommand(){
        for(Employee employee: directors){
            Director director = (Director) employee.getPositions().stream()
                    .filter(p -> p.getName().equals("Director"))
                    .findFirst()
                    .get();
            director.giveCommand(notDirectors, workingTime);
        }
    }

    private void newTimeInNewDay(List<Employee> employees){
        employees.forEach(e -> e.setBusy(false));
        employees.forEach(Employee::setBeginEndDoCommand);
    }

    LocalDate getDay() {
        return day;
    }

    void setDay(LocalDate day) {
        this.day = day;
    }

    public Office getOffice() {
        return office;
    }
}

