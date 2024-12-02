package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Product;
import view.componentes_personalizados.*;

public class AddProductFrame extends MyJFrame{   
    Product product = null;

    RoundedJTextFied jTxtFName;
    RoundedJTextFied jTxtFBrand;
    RoundedJTextFied jTxtFValue;
    RoundedJTextFied jTxtFQuantity;
    RoundedJTextFied jTxtFDiscount;
    MyJCheckBox jCkBoxDigital;
    MyJCheckBox jCheckBoxPhisic;

    JLabel jLblName;
    JLabel jLblFBrand;
    JLabel jLblFValue;
    JLabel jLblFQuantity;
    JLabel jLblFDiscount;
    JLabel jLblTipo;

    public AddProductFrame(){
        super("Adicionar produto");     

        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setVgap(20);
        flowLayout.setHgap(50);
        flowLayout.setAlignment(FlowLayout.CENTER);
        
        // configuração do frame principal
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(CONTENT_COLOR);
        this.setBackground(MyJFrame.CONTENT_COLOR);
        this.setPreferredSize(new Dimension(400,550));
        this.setLocationRelativeTo(null);
        this.setLayout(flowLayout);
        this.setVisible(true);

        jTxtFName = new RoundedJTextFied();
        jTxtFBrand = new RoundedJTextFied();
        jTxtFValue = new RoundedJTextFied();
        jTxtFDiscount = new RoundedJTextFied();
        jTxtFQuantity = new RoundedJTextFied();
        jCheckBoxPhisic = new MyJCheckBox("Produto digital");
        jCheckBoxPhisic.setBackground(CONTENT_COLOR);

        jCkBoxDigital = new MyJCheckBox("Produto Físico");
        jCkBoxDigital.setBackground(CONTENT_COLOR);
        
        jLblName = new JLabel("Nome:          ");
        jLblName.setPreferredSize(new Dimension(RoundedJTextFied.WIDTH,10));

        jLblFBrand = new JLabel("Marca:       ");
        jLblFBrand.setPreferredSize(new Dimension(RoundedJTextFied.WIDTH,10));

        jLblFValue = new JLabel("Valor:       ");
        jLblFValue.setPreferredSize(new Dimension(RoundedJTextFied.WIDTH,10));

        jLblFDiscount = new JLabel("Desconto (%, números inteiros)):");
        jLblFDiscount.setPreferredSize(new Dimension(RoundedJTextFied.WIDTH,10));

        jLblFQuantity = new JLabel("Quantidade em estoque:");
        jLblFQuantity.setPreferredSize(new Dimension(RoundedJTextFied.WIDTH,10));

        jLblTipo = new JLabel("Tipo de produto:");
        jLblTipo.setPreferredSize(new Dimension(RoundedJTextFied.WIDTH,10));

        JPanel nameBox = new JPanel();        
        nameBox.setLayout(new BoxLayout(nameBox, BoxLayout.Y_AXIS));
        nameBox.setBackground(this.getBackground());
        nameBox.add(jLblName);
        nameBox.add(Box.createVerticalStrut(5));
        nameBox.add(jTxtFName);

        JPanel brandBox = new JPanel();      
        brandBox.setLayout(new BoxLayout(brandBox, BoxLayout.Y_AXIS));
        brandBox.setBackground(this.getBackground());
        brandBox.add(jLblFBrand);
        brandBox.add(Box.createVerticalStrut(5));
        brandBox.add(jTxtFBrand);

        JPanel valueBox = new JPanel();      
        valueBox.setLayout(new BoxLayout(valueBox, BoxLayout.Y_AXIS));
        valueBox.setBackground(this.getBackground());
        valueBox.add(jLblFValue);
        valueBox.add(Box.createVerticalStrut(5));
        valueBox.add(jTxtFValue);

        JPanel discountBox = new JPanel(); 
        discountBox.setLayout(new BoxLayout(discountBox, BoxLayout.Y_AXIS));
        discountBox.setBackground(this.getBackground());
        discountBox.add(jLblFDiscount);
        discountBox.add(Box.createVerticalStrut(5));
        discountBox.add(jTxtFDiscount);

        JPanel quantityBox = new JPanel();
        quantityBox.setLayout(new BoxLayout(quantityBox, BoxLayout.Y_AXIS));
        quantityBox.setBackground(this.getBackground());
        quantityBox.add(jLblFQuantity);
        quantityBox.add(Box.createVerticalStrut(5));
        quantityBox.add(jTxtFQuantity);
        
        JPanel checkboxGroup = new JPanel();
        checkboxGroup.setLayout(new BoxLayout(checkboxGroup, BoxLayout.Y_AXIS));
        checkboxGroup.setBackground(this.getBackground());
        checkboxGroup.add(jCheckBoxPhisic);
        checkboxGroup.add(jCkBoxDigital);

        JPanel typeBox = new JPanel();
        typeBox.setLayout(new BoxLayout(typeBox, BoxLayout.X_AXIS));
        typeBox.setPreferredSize(new Dimension(300,50));
        typeBox.setBackground(this.getBackground());
        typeBox.add(jLblTipo);
        typeBox.add(Box.createHorizontalStrut(5));
        typeBox.add(checkboxGroup);

        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.X_AXIS));
        box.setAlignmentX(SwingConstants.CENTER);
        box.add(typeBox);

        this.add(nameBox);
        this.add(brandBox);
        this.add(valueBox);
        this.add(discountBox);
        this.add(quantityBox);
        this.add(typeBox);

        this.pack();        
    }    

    public Product getProduct(){
        String name = null;
        String brand = null;
        Double value = null;
        Integer discount = null;
        Integer quantity = null;
        Integer type = null;

        try {
            name = jTxtFName.getText().toString();
            brand = jTxtFBrand.getText().toString();
            value = Double.parseDouble(jTxtFValue.getText());
            discount = Integer.parseInt(jTxtFDiscount.getText());
            quantity = Integer.parseInt(jTxtFQuantity.getText());

            if(jCheckBoxPhisic.isSelected() && jCkBoxDigital.isSelected()){
                type = 3;
            } else if (jCheckBoxPhisic.isSelected() && !jCkBoxDigital.isSelected()){
                type = 2;
            } else {
                type = 1;
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if(name == null){
            throw new NullPointerException("nome nulo");
        }

        if(brand == null){
            throw new NullPointerException("marca nulo");
        }

        if(value == null){
            throw new NullPointerException("valor nulo");
        }

        if(discount == null){
            throw new NullPointerException("desconto nulo");
        }

        if(quantity == null){
            throw new NullPointerException("quantidade nulo");
        }

        if(type == null){
            throw new NullPointerException("nome nulo");
        }

        return new Product(null, name, brand, value, discount, quantity, type);
    }
}
