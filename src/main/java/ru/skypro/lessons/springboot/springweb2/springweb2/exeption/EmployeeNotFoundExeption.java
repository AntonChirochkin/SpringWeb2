package ru.skypro.lessons.springboot.springweb2.springweb2.exeption;

public class EmployeeNotFoundExeption extends RuntimeException {
private final int id;
    public EmployeeNotFoundExeption(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
