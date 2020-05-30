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

//    public Department getDepartment() {
//        return department;
//    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                '}';
    }

}
