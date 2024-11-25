package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.util.ArrayList;

public class AddProductFrame extends JFrame implements ActionListener{

    final Color MENU_COLOR = new Color(0x3C2961);
    final Color CONTENT_COLOR = new Color(0x9C98BB);
    final Color FONT_COLOR = new Color(0xDBD6E3);

    JButton confBtn;
    JButton clBtn;

    JTextField jTxtFName;

    public AddProductFrame(){
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setVgap(20);
        flowLayout.setHgap(50);
        flowLayout.setAlignment(FlowLayout.CENTER);

        this.setBackground(CONTENT_COLOR);
        this.setSize(400,800);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Adicionar Produto");
        this.setVisible(true);
        this.setLayout(flowLayout);        
        this.getContentPane().setBackground(CONTENT_COLOR);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        jTxtFName = new JTextField();
        jTxtFName.setSize(new Dimension(200,40));
        jTxtFName.setBackground(Color.WHITE);
        jTxtFName.setText("Nome");

       this.add(jTxtFName);
    }

    @Override
    public void actionPerformed(ActionEvent evt){
        
    }
}
