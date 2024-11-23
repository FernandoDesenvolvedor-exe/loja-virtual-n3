package view;

public enum ImgIcon {    
    CART_DARK("Projeto digital_shop\\app\\loga_digital\\src\\assets\\icons\\carrinho.png"),
    CART_LIGHT("Projeto digital_shop\\app\\loga_digital\\src\\assets\\icons\\carrinho-branco.png"),
    STORE_DARK("Projeto digital_shop\\app\\loga_digital\\src\\assets\\icons\\loja.png"),
    STORE_LIGHT("Projeto digital_shop\\app\\loga_digital\\src\\assets\\icons\\loja-branco.png"),
    LOGOUT_DARK("Projeto digital_shop\\app\\loga_digital\\src\\assets\\icons\\logout.png"),
    LOGOUT_LIGHT("Projeto digital_shop\\app\\loga_digital\\src\\assets\\icons\\logout-branco.png"),
    DESCONTO("Projeto digital_shop\\app\\loga_digital\\src\\assets\\icons\\distintivo-de-desconto.png");

    final String path;

    ImgIcon(String img){
        this.path = img;
    }

    public String img(){
        return path;
    }
}
