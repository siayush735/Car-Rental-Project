import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car {
    private String carId;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;

    public Car(String carId, String model, double basePricePerDay) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;
    }

    public String getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double calculatorPrice(int rentalDays) {
        return basePricePerDay * rentalDays;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rent() {
        isAvailable = false;
    }

    public void returnCar() {
        isAvailable = true;
    }

    class Customer {
        private String customerId;
        private String name;

        public Customer(String customerId, String name) {
            this.customerId = customerId;
            this.name = name;
        }

        public String getCustomerId() {
            return customerId;
        }

        public String getName() {
            return name;
        }
    }

    class Rental {
        private Car car;
        private Customer customer;
        private int days;

        public Rental(Car car, Customer customer, int days) {
            this.car = car;
            this.customer = customer;
            this.days = days;
        }

        public Car getCar() {
            return car;
        }

        public Customer getcustomer() {
            return customer;
        }

        public int getDays() {
            return days;
        }
    }

    class carRentalSystem {
        private List<Car> cars;
        private List<Customer> customers;
        private List<Rental> rentals;

        public void CarRentalSystem() {
            cars = new ArrayList<>();
            customers = new ArrayList<>();
            rentals = new ArrayList<>();
        }

        public void addCar(Car car) {
            cars.add(car);
        }

        public void addCustomer(Customer customer) {
            customers.add(customer);
        }

        public void rentalCar(Car car, Customer customer, int days) {
            if (car.isAvailable()) {
                car.rent();
                rentals.add(new Rental(car, customer, days));
            } else {
                System.out.println("Car is not available for rent.");
            }
        }

        public void returnCar(Car car) {
            car.returnCar();
            Rental rentalToRemove = null;
            for (Rental rental : rentals) {
                if (rental.getCar() == car) {
                    rentalToRemove = rental;
                    break;
                }
            }
            if (rentalToRemove != null) {
                rentals.remove(rentalToRemove);
                System.out.println("Car returned succesfully.");
            } else {
                System.out.println("Car was not rented");
            }
        }

        public void menu() {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("===== Car Rental System =====");
                System.out.println("1.Rent a car");
                System.out.println("2. Return a car");
                System.out.println("3. Exit");
                System.out.println("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    System.out.println("\n==Rent a Car==\n");
                    System.out.println("Enter your name: ");
                    String customberName = scanner.nextLine();
                    System.out.println("\nAvailable Cars:");
                    for (Car car : cars) {
                        if (car.isAvailable()) {
                            System.out.println(car.getCarId() + " - " + car.getBrand() + " " + car.getModel());
                        }
                    }
                    System.out.print("\nEnter the car ID you want to rent: ");
                    String carId = scanner.nextLine();
                    System.out.print("Enter the number of days for rental: ");
                    int rentalDays = scanner.nextInt();
                    scanner.nextLine();

                    Customer newCustomer = new Customer(customerId : "CUS" + (customers.size() + 1), customerName);
                    addCustomer(newCustomer);

                    Car selectedCar = null;
                    for(Car car : cars){r
                        if(car.getCarId().equals(carId) && car.isAvailable()){
                            selectedCar = car;
                            break;
                        }
                    }
                   if(selectedCar != null){
                    double totalPrice = selectedCar.calculatePrice(rentalDays);
                    System.out.println("\n== Rental Information ==\n");
                    System.out.println("Customer ID: "+ newCustomer.getCustomerId());
                    System.out.println("Customer Name: "+ newCustomer.gerName());
                    System.out.println("Car: " + selectedCar.getBrand() + " "+ selectedCar.getModel());
                    System.out.println("Rental Days: "+ rentalDays);
                    System.out.println("Total Price: $%.2/n", totalPrice);
                   }

                }

            }
        }
    }
}