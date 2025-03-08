import java.io.*;
import java.util.*;

class Medicine {
    String name;
    double price;
    int quantity;
    
    public Medicine(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String format() {
        return name + "," + price + "," + quantity;
    }
}

class Pharmacy {
    private List<Medicine> stock;
    
    public Pharmacy() {
        stock = new ArrayList<>();
        loadStockFromFile();
    }
    
    public void loadStockFromFile() {
        File file = new File("stock.txt");
        if (!file.exists()) {
            return;
        }
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                if (data.length == 3) {
                    String name = data[0];
                    double price = Double.parseDouble(data[1]);
                    int quantity = Integer.parseInt(data[2]);
                    stock.add(new Medicine(name, price, quantity));
                }
            }
            System.out.println("Stock loaded from file.");
        } catch (FileNotFoundException e) {
            System.out.println("Error reading stock file: ");
        }
    }
    
    public void displayStock() {
        for (Medicine med : stock) {
            System.out.println("Medicine: " + med.name + ", Price: " + med.price + ", Stock: " + med.quantity);
        }
    }
    
    public void addStock(String name, double price, int quantity) {
        stock.add(new Medicine(name, price, quantity));
    }
    
    public void updateStock(String name, int additionalQuantity) {
        for (Medicine med : stock) {
            if (med.name.equalsIgnoreCase(name)) {
                med.quantity += additionalQuantity;
                System.out.println("Stock updated for " + name + ". New quantity: " + med.quantity);
                return;
            }
        }
        System.out.println("Medicine not found. Consider adding it.");
    }
    
    public void sellStock(String name, int quantity) {
        for (Medicine med : stock) {
            if (med.name.equalsIgnoreCase(name)) {
                if (med.quantity >= quantity) {
                    med.quantity -= quantity;
                    System.out.println("Stock Sold.");
                } else {
                    System.out.println("Stock Not Available.");
                }
                return;
            }
        }
        System.out.println("Stock Not Found.");
    }
    
    public void savetofile() {
        try (PrintWriter writer = new PrintWriter(new File("stock.txt"))) {
            for (Medicine med : stock) {
                writer.println(med.format());
            }
            System.out.println("Stock saved to file.");
        } catch (FileNotFoundException e) {
            System.out.println("Error saving stock to file: " + e.getMessage());
        }
    }
}

public class project {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pharmacy pharmacy = new Pharmacy();
        
        while (true) {
            System.out.println("\nPharmacy Management System");
            System.out.println("1. Display Stock");
            System.out.println("2. Add Medicine");
            System.out.println("3. Update Medicine Stock");
            System.out.println("4. Sell Medicine");
            System.out.println("5. Save Stock to File");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch(choice) {
                case 1:
                    pharmacy.displayStock();
                    break;
                case 2:
                    System.out.print("Enter Medicine Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Medicine Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Medicine Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    pharmacy.addStock(name, price, quantity);
                    break;
                case 3:
                    System.out.print("Enter Medicine Name to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter additional quantity: ");
                    int addQuantity = scanner.nextInt();
                    scanner.nextLine();
                    pharmacy.updateStock(updateName, addQuantity);
                    break;
                case 4:
                    System.out.print("Enter Medicine Name: ");
                    String sellName = scanner.nextLine();
                    System.out.print("Enter Quantity to sell: ");
                    int sellQuantity = scanner.nextInt();
                    scanner.nextLine();
                    pharmacy.sellStock(sellName, sellQuantity);
                    break;
                case 5:
                    pharmacy.savetofile();
                    break;
                case 6:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid Choice. Try again.");
            }
        }
    }
}
