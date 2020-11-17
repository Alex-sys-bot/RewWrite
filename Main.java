package ru.sapteh;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        // read File;
        String fileName =  "listStudents.txt";
        List<Person> studentsList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
           while (reader.ready()) {
               Person person = getPerson(reader.readLine());
               studentsList.add(person);
            }
        }

        //      write File;
        File file = new File("C:/java_42/Files/Students.txt");
        file.createNewFile();
        FileWriter fwStudents = new FileWriter(file);

        for (Person person : studentsList) {
        fwStudents.write(person.toString());
        fwStudents.write("\n");
        }

//            searc id;
        BufferedReader searchId = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите id Студента");
        int id = Integer.parseInt(searchId.readLine());

        for (Person person: studentsList) {
            if (id == person.getId()){
                System.out.printf("Студент %s %s %s имеет возраст: %d года:",
                        person.getFirstName(), person.getLastName(), person.getPatronymic(),
                        (new Date().getTime() - person.getDate().getTime())/1000/60/60/24/365);
            }
        }
            fwStudents.close();
        }

        public static Person getPerson(String strLine) throws ParseException {
            String[] arrSudents = strLine.split(" ");
            int id = Integer.parseInt(arrSudents[0]);
            String lastName = arrSudents[1];
            String firstName = arrSudents[2];
            String patronymic = arrSudents[3];
            Date date = new SimpleDateFormat("MM/dd/yy").parse(arrSudents[4]);
            return new Person(id, lastName, firstName, patronymic, date);
        }
    }
