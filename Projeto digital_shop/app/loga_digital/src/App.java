import model.User;
import view.MainMenuFrame;

public class App {
    public static void main(String[] args) throws Exception {  
        User user = new User();

        user.setUserType(1);
        user.setUserName("Luis");
        
        @SuppressWarnings("unused")
        MainMenuFrame frame = new MainMenuFrame(user);
    }
}
