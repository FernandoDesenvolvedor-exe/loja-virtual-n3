package classes.model;

public class Product {
    private int id;
    private String name;
    private String brand;
    private float value;
    private int discount;
    private int quantity;

    public int getId() {
        return id;
    }    
    public String getName() {
        return name;
    }
    public String getBrand() {
        return brand;
    }
    public int getQuantity() {
        return quantity;
    }
    public float getValue() {
        return value;
    }
    public int getDiscount() {
        return this.discount;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setValue(float value) {
        this.value = value;
    }

    public void Product(int id, String name, String brand, float value, int discount, int quantity){
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.value = value;
        this.discount = discount;
        this.quantity = quantity;
    }    
}