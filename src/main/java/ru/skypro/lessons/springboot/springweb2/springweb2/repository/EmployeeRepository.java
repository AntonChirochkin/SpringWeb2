package ru.skypro.lessons.springboot.springweb2.springweb2.repository;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.springweb2.springweb2.delo.Employee;

import java.util.*;

@Repository
public class EmployeeRepository {
    private final List<Employee> employeeList = new ArrayList<>();
    @PostConstruct
    public void init() {
        employeeList.add(new Employee("Катя", 90_000));
        employeeList.add(new Employee("Дима", 102_000));
        employeeList.add(new Employee("Олег", 80_000));
        employeeList.add(new Employee("Вика", 165_000));
        employeeList.add(new Employee("Женя", 175_000));
    }
    public List<Employee> getAll() {
        return Collections.unmodifiableList(employeeList);
    }

    public Employee add(Employee employee) {

        employeeList.add(employee);

        return employee;
    }



    public void update(int id, Employee employee) {
        int indexForUpdating = findIndexById(id);
        if (indexForUpdating != -1) {
            employeeList.set(indexForUpdating, employee);
        }
    }

    public Optional<Employee> findById(int id) {
        return employeeList.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();
    }

    public void delete(int id) {
        int indexForRemoving = findIndexById(id);
        if (indexForRemoving != -1) {
            employeeList.remove(indexForRemoving);
        }
    }

    private int findIndexById(int id) {
        int index = -1;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }
}
