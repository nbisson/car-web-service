package fr.nicolasbisson.carWebService.services;

import fr.nicolasbisson.carWebService.models.Car;
import fr.nicolasbisson.carWebService.models.Dates;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class CarService {

    private List<Car> cars = new ArrayList<Car>();

    public CarService() {
        cars.add(new Car("11AA22", "Ferrari", 1000, new Dates(new Date(), new Date())));
        cars.add(new Car("33BB44", "Porshe", 2222));
    }

    @RequestMapping(value="/cars", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getListOfCars(){
        return cars;
    }

    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addCar(@RequestBody Car car) throws Exception{
        System.out.println(car);
        cars.add(car);
    }

    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Car getCar(@PathVariable(value = "plateNumber") String plateNumber){
        for(Car car: cars){
            if(car.getPlateNumber().equals(plateNumber)){
                return car;
            }
        }
        return null;
    }

    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
    public ResponseEntity<String> rent(@PathVariable("plateNumber") String plateNumber, @RequestParam(value="rent", required = true) boolean rent, @RequestBody(required = false) Dates dates) throws Exception {
        for(Car car: cars){
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
        }
        return new ResponseEntity<>("car does not exist", HttpStatus.NOT_FOUND);
    }

}
