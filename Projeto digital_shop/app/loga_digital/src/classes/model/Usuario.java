package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import connectorJ.JConnector;

public class Usuario {    
    int tipos;
    String nome;
    String sobrenome;
    String email;
    String senha;
    String endereço;
    Carrinho carrinho;

    public Usuario(String nome, String sobrenome, String email, String senha, int tipos, String endereço) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.tipos = tipos;
        this.endereço = endereço;

    }

    @Override
    public String toString() {
        if (this.tipos == 2) {
            return "Nome: " + nome + " " + sobrenome + "(funcionario)";
        } else{
            return "Nome: " + nome + " " + sobrenome + "(Cliente)";
        }
    }

    public String getSenha(){
        return this.senha;
    }

    public void setSenha(String novaSenha){
        this.senha = novaSenha;
    }

    public boolean login(){
        return false;
    }

    public boolean logout(){
        return false;
    }
    
    public int getTipo() {
        return this.tipos;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String userName) {
        this.nome = userName;
    }

    public void setTipo(int userType) {
        this.tipos = userType;
    }

    public void salveUsuario() {
        Connection save = JConnector.getConnecion();

        String sql = "INSERT INTO users (user_name, user_surname, user_email, user_password, user_address, user_type) VALUES (?, ?, ?, ?, ?, ?)";

        try {
        PreparedStatement stmt = save.prepareStatement(sql);

        stmt.setString(1, this.nome);
        stmt.setString(2, this.sobrenome);
        stmt.setString(3, this.email);
        stmt.setString(4, this.senha);
        stmt.setString(5, this.endereço);
        stmt.setInt(6, this.tipos);

        int rowsInserted = stmt.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("Inserção bem-sucedida!");
        }
    } catch (Exception e){
        e.printStackTrace();
    }
    }

public static List<Usuario> getAllUsuarios() {
    List<Usuario> usuarios = new ArrayList<>();
    Connection connection = JConnector.getConnecion();

    String sql = "SELECT user_name, user_surname, user_email, user_password, user_address, user_type FROM users";

    try {
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String nome = rs.getString("user_name");
            String sobrenome = rs.getString("user_surname");
            String email = rs.getString("user_email");
            String senha = rs.getString("user_password");
            String endereco = rs.getString("user_address");
            int tipo = rs.getInt("user_type");

            Usuario usuario = new Usuario(nome, sobrenome, email, senha, tipo, endereco);
            usuarios.add(usuario);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return usuarios;
}

}
