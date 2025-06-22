import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 

public class ParkingController {
    ArrayList<ParkingSlot> slots;
    Map<String, Ticket> tickets; // make key vehicle id with its ticket
    ParkingStrategy strategy; // first come or best approach
    Double totalIncome = 0.0;
    int totalVehicles = 0;
   // constructor to initialize parking garage and strategy
    public ParkingController(ArrayList<ParkingSlot> slots, ParkingStrategy strategy) {
        this.slots = slots;
        this.strategy = strategy;
        this.tickets = new HashMap<>();
    }
    // void method to park in a vehicle 
    public void parkIn(Vehicle vehicle) throws NoAvailableSlot, VehicleAlreadyParked {
        // if ticket already exists
        if (tickets.containsKey(vehicle.getID())) {
            throw new VehicleAlreadyParked("Vehicle already parked.");
        }
         // choose strategy and find slot 
         ParkingSlot slot = strategy.findSlot(slots, vehicle);
         // all slots are occupied
        if (slot == null) {
            throw new NoAvailableSlot("No slots available ");
        }
        slot.setOccupied(true);// set it as unavailable

        //add a new ticket with vehicle and given slot and time in
        Ticket ticket = new Ticket(vehicle, slot, LocalTime.now());
        tickets.put(vehicle.getID(), ticket);
    }
     // method to park out a vehicle
    public double parkOut(String vehicleID) throws VehicleNotFound {
        Ticket ticket = tickets.get(vehicleID);
        // if vehicle isn't parked in
        if (ticket == null) {
            throw new VehicleNotFound("Vehicle not found.");
        }
        // get time the vehicle entered 
        LocalTime timeIn = ticket.getTimeIn();
        // capture time out automatically with local time
        LocalTime timeOut = LocalTime.now();
        ticket.setTimeOut(timeOut);
        // calculate estimated duration a vehicle was parked in hours 
        int inMinutes = timeIn.getHour() * 60 + timeIn.getMinute();
        int outMinutes = timeOut.getHour() * 60 + timeOut.getMinute();
        int totalMinutes = outMinutes - inMinutes;
        double duration = (int) Math.ceil(totalMinutes)/60;// round up for nearest hours
   
        double fees = duration * 5;
        ticket.setFees(fees);
         //  slot is  available again and remove vehicle from tickets list
        ticket.getSlot().setOccupied(false);
        tickets.remove(vehicleID);
        // add up total vehicles parked out with fees
        totalIncome += fees;
        totalVehicles++;

        return fees;
    }

    // get a list of available slots
    public List<ParkingSlot> getAvailableSlots() {
        List<ParkingSlot> availableSlots = new ArrayList<>();
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied()) {
                availableSlots.add(slot);
            }
        }
        return availableSlots;
    }
    
    public Double getTotalincome() {
        return totalIncome;
    }

    public int getTotalvehicles() {
        return totalVehicles;
    }
     
    
}
