package at.bha.io.aufgabe2;

import java.util.ArrayList;

public class Person2 {
    private String fullName;
    private Department2 department2;


    public Person2(String fullName, Department2 department2) {
        this.fullName = fullName;
        this.department2 = department2;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", department=" + department2 +
                '}';
    }
}
