package at.bha.io;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Person> people;

    public Department(String name, ArrayList people) {
        this.name = name;
        this.people = people;
    }

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

    public void addPerson(Person person){
        this.people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }
}

