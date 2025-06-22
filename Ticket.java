import java.time.LocalTime;// used built in class to get time zone

public class Ticket {
     private Vehicle vehicle;
     private ParkingSlot slot;
     private Double fees;
     private LocalTime timeIn;// to automatically capture time
     private LocalTime timeOut;

    // Constructor  
    public Ticket(Vehicle vehicle, ParkingSlot slot, LocalTime timeIn) {
        this.vehicle = vehicle;
        this.slot = slot;
        this.timeIn = timeIn;
        this.fees = 0.0;
        this.timeOut = null;
    }
     //getters
     public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public Double getFees() {
        return fees;
    }

    public LocalTime getTimeIn() {
        return timeIn;
    }

    public LocalTime getTimeOut() {
        return timeOut;
    }
     // setters
     public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setSlot(ParkingSlot slot) {
        this.slot = slot;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public void setTimeIn(LocalTime timeIn) {
        this.timeIn = timeIn;
    }

    public void setTimeOut(LocalTime timeOut) {
        this.timeOut = timeOut;
    }
}
