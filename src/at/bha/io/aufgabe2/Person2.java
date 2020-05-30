package at.bha.io.aufgabe2;

import java.util.ArrayList;

public class Person2 {
    private String fullName;
    private Department2 department2;
 //   private Department2 parentDepartment2;
//    private ArrayList<Person2> people;

    public Person2(String fullName, Department2 department2) {
        this.fullName = fullName;
        this.department2 = department2;
  //      this.parentDepartment2 = parentDepartment2;
    }

    public String getFullName() {
        return fullName;
    }

    public Department2 getDepartment2() {
        return department2;
    }

    public Department2 getParentDepartment2() {
        return null;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", department=" + department2 +
      //          ", parentDepartment=" + parentDepartment2 +
            //    ", people=" + people +
                '}';
    }
}
