package controller;

import java.util.List;
import java.util.Scanner;
import model.Usuario;

public class SistemaLogin {
    private List<Usuario> usuarios = Usuario.getAllUsuarios();

    public void registrarUsuario(Scanner scanner) {
        System.out.print("Digite seu primeiro nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();

        System.out.print("Digite um e-mail: ");
        String email = scanner.nextLine();

        System.out.print("Digite uma senha: ");
        String senha = scanner.nextLine();

        System.out.print("Digite o seu endereço: ");
        String endereço = scanner.nextLine();

        System.out.print("Tipo de de usuario: ");
        int tipos = scanner.nextInt();

        Usuario usuario = new Usuario(nome, sobrenome, email, senha, tipos, endereço);

        usuarios.add(usuario);
        usuario.salveUsuario();
        System.out.println("Usuário registrado com sucesso!");
    }

    public Usuario fazerLogin(Scanner scanner) {
        Usuario usuarioEncontrado = new Usuario(null, null, null, null, 0, null);

        System.out.print("Digite o nome de usuário: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        boolean autenticado = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)) {
                System.out.println("Login bem-sucedido! Bem-vindo, " + nome + "!");
                usuarioEncontrado = usuario;
                autenticado = true;
                break;
            }
        }

        if (!autenticado) {
            System.out.println("Nome de usuário ou senha incorretos. Tente novamente.");
            return null;
        }

        return usuarioEncontrado;
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
