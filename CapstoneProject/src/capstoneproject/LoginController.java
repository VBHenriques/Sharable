package capstoneproject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LoginController implements Initializable {
   
    @FXML
    private Label Passwordlabel;

    @FXML
    private Label Frasesarea;

    @FXML
    private TextField Usernamefield;

    @FXML
    private PasswordField Passwordfield;

    @FXML
    private ImageView title;

    @FXML
    private Hyperlink Signuplink;

    @FXML
    private Label UsernameLabel;
    
    @FXML
    private Button Loginbut;
    
    @FXML
    private Label wrongpass;

    String UN,PW;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Image image;     
        try {
            image = new Image("Images/Title.png");
            title.setImage(image);
            Passwordlabel.setText("Password:");
            UsernameLabel.setText("Username:");
            Signuplink.setText("New to Shareable? Sign-up with this link");
            Loginbut.setText("Login");
            Frasesarea.setText("Where there is a will, there is a way. If there is a chance in a million that you can do something, anything, to keep what you want from ending, do it. Pry the door open or, if need be, wedge your foot in that door and keep it open.” —Pauline Kael");
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());            
        }
    }    
    public void changeScreenButtonPushed(ActionEvent event) throws IOException{
        
        UN = Usernamefield.getText();  
        PW = Passwordfield.getText();
        try {

        String myDriver = "com.mysql.jdbc.Driver";

        String myUrl = "jdbc:mysql://localhost:3306/capstone";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");

        String query = "select count(*) from users where username = '"+UN+"' and password = '"+PW+"';";

            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(query);
                rs.next();
                int PW1 = rs.getInt("count(*)");
                
                if (PW1>=1){
                    String query2 = "select firstname, lastname, nationality, lot, email from users where username = '"+UN+"';";
                    try (Statement st2 = conn.createStatement()){
                        ResultSet rs2 = st2.executeQuery(query2);
                        rs2.next();
                        String FN1 = rs2.getString("firstname");
                        String LN1 = rs2.getString("lastname");
                        String NAT = rs2.getString("nationality");
                        String LOT = rs2.getString("lot");
                        String email = rs2.getString("email");
                        Users loginuser = new Users(FN1,LN1,NAT,LOT,email);
                    }
                    
                    Parent pageViewParent = FXMLLoader.load(getClass().getResource("Mainpage.fxml"));
                    Scene pageViewScene = new Scene(pageViewParent);
        
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                    window.setScene(pageViewScene);
                    window.show();
                }     
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        
        wrongpass.setText("Wrong username or password");

    }   
    public void changeScreenButtonPushed2(ActionEvent event) throws IOException{
        
        Parent pageViewParent = FXMLLoader.load(getClass().getResource("CreateProf.fxml"));
        Scene pageViewScene = new Scene(pageViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(pageViewScene);
        window.show();
        }
}