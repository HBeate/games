package at.bha.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReadTest {
    public static void main(String[] args) {
        List<PersonTest> people = new ArrayList<>();

        File file = new File( "./testdata/people.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while((line = bufferedReader.readLine())!=null) {
              String[] lineArray=   line.split(";");
              PersonTest person = new PersonTest(lineArray[0], lineArray[1], lineArray[2]);
              people.add(person);
                System.out.println(lineArray[0]);
            }
            for (PersonTest person:people) {
                System.out.println(person);
            }
/*           int character;
            while((character = fileReader.read())!=-1){
                System.out.print(Character.toString(character));
            }*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
