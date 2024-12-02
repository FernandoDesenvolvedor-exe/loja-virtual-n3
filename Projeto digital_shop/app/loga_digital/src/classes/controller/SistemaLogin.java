package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Usuario;
import view.MainMenuFrame;

public class SistemaLogin {
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void registrarUsuario(Scanner scanner) {
        System.out.print("Digite um nome de usuário: ");
        String nome = scanner.nextLine();

        System.out.print("Digite um e-mail: ");
        String email = scanner.nextLine();

        System.out.print("Digite uma senha: ");
        String senha = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        usuarios.add(new Usuario(nome, email, senha, idade));
        System.out.println("Usuário registrado com sucesso!");
    }

    public void fazerLogin(Scanner scanner) {
        System.out.print("Digite o nome de usuário: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        boolean autenticado = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)) {
                System.out.println("Login bem-sucedido! Bem-vindo, " + nome + "!");
                autenticado = true;

                MainMenuFrame menu = new MainMenuFrame(usuario);
                break;
            }
        }

        if (!autenticado) {
            System.out.println("Nome de usuário ou senha incorretos. Tente novamente.");
        }
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            System.out.println("\n=== Lista de Usuários ===");
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        }
    }
}
