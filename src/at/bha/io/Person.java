package at.bha.io;

import at.bha.games.snake.Food;

import java.util.ArrayList;

public class Person {
    private String fullName;
    private Department department;
    private ArrayList<Person> people;


    public Person(String fullName, Department department) {
        this.fullName = fullName;
        this.department = department;
        this.people = new ArrayList<Person>();

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                '}';
    }

}
