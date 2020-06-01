package at.bha.io.aufgabe2;

import at.bha.io.Department;
import at.bha.io.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
        /*
        PersonenName;Abteilung;ParentAbteilung
        Franz Müller;Vorstand;
        Max Mustermann;Einkauf;Vorstand
        Frida Haudrauf;Einkauf Europa;Einkauf
        Alois Stich;Einkauf Europa;Einkauf
        Bernd Muster;Einkauf Italien;Einkauf Europa
        Ulla Neu;Einkauf USA;Einkauf
        Iris Tor;Vertrieb;Vorstand
        Paul Hinter;Vertrieb Europa;Vertrieb
        Ernst Bock; Vertrieb Europa;Vertrieb
        Olga Peter; Vertrieb Europa;Vertrieb
        */

public class Abteilungen2 {
    public static void main(String[] args) {
        List<Department2> parents = new ArrayList<>();
        List<Department2> children = new ArrayList<>();

        File file = new File("./testdata/abteilungen1.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine(); //-> reads the first line and doesn't do anything with it
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineArray = line.split(";");
                if (lineArray.length == 3) {
                    Department2 parent = null;
                    for (Department2 parentDep : parents) {
                        if (parentDep.getName().equalsIgnoreCase(lineArray[2])) {
                            parent = parentDep;
                        }
                    }
                    if (parent == null) {
                        parent = new Department2(lineArray[2].trim());
                        parents.add(parent);
                    }
                }
            }
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine(); //-> reads the first line and doesn't do anything with it
            while ((line = bufferedReader.readLine()) != null) { //Max Mustermann;Einkauf;VOrstand
                String[] lineArray = line.split(";");
                Department2 childDepartment = new Department2(lineArray[1].trim()); // Einkauf
                Person2 pers = new Person2(lineArray[0].trim(), childDepartment);   // Mustermann
                childDepartment.addPerson(pers);

                if (lineArray.length == 3) {
                    for (Department2 department2 : parents) { // Vorstand
                        if (department2.getName().equals(lineArray[2].trim())) { // Objekt Vorstand equals String Vorstand
                            if (lineArray.length == 3) {

//TODO schaffe die verdammte Ausgabe nicht (Abteilungen nicht doppelt und dreifach anzeigen)

                                Department2 child = null;
                                for (Department2 childDep : children) {
                                    if (childDep.getName().equals(lineArray[1])) {
                                        child = childDep;
                                    }
                                }
                                if (child == null) {
                                    child = new Department2(lineArray[1].trim());
                                    children.add(child);

                                        department2.addChildDepartment(childDepartment);
                                        department2.addPerson(pers);
                                }
                                break;



                            }
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
            System.out.println(parent.getName().toUpperCase());
            for (Department2 child : parent.getChildDepartments()) {
                System.out.println("     " + child.getName());
                for (Person2 person : child.getPeople()) {
                    System.out.println("            " + person.getFullName());
                }
            }
        }
    }
}