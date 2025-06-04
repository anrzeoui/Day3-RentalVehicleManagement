import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Vehicle {
    String brand;
    double price;

    public Vehicle(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    abstract double calculateRentalCost(int days, boolean insurance);

    public String getBrand() {
        return brand;
    }
}

class Car extends Vehicle {
    public Car(String brand, double price) {
        super(brand, price);
    }

    double calculateRentalCost(int days, boolean insurance) {
        double cost = price * days;
        if (insurance) cost += 2500 * days;
        return cost;
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String brand, double price) {
        super(brand, price);
    }

    double calculateRentalCost(int days, boolean insurance) {
        double cost = price * days;
        if (insurance) cost += 1750 * days;
        return cost;
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyata Aqua", 100000));
        cars.add(new Car("Toyota Prius",150000));
        cars.add(new Car("Toyota Alphard", 250000));
        
        List<Motorcycle> motorcycles = new ArrayList<>();
        motorcycles.add(new Motorcycle("Honda CB500", 150000));
        motorcycles.add(new Motorcycle("Yamaha MT-07", 200000));
        motorcycles.add(new Motorcycle("KTM Duke 390", 300000));

        System.out.println("*****Vehicle rental system*****");
        System.out.println("Select vehicle type: 1. Car  2. Moto");
        int typeChoice = scanner.nextInt();

        Vehicle selectedVehicle = null;

        if (typeChoice == 1) {
            System.out.println("Cars:");
            for (int i = 0; i < cars.size(); i++) {
                System.out.println((i + 1) + ".  " + cars.get(i).getBrand() +" "+ cars.get(i).price +"$"+ "/day");
            }
            System.out.print("Select (1-" + cars.size() + "): ");
            int carChoice = scanner.nextInt();
            selectedVehicle = cars.get(carChoice - 1);

        } else if (typeChoice == 2) {
            System.out.println("Motos:");
            for (int i = 0; i < motorcycles.size(); i++) {
                System.out.println((i + 1) + ". " + motorcycles.get(i).getBrand() + " " + motorcycles.get(i).price +"$"+ "/day");
            }
            System.out.print("Select (1-" + motorcycles.size() + "): ");
            int motoChoice = scanner.nextInt();
            selectedVehicle = motorcycles.get(motoChoice - 1);

        } else {
            System.out.println("Invalid. Try again");
            return;
        }

        System.out.print("Enter number of rental days?");
        int days = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Insurance? (yes/no): ");
        String insuranceInput = scanner.nextLine();
        boolean insurance = insuranceInput.equalsIgnoreCase("yes");

        double totalCost = selectedVehicle.calculateRentalCost(days, insurance);

        System.out.println("\n*****Paymenmt*****");
        System.out.println("Vehicle: " + selectedVehicle.getBrand());
        System.out.println("Day: " + days);
        System.out.println("Insurance: " + (insurance ? "yes" : "no"));
        System.out.println("Total cost: " + totalCost + "$");
    }
}
