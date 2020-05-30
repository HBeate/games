package at.bha.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Abteilungen {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        List<Department> departments = new ArrayList<>();

        Department vorstand = new Department("Vorstand");
        Department einkauf = new Department("Einkauf");
        Department einkaufEuropa = new Department("Einkauf Europa");
        Department einkaufItalien = new Department("Einkauf Italien");
        Department einkaufUsa = new Department("Einkauf USA");
        Department vertrieb = new Department("Vertrieb");
        Department vertriebEuropa = new Department("Vertrieb Europa");

        departments.add(vorstand);
        departments.add(einkauf);
        departments.add(einkaufEuropa);
        departments.add(einkaufItalien);
        departments.add(einkaufUsa);
        departments.add(vertrieb);
        departments.add(vertriebEuropa);

        File file = new File("./testdata/abteilungen.txt");
        try {
            FileReader fileReader = new FileReader(file);


            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine())!= null) {
                String[] lineArray = line.split(";");

                addPersonToDep(departments, lineArray);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Department department : departments) {
            System.out.println("'"+department.getName().toUpperCase()+"'");
            for (Person person: department.getPeople()){
                System.out.println("    '" + person.getFullName() + "'");
            }
            System.out.println();
        }
    }

    private static void addPersonToDep(List<Department> departments, String[] lineArray) {
        for (Department dep : departments) {
            if(dep.getName().equalsIgnoreCase(lineArray[1].trim())){
                Person person = new Person(lineArray[0].trim(),dep);
                dep.addPerson(person);

            }
        }
    }
}

