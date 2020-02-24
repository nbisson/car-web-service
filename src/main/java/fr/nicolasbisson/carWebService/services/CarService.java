package fr.nicolasbisson.carWebService.services;

import fr.nicolasbisson.carWebService.models.Car;
import fr.nicolasbisson.carWebService.models.Dates;
import fr.nicolasbisson.carWebService.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarService {

    @Autowired
    private CarRepository carRepository;

    private List<Car> cars = new ArrayList<Car>();

    @RequestMapping(value="/cars", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getListOfCars(){

        return (List<Car>) carRepository.findAll();
    }

    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addCar(@RequestBody Car car) throws Exception{
        System.out.println(car);
        carRepository.save(car);
        //cars.add(car);
    }

    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Car> getCar(@PathVariable(value = "plateNumber") String plateNumber){

        Car car = carRepository.findByPlateNumber(plateNumber);

        if (car != null) {
            return new ResponseEntity(car, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
    public ResponseEntity<String> rent(@PathVariable("plateNumber") String plateNumber, @RequestParam(value="rent", required = true) boolean rent, @RequestBody(required = false) Dates dates) throws Exception {

        Car car = carRepository.findByPlateNumber(plateNumber);

        if(car.getPlateNumber().equals(plateNumber)){
            // to rent
            if (rent == true) {
                if (car.getDates() == null) {
                    car.setDates(dates);
                    return new ResponseEntity<>(HttpStatus.OK);
                }
                else {
                    return new ResponseEntity<>("car already rent", HttpStatus.CONFLICT);
                }
            }
            // to rent back
            else {
                car.setDates(null);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("car does not exist", HttpStatus.NOT_FOUND);
    }

}
