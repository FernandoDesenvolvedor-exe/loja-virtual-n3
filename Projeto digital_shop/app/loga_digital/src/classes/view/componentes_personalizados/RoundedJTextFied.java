package view.componentes_personalizados;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Dimension;
import java.awt.Color;


public class RoundedJTextFied extends JTextField{
    final Dimension TEXT_FIELD_DIMENSION = new Dimension(250,35);
    final EmptyBorder TEXT_FIELD_BORDER = new EmptyBorder(5, 10, 5, 10);

    public RoundedJTextFied(String text){        
        this.setOpaque(false);
        this.setPreferredSize(this.TEXT_FIELD_DIMENSION);
        this.setBackground(Color.WHITE);
        this.setBorder(TEXT_FIELD_BORDER);       
        this.setText(text);
    }

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
}
