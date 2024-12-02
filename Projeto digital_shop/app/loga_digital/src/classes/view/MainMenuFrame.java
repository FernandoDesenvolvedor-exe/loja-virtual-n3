package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

import model.Usuario;
import view.componentes_personalizados.MyJFrame;
import view.componentes_personalizados.MyMenuJButton;

public class MainMenuFrame extends MyJFrame implements ActionListener{
    boolean exit = false;

    Usuario user;

    MyMenuJButton logoutBtn = new MyMenuJButton("Sair", this);
    MyMenuJButton storePanelBtn = new MyMenuJButton("Loja", this);
    MyMenuJButton cartFrameBtn = new MyMenuJButton("Carrinho", this);

    Components width = Components.BTNW;
    Components height = Components.BTNH; 
    Container container;
    CardLayout cardLayout;

    ImageIcon cartIconDark = new ImageIcon(ImgIcon.CART_DARK.img());
    ImageIcon cartIconLight = new ImageIcon(ImgIcon.CART_LIGHT.img());
    ImageIcon storeIconDark = new ImageIcon(ImgIcon.STORE_DARK.img());
    ImageIcon storeIconLight = new ImageIcon(ImgIcon.STORE_LIGHT.img());
    ImageIcon logoutIconDark = new ImageIcon(ImgIcon.LOGOUT_DARK.img());
    ImageIcon logoutIconLight = new ImageIcon(ImgIcon.LOGOUT_LIGHT.img());    

    JDialog dialog;

    public MainMenuFrame(Usuario user) {
        super("loja virtual");
        this.user = user;

        // Inicializa componentes        
        dialog = new JDialog();
        JPanel menuPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();
        JPanel logoutButtonPanel = new JPanel();
        container = new Container();
        cardLayout = new CardLayout();
        StorePanel storePanel = new StorePanel(user.getTipo());
        
        container.add(storePanel);

        this.add(menuPanel, BorderLayout.NORTH);
        this.add(container, BorderLayout.SOUTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        dialog.setBounds(0, 0,300,200);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setBackground(CONTENT_COLOR);

        buttonsPanel.add(storePanelBtn);
        if(user.getTipo() == 1) buttonsPanel.add(cartFrameBtn);
        buttonsPanel.setLayout(new FlowLayout(0,0,0));
        buttonsPanel.setBackground(MENU_COLOR);

        logoutButtonPanel.add(logoutBtn);
        logoutButtonPanel.setBackground(MENU_COLOR);
        logoutButtonPanel.setLayout(new FlowLayout(0,0,0));

        //paineis -menu 
        menuPanel.setBackground(MENU_COLOR);
        menuPanel.setLayout(new BorderLayout(0,0));
        menuPanel.add(buttonsPanel,BorderLayout.WEST);
        menuPanel.add(logoutButtonPanel,BorderLayout.EAST);
        //menuPanel.setLayout(new FlowLayout(FlowLayout.LEFT,1,0));
    
        //paineis - conteudo
        container.setPreferredSize(new Dimension(this.getWidth(), this.getHeight() - 50));
        container.setLayout(cardLayout);
        cardLayout.first(container);    

        //Botoes - Loja        
        storePanelBtn.setSelectedButton(true,storeIconDark);
        cartFrameBtn.setSelectedButton(false, cartIconLight);
        logoutBtn.setSelectedButton(false, logoutIconLight);
        
        this.pack();        
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == storePanelBtn){
            storePanelBtn.setSelectedButton(true, storeIconDark);
            cartFrameBtn.setSelectedButton(false, cartIconLight);
            logoutBtn.setSelectedButton(false, logoutIconLight);
        }

        if(evt.getSource() == cartFrameBtn){
            storePanelBtn.setSelectedButton(false, storeIconLight);
            cartFrameBtn.setSelectedButton(true, cartIconDark);
            logoutBtn.setSelectedButton(false, logoutIconLight);
        }

        if(evt.getSource() == logoutBtn){
            /*
            storePanelBtn.setSelectedButton(false, storeIconLight);
            cartFrameBtn.setSelectedButton(false, cartIconLight);
            logoutBtn.setSelectedButton(true, logoutIconDark);*/
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        }
    }
}
