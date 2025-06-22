// handles exception if vehicle isn't found when parking out
public class VehicleNotFound extends Exception {
    public VehicleNotFound(String message) {
        super(message);
    }
}