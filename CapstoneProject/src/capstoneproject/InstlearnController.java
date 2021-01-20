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

public class InstlearnController implements Initializable {
    
     @FXML
    private Label date;

    @FXML
    private Label typeofclass;

    @FXML
    private ImageView titleimg;

    @FXML
    private Button homebut;

    @FXML
    private Label typeofclasslab;

    @FXML
    private Label durofclass;

    @FXML
    private Label title2;

    @FXML
    private Label timelab;

    @FXML
    private Label durofclasslab;

    @FXML
    private Label price;

    @FXML
    private Label desclab;

    @FXML
    private Label datelab;

    @FXML
    private Label time;

    @FXML
    private Button acceptbut;

    @FXML
    private Label pricelab;
    
    @FXML
    private Label descarea;
    
    
    String connect, connectpass;
    
    public void initData(String instpass) {
        String id = instpass;
        try {

        String myDriver = "com.mysql.jdbc.Driver";

        String myUrl = "jdbc:mysql://localhost:3306/capstone";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");

        String resultsearch = "select name, date, time, type, duration, price, description, teacher from insttopicst where id = '"+id+"';";
        System.out.println(resultsearch);

            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(resultsearch);
                rs.next();
                title2.setText(rs.getString("name")); 
                date.setText(rs.getString("date"));
                time.setText(rs.getString("time"));
                typeofclass.setText(rs.getString("type"));
                durofclass.setText(rs.getString("duration"));
                price.setText(rs.getString("price"));
                descarea.setText(rs.getString("description"));
                connect = rs.getString("teacher");
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
        
        try {
            image = new Image("Images/Title.png");
            titleimg.setImage(image);
            typeofclasslab.setText("Type of class:");
            datelab.setText("Date:");
            pricelab.setText("Price:");
            desclab.setText("Description:");
            timelab.setText("Time:");
            durofclasslab.setText("Duration(mins):");
            acceptbut.setText("Shareable?");
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());   
        
        } 
    }    
    
    public void changeScreentoConnect(ActionEvent event) throws IOException{
        connectpass = connect;
               
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Profile2.fxml"));
            Parent pageViewParent = loader.load();
            
            Scene pageViewScene = new Scene(pageViewParent);
            
            Profile2Controller controller = loader.getController();
            controller.initData(connectpass);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(pageViewScene);
        window.show();
    }
    public void changeScreenMain(ActionEvent event) throws IOException{
        
        Parent pageViewParent = FXMLLoader.load(getClass().getResource("Mainpage.fxml"));
        Scene pageViewScene = new Scene(pageViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(pageViewScene);
        window.show();
    }
}
