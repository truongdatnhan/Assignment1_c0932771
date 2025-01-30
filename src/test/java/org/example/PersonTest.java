package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void personCreationWithoutDog() {
        Person person = new Person("Maya", 23);
        assertEquals("Maya", person.getName());
        assertEquals(23, person.getAge());
        assertFalse(person.getDog().isPresent());
    }

    @Test
    void personCreationWithDog() {
        Dog dog = new Dog("Gud boy", 5);
        Person person = new Person("Maya", 23, dog);
        assertEquals("Maya", person.getName());
        assertEquals(23, person.getAge());
        assertTrue(person.getDog().isPresent());
    }

    @Test
    void personSetNameSuccess() {
        Person person = new Person("Maya", 23);
        person.setName("Andrew");
        assertEquals("Andrew", person.getName());
    }

    @Test
    void personSetAgeSuccess() {
        Person person = new Person("Maya", 23);
        person.setAge(13);
        assertEquals(13, person.getAge());
    }

    @Test
    void changeDogsNameSuccess() {
        Dog dog = new Dog("Gud boy", 5);
        Person person = new Person("Maya", 23, dog);
        person.changeDogsName("Buddy");
        assertEquals("Buddy",person.getDog().get().getName());
    }

    @Test
    void changeDogsNameThrowsExceptionWhenNoDog() {
        Person person = new Person("Maya", 23);
        assertThrows(RuntimeException.class, () -> person.changeDogsName("Max"));
    }

    @Test
    void hasOldDogTrue() {
        Dog oldDog = new Dog("Gud boy", 12);
        Person person = new Person("Maya", 23, oldDog);
        assertTrue(person.hasOldDog());
    }

    @Test
    void hasOldDogFalse() {
        Dog youngDog = new Dog("Gud boy", 5);
        Person person = new Person("Maya", 23, youngDog);
        assertFalse(person.hasOldDog());
    }

    @Test
    void hasOldDogWhenNoDog() {
        Person person = new Person("Maya", 23);
        assertFalse(person.hasOldDog());
    }
}