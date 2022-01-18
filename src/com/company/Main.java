package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Person[] somePerson = new Person[3];
        somePerson[0] = new Person();
        somePerson[1] = new Person();
        somePerson[2] = new Person();

        somePerson[0].add(new Person("Vladimir Vysockiy"));
        somePerson[0].add(new Person("Jimmy Whooley"));
        somePerson[0].add(new Person("John Wick"));

        somePerson[1].add(new Person("Attokur Malevich"));
        somePerson[1].add(new Person("Myktybek Keneshov"));
        somePerson[1].add(new Person("Beksultan Ashyrov"));

        somePerson[2].add(new Person("Barakelde Myrzaevich"));
        somePerson[2].add(new Person("Kylmysh Maratov"));
        somePerson[2].add(new Person("Milana Consgrove"));

        Scanner sc = new Scanner(System.in);
        System.out.println("Write the name of Ceo");
        System.out.print("Ceo is");
        String ceo = sc.nextLine();
        Person p = somePerson[0].find(ceo);
        if (p != null) {
            System.out.println("Your Ceo is" + p);
        }
        else{
            System.out.println("We cant find your Ceo");
        }
    }
}

abstract class Locality implements Searching {
    ArrayList<Person> persons;

    //construct
    public Locality() {
        persons = new ArrayList<>();

    }

    void add (Person p){
        persons.add(p);
    }

    public Person find(String Ceo) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getCeo().toLowerCase().contains(Ceo.toLowerCase())) {
                return persons.get(i);
            }
        }
        return null;
    }

    @Override
    public abstract String toString();

    public int getSize() {
        return persons.size();
    }
}

class Person {
    private String ceo;



    public Person() {
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public Person(String ceo) {
        this.ceo = ceo;
    }

    @Override
    public String toString() {
        String res = "Your Ceo is" + getCeo();
        return res;
    }

    public void add(Person name) {
    }

    public Person find(String ceo) {

        return null;
    }
}

abstract class Town extends Locality implements Searching {
    public void searchCeo() {
        System.out.println("Your Ceo is ");
    }
}

abstract class Village extends Locality implements Searching {
    public void searchCeo() {
        System.out.println("Your Ceo is");
    }
}

abstract class Region extends Locality implements Searching {
    public void searchCeo() {
        System.out.println("Your Ceo is ");
    }
}

interface Searching {
    void searchCeo();
}