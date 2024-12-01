package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import view.componentes_personalizados.*;

public class AddProductFrame extends MyJFrame implements ActionListener{    
    JButton confBtn;
    JButton clBtn;

    RoundedJTextFied jTxtFName;
    RoundedJTextFied jTxtFBrand;
    RoundedJTextFied jTxtFValue;
    RoundedJTextFied jTxtFQuantity;
    RoundedJTextFied jTxtFDiscount;
    MyJCheckBox jCkBoxDigital;
    MyJCheckBox jCheckBoxPhisic;

    public AddProductFrame(){        
        super("Adicionar produto");
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setVgap(20);
        flowLayout.setHgap(50);
        flowLayout.setAlignment(FlowLayout.CENTER);
        
        // configuração do frame principal
        this.setBackground(MyJFrame.CONTENT_COLOR);
        this.setSize(400,800);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(flowLayout);
        this.getContentPane().setBackground(CONTENT_COLOR);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        jTxtFName = new RoundedJTextFied("Nome");
        jTxtFBrand = new RoundedJTextFied("Marca");
        jTxtFValue = new RoundedJTextFied("Valor");
        jCheckBoxPhisic = new MyJCheckBox("Digital");
        jCkBoxDigital = new MyJCheckBox("Físico");

        this.add(jTxtFName);
        this.add(jTxtFBrand);
        this.add(jTxtFValue);
        this.add(jCheckBoxPhisic);
        this.add(jCkBoxDigital);
    }

    @Override
    public void actionPerformed(ActionEvent evt){
        
    }
}
