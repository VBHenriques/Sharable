
package capstoneproject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class CreateProfController implements Initializable {
    
    @FXML
    private Button PP;

    @FXML
    private ChoiceBox Nat;

    @FXML
    private Label PPLab;

    @FXML
    private TextField LN;

    @FXML
    private Label UNlab;

    @FXML
    private PasswordField PW;

    @FXML
    private TextField FN;

    @FXML
    private Label NatLab;

    @FXML
    private Label LoTLab;

    @FXML
    private Label PWlab;

    @FXML
    private TextField UN;

    @FXML
    private Label FNlab;

    @FXML
    private Label LNlab;
    
    @FXML
    private Button Createbut;
    
    @FXML
    private ChoiceBox LoT;
       
    @FXML
    private ImageView title;
    
    @FXML
    private Label emaillab;
    
    @FXML
    private TextField email;

    String UN1, PW1, FN1, LN1, LoT1, Nat1,email1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            Image image;
            Nat.getItems().addAll("Not selected","Australia","Argentina","Brazil","Belgium","Canada","Denmark","Egypt","France","German","Mexico","Russia","Nigeria","Switzerland","Turkey");
            Nat.setValue("Not selected");
            LoT.getItems().addAll("Not selected","Teach","Learn");
            LoT.setValue("Not selected");
            image = new Image("Images/Title.png");
            title.setImage(image);
            UNlab.setText("Username:");
            PWlab.setText("Password:");
            FNlab.setText("First Name:");
            LNlab.setText("Last Name:");
            NatLab.setText("Nationality:");
            PPLab.setText("Profile Picture:");
            PP.setText("Upload");
            LoTLab.setText("Learn or Teach?");
            Createbut.setText("Create");
            emaillab.setText("Email:");
    }    
    public void changeScreenButtonPushed(ActionEvent event) throws IOException{
        UN1 = UN.getText();
        PW1 = PW.getText();
        FN1 = FN.getText();
        LN1 = LN.getText();
        LoT1 = (String) LoT.getValue();
        Nat1 = (String) Nat.getValue();
        email1 = email.getText();
        
        try {

        String myDriver = "com.mysql.jdbc.Driver";

        String myUrl = "jdbc:mysql://localhost:3306/capstone";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");

        String query = "insert into users (username, password, firstname, lastname, lot, nationality, email) " + "values ('"+UN1+"','"+PW1+"','"+FN1+"','"+LN1+"','"+LoT1+"','"+Nat1+"','"+email1+"');";
        System.out.println(query);

            try (Statement st = conn.createStatement()) {
                st.executeUpdate(query);
                   
            }
    }
        catch (ClassNotFoundException | SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
    }
        
        Parent pageViewParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene pageViewScene = new Scene(pageViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(pageViewScene);
        window.show();
        }
}
