package entities;

public class Product {
    private static int autoID = 0;

    public static int getNextID() {
        return ++autoID;
    }
    private int id;
    private String name;
    private String description;
    private int quantity;
    private double price;
    private String unit;

    public Product(int id, String name, String description, int quantity, double price, String unit) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.unit = unit;
    }

    public static int getAutoID() {
        return autoID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                '}';
    }
}
