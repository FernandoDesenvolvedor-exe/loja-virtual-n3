package classes.view;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.List;
import classes.model.Product;

public class StoreFrame extends JFrame{
    private  List<Product> storeList;

    public StoreFrame()
    {
        this.setTitle("Loja");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLayout(new FlowLayout());

        JButton btnCart = new JButton("Carrinho");
        JButton btnReturn = new JButton("Voltar");

        this.add(btnCart);
        this.add(btnReturn);

        this.pack();
        this.setVisible(true);
    }
}
