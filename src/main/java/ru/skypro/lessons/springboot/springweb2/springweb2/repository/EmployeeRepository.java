package ru.skypro.lessons.springboot.springweb2.springweb2.repository;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.springweb2.springweb2.delo.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
    public void add(Employee employee) {
        employeeList.add(employee);
    }
}
