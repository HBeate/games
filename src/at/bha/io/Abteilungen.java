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
        //etc.

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
             //           vorstand.addPerson();
                        people.add(pEinkaufEuropa);
                        break;
                    case "Einkauf Italien":
                        Person pEinkaufItalien = new Person(lineArray[0],einkaufItalien);
             //           vorstand.addPerson();
                        people.add(pEinkaufItalien);
                        break;
                    case "Einkauf USA":
                        Person pEinkaufUsa = new Person(lineArray[0],einkaufUsa);
            //            vorstand.addPerson();
                        people.add(pEinkaufUsa);
                        break;
                    case "Vertrieb":
                        Person pVertrieb = new Person(lineArray[0],vertrieb);
           //             vorstand.addPerson();
                        people.add(pVertrieb);
                        break;
                    case "Vertrieb Europa":
                        Person pVertriebEuropa = new Person(lineArray[0],vertriebEuropa);
           //             vorstand.addPerson();
                        people.add(pVertriebEuropa);
                        break;

                }
//                System.out.println(vorstand + " " + lineArray[0]);
//                System.out.println(einkauf + " " + lineArray[0]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        for (Person person: people) {
            System.out.println(person.getFullName() + " " + person.getDepartment().getName());
        }

        for (Department department: departments) {
            System.out.println(department.getName());
            for (Person person: department.getPeople()){
                System.out.println(" " + person.getFullName());

            }

        }

    }
}

