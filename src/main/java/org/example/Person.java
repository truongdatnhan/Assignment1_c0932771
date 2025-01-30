package org.example;

import java.util.Objects;
import java.util.Optional;

public class Person {
    private String name;
    private int age;
    private Optional<Dog> dog;

    public Person(String name, int age) {
        this(name, age, null);
    }

    public Person(String name, int age, Dog dog) {
        this.name = name;
        this.age = age;
        this.dog = Optional.ofNullable(dog);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Optional<Dog> getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = Optional.ofNullable(dog);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(dog, person.dog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, dog);
    }

    public boolean hasOldDog() {
        return dog.isPresent() && dog.get().getAge() >= 10;
    }

    public void changeDogsName(String newName) throws RuntimeException {
        dog.orElseThrow(() -> new RuntimeException(this.name + " does not own a dog!")).setName(newName);
    }


}
