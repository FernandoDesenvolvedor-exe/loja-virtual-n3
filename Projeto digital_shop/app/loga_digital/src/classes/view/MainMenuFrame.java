package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

import model.User;
import view.componentes_personalizados.MainMenuBtnConstraints;
import view.componentes_personalizados.MyJButton;
import view.componentes_personalizados.MyJFrame;
import view.componentes_personalizados.MyMenuJButton;

public class MainMenuFrame extends MyJFrame implements ActionListener{
    final Color MENU_COLOR = new Color(0x3C2961);
    final Color CONTENT_COLOR = new Color(0x9C98BB);
    final Color FONT_COLOR = new Color(0xDBD6E3);
    boolean exit = false;

    User user;

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

    public MainMenuFrame(User user) {
        super("loja virtual");
        this.user = user;

        // Inicializa componentes        
        dialog = new JDialog();        
        JPanel menuPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();
        JPanel logoutButtonPanel = new JPanel();
        container = new Container();
        cardLayout = new CardLayout();
        StorePanel storePanel = new StorePanel(user.getUserType());
        
        buttonsPanel.add(buttonsPanel);
        buttonsPanel.add(storePanelBtn);
        buttonsPanel.add(cartFrameBtn);
        menuPanel.add(logoutBtn);
        menuPanel.add(logoutButtonPanel); 
        container.add(storePanel);
        this.add(menuPanel, BorderLayout.NORTH);
        this.add(container, BorderLayout.SOUTH);
        this.setVisible(true);

        if(user.getUserType() == 2) cartFrameBtn.setVisible(false);

        //layout
       // LayoutManager layout = new GridBagLayout();

        dialog.setBounds(0, 0,300,200);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                
        //paineis -menu 

        menuPanel.setBackground(MENU_COLOR);
        menuPanel.setLayout(new FlowLayout(FlowLayout.LEFT,1,0));
    
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
            storePanelBtn.setSelectedButton(false, storeIconLight);
            cartFrameBtn.setSelectedButton(false, cartIconLight);
            logoutBtn.setSelectedButton(true, logoutIconDark);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        }
    }
}
