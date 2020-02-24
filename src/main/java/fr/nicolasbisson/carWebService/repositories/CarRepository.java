package fr.nicolasbisson.carWebService.repositories;

import fr.nicolasbisson.carWebService.models.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, String> {

    List<Car> findAll();

    Car findByPlateNumber(String plateNumber);

}
