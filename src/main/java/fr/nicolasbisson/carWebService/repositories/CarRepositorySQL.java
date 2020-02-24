package fr.nicolasbisson.carWebService.repositories;

import fr.nicolasbisson.carWebService.models.Car;
import fr.nicolasbisson.carWebService.models.CarSQL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepositorySQL extends CrudRepository<CarSQL, String> {

}
