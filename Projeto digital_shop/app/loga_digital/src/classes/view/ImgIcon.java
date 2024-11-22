package view;

public enum ImgIcon {
    CART_DARK("loja-virtual-n3\\Projeto digital_shop\\app\\loga_digital\\src\\assets\\icons\\carrinho.png"),
    CART_LIGHT("loja-virtual-n3\\Projeto digital_shop\\app\\loga_digital\\src\\assets\\icons\\carrinho-branco.png"),
    STORE_DARK("loja-virtual-n3\\Projeto digital_shop\\app\\loga_digital\\src\\assets\\icons\\loja.png"),
    STORE_LIGHT("loja-virtual-n3\\Projeto digital_shop\\app\\loga_digital\\src\\assets\\icons\\loja-branco.png"),
    LOGOUT_DARK("loja-virtual-n3\\Projeto digital_shop\\app\\loga_digital\\src\\assets\\icons\\logout.png"),
    LOGOUT_LIGHT("loja-virtual-n3\\Projeto digital_shop\\app\\loga_digital\\src\\assets\\icons\\logout-branco.png");

    final String img_name;

    ImgIcon(String img){
        this.img_name = img;
    }

    public String img(){
        return img_name;
    }
}
