package co.edu.umanizales.rentadevehiculos.service;

public class VehicleServiceImpl {

import co.edu.rentcar.dto.ResponseFilter;
import co.edu.rentcar.model.Vehicle;
import co.edu.rentcar.exception.VehicleNotAvailableException;
import co.edu.rentcar.exception.VehicleNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

    @Service
    public class VehicleServiceImpl implements VehicleService {
        private final List<Vehicle> vehicles = new ArrayList<>();

        public VehicleServiceImpl() {
            vehicles.add(new Vehicle("ABC123", VehicleType.CAR, "Red", true));
            vehicles.add(new Vehicle("XYZ987", VehicleType.MOTORCYCLE, "Blue", true));
            vehicles.add(new Vehicle("LMN456", VehicleType.VAN, "Red", true));
        }

        @Override
        public List<Vehicle> getAllVehicles() {
            return vehicles;
        }

        @Override
        public boolean rentVehicle(String plate) {
            Optional<Vehicle> vehicle = vehicles.stream()
                    .filter(v -> v.getPlate().equalsIgnoreCase(plate))
                    .findFirst();
            if (!vehicle.isPresent()) {
                throw new VehicleNotFoundException("Vehicle with plate " + plate + " not found.");
            }
            if (!vehicle.get().isAvailable()) {
                throw new VehicleNotAvailableException("Vehicle with plate " + plate + " is not available.");
            }
            vehicle.get().setAvailable(false);
            return true;
        }

        @Override
        public List<ResponseFilter> filterByColor(String color) {
            return vehicles.stream()
                    .filter(v -> v.getColor().equalsIgnoreCase(color))
                    .collect(Collectors.groupingBy(v -> v.getType().toString(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .map(entry -> new ResponseFilter(entry.getKey(), entry.getValue().intValue()))
                    .collect(Collectors.toList());
        }
    }

}
