package at.bha.io.aufgabe2;

import at.bha.io.Department;
import at.bha.io.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Abteilungen2 {
    public static void main(String[] args) {
        List<Department2> parents = new ArrayList<>();

        File file = new File("./testdata/abteilungen1.txt");
        try {
            FileReader fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //bufferedReader.skip(1); -> skips only characters
            bufferedReader.readLine(); //-> reads the first line and doesn't do anything with it
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineArray = line.split(";");
                if (lineArray.length == 3) {
                    Department2 parent = null;
                    for (Department2 parentDep : parents) {
                        if(parentDep.getName().equalsIgnoreCase(lineArray[2])){
                            parent = parentDep;
                        }
                    }
                    if(parent == null) {
                        parent = new Department2(lineArray[2].trim());
                        parents.add(parent);
                    }
                }
            }
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) { //Max Mustermann;Einkauf;VOrstand
                String[] lineArray = line.split(";");                 // Max Mustermann       0
                // Einkauf              1
                // Vorstand             2

                Department2 dep = new Department2(lineArray[1].trim()); // Einkauf
                Person2 pers = new Person2(lineArray[0].trim(), dep);   // Mustermann

                dep.addPerson(pers);

                if (lineArray.length == 3) {
                    for (Department2 department2 : parents) { // Vorstand
                        if (department2.getName().equals(lineArray[2].trim())) { // Objekt Vorstand equals String Vorstand
                            department2.addChildDepartment(dep);
                            department2.addPerson(pers);
                            break;
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Department2 parent : parents) {
            System.out.println("'" + parent.getName().toUpperCase() + "'");
            for (Department2 child : parent.getChildDepartments()) {
                System.out.println(child.getName());
                for (Person2 person : child.getPeople()) {
                    System.out.println("    '" + person.getFullName() + "'");
                }
                System.out.println();
//            }
            }
        }
    }
}

