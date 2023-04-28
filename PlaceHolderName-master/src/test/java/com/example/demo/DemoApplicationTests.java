package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    DogRepository dogRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testDogRepository() {
        Dog dog = dogRepository.getDog(13);
        Assertions.assertEquals("Killer", dog.getName());
    }


    @Test
    void testGetAllDogs() {
        List<Dog> dogs =  dogRepository.getAllDogs();
        Assertions.assertEquals(20, dogs.size());
    }

    @Test
    void testGetDog() {
        Dog dog = dogRepository.getDog(14);
        Assertions.assertEquals("Sammy", dog.getName());
    }

}
