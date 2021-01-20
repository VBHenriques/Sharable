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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
public class Profile2Controller implements Initializable {
    
    @FXML
    private Label Nationalitylab;

    @FXML
    private Label LorT;

    @FXML
    private ImageView prof_img;

    @FXML
    private Label nat;

    @FXML
    private Label recentactlab,emaillab,email;

    @FXML
    private Label recentact2;

    @FXML
    private Label Namelab;

    @FXML
    private Label LorTlab;

    @FXML
    private Label recentact1;

    @FXML
    private Label Name;

    @FXML
    private Label recentact3;
    
    @FXML
    private ImageView title;

    @FXML
    private Button mainbut;
    
    String connect,FN,LN;
    
    public void initData(String connectpass) {
        connect = connectpass;
        try {

        String myDriver = "com.mysql.jdbc.Driver";

        String myUrl = "jdbc:mysql://localhost:3306/capstone";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");

        String resultsearch = "select firstname, lastname, lot, nationality, email from users where email = '"+connect+"';";
        System.out.println(resultsearch);

            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(resultsearch);
                rs.next();
                FN = rs.getString("firstname");
                LN = rs.getString("lastname");
                Name.setText(FN+" "+LN);
                LorT.setText(rs.getString("lot"));
                nat.setText(rs.getString("nationality"));
                email.setText(rs.getString("email"));
                }
        }
        catch (ClassNotFoundException | SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image image;
        Image image2;
        try {
        image = new Image("Images/Profilepic.png");
        prof_img.setImage(image);    
        image2 = new Image("Images/Title.png");
        title.setImage(image2);
        Nationalitylab.setText("Nationality:");
        recentactlab.setText("Recent Activity");
        Name.setText(FN+" "+LN);
        Namelab.setText("Name:");
        LorTlab.setText("Learning/Teaching:");  
        emaillab.setText("Email:");
        recentact1.setText("Python");
        recentact2.setText("Trigonometry");
        recentact3.setText("Astrology");
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());            
        }
    }
    public void changeScreenMain(ActionEvent event) throws IOException{
        
        Parent pageViewParent = FXMLLoader.load(getClass().getResource("Mainpage.fxml"));
        Scene pageViewScene = new Scene(pageViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(pageViewScene);
        window.show();
    }    
    
}
