import java.util.ArrayList;
// finds first available parking slot that can fit the vehicle
public class FirstclassFirstServed implements ParkingStrategy {
   public ParkingSlot findSlot(ArrayList<ParkingSlot> slots, Vehicle vehicle) {
       for (ParkingSlot slot : slots) {
           // if slot available and can fit the vehicle's dimensions
           if (!slot.isOccupied() && slot.getWidth() >= vehicle.getWidth() && slot.getDepth() >= vehicle.getDepth()) {
               return slot;
           }
       }
        // if no suitable slot found
        return null;
    }
}
