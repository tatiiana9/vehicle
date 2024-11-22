package co.edu.umanizales.rentadevehiculos.exception;
package co.edu.rentcar.exception;

public class VehicleNotAvailableException extends RuntimeException {
    public VehicleNotAvailableException(String message) {
        super(message);
    }
}