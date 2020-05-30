package at.bha.io.aufgabe2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Abteilungen2 {
    public static void main(String[] args) {

        List<Person2> people = new ArrayList<>();
        List<Department2> departmentList = new ArrayList<>();

        File file = new File("./testdata/abteilungen1.txt");
        try {
            FileReader fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //bufferedReader.skip(1); -> skips only characters
            bufferedReader.readLine(); //-> reads the first line and doesn't do anything with it
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineArray = line.split(";");
                String personName = lineArray[0];
                String departmentName = lineArray[1];
                String parentDepartmentName;

                if (lineArray.length == 2) {
                    Department2 department2 = new Department2(departmentName,"");
                    Person2 person = new Person2(personName,department2);
                    department2.addPerson(person);
                    departmentList.add(department2);
                }

                if (lineArray.length == 3) {
                    parentDepartmentName = lineArray[2];
                    Department2 department2 = new Department2(departmentName,parentDepartmentName);
                    Person2 person = new Person2(personName,department2);
                    department2.addPerson(person);
                    departmentList.add(department2);
                }
            }

            for (Department2 department2 : departmentList) {
                for (Person2 person2 : department2.getPeople()) {
                    String departmentName = department2.getName();
                    System.out.println(departmentName.toUpperCase());
                    String personDepartment = person2.getDepartment2().getName();
                    if (departmentName.equalsIgnoreCase(personDepartment)) {
                        String personName = person2.getFullName();
                        System.out.println("   '" + personName + "'");
                    }
                }
            }


//            fileReader = new FileReader(file);
//            bufferedReader = new BufferedReader(fileReader);
//            while ((line = bufferedReader.readLine()) != null) { //Max Mustermann;Einkauf;VOrstand
//                String[] lineArray = line.split(";"); // Max Mustermann     0
//                // Einkauf              1
//                // Vorstand             2
//                Department2 dep = new Department2(lineArray[1]); // Einkauf
//                Person2 pers = new Person2(lineArray[0], dep);   // Mustermann
//
//                dep.addPerson(pers);
//
//                if (lineArray.length == 3) {
//                    for (Department2 department2 : parents) { // Vorstand
//                        if (department2.getName().equals(lineArray[2])) { // Objekt Vorstand equals String Vorstand
//                            department2.addChildDepartment(dep);
//                            break;
//                        }
//                    }
//                }
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


