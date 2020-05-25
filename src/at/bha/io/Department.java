package at.bha.io;

import at.bha.games.snake.Food;

import java.io.*;
import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Person> people;

    public Department(String name) {
        this.name = name;
        this.people = new ArrayList<Person>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }
    public void addPerson(Person person){
        this.people.add(person);
    }


    public ArrayList<Person> getPeople() {
        return people;
    }


}

