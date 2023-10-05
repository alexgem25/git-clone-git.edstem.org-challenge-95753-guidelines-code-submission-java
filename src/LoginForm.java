import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.application.*;
import javafx.scene.text.*;

public class LoginForm extends Application {
    public static void main(String[] args) { launch(args); }
    
    private Label userLbl;
    private TextField userTf;
    private Label passLbl;
    private PasswordField passField;
    private Button loginBtn;
    private Text result;

    @Override
    public void start(Stage stage) throws Exception {
        userLbl = new Label("Username:");
        userTf = new TextField();
        passLbl = new Label("Password:");
        passField = new PasswordField();
        loginBtn = new Button("Login");
        result = new Text();

        GridPane grid = new GridPane();
        grid.add(userLbl,0,0);
        grid.add(userTf,1,0);
        grid.add(passLbl,0,1);
        grid.add(passField,1,1);
        grid.add(loginBtn,1,2);
        grid.add(result,1,3);

        loginBtn.setOnAction(event -> setText(getUser(), getPass()));

        stage.setScene(new Scene(grid));
        stage.setTitle("Login");
        stage.show();
    }

    private String getUser(){
        return userTf.getText();
    }

    private String getPass(){
        return passField.getText();
    }

    private void setText(String username, String password){
        String validUser = "sam";
        String validPass = "mypassword";
        if (username.equals(validUser) && password.equals(validPass)){
            result.setText("Password correct!");
        }else{
            result.setText("Password incomplete!");
        }

    }

}
