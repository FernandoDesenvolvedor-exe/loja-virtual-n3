package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import model.Product;

public class StoreCardPanel extends JPanel implements ActionListener{
    JButton addProductBtn;
    JButton addCartProductBtn;
    JButton altProductBtn;
    JButton removeProductBtn;
    
    ImageIcon offerIcon = new ImageIcon(ImgIcon.DESCONTO.img());

    final Color MENU_COLOR = new Color(0x3C2961);
    final Color CONTENT_COLOR = new Color(0x9C98BB);
    final Color FONT_COLOR = new Color(0xDBD6E3);
    
    public StoreCardPanel(int userType){            
        this.setBackground(CONTENT_COLOR);
        this.setSize(800, 800);
        this.setLayout(new BorderLayout(20,20));

        JPanel buttoPanel = new JPanel();
        buttoPanel.setLayout(null);
        buttoPanel.setPreferredSize(new Dimension(100,this.getHeight()));
        buttoPanel.setBackground(CONTENT_COLOR);

        if(userType == 1){
            addProductBtn = new JButton("Adicionar Produto");
            altProductBtn = new JButton("Alterar Produto");
            removeProductBtn = new JButton("Remover Produto");

            buttoPanel.add(addProductBtn);
            buttoPanel.add(altProductBtn);
            buttoPanel.add(removeProductBtn);
        } else {
            addCartProductBtn = new JButton("Adicionar ao carrinho");
        }

        ArrayList<Product> products = Product.getAll();
        String[] columns = {"ID","Produto","Marca","Preço","Desconto","Quantidade","Digital"};
        Object[][] data = new Object[products.size()][8];

        int n = 0;
        for (Product product : products) {           

            data[n][0] = product.getId();
            data[n][1] = product.getName();
            data[n][2] = product.getBrand();
            data[n][3] = new String("R$ "+ (product.getValue() - (product.getValue()*(product.getDiscount()/100))));
            data[n][4] = product.getValue()*(product.getDiscount()/100);
            
            if(product.getDiscount() > 0) 
                data[n][5] = offerIcon;

            data[n][6] = product.getQuantity();
            data[n][7] = product.isDigital();
            
            n++;
        }


        JTable table = new JTable(data,columns);    
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        TableColumn column = null;
        for (int i = 0; i < 5; i++) {
            column = table.getColumnModel().getColumn(i);

            if (i == 0) {
                column.setPreferredWidth(20); //third column is bigger
            }

            if(i == 1){
                column.setPreferredWidth(250);
            }

            if(i == 2){
                column.setPreferredWidth(200);
            }
            
            if(i == 3){
                column.setPreferredWidth(120);
            }

            if(i == 4){
                column.setPreferredWidth(100);
            }

        }

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane.setPreferredSize(new Dimension(600,100));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.add(scrollPane,BorderLayout.LINE_END);
        this.add(buttoPanel,BorderLayout.LINE_START);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt){

    }
}
