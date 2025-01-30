package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {
    @Test
    void dogCreation() {
        Dog dog = new Dog("Gud boy", 5);
        assertEquals("Gud boy", dog.getName());
        assertEquals(5, dog.getAge());
    }

    @Test
    void dogSetNameSuccess() {
        Dog dog = new Dog("Gud boy", 5);
        dog.setName("Anim");
        assertEquals("Anim", dog.getName());
    }

    @Test
    void dogSetAgeSuccess() {
        Dog dog = new Dog("Gud boy", 5);
        dog.setAge(15);
        assertEquals(15, dog.getAge());
    }
}