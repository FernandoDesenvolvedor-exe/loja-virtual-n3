package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddProductFrame extends JFrame implements ActionListener{

    final Color MENU_COLOR = new Color(0x3C2961);
    final Color CONTENT_COLOR = new Color(0x9C98BB);
    final Color FONT_COLOR = new Color(0xDBD6E3);
    final Dimension TEXT_FIELD_DIMENSION = new Dimension(250,35);
    final EmptyBorder TEXT_FIELD_BORDER = new EmptyBorder(5, 10, 5, 10);

    JButton confBtn;
    JButton clBtn;

    JTextField jTxtFName;
    JTextField jTxtFBrand;


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

        jTxtFName = new JTextField(){
            @Override
            protected void paintComponent(Graphics g){
                //Desenha fundo arredondado
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                //Cor de fundo do JTextField
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth() -1, getHeight() -1, 15, 15);

                //Cor da borda
                g2.setColor(getForeground());
                g2.drawRoundRect(0, 0, getWidth() -1, getHeight() -1, 15, 15);

                g2.dispose();

                super.paintComponent(g);

            }
        };
        jTxtFName.setOpaque(false);
        jTxtFName.setPreferredSize(TEXT_FIELD_DIMENSION);
        jTxtFName.setBackground(Color.WHITE);
        jTxtFName.setText("Nome");
        jTxtFName.setBorder(TEXT_FIELD_BORDER);                

        jTxtFBrand = new JTextField(){
            @Override
            protected void paintComponent(Graphics g){
                //Desenha fundo arredondado
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                //Cor de fundo do JTextField
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth() -1, getHeight() -1, 15, 15);

                //Cor da borda
                g2.setColor(getForeground());
                g2.drawRoundRect(0, 0, getWidth() -1, getHeight() -1, 15, 15);

                g2.dispose();

                super.paintComponent(g);

            }
        };
        jTxtFBrand.setOpaque(false);
        jTxtFBrand.setPreferredSize(TEXT_FIELD_DIMENSION);
        jTxtFBrand.setBackground(Color.WHITE);
        jTxtFBrand.setText("Marca");
        jTxtFBrand.setBorder(TEXT_FIELD_BORDER);       



        this.add(jTxtFName);
        this.add(jTxtFBrand);
    }

    @Override
    public void actionPerformed(ActionEvent evt){
        
    }
}
