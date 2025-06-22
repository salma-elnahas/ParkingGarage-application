import java.util.ArrayList;
// finds the best parking slot for the given vehicle from the list of available slots
public class BestFit implements ParkingStrategy {
     public ParkingSlot findSlot(ArrayList<ParkingSlot> slots, Vehicle vehicle) {
        ParkingSlot bestSlot = null;// initialize it with null
    
        for (ParkingSlot slot : slots) {//iterate over slots
            if (!slot.isOccupied() && slot.canFit(vehicle)) {// if slot available and can fit vehicle
                if (bestSlot == null) {  // select first slot found as best slot
                bestSlot = slot;
            } else {
                //current area
                float slotArea = slot.getWidth() * slot.getDepth();
                float bestSlotarea = bestSlot.getWidth() * bestSlot.getDepth();
                //if current slot is smaller, update bestSlot
                if (slotArea < bestSlotarea) {
                    bestSlot = slot;
                  }
            }
              
            }
        }

        return bestSlot;
    }

}
