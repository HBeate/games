package at.bha.io.aufgabe2;

import java.util.ArrayList;

public class Department2 {
    private String name;
    private ArrayList<Person2> people;
    private ArrayList<Department2> department2s;

    public Department2(String name) {
        this.name = name;
        this.people = new ArrayList<Person2>();
        this.department2s = new ArrayList<>();
    }

    public void addChildDepartment(Department2 child){
        department2s.add(child);
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
    public void addPerson(Person2 person2){
        this.people.add(person2);
    }


    public ArrayList<Person2> getPeople() {
        return people;
    }


}

