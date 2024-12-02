package classes.controller;

import java.util.Scanner;

import classes.model.Produto;
import classes.model.Usuario;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;

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

                    break;

                case 3:

                    break;
                
                case 4:
                    try{
                        System.out.println("--------- Produto Novo ------------");
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        System.out.print("Marca: ");
                        String marca = scanner.nextLine();

                        System.out.print("Valor: ");
                        Double valor = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.println("Desconto: ");
                        int desconto = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Quantidade em estoque: ");
                        int qtdEstoque = scanner.nextInt();

                        System.out.println("(1)Digital; (2)Fisico; (3)Digital/Fisico");
                        int tipo = scanner.nextInt();

                        Produto produto = new Produto(produtos.getLast().getId()+1, nome, marca, valor, desconto, qtdEstoque, tipo);


                        produtos.add(produto);

                        Produto.adicionarProduto(new Produto(0, nome, marca, valor, desconto, qtdEstoque, tipo));

                        System.out.println("Produto inserido com sucesso!");
                    }catch(NoSuchElementException e){
                        e.printStackTrace();
                    }

                    break;            
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
                        System.out.println("O que deseja alterar: ");
                        System.out.println("1 - Nome");
                        System.out.println("2 - Marca");
                        System.out.println("4 - Valor");
                        System.out.println("5 - Desconto");
                        System.out.println("6 - Tipo");
                        System.out.print("Escolha uma opção: ");
                        int prtOpcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (prtOpcao) {
                            case 1:
                                System.out.println("Nome:"+produto.getName());
                                System.out.print("Novo nome");
                                String novoNome = scanner.nextLine();
                                

                                
                                break;
                            case 2:
                                System.out.println("Marca:"+produto.getBrand());
                            default:
                                break;
                        }
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