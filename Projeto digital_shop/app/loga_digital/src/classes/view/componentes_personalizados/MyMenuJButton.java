package view.componentes_personalizados;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyMenuJButton extends JButton{
    final Color MENU_COLOR = new Color(0x3C2961);
    final Color CONTENT_COLOR = new Color(0x9C98BB);
    final Color FONT_COLOR = new Color(0xDBD6E3);

    public MyMenuJButton(String text, ActionListener actionListener){
        this.setPreferredSize(new Dimension(200,50));
        this.setBackground(MENU_COLOR);
        this.setForeground(Color.WHITE);
        this.setFocusable(false);
        this.addActionListener(actionListener);
        this.setBorderPainted(false);
        this.setText(text);
    }

    public MyMenuJButton(String text){
        this.setPreferredSize(new Dimension(200,50));
        this.setBackground(MENU_COLOR);
        this.setForeground(Color.WHITE);
        this.setFocusable(false);
        this.setBorderPainted(false);
        this.setText(text);
    }

    public MyMenuJButton(String text, ImageIcon icon){
        this.setPreferredSize(new Dimension(200,50));
        this.setBackground(MENU_COLOR);
        this.setForeground(Color.WHITE);
        this.setFocusable(false);
        this.setBorderPainted(false);
        this.setIcon(icon);
    }

    public MyMenuJButton(ImageIcon icon){
        this.setPreferredSize(new Dimension(200,50));
        this.setBackground(MENU_COLOR);
        this.setForeground(Color.WHITE);
        this.setFocusable(false);
        this.setBorderPainted(false);
        this.setIcon(icon);
    }

    public MyMenuJButton(){
        this.setPreferredSize(new Dimension(200,50));
        this.setBackground(MENU_COLOR);
        this.setForeground(Color.WHITE);
        this.setFocusable(false);
        this.setBorderPainted(false);
    }

    public void setSelectedButton(Boolean on, ImageIcon newIcon){
        if(newIcon != null) this.setIcon(newIcon);

        if(on){
            this.setBackground(CONTENT_COLOR);
            this.setForeground(Color.BLACK);
            
        } else {
            this.setBackground(MENU_COLOR);
            this.setForeground(Color.WHITE);
            this.setFocusable(false);
        }
    }
}   
