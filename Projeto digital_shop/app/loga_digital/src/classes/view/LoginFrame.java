package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LoginFrame extends JFrame {
    public LoginFrame()
    {
        this.setTitle("Loja");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0xDEF0FA));
        //this.setLayout(new FlowLayout());

        JButton btnCart = new JButton("Carrinho");
        JButton btnReturn = new JButton("Voltar");

        this.add(btnCart);
        this.add(btnReturn);

        //this.pack();
        this.setVisible(true);
    }
}
