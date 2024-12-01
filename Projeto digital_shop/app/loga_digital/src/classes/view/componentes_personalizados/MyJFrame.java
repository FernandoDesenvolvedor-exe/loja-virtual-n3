package view.componentes_personalizados;

import javax.swing.JFrame;

import java.awt.Color;

public class MyJFrame extends JFrame{
    public static final Color MENU_COLOR = new Color(0x3C2961);
    public static final Color CONTENT_COLOR = new Color(0x9C98BB);
    public static final Color FONT_COLOR = new Color(0xDBD6E3);

    public MyJFrame(String title){
        // configuração do frame principal
        this.setSize(1200,800);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);        
        this.setTitle(title);
    }

    public MyJFrame(){
        // configuração do frame principal
        this.setSize(800,600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
}
