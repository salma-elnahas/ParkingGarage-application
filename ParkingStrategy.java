 import java.util.ArrayList;
// interface for parking strategy
public interface ParkingStrategy {
  public ParkingSlot findSlot(ArrayList<ParkingSlot> slots, Vehicle vehicle);
}



