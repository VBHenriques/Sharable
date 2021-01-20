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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CtopicController implements Initializable {
    @FXML
    private Label namelab;

    @FXML
    private ImageView backimg;

    @FXML
    private Button backbut;

    @FXML
    private TextField descarea;

    @FXML
    private TextField name;

    @FXML
    private ImageView title;

    @FXML
    private Label descarealab;

    @FXML
    private Button createbut;
    
    String N,D;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image image;
        Image image2;
        
        try {
            image = new Image("Images/Title.png");
            title.setImage(image);
            image2 = new Image("Images/Backarrow.png");
            backimg.setImage(image2);
            descarealab.setText("Description:");
            namelab.setText("Name:");
            createbut.setText("Create");
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());   
        
        }
    } 
    public void changeScreentoBack(ActionEvent event) throws IOException{
        
        Parent pageViewParent = FXMLLoader.load(getClass().getResource("Search.fxml"));
        Scene pageViewScene = new Scene(pageViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(pageViewScene);
        window.show();
        } 
    public void changeScreentoCreate(ActionEvent event) throws IOException{
        N = name.getText();
        D = descarea.getText();
        
        try {

        String myDriver = "com.mysql.jdbc.Driver";

        String myUrl = "jdbc:mysql://localhost:3306/capstone";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");

        String query = "insert into topics (name,learners,teachers,description) " + "values ('"+N+"',0,0,'"+D+"');";

            try (Statement st = conn.createStatement()) {
                st.executeUpdate(query);
                   
            }
        String query2 = "insert into views (name,views) " + "values ('"+N+"',0);";

            try (Statement st = conn.createStatement()) {
                st.executeUpdate(query2);
                   
            }    
    }
        catch (ClassNotFoundException | SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
    }    
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Topic.fxml"));
            Parent pageViewParent = loader.load();
            
            Scene pageViewScene = new Scene(pageViewParent);
            
            TopicController controller = loader.getController();
            controller.initData(N);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(pageViewScene);
        window.show();
        } 
    public void changeScreentoHome(ActionEvent event) throws IOException{
        
        Parent pageViewParent = FXMLLoader.load(getClass().getResource("Mainpage.fxml"));
        Scene pageViewScene = new Scene(pageViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(pageViewScene);
        window.show();
        }
}