package entity;

import java.time.LocalTime;
import java.util.List;
import static service.ProjectUtils.random;

/**
 * Created by bulov on 21.02.2017.
 */
public class Employee {
    private String firstName;
    private String lastName;
    private List<Position> positions;
    private double salary;
    private boolean busy = false;
    private LocalTime endDoCommand = LocalTime.of(8, 0);
    private LocalTime endWorking;
    private long hoursWorked = 0;

    public Employee(String firstName, String lastName, int workingHours) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.endWorking = LocalTime.of(8+workingHours, 0);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBeginEndDoCommand(){
        this.endDoCommand = LocalTime.of(8, 0);
    }

    public void setEndDoCommand(LocalTime endDoCommand) {
        this.endDoCommand = endDoCommand.plusHours(random(2, 1));
    }

    public LocalTime getEndDoCommand() {
        return endDoCommand;
    }

    public LocalTime getEndWorking() {
        return endWorking;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public long getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(long hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
