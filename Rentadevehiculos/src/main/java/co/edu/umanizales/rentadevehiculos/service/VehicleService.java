package co.edu.umanizales.rentadevehiculos.service;

public class VehicleService {
    package co.edu.rentcar.service;

import co.edu.rentcar.dto.ResponseFilter;
import co.edu.rentcar.model.Vehicle;

import java.util.List;

    public interface VehicleService {
        List<Vehicle> getAllVehicles();
        boolean rentVehicle(String plate);
        List<ResponseFilter> filterByColor(Stringcolor);
    }
}
