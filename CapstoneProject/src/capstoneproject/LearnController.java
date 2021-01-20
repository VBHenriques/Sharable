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

public class LearnController implements Initializable {

    @FXML
    private ImageView backimg;
    
    @FXML
    private Button backbut;

    @FXML
    private Label title2;

    @FXML
    private ImageView title;

    @FXML
    private Button createbut;
    
    @FXML
    private Label typelab,datelab,timelab,durlab,profitlab;
    
    @FXML
    private Label type1,date1,time1,dur1,profit1;
    
    @FXML
    private Label type2,date2,time2,dur2,profit2;
    
    @FXML
    private Label type3,date3,time3,dur3,profit3;
    
    @FXML
    private Label type4,date4,time4,dur4,profit4;
    
    @FXML
    private Label type5,date5,time5,dur5,profit5;
    
    @FXML
    private Label type6,date6,time6,dur6,profit6;
    
    @FXML
    private Button v1,v2,v3,v4,v5,v6;
    
    String id1,id2,id3,id4,id5,id6;
    
    String topicpass,instpass;
    
    public void initData(String topicpass) {
        title2.setText(topicpass);
        try {

        String myDriver = "com.mysql.jdbc.Driver";

        String myUrl = "jdbc:mysql://localhost:3306/capstone";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");

        String resultsearch = "select id, type, date, time, duration, price from insttopicst where name = '"+title2.getText()+"' limit 6 ;";
        System.out.println(resultsearch);

            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(resultsearch);
                rs.next();
                id1= Integer.toString(rs.getInt("id"));
                type1.setText(rs.getString("type"));
                date1.setText(rs.getString("date"));
                time1.setText(rs.getString("time"));
                dur1.setText(rs.getString("duration"));
                profit1.setText(rs.getString("price"));
                rs.next();
                id2= Integer.toString(rs.getInt("id"));
                type2.setText(rs.getString("type"));
                date2.setText(rs.getString("date"));
                time2.setText(rs.getString("time"));
                dur2.setText(rs.getString("duration"));
                profit2.setText(rs.getString("price"));
                rs.next();
                id3= Integer.toString(rs.getInt("id"));
                type3.setText(rs.getString("type"));
                date3.setText(rs.getString("date"));
                time3.setText(rs.getString("time"));
                dur3.setText(rs.getString("duration"));
                profit3.setText(rs.getString("price"));
                rs.next();
                id4= Integer.toString(rs.getInt("id"));
                type4.setText(rs.getString("type"));
                date4.setText(rs.getString("date"));
                time4.setText(rs.getString("time"));
                dur4.setText(rs.getString("duration"));
                profit4.setText(rs.getString("price"));
                rs.next();
                id5= Integer.toString(rs.getInt("id"));
                type5.setText(rs.getString("type"));
                date5.setText(rs.getString("date"));
                time5.setText(rs.getString("time"));
                dur5.setText(rs.getString("duration"));
                profit5.setText(rs.getString("price"));
                rs.next();
                id6= Integer.toString(rs.getInt("id"));
                type6.setText(rs.getString("type"));
                date6.setText(rs.getString("date"));
                time6.setText(rs.getString("time"));
                dur6.setText(rs.getString("duration"));
                profit6.setText(rs.getString("price"));    
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
            backimg.setImage(image2);
            createbut.setText("Create");
        }
        
        catch (Exception e) {
            System.out.println(e.getMessage());   
        
        }
    }
    public void changeScreentoView1(ActionEvent event) throws IOException{
        instpass = id1;
               
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Instlearn.fxml"));
            Parent pageViewParent = loader.load();
            
            Scene pageViewScene = new Scene(pageViewParent);
            
            InstlearnController controller = loader.getController();
            controller.initData(instpass);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(pageViewScene);
        window.show();
        } 
    public void changeScreentoView2(ActionEvent event) throws IOException{
        instpass = id2;
               
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Instlearn.fxml"));
            Parent pageViewParent = loader.load();
            
            Scene pageViewScene = new Scene(pageViewParent);
            
            InstlearnController controller = loader.getController();
            controller.initData(instpass);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(pageViewScene);
        window.show();
        } 
    public void changeScreentoView3(ActionEvent event) throws IOException{
        instpass = id3;
               
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Instlearn.fxml"));
            Parent pageViewParent = loader.load();
            
            Scene pageViewScene = new Scene(pageViewParent);
            
            InstlearnController controller = loader.getController();
            controller.initData(instpass);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(pageViewScene);
        window.show();
        } 
    public void changeScreentoView4(ActionEvent event) throws IOException{
        instpass = id4;
               
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Instlearn.fxml"));
            Parent pageViewParent = loader.load();
            
            Scene pageViewScene = new Scene(pageViewParent);
            
            InstlearnController controller = loader.getController();
            controller.initData(instpass);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(pageViewScene);
        window.show();
        } 
    public void changeScreentoView5(ActionEvent event) throws IOException{
        instpass = id5;
               
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Instlearn.fxml"));
            Parent pageViewParent = loader.load();
            
            Scene pageViewScene = new Scene(pageViewParent);
            
            InstlearnController controller = loader.getController();
            controller.initData(instpass);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(pageViewScene);
        window.show();
        } 
    public void changeScreentoView6(ActionEvent event) throws IOException{
        instpass = id6;
               
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Instlearn.fxml"));
            Parent pageViewParent = loader.load();
            
            Scene pageViewScene = new Scene(pageViewParent);
            
            InstlearnController controller = loader.getController();
            controller.initData(instpass);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(pageViewScene);
        window.show();
        }
    public void changeScreenback(ActionEvent event) throws IOException{
        topicpass = title2.getText();    
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Topic.fxml"));
            Parent pageViewParent = loader.load();
            
            Scene pageViewScene = new Scene(pageViewParent);
            
            TopicController controller = loader.getController();
            controller.initData(topicpass);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(pageViewScene);
        window.show();
    }
    
    public void changeScreentoCreate(ActionEvent event) throws IOException{
        topicpass = title2.getText();    
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Cinstlearn.fxml"));
            Parent pageViewParent = loader.load();
            
            Scene pageViewScene = new Scene(pageViewParent);
            
            CinstlearnController controller = loader.getController();
            controller.initData(topicpass);
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