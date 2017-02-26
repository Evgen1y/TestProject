package office;

import entity.Employee;
import entity.Position;
import entity.implementation.*;

import static service.ProjectUtils.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bulov on 22.02.2017.
 */

public class Office {

    private List<Employee> employees = new ArrayList<>();

    public Office() {
        createEmployees();
    }

    public List<Employee> getDirectors() {
        List<Employee> directors = new ArrayList<>();
        for(Employee employee: employees){
            for(Position position: employee.getPositions()){
                if(position.getName().equals("Director")) directors.add(employee);
            }
         }
        return directors;
    }

    public List<Employee> getEmployeesNotDirectors() {
        List<Employee> notDirectors = new ArrayList<>();
        for(Employee employee: employees){
            for(Position position: employee.getPositions()){
                if(!position.getName().equals("Director")) notDirectors.add(employee);
            }
        }
        return notDirectors;
    }

    private void createEmployees(){
        for(int i = 1; i < random(101, 11); i++){
            employees.add(new Employee("First name "+ i, "Last Name " + i, random(8, 6), i));
        }
        int countDirector = 0;
        for(Employee employee: employees){
            int random;
            List<Position> positions = new ArrayList<>();
            List<Integer> checkPosition = new ArrayList<>();
            for(int i = 0; i < random(2, 1); i++){
                random = random(6, 1);
                if(checkPosition.contains(random)) break;
                checkPosition.add(random);
                switch (checkPosition.get(i)){
                    case 1: positions.add(new Accountant());
                        break;
                    case 2: positions.add(new Designer());
                        break;
                    case 3: if(countDirector < 1){
                        positions.add(new Director());
                        countDirector++;
                        break;
                    }
                        if (positions.isEmpty()) positions.add(new Programmer());
                        break;
                    case 4: positions.add(new Manager());
                        break;
                    case 5: positions.add(new Programmer());
                        break;
                    case 6: positions.add(new Tester());
                }
            }
            employee.setPositions(positions);
        }
        employees.get(random(employees.size()-1, 1)).getPositions().add(new Director());
        employees.get(random(employees.size()-1, 1)).getPositions().add(new Accountant());
        employees.get(random(employees.size()-1, 1)).getPositions().add(new Manager());
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
