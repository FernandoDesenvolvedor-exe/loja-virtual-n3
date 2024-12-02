package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import connectorJ.JConnector;

public class Product {
    private Integer id;
    private String name;
    private String brand;
    private Double value;
    private Integer discount;
    private Integer quantity;
    private Integer type;

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    
    public Integer getId() {
        return id;
    }    
    public String getName() {
        return name;
    }
    public String getBrand() {
        return brand;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public Double getValue() {
        return value;
    }
    public Integer getDiscount() {
        return this.discount;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return "{nome: "+this.name+",\nmarca: "+this.brand+",\nvalor: "+this.value+"}";
    }

    public Product(Integer id, String name, String brand, Double value, Integer discount, Integer quantity, Integer type){
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.value = value;
        this.discount = discount;
        this.quantity = quantity;
        this.type = type;
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
                    result.getInt("product_type")
                    )
                );
            }

        }catch(SQLException e){
            e.printStackTrace();
        }     

        return list;
    }

    public static boolean register(Product newProduct){
        Connection conn = JConnector.getConnecion();
        
        String sql = "INSERT INTO products (product_name,product_brand_name,product_quantity,product_value,product_discount,product_type) VALUES (?,?,?,?,?,?)";

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, newProduct.getName());
            stmt.setString(2, newProduct.getBrand());
            stmt.setInt(3, newProduct.getQuantity());
            stmt.setDouble(4, newProduct.getValue());
            stmt.setInt(5, newProduct.getDiscount());
            stmt.setInt(6, newProduct.getType());
            stmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
}