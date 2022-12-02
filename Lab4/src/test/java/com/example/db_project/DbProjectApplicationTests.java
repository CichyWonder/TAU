package com.example.db_project;

import com.example.db_project.dao.CarDao;
import com.example.db_project.model.Car;
import com.example.db_project.model.Owner;
import com.example.db_project.service.CarService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class DbProjectApplicationTests {

    @Autowired
    private CarService carService;
    @Mock
    private CarDao carDao;


    @Test
    void test_should_select_cars() {
        Owner owner = new Owner("Michał", "Cichowski");
        Car car = new Car("Mercedes", "w212", "white", 2009, owner);

        List<Car> cars = Arrays.asList(car);

        given(carDao.findAll()).willReturn(cars);

        List<Car> cars1 = carService.selectAllCars();

        assertThat(cars1).hasSize(2);
    }

    @Test
    void test_should_select_car_by_id() {
        Owner owner = new Owner("Michał", "Cichowski");
        Car car = new Car("Mercedes", "w212", "white", 2009, owner);

        Long carId = car.getId();
        given(carDao.findById(carId)).willReturn(Optional.of(car));

        assertThat(carService.selectCarById(carId)).isEqualToComparingFieldByField(car);
    }
}
