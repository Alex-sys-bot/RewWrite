package ru.sapteh;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class Person{
    private int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private Date date;


    public Person(int id, String lastName, String firstName, String patronymic, Date date){
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.date = date;
    }

    public int getId(){
        return  id;
    }
    public String getLastName(){
        return lastName;
    }
    public String getFirstName(){
        return firstName;}
    public String getPatronymic(){
        return patronymic;}
    public Date getDate() {
        return date;
    }


    public String dateToString(){
        return new SimpleDateFormat("dd.MM.yyyy").format(getDate());
    }

    public int yearToday(){
        Date date = new Date();
        return (int)(date.getTime() - getDate().getTime()/1000/24/60/60);
    }

    public String toString(){
        return String.format("%d %s %s %s %s", getId(), getLastName(), getFirstName(), getPatronymic(), dateToString(), yearToday());
    }
}
