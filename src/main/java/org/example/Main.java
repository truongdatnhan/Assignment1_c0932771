package org.example;

public class Main {
    public static void main(String[] args) {
        Person p = new Person("Nathan", 24);

        try {
            p.changeDogsName("CCT");
        } catch(Exception e) {
            System.out.println("Unable to change dogs name: " + e.getMessage());
        }
    }
}