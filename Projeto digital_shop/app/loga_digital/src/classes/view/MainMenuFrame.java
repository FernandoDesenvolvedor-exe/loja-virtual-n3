package classes.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class MainMenuFrame extends JFrame implements ActionListener{

    private JButton exitBtn;
    private JButton storeFrameBtn;    
    
    MainMenuFrame() {
        JFrame frame = new JFrame();    
        
        //Inicializa botões e adiciona os ouvintes de ações
        exitBtn = new JButton("Sair");
        exitBtn.addActionListener(this);

        storeFrameBtn = new JButton("Loja");
        storeFrameBtn.addActionListener(this);    

        frame.setSize(800,500);
        frame.setResizable(false);
        frame.setTitle("loja virtual");        
        frame.setBackground(new Color(0xBFE8F5));

        frame.setLayout(null);


        frame.add(exitBtn);
        frame.add(storeFrameBtn);
        
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == exitBtn) {

        } else if (evt.getSource() == storeFrameBtn) {

        }
    }


}
