package co.edu.umanizales.rentadevehiculos.controller;

public class VehicleController {

import co.edu.rentcar.dto.ResponseFilter;
import co.edu.rentcar.dto.RentVehicleRequest;
import co.edu.rentcar.exception.VehicleNotAvailableException;
import co.edu.rentcar.exception.VehicleNotFoundException;
import co.edu.rentcar.model.Vehicle;
import co.edu.rentcar.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/vehicles")
    public class VehicleController {
        private final VehicleService vehicleService;

        public VehicleController(VehicleService vehicleService) {
            this.vehicleService = vehicleService;
        }

        @GetMapping
        public List<Vehicle> getAllVehicles() {
            return vehicleService.getAllVehicles();
        }

        @PostMapping("/rent")
        public ResponseEntity<String> rentVehicle(@RequestBody RentVehicleRequest request) {
            try {
                vehicleService.rentVehicle(request.getPlate());
                return ResponseEntity.ok("Vehicle rented successfully");
            } catch (VehicleNotFoundException | VehicleNotAvailableException ex) {
                return ResponseEntity.status(404).body(ex.getMessage());
            }
        }

        @GetMapping("/filter/{color}")
        public List<ResponseFilter> filterByColor(@PathVariable String color) {
            return vehicleService.filterByColor(color);
        }
    }
}
