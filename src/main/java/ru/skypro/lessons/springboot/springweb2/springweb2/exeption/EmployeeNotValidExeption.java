package ru.skypro.lessons.springboot.springweb2.springweb2.exeption;

import ru.skypro.lessons.springboot.springweb2.springweb2.delo.Employee;

public class EmployeeNotValidExeption extends RuntimeException{
    private final Employee employee;

    public EmployeeNotValidExeption(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
