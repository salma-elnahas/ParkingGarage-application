// handles exception if vehicle already there

public class VehicleAlreadyParked extends Exception {
   public VehicleAlreadyParked (String message) {
        super(message);
    }
}