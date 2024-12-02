package controller;

import java.util.Scanner;

import model.Produto;
import model.Usuario;

import java.util.List;

public class SistemaLoja {
    List<Produto> produtos = Produto.getAll();
    Usuario usuarioLogado;
    Scanner scanner;

    public SistemaLoja(Usuario usuarioLogado, Scanner scanner){
        this.usuarioLogado = usuarioLogado;
        this.scanner = scanner;
    }

    public void abrirMenuLoja(){
        int opcaoLoja;

        do{
            System.out.println("Menu Loja - "+usuarioLogado.toString());
            System.out.println();
            System.out.println("1 - Loja");
            if(usuarioLogado.getTipo() == 1){
                System.out.println("2 - Carrinho");
            }
            System.out.println("3 - logout;");
            System.out.println("Escolha uma opção");
            opcaoLoja = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcaoLoja) {
                case 1:
                    this.menuLoja();    
                    
                    break;
                case 2:
                    break;
                case 3:
                    break;
            
                default:
                    break;
            }


        }while(opcaoLoja != 3);
    }    

    void menuLoja(){
        int opcao;
        do{
            System.out.println("Loja - "+this.usuarioLogado.toString());
            System.out.println("");
            System.out.println("1 - Listar produtos");
            System.out.println("2 - Selecionar produto");
            System.out.println("3 - voltar");
            if(usuarioLogado.getTipo() == 2){
                System.out.println("4 - Novo produto");
            }
            System.out.println();
            System.out.println("Escolha uma opção");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:

                    for (Produto produto : produtos) {
                        System.out.println("--------------------------");
                        System.out.println(produto.toString());
                        System.out.println("--------------------------");
                    }
                    
                    break;

                case 2:

                    this.menuProduto();
            
                default:
                    break;
            }

        }while(opcao != 4);
    }

    Produto buscaProdutoPorId(Integer id){
        for (Produto produto : produtos) {
            if(produto.getId() == id){
                return produto;
            }
        }

        return null;
    }

    void menuProduto(){
        int opcao;
        do{
            System.out.println("ID do produto: ");
            int id = scanner.nextInt();
            scanner.nextLine();
    
            Produto produto = this.buscaProdutoPorId(id);
    
            System.out.println("-----------------------");
            System.out.println(produto.toString());
            System.out.println("-----------------------");            
            if(usuarioLogado.getTipo() == 1){
                this.menuCliente();   
            } else {
                this.menuFuncionario();
            }
            System.out.println("Escolha uma opcao");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if(usuarioLogado.getTipo() == 1){

                    }
                    
                    break;
            
                default:
                    break;
            }

        }while(opcao != 0);
        
    }

    void menuCliente(){
        System.out.println("1 - Adicionar ao carrinho");
    }

    void menuFuncionario(){
        System.out.println("1 - Alterar produto");
        System.out.println("2 - Remover produto");
    }
}