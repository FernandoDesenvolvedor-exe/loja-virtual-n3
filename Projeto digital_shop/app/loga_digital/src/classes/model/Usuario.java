package model;

public class Usuario {    
    int tipo;
    String nome;
    String email;
    String senha;
    int idade;

    public Usuario(String nome, String email, String senha, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", E-mail: " + email + ", Idade: " + idade;
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
        return this.tipo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String userName) {
        this.nome = userName;
    }

    public void setTipo(int userType) {
        this.tipo = userType;
    }
}
