import model.User;
import view.MainMenuFrame;

public class App {
    public static void main(String[] args) throws Exception {  
        User user = new User();

        user.setUserType(2);
        user.setUserName("Luis");
        
        MainMenuFrame frame = new MainMenuFrame(user);
    }
}
