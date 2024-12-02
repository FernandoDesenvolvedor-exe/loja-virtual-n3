package classes.model;
import java.util.List;
import java.util.Date;

public class Carrinho {
    //private Client client;
    public List<Produto> list;
    
    @SuppressWarnings("unused")
    private Date creationDate;

    public Carrinho(){}

    public void add(Produto produto){
        list.add(produto);
    }

    public void remover(Produto produto){
        list.remove(produto);
    }

    public void alterar(Produto produto){
        if(list.contains(produto)){
            int indice = list.indexOf(produto);
            list.add(indice, produto);
        }
    }
}
