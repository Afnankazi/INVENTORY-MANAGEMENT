// App's External Imports

import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

class Product {
    private final int id;
    private int quantity;
    private String category;
    private final String name;
    private double buying_price;
    private double selling_price;

    public Product(int id, String name, int quantity, String category, double buying_price, double selling_price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.category = category;
        this.buying_price = buying_price;
        this.selling_price = selling_price;
    }

    // Methods To Get Product Details
    public int get_id() {
        return id;
    }

    public String get_name() {
        return name;
    }

    public int get_quantity() {
        return quantity;
    }

    public String get_category() {
        return category;
    }

    public double get_buying_price() {
        return buying_price;
    }

    public double get_selling_price() {
        return selling_price;
    }

    // Methods To Set Product Details
    public void set_quantity(int quantity) {
        this.quantity = quantity;
    }

    public void set_category(String category) {
        this.category = category;
    }

    public void set_buying_price(double buying_price) {
        this.buying_price = buying_price;
    }

    public void set_selling_price(double selling_price) {
        this.selling_price = selling_price;
    }

    public String convert_to_string() {
        return String.format("\t\t| %2d | %-20s | %8d | %-17s | Rs %-16.2f | Rs %-16.2f |", id, name, quantity, category, buying_price, selling_price);
    }

    public String convert_to_file_string() {
        return String.format("%d,%s,%d,%s,%.2f,%.2f", id, name, quantity, category, buying_price, selling_price);
    }
}

public class Inventory {
    private String invoke_method_type;
    private static ArrayList<Product> inventory = new ArrayList<>();
    private static ArrayList<Product> invoice = new ArrayList<>();
    private static final String FILE_PATH = "inventory.txt";
    private static final Scanner scanner = new Scanner(System.in);

    Inventory() {
        invoke_method_type = "inventory";
    }

    Inventory(String method_type) {
        invoke_method_type = method_type;
    }

    public void main() {
        fetch_inventory();

        while (true) {
            display_menu(invoke_method_type);

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (Objects.equals(invoke_method_type, "inventory")) {
                switch (choice) {
                    case 1:
                        add_product();
                        break;
                    case 2:
                        modify_product();
                        break;
                    case 3:
                        delete_product();
                        break;
                    case 4:
                        display_inventory();
                        break;
                    case 5:
                        save_inventory();
                        System.out.println("\n\t\tExiting program. Thank You!");
                        System.exit(0);
                    default:
                        System.out.println("\t\tInvalid choice. Please try again.");
                }
            } else {
                switch (choice) {
                    case 1:
                        generate_invoice();
                        break;
                    case 2:
                        print_invoice();
                        break;
                    case 3:
                        save_inventory();
                        System.out.println("\n\t\tExiting program. Thank You!");
                        System.exit(0);
                    default:
                        System.out.println("\t\tInvalid choice. Please try again.");
                }
            }
        }
    }

    private static void display_menu(String method_type) {
        if (Objects.equals(method_type, "inventory")) {
            System.out.println("\n\t================================================== Welcome To AJ Electronics Inventory ==================================================");
            System.out.println("\n\t\t1) Add Product");
            System.out.println("\t\t2) Modify Product");
            System.out.println("\t\t3) Delete Product");
            System.out.println("\t\t4) Display Inventory");
            System.out.println("\t\t5) Save and Exit");
            System.out.print("\n\t\tEnter your choice: ");
        } else {
            System.out.println("\n\t================================================== Welcome To AJ Electronics ==================================================");
            System.out.println("\n\t\t1) Generate Invoice");
            System.out.println("\t\t2) Print Invoice");
            System.out.println("\t\t3) Save and Exit");
            System.out.print("\n\t\tEnter your choice: ");
        }

    }

    private static void add_product() {
        System.out.println("\n\t\t<------------------- Add Product ----------------------->");
        System.out.print("\n\t\tEnter product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("\t\tEnter product name: ");
        String name = scanner.nextLine();

        System.out.print("\t\tEnter quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("\t\tEnter product category: ");
        String category = scanner.next();

        System.out.print("\t\tEnter buying price: Rs ");
        double buying_price = scanner.nextDouble();

        System.out.print("\t\tEnter selling price: Rs ");
        double selling_price = scanner.nextDouble();

        Product new_product = new Product(id, name, quantity, category, buying_price, selling_price);
        inventory.add(new_product);
        System.out.println("\n\t\t<------------------- Product added successfully! ----------------------->");
    }

    private static void modify_product() {
        System.out.println("\n\t\t<------------------- Modify Product ----------------------->");
        System.out.print("\n\t\tEnter the product ID to modify: ");
        int id_to_modify = scanner.nextInt();
        scanner.nextLine();

        for (Product product : inventory) {
            if (product.get_id() == id_to_modify) {
                System.out.format("\t\tEnter new quantity (previous: %d): ", product.get_quantity());
                int new_quantity = scanner.nextInt();
                product.set_quantity(new_quantity);

                System.out.format("\t\tEnter new category (previous: %s): ", product.get_category());
                String new_category = scanner.next();
                product.set_category(new_category);

                System.out.format("\t\tEnter new buying price (previous: Rs %.2f): Rs ", product.get_buying_price());
                double new_buying_price = scanner.nextDouble();
                product.set_buying_price(new_buying_price);

                System.out.format("\t\tEnter new selling price (previous: Rs %.2f): Rs ", product.get_selling_price());
                double new_selling_price = scanner.nextDouble();
                product.set_selling_price(new_selling_price);

                System.out.println("\n\t\t<------------------- Product modified successfully! ----------------------->");
                return;
            }
        }

        System.out.format("\n\t\t<------------------- Ops! Product not found with ID: %d ----------------------->", id_to_modify);
    }

    private static void delete_product() {
        System.out.println("\n\t\t<------------------- Delete Product ----------------------->");
        System.out.print("\n\t\tEnter the product ID to delete: ");
        int id_to_delete = scanner.nextInt();
        scanner.nextLine();

        for (Product product : inventory) {
            if (product.get_id() == id_to_delete) {
                inventory.remove(product);
                System.out.println("\n\t\t<------------------- Product deleted successfully! ----------------------->");
                return;
            }
        }

        System.out.format("\n\t\t<------------------- Ops! Product not found with ID: %d ----------------------->", id_to_delete);
    }

    static void display_inventory() {
        System.out.println("\n\t\t<------------------- Inventory ----------------------->");
        if (inventory.isEmpty()) {
            System.out.println("\n\t\t<------------------- Ops! Inventory is empty ----------------------->");
        } else {
            System.out.format("\t\t+----+----------------------+----------+----------------------+----------------------+----------------------+\n" + "\t\t| ID | Name                 | Quantity | Category             | Buying Price         | Selling Price        |\n" + "\t\t+----+----------------------+----------+----------------------+----------------------+----------------------+\n");
            for (Product product : inventory) {
                System.out.println(product.convert_to_string());
            }
            System.out.format("\t\t+----+----------------------+----------+----------------------+----------------------+----------------------+");
        }
    }

    private static void generate_invoice() {
        System.out.println("\n\t\t<------------------- Generate Invoice ----------------------->");

        while (true) {
            System.out.print("\n\t\tEnter the product ID: ");
            int product_id = scanner.nextInt();
            scanner.nextLine();

            if (product_id == 0) {
                break;
            }

            for (Product product : inventory) {
                if (product.get_id() == product_id) {
                    if (product.get_quantity() != 0) {
                        int previous_quantity = product.get_quantity();
                        System.out.format("\t\tEnter the quantity (available: %d): ", previous_quantity);
                        int new_quantity = scanner.nextInt();
                        product.set_quantity(previous_quantity - new_quantity);

                        Product purchased_product = new Product(product.get_id(), product.get_name(), product.get_quantity(), product.get_category(), product.get_buying_price(), product.get_selling_price());
                        invoice.add(purchased_product);
                    } else {
                        System.out.println("\n\t\t<------------------- Product Out of Stock ----------------------->");
                        break;
                    }
                }
            }
        }
    }

    private static void print_invoice() {
        System.out.println("\n\t\t<------------------- Invoice ----------------------->");

        if (inventory.isEmpty()) {
            System.out.println("\n\t\t<------------------- Ops! Your cart is currently empty ----------------------->");
        } else {
            System.out.format("\t\t+----+----------------------+----------+----------------------+----------------------+----------------------+\n" + "\t\t| ID | Name                 | Quantity | Category             | Buying Price         | Selling Price        |\n" + "\t\t+----+----------------------+----------+----------------------+----------------------+----------------------+\n");
            for (Product product : invoice) {
                System.out.println(product.convert_to_string());
            }
            System.out.format("\t\t+----+----------------------+----------+----------------------+----------------------+----------------------+");
        }
    }

    private static void fetch_inventory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                String category = parts[3];
                double buying_price = Double.parseDouble(parts[4]);
                double selling_price = Double.parseDouble(parts[5]);
                Product product = new Product(id, name, quantity, category, buying_price, selling_price);
                inventory.add(product);
            }
        } catch (IOException e) {
            System.out.println("\n\t\t<------------------- Failed to fetch inventory! ----------------------->");
        }
    }

    private static void save_inventory() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Product product : inventory) {
                writer.write(product.convert_to_file_string());
                writer.newLine();
            }
            System.out.println("\n\t\t<------------------- Inventory saved successfully! ----------------------->");
        } catch (IOException e) {
            System.out.println("\n\t\t<------------------- Failed to save inventory! ----------------------->");
        }
    }
}
