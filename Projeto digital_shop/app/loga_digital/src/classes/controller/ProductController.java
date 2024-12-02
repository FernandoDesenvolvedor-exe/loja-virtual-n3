package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Product;
import model.Usuario;
import view.AddProductFrame;
import view.componentes_personalizados.MyJButton;

public class ProductController implements ActionListener {
    Product lastAddProduct;
    Usuario user;

    AddProductFrame addFrame;
    MyJButton saveBtn = new MyJButton("Salvar");
    MyJButton cancelBtn = new MyJButton("Cancelar");

    public void addProduct(){
        addFrame = new AddProductFrame();
        
        addFrame.add(saveBtn);
        addFrame.add(cancelBtn);
        
        saveBtn.addActionListener(this);
        cancelBtn.addActionListener(this);    

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == this.saveBtn){
            try{
                Product.register(addFrame.getProduct());
            }catch(NullPointerException e){
                e.printStackTrace();
            }            
        }

        if(evt.getSource() == cancelBtn){
            addFrame.dispose();
        }
    }
    
    /*public Product getLastAddProduct(){
        if(lastAddProduct == null){
            throw new NullPointerException();
        }
        return lastAddProduct;
    }*/
}
