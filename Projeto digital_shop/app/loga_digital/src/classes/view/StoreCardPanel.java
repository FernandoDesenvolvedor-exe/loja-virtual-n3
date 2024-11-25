package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import model.Product;

public class StoreCardPanel extends JPanel implements ActionListener{
    JButton addProductBtn;
    JButton addCartProductBtn;
    JButton altProductBtn;
    JButton removeProductBtn;
    JTable table;

    JDialog dialog;
    
    ImageIcon offerIcon = new ImageIcon(ImgIcon.DESCONTO.img());

    final Color MENU_COLOR = new Color(0x3C2961);
    final Color CONTENT_COLOR = new Color(0x9C98BB);
    final Color FONT_COLOR = new Color(0xDBD6E3);
    
    public StoreCardPanel(int userType){            

        JPanel buttoPanel = new JPanel();
        buttoPanel.setBackground(CONTENT_COLOR);
        

        if(userType == 1){
            addProductBtn = new JButton("Adicionar Produto");
            addProductBtn.setPreferredSize(new Dimension(Components.BTNW.getNum(),Components.BTNH.getNum()));
            addProductBtn.setBackground(MENU_COLOR);
            addProductBtn.setForeground(Color.WHITE);
            addProductBtn.setFocusable(false);
            addProductBtn.addActionListener(this);

            altProductBtn = new JButton("Alterar Produto");
            altProductBtn.setPreferredSize(new Dimension(Components.BTNW.getNum(),Components.BTNH.getNum()));
            altProductBtn.setBackground(MENU_COLOR);
            altProductBtn.setForeground(Color.WHITE);
            altProductBtn.setFocusable(false);

            removeProductBtn = new JButton("Remover Produto");
            removeProductBtn.setPreferredSize(new Dimension(Components.BTNW.getNum(),Components.BTNH.getNum()));
            removeProductBtn.setBackground(MENU_COLOR);
            removeProductBtn.setForeground(Color.WHITE);
            removeProductBtn.setFocusable(false);

            buttoPanel.add(addProductBtn);
            buttoPanel.add(altProductBtn);
            buttoPanel.add(removeProductBtn);
            
            buttoPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,100));  
        } else {
            addCartProductBtn = new JButton("Adicionar ao carrinho");
            addCartProductBtn.setPreferredSize(new Dimension(Components.BTNW.getNum(),Components.BTNH.getNum()));
            addCartProductBtn.setBackground(MENU_COLOR);
            addCartProductBtn.setForeground(Color.WHITE);
            addCartProductBtn.setFocusable(false);

            buttoPanel.add(addCartProductBtn);
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
                data[n][5] = new JButton("",offerIcon);

            data[n][6] = product.getQuantity();
            data[n][7] = product.isDigital();
            
            n++;
        }

        table = new JTable();    
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        DefaultTableModel tModel = new DefaultTableModel(data,columns){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };       

        table.setModel(tModel);
        table.setRowHeight(100);              
        table.setShowVerticalLines(false);        
        table.setFocusable(false);
        table.setBackground(new Color(0xE7E2F4));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        TableColumn column = null;
        for (int i = 0; i < 5; i++) {
            column = table.getColumnModel().getColumn(i);

            DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
            cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            column.setCellRenderer(cellRenderer);

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

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        table.setFillsViewportHeight(true);
        
        scrollPane.setPreferredSize(new Dimension(450,500));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JPanel newPanel = new JPanel();
        newPanel.add(scrollPane);
        newPanel.setBackground(CONTENT_COLOR);

        this.setLayout(new BorderLayout(0,0));
        this.add(newPanel,BorderLayout.WEST);
        this.add(buttoPanel);
        this.setBackground(CONTENT_COLOR);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == addProductBtn){
            AddProductFrame addPanel = new AddProductFrame();
        }
    }
}
