package classes.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.MissingFormatArgumentException;

import connectorJ.JConnector;

public class Produto {
    private int id;
    private String name;
    private String brand;
    private double value;
    private int discount;
    private int quantity;
    private int type;

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
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
        if(value > 100 || value < 0){
            throw new MissingFormatArgumentException("");
        }

        this.value = value;
    }

    public Produto(int id, String name, String brand, double value, int discount, int quantity, int type){
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.value = value;
        this.discount = discount;
        this.quantity = quantity;
        this.type = type;
    }
    
    @Override
    public String toString(){
        NumberFormat moeda = NumberFormat.getCurrencyInstance(Locale.US);
        String tipo;

        if(this.type == 1){
            tipo = "Digital";
        } else if (this.type == 2){
            tipo = "Físico";
        } else {
            tipo = "Digital/Físico";
        }

        return "ID: "+this.id+"\nNome : "+this.name+"\nMarca: "+this.brand+"\nValor: "+moeda.format(this.value-(this.value*(this.discount/100)))+"\nDesconto: "+this.discount+"%\nTipo: "+tipo;
    }

    public static ArrayList<Produto> getAll(){
        String sql = "SELECT * FROM products";
        ArrayList<Produto> list = new ArrayList<Produto>();

        try{
            PreparedStatement stmt = JConnector.getConnecion().prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                list.add(new Produto(
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

    public static void adicionarProduto(Produto produto){
        String sql = "INSERT INTO products (product_name,product_brand_name,product_quantity,product_value,product_discount,product_type) VALUES (?,?,?,?,?,?)";
        Connection conn = JConnector.getConnecion();

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, produto.getName());
            stmt.setString(2, produto.getBrand());
            stmt.setInt(3, produto.getQuantity());
            stmt.setDouble(4, produto.getValue());
            stmt.setInt(5, produto.getDiscount());
            stmt.setInt(6, produto.getType());

            stmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}