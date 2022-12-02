package com.example.db_project;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DbProjectStubTest {
    interface Service{
        List<String> getCars();
    }
        static class Car{
            Service service;
                    public Car (Service service){
                        this.service = service;
                    }
        public List<String> getCarsWhichStartWithLetterM(){
                        List<String> cars = new ArrayList<>();
                        for(String carName : service.getCars()){
                            cars.add(carName);
                        }
                        return cars;
        }
    }
}

 class DbProjectStubJavaTest {
     @Test
     public void whenCallServiceIsStubbed() {

         DbProjectStubTest.Car service = new DbProjectStubTest.Car(new StubService());

         assertEquals(5, service.getCarsWhichStartWithLetterM().size());
         assertEquals("Mercedes", service.getCarsWhichStartWithLetterM().get(1));
     }

     static class StubService implements DbProjectStubTest.Service {
         public List<String> getCars() {
             return Arrays.asList("Audi", "Mercedes", "BMW", "Renault", "Volkswagen");
         }
     }
}
