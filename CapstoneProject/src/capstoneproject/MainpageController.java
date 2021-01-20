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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainpageController implements Initializable {
    @FXML
    private Label con1;
    
    @FXML
    private Button topsearch1but;

    @FXML
    private Button searchbutton;

    @FXML
    private ChoiceBox topsearchbox;

    @FXML
    private Label taisearchlab,topsearchlab;

    @FXML
    private Label taisearch3;

    @FXML
    private Label act3;

    @FXML
    private Label taisearch2;

    @FXML
    private Label act2;

    @FXML
    private Label taisearch1;

    @FXML
    private Label act1;

    @FXML
    private Label actlab;

    @FXML
    private Label titleconlab;

    @FXML
    private Label proflab;

    @FXML
    private ImageView pagetitle;

    @FXML
    private Label topsearch2;

    @FXML
    private Label topsearch1;

    @FXML
    private Label con2;

    @FXML
    private Label topsearch3;

    @FXML
    private Label con3;
    
    @FXML
    private Button logout;
    
    String user,ts1,ts2,ts3,tas1,tas2,tas3,topicpass;
    int views;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image image;
        try {
            searchbutton.setText("Search");
            image = new Image("Images/Title.png");
            pagetitle.setImage(image);
            user = Users.firstName;
            proflab.setText("Welcome, "+user);
            taisearchlab.setText("Interesting topics");
            actlab.setText("What your friends have been doing");
            act1.setText("Mozart recently taught Physics 101");
            act2.setText("Galileu recently learned about Astronomy");
            act3.setText("Trump recently learned about World Domination");
            titleconlab.setText("Connections similar to you");
            topsearchlab.setText("Most searched");
            con1.setText("Dogan Guven");
            con2.setText("John Smith");
            con3.setText("James Bond");
            topsearchbox.getItems().addAll("Today","Weekly","Monthly","Yearly","All Time");
            topsearchbox.setValue("Today");
            logout.setText("Logout");
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());            
        }
        try {

        String myDriver = "com.mysql.jdbc.Driver";

        String myUrl = "jdbc:mysql://localhost:3306/capstone";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");

        String topsearched = "select name from views order by views desc limit 3;";

            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(topsearched);
                rs.next();
                String ts1 = rs.getString("name"); 
                topsearch1.setText(ts1);
                rs.next();
                String ts2 = rs.getString("name"); 
                topsearch2.setText(ts2);
                rs.next();
                String ts3 = rs.getString("name"); 
                topsearch3.setText(ts3);               
                }
            
        String taisearched = "select name from views order by name desc limit 3;"  ; 
                
            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(taisearched);
                rs.next();
                String tas1 = rs.getString("name"); 
                taisearch1.setText(tas1);
                rs.next();
                String tas2 = rs.getString("name"); 
                taisearch2.setText(tas2);
                rs.next();
                String tas3 = rs.getString("name"); 
                taisearch3.setText(tas3);               
                }
            }
        
        catch (ClassNotFoundException | SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        
    }    
        public void changeScreentoTopSearch1(ActionEvent event) throws IOException{
            ts1 = topsearch1.getText();
            try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                
                String getViews = "select views from views where name = '"+ts1+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+ts1+"';";
                System.out.println(updateViews);
                
                try (Statement st = conn.createStatement()) {
                st.executeUpdate(updateViews);
                }   
            }
                catch (ClassNotFoundException | SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
                }
            
            topicpass = ts1;
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
        public void changeScreentoTopSearch2(ActionEvent event) throws IOException{
            ts2 = topsearch2.getText();
            try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                String getViews = "select views from views where name = '"+ts2+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+ts2+"';";
                System.out.println(updateViews);
                
                try (Statement st = conn.createStatement()) {
                st.executeUpdate(updateViews);
                }  
            }
                catch (ClassNotFoundException | SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
                }
            
            topicpass = ts2;
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
        public void changeScreentoTopSearch3(ActionEvent event) throws IOException{
            ts3 = topsearch3.getText();
            try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                
                String getViews = "select views from views where name = '"+ts3+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+ts3+"';";
                System.out.println(updateViews);
                
                try (Statement st = conn.createStatement()) {
                st.executeUpdate(updateViews);
                }   
            }
                catch (ClassNotFoundException | SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
                }
                        
            topicpass = ts3;
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
        public void changeScreentoTaiSearch1(ActionEvent event) throws IOException{
            tas1 = taisearch1.getText();
            try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                
                String getViews = "select views from views where name = '"+tas1+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+tas1+"';";
                System.out.println(updateViews);
                
                try (Statement st = conn.createStatement()) {
                st.executeUpdate(updateViews);
                }        
            }
                catch (ClassNotFoundException | SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
                }
                     
            topicpass = tas1;
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
        public void changeScreentoTaiSearch2(ActionEvent event) throws IOException{
            tas2 = taisearch2.getText();
            try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                
                String getViews = "select views from views where name = '"+tas2+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+tas2+"';";
                System.out.println(updateViews);
                
                try (Statement st = conn.createStatement()) {
                st.executeUpdate(updateViews);
                }     
            }
                catch (ClassNotFoundException | SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
                }
            
                        
            topicpass = tas2;
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
        public void changeScreentoTaiSearch3(ActionEvent event) throws IOException{
            tas3 = taisearch3.getText();
            try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                
                String getViews = "select views from views where name = '"+tas3+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+tas3+"';";
                System.out.println(updateViews);
                
                try (Statement st = conn.createStatement()) {
                st.executeUpdate(updateViews);
                } 
            }
                catch (ClassNotFoundException | SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
                }
                        
            topicpass = tas3;
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
        public void changeScreenButtonPushed(ActionEvent event) throws IOException{
        
            Parent pageViewParent = FXMLLoader.load(getClass().getResource("Search.fxml"));
            Scene pageViewScene = new Scene(pageViewParent);
        
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
            window.setScene(pageViewScene);
            window.show();
        }
        public void changeScreentoProf(ActionEvent event) throws IOException{
        
            Parent pageViewParent = FXMLLoader.load(getClass().getResource("Profile.fxml"));
            Scene pageViewScene = new Scene(pageViewParent);
        
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
            window.setScene(pageViewScene);
            window.show();
    }
        public void changeScreentologout(ActionEvent event) throws IOException{
        
            Parent pageViewParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene pageViewScene = new Scene(pageViewParent);
        
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
            window.setScene(pageViewScene);
            window.show();
    }
}