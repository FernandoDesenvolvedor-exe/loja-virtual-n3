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

import controller.ProductController;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import model.Product;
import view.componentes_personalizados.MyJButton;
import view.componentes_personalizados.MyJFrame;

public class StorePanel extends JPanel implements ActionListener{
    ProductController productController = new ProductController();
    ArrayList<Product> products = Product.getAll();

    MyJButton addProductBtn;
    MyJButton addCartProductBtn;
    MyJButton altProductBtn;
    MyJButton removeProductBtn;
    JTable table;

    JDialog dialog;
    
    ImageIcon offerIcon = new ImageIcon(ImgIcon.DESCONTO.img());

    final Color CONTENT_COLOR = new Color(0x9C98BB);
    final Color FONT_COLOR = new Color(0xDBD6E3);
    
    public StorePanel(int userType){
       
        this.setLayout(new BorderLayout(0,0));
        this.setBackground(Color.BLUE);

        JPanel buttonPanel = new JPanel();
        altProductBtn = new MyJButton("Alterar Produto",this,150,40);
        removeProductBtn = new MyJButton("Remover Produto",this,150,40);
        addProductBtn = new MyJButton("Adicionar Produto",this,150,40);
        addCartProductBtn = new MyJButton("Adicionar ao carrinho",this);

        buttonPanel.setBackground(MyJFrame.CONTENT_COLOR);
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setPreferredSize(new Dimension(200,800));
        
        if(userType == 2){
            buttonPanel.add(addProductBtn);
            buttonPanel.add(altProductBtn);
            buttonPanel.add(removeProductBtn);
            
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,100));  
        } else {
            buttonPanel.add(addCartProductBtn);
        }
        
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
            data[n][7] = product.getType();
            
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
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(860,600));
        
        JPanel newPanel = new JPanel();
        newPanel.add(scrollPane);
        newPanel.setBackground(MyJFrame.CONTENT_COLOR);
        newPanel.setLayout(new GridBagLayout());
        newPanel.setPreferredSize(new Dimension(1000,600));

        this.add(newPanel,BorderLayout.WEST);        
        this.add(buttonPanel, BorderLayout.EAST);

        this.setVisible(true);

        
    }

    @Override
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == addProductBtn){
            productController.addProduct();
        }
    }
}
