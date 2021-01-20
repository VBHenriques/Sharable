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


public class TopicController implements Initializable {

    @FXML
    private Button teachbutton;

    @FXML
    private Label numlearnlab;

    @FXML
    private Label preftofclasslab;

    @FXML
    private Label numteach;

    @FXML
    private Label estduration;

    @FXML
    private Label numlearn;

    @FXML
    private Label estdurlab;

    @FXML
    private Label descarea;

    @FXML
    private ImageView title;

    @FXML
    private Label preftofclass;

    @FXML
    private Button learnbutton;

    @FXML
    private Label numteachlab;
    
    @FXML
    private ImageView backImg;
    
    @FXML
    private Button backBut;
    
    @FXML
    private Label title2;
    
    String topicpass;
    
    public void initData(String topicpass) {
        title2.setText(topicpass);
    try {

        String myDriver = "com.mysql.jdbc.Driver";

        String myUrl = "jdbc:mysql://localhost:3306/capstone";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");

        String resultsearch = "select learners, teachers, description from topics where name = '"+title2.getText()+"';";
        System.out.println(resultsearch);

            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(resultsearch);
                rs.next();
                numlearn.setText(Integer.toString(rs.getInt("learners")));
                numteach.setText(Integer.toString(rs.getInt("teachers")));
                descarea.setText(rs.getString("description"));
        }
    }
        catch (ClassNotFoundException | SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        try {

        String myDriver = "com.mysql.jdbc.Driver";

        String myUrl = "jdbc:mysql://localhost:3306/capstone";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");

        String resultsearch = "select avg(duration), type from insttopicst where name = '"+title2.getText()+"' ;";
        System.out.println(resultsearch);

            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(resultsearch);
                rs.next();                
                estduration.setText(rs.getString("avg(duration)"));
                preftofclass.setText(rs.getString("type"));
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
            image = new Image("Images/Title.png");
            title.setImage(image);
            image2 = new Image("Images/Backarrow.png");
            backImg.setImage(image2);
            numlearnlab.setText("Number of Learners:");
            numteachlab.setText("Number of Teachers:");
            estdurlab.setText("Estimated duration(mins):");
            preftofclasslab.setText("Prefered type:");
            learnbutton.setText("Learn");
            teachbutton.setText("Teach");
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());   
        
    }    
    
}
    public void changeScreentoTeach(ActionEvent event) throws IOException{
        topicpass = title2.getText();    
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Teach.fxml"));
            Parent pageViewParent = loader.load();
            
            Scene pageViewScene = new Scene(pageViewParent);
            
            TeachController controller = loader.getController();
            controller.initData(topicpass);
            
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(pageViewScene);
        window.show();
        }
    public void changeScreentoLearn(ActionEvent event) throws IOException{
        topicpass = title2.getText();    
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Learn.fxml"));
            Parent pageViewParent = loader.load();
            
            Scene pageViewScene = new Scene(pageViewParent);
            
            LearnController controller = loader.getController();
            controller.initData(topicpass);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(pageViewScene);
        window.show();
        }
    public void changeScreenBack(ActionEvent event) throws IOException{
        
        Parent pageViewParent = FXMLLoader.load(getClass().getResource("Search.fxml"));
        Scene pageViewScene = new Scene(pageViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(pageViewScene);
        window.show();
        }


}
