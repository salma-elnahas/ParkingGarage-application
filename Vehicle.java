 public class Vehicle {
      private String modelName,ID,modelYear;
      private Dimensions dimensions;
       // constructor
       Vehicle(String name, String id, String year, Dimensions dims) {
           this.modelName = name;
           this.ID = id;
           this.modelYear = year;
           this.dimensions = dims;

       }
       //setters
    public void setID(String id) { this.ID =id; }
    public void setModelName(String name) { this.modelName = name; }
    public void setModelYear(String year) { this.modelYear = year; }

    // getters
    public String getID() { return ID; }
    public String getModelName() { return modelName; }
    public String getModelYear() { return modelYear; }
    public float getWidth() { return dimensions.getWidth(); }
    public float getDepth() { return dimensions.getDepth(); }
  }