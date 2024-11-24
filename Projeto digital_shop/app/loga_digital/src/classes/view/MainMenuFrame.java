package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.User;

public class MainMenuFrame extends JFrame {
    final Color MENU_COLOR = new Color(0x3C2961);
    final Color CONTENT_COLOR = new Color(0x9C98BB);
    final Color FONT_COLOR = new Color(0xDBD6E3);
    boolean exit = false;

    User user;

    JButton logoutBtn = new JButton();
    JButton storeFrameBtn = new JButton();   
    JButton cartFrameBtn = new JButton();

    Components width = Components.BTNW;
    Components height = Components.BTNH; 
    Container container;
    CardLayout cardLayout;

    GridBagConstraints constraintBtnStore = new GridBagConstraints();
    GridBagConstraints constraintBtnCart = new GridBagConstraints();
    GridBagConstraints constraintBtnLogout = new GridBagConstraints();

    ImageIcon cartIconDark = new ImageIcon(ImgIcon.CART_DARK.img());
    ImageIcon cartIconLight = new ImageIcon(ImgIcon.CART_LIGHT.img());
    ImageIcon storeIconDark = new ImageIcon(ImgIcon.STORE_DARK.img());
    ImageIcon storeIconLight = new ImageIcon(ImgIcon.STORE_LIGHT.img());
    ImageIcon logoutIconDark = new ImageIcon(ImgIcon.LOGOUT_DARK.img());
    ImageIcon logoutIconLight = new ImageIcon(ImgIcon.LOGOUT_LIGHT.img());
    
    JPanel menuPanel;

    public MainMenuFrame(User user) {
        this.user = user;

        // configuração do frame principal
        this.setSize(800,600);
        this.setResizable(false);
        this.setTitle("loja virtual");        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //layout
        LayoutManager layout = new GridBagLayout();

        //
        JDialog dialog = new JDialog();
        dialog.setBounds(0, 0,300,200);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                
        //paineis -menu 
        menuPanel = new JPanel();
        menuPanel.setBackground(MENU_COLOR);
        menuPanel.setBounds(0,0,100,this.getHeight());
        menuPanel.setLayout(layout);      
    
        //paineis - conteudo
        container = new Container();
        cardLayout = new CardLayout();        
        container.setLayout(cardLayout);

        StoreCardPanel storeFrame = new StoreCardPanel(user.getUserType());
        storeFrame.setBounds(container.getBounds());  
        container.add(storeFrame);       
        cardLayout.first(container);
        
        
        //selectedPanel.setLayout(new CardLayout());       
        //selectedPanel.add(storeFrame);
        

        //Botoes - Loja
        storeFrameBtn.setIcon(storeIconDark);
        storeFrameBtn.setBackground(CONTENT_COLOR);
        storeFrameBtn.setForeground(Color.BLACK);
        storeFrameBtn.setFocusable(false);
        storeFrameBtn.setBorderPainted(false);
        storeFrameBtn.setText("Loja");
        constraintBtnStore.fill = GridBagConstraints.BOTH;
        constraintBtnStore.weighty = 0.1;
        constraintBtnStore.gridy = 0;
        constraintBtnStore.gridx = 0;

        storeFrameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //Botoes - Loja
                storeFrameBtn.setIcon(storeIconDark);
                storeFrameBtn.setBackground(CONTENT_COLOR);
                storeFrameBtn.setForeground(Color.BLACK);

                //Botoes - carrinho
                if(user.getUserType() == 2){          
                    cartFrameBtn.setIcon(cartIconLight);
                    cartFrameBtn.setBackground(MENU_COLOR);
                    cartFrameBtn.setForeground(FONT_COLOR);
                }                 
                
                //Botoes - logout
                logoutBtn.setIcon(logoutIconLight);
                logoutBtn.setBackground(MENU_COLOR);
                logoutBtn.setForeground(FONT_COLOR);
            }
        });
        
        //Botoes - carrinho
        if(user.getUserType() == 2){          
            cartFrameBtn.setIcon(cartIconLight);
            cartFrameBtn.setBackground(MENU_COLOR);
            cartFrameBtn.setForeground(FONT_COLOR);
            cartFrameBtn.setFocusable(false);
            cartFrameBtn.setBorderPainted(false);
            cartFrameBtn.setText("Carrinho");            
            constraintBtnCart.fill = GridBagConstraints.BOTH;
            constraintBtnCart.weighty = 0.1;
            constraintBtnCart.gridy = 1;
            constraintBtnCart.gridx = 0;

            cartFrameBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt){   
                    //Botoes - Loja
                    storeFrameBtn.setIcon(storeIconLight);
                    storeFrameBtn.setBackground(MENU_COLOR);
                    storeFrameBtn.setForeground(FONT_COLOR);

                    //Botoes - Carrinho
                    cartFrameBtn.setIcon(cartIconDark);
                    cartFrameBtn.setBackground(CONTENT_COLOR);
                    cartFrameBtn.setForeground(Color.black);

                    //Botoes - logout
                    logoutBtn.setIcon(logoutIconLight);
                    logoutBtn.setBackground(MENU_COLOR);
                    logoutBtn.setForeground(FONT_COLOR);                    
                }
            });
        }         
        
        //Botoes - logout             
        logoutBtn.setIcon(logoutIconLight);
        logoutBtn.setBackground(MENU_COLOR);
        logoutBtn.setForeground(FONT_COLOR);
        logoutBtn.setFocusable(false);
        logoutBtn.setBorderPainted(false);
        logoutBtn.setText("Sair");          
        constraintBtnLogout.fill = GridBagConstraints.BOTH;
        constraintBtnLogout.weighty = 0.01;
        constraintBtnLogout.gridy = 2;
        constraintBtnLogout.gridx = 0;
        
        

        logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //Botoes - Loja
                storeFrameBtn.setIcon(storeIconLight);
                storeFrameBtn.setBackground(MENU_COLOR);
                storeFrameBtn.setForeground(FONT_COLOR);

                //Botoes - carrinho
                if(user.getUserType() == 2){          
                    cartFrameBtn.setIcon(cartIconLight);
                    cartFrameBtn.setBackground(MENU_COLOR);
                    cartFrameBtn.setForeground(FONT_COLOR);
                }
                
                logoutBtn.setIcon(logoutIconDark);
                logoutBtn.setBackground(CONTENT_COLOR);
                logoutBtn.setForeground(Color.black);

                exit = true;                              
            }
        });

        menuPanel.add(storeFrameBtn,constraintBtnStore);  
        if(user.getUserType() == 2)menuPanel.add(cartFrameBtn,constraintBtnCart);
        menuPanel.add(logoutBtn,constraintBtnLogout);  
        
        if(exit){
            this.add(dialog);
            dialog.setVisible(true);
        }
        this.add(menuPanel,BorderLayout.LINE_START);
        this.add(container);

        this.setVisible(true);
    }
}
