public class ParkingSlot {
   private Dimensions dimensions;
   private boolean status;
     // constructor
    ParkingSlot(Dimensions dims) {
        this.dimensions = dims;
    }
    // if slot available
    public Boolean isOccupied() {
        return status;
    }

    public void setOccupied(boolean stat) {
        this.status = stat;
    }
     // for convenience
    public float getWidth() { return dimensions.getWidth(); }
    public float getDepth() { return dimensions.getDepth(); }
     // to calculate area of vehicle or slot
    public boolean canFit (Vehicle vehicle){
        return vehicle.getWidth()<= this.getWidth() && vehicle.getDepth()<=this.getDepth();
            }   
}
