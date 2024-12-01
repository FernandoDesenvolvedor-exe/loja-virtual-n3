package view.componentes_personalizados;

import javax.swing.JCheckBox;

public class MyJCheckBox extends JCheckBox{
    public MyJCheckBox(String text){
        this.setFocusable(false);        
        this.setText(text);
    }
}
