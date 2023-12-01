package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface CarService {
    void addCar(Car car);
    List<User> printCar(String model, int series);

}
