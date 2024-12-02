import java.util.Scanner;

import controller.SistemaLogin;
import controller.SistemaLoja;
import model.Usuario;;

public class App {
    public static void main(String[] args) throws Exception {  
        SistemaLogin logger = new SistemaLogin();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            
            System.out.println("\n=== Sistema de Login ===");
            System.out.println("1. Registrar novo usuário");
            System.out.println("2. Fazer login");
            System.out.println("3. Listar usuários cadastrados (Admin)");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    logger.registrarUsuario(scanner);
                    break;
                case 2:
                    Usuario usuarioLogado = logger.fazerLogin(scanner);
                    SistemaLoja loja = new SistemaLoja(usuarioLogado, scanner);
                    loja.abrirMenuLoja();

                    break;
                case 3:
                    logger.listarUsuarios();
                    break;
                case 4:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
