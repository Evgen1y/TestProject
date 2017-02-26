package workModel;

import entity.Employee;
import entity.Position;
import entity.implementation.Accountant;
import entity.implementation.Director;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by bulov on 23.02.2017.
 */
public class WorkMonth {
    private WorkWeek workWeek;

    public WorkMonth(int month) {
        workWeek = new WorkWeek(month);
        while (workWeek.getDay().isBefore(workWeek.getEndMonth())){
            workWeek.workOneWeek();
        }
        doReport();
    }

    private void doReport () {
        Accountant accountant = workWeek.getAccountant();
        List<Employee> directors = workWeek.getOffice().getDirectors();
        try(FileWriter writer = new FileWriter("out/" + workWeek.getDay().getMonth() + ".txt")){
            for(Employee employee : directors){
                for(Position position: employee.getPositions()){
                    if(position.getName().equals("Director")){
                        writer.write("\n" + employee.getFirstName() + " report\n");
                        writer.write(((Director)position).getReport().toString());
                    }
                }
            }
            writer.write("\nAccountant report\n");
            writer.write(accountant.getReport().toString());
            writer.flush();
        }catch (IOException e){
            System.err.println("File not create!");
        }
    }
}
