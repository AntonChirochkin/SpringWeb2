package ru.skypro.lessons.springboot.springweb2.springweb2.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.springweb2.springweb2.delo.Employee;
import ru.skypro.lessons.springboot.springweb2.springweb2.repository.EmployeeRepository;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public int getSumOfSalaries() {
        return employeeRepository.getAll().stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public Employee getEmployeeWithMinSalary() {
        return employeeRepository.getAll().stream()
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Employee getEmployeeWithMaxSalary() {
        return employeeRepository.getAll().stream()
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public List<Employee> getEmployeeWithSalaryHigherThanAverage() {
        double average = employeeRepository.getAll().stream()
                .mapToInt(Employee::getSalary)
                .average()
                .orElse(0D);
        return employeeRepository.getAll().stream()
                .filter(employee -> employee.getSalary() > average)
                .collect(Collectors.toList());
    }
}
