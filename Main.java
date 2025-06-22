import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// for user input
        // create parking slots
        ArrayList<ParkingSlot> slots = new ArrayList<>();
        slots.add(new ParkingSlot(new Dimensions(4, 5)));
        slots.add(new ParkingSlot(new Dimensions(3, 3)));
        slots.add(new ParkingSlot(new Dimensions(4, 4)));
        
        // get vehicles from input
        System.out.println("Enter vehicle info:");

        System.out.print("Model name: ");
        String brand = scanner.nextLine();

        System.out.print("ID number: ");
        String plate = scanner.nextLine();

        System.out.print("Model Year: ");
        String modelYear = scanner.nextLine();

        System.out.print("Width: ");
        float width = scanner.nextFloat();

        System.out.print("Depth: ");
        float depth = scanner.nextFloat();
        // input  parking strategy and controller
        System.out.println("Choose slot configuration:");
        System.out.println("1. First-Come-First-Served");
        System.out.println("2. Best-Fit");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        ParkingStrategy strategy;
        if (choice == 1) {
            strategy = new FirstclassFirstServed();
        } else {
            strategy = new BestFit();
        }
         ParkingController controller = new ParkingController(slots, strategy);

         Vehicle vehicle1 = new Vehicle(brand, plate, modelYear, new Dimensions(width, depth));
         System.out.println("Available Slots :");
        for (ParkingSlot slot : controller.getAvailableSlots()) {
         System.out.println("Slot: " + slot.getWidth() + " x " + slot.getDepth());

        }
        
        //handles exceptions
        try {
            //park in
            controller.parkIn(vehicle1);
            System.out.println("Vehicle with ID :" + vehicle1.getID() + " parked successfully.");
            Ticket ticket = controller.tickets.get(vehicle1.getID()); // access internal ticket 
            ticket.setTimeIn(LocalTime.now().minusHours(1));

            System.out.println("Available slots after park-in:");
            for (ParkingSlot s : controller.getAvailableSlots()) {
                System.out.println("Slot: " + s.getWidth() + " x " + s.getDepth());
            }
            //park out
            double fee = controller.parkOut(vehicle1.getID());
            System.out.println("Vehicle " + vehicle1.getID() + " Parked out with Total fee: " + fee + " EGP");

            System.out.println("Total income: " + controller.getTotalincome());
            System.out.println("Total vehicles : " + controller.getTotalvehicles());
        } catch (VehicleAlreadyParked | NoAvailableSlot | VehicleNotFound e) {
            System.out.println("Error: " + e.getMessage());
        }
         scanner.close();
    }
 }