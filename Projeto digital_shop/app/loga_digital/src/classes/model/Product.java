package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectorJ.JConnector;

public class Product {
    private int id;
    private String name;
    private String brand;
    private double value;
    private int discount;
    private int quantity;
    private boolean isDigital;

    public boolean isDigital() {
        return isDigital;
    }

    public void setDigital(boolean isDigital) {
        this.isDigital = isDigital;
    }
    
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
    public double getValue() {
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

    public Product(int id, String name, String brand, double value, int discount, int quantity, boolean isDigital){
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.value = value;
        this.discount = discount;
        this.quantity = quantity;
        this.isDigital = isDigital;
    }    

    public static ArrayList<Product> getAll(){
        String sql = "SELECT * FROM products";
        ArrayList<Product> list = new ArrayList<Product>();

        try{
            PreparedStatement stmt = JConnector.getConnecion().prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                list.add(new Product(
                    result.getInt("product_id"),
                    result.getString("product_name"), 
                    result.getString("product_brand_name"), 
                    result.getDouble("product_value"), 
                    result.getInt("product_quantity"),
                    result.getInt("product_discount"),
                    result.getBoolean("product_type")
                    )
                );
            }

        }catch(SQLException e){
            e.printStackTrace();
        }     

        return list;
    }
}