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
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineArray = line.split(";");

                switch (lineArray[1]) {
                    case "Vorstand":
                        Person pVorstand = new Person(lineArray[0],vorstand);
                        vorstand.addPerson(pVorstand);

                        people.add(pVorstand);
                        break;
                    case "Einkauf":
                        Person pEinkauf = new Person(lineArray[0],einkauf);
                        einkauf.addPerson(pEinkauf);
                        people.add(pEinkauf);
                        break;
                    case "Einkauf Europa":
                        Person pEinkaufEuropa = new Person(lineArray[0],einkaufEuropa);
                      einkaufEuropa.addPerson(pEinkaufEuropa);
                        people.add(pEinkaufEuropa);
                        break;
                    case "Einkauf Italien":
                        Person pEinkaufItalien = new Person(lineArray[0],einkaufItalien);
                        einkaufItalien.addPerson(pEinkaufItalien);
                        people.add(pEinkaufItalien);
                        break;
                    case "Einkauf USA":
                        Person pEinkaufUsa = new Person(lineArray[0],einkaufUsa);
                        einkaufUsa.addPerson(pEinkaufUsa);
                        people.add(pEinkaufUsa);
                        break;
                    case "Vertrieb":
                        Person pVertrieb = new Person(lineArray[0],vertrieb);
                        vertrieb.addPerson(pVertrieb);
                        people.add(pVertrieb);
                        break;
                    case "Vertrieb Europa":
                        Person pVertriebEuropa = new Person(lineArray[0],vertriebEuropa);
                        vertriebEuropa.addPerson(pVertriebEuropa);
                        people.add(pVertriebEuropa);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Person person: people) {
            System.out.println(person.getFullName() + " " + person.getDepartment().getName());
        }
        System.out.println();

        for (Department department: departments) {
            System.out.println(department.getName().toUpperCase());
            for (Person person: department.getPeople()){
                System.out.println("    " + person.getFullName());


            }                System.out.println();
        }
    }
}

