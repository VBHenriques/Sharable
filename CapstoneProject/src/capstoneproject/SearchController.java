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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SearchController implements Initializable {
    @FXML
    private Label topsearchedlabel;

    @FXML
    private TextField searchfield;

    @FXML
    private Label tailoredtopicslab;

    @FXML
    private Label ts2;

    @FXML
    private Label ts1;

    @FXML
    private Label ts4;

    @FXML
    private Label ts3;

    @FXML
    private Label ts5;

    @FXML
    private Label tas4;

    @FXML
    private Label tas5;

    @FXML
    private Label tas2;

    @FXML
    private Label tas3;

    @FXML
    private Label tas1;

    @FXML
    private ChoiceBox searchbox;
    
    @FXML
    private Button Searchbut;
    
    @FXML
    private ImageView title;
    
    @FXML
    private ImageView back;
    
    @FXML
    private Button back2;
    
    @FXML
    private Button createtop;
    
    @FXML
    private Button tasbut5;

    @FXML
    private Button tasbut4;

    @FXML
    private Button tasbut3;

    @FXML
    private Button tsbut3;

    @FXML
    private Button tsbut2;

    @FXML
    private Button tsbut5;

    @FXML
    private Button tsbut4;
    
    @FXML
    private Button tasbut2;

    @FXML
    private Button tasbut1;

    @FXML
    private Button tsbut1;
        
    String user,tops1,tops2,tops3,tops4,tops5,tais1,tais2,tais3,tais4,tais5,topicpass,sename,namepass;
    int views;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image image;
        Image image2;
        try {
            image = new Image("Images/Title.png");
            title.setImage(image);
            image2 = new Image("Images/Backarrow.png");
            back.setImage(image2);
            topsearchedlabel.setText("Top Searches");
            tailoredtopicslab.setText("Topics that interest you");
            Searchbut.setText("Search");
            createtop.setText("Create");
            searchbox.getItems().addAll("Today","Weekly","Monthly","Yearly","All Time");
            searchbox.setValue("Today");
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());            
        }
        try {

        String myDriver = "com.mysql.jdbc.Driver";

        String myUrl = "jdbc:mysql://localhost:3306/capstone";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");

        String topsearched = "select name from views order by views desc limit 5;";

            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(topsearched);
                rs.next();
                String tops1 = rs.getString("name"); 
                ts1.setText(tops1);
                rs.next();
                String tops2 = rs.getString("name"); 
                ts2.setText(tops2);
                rs.next();
                String tops3 = rs.getString("name"); 
                ts3.setText(tops3);                             
                rs.next();
                String tops4 = rs.getString("name"); 
                ts4.setText(tops4);    
                rs.next();
                String tops5 = rs.getString("name"); 
                ts5.setText(tops5);               
                }
            
        String taisearched = "select name from views order by name desc limit 5;"  ; 
                
            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(taisearched);
                rs.next();
                String tais1 = rs.getString("name"); 
                tas1.setText(tais1);
                rs.next();
                String tais2 = rs.getString("name"); 
                tas2.setText(tais2);
                rs.next();
                String tais3 = rs.getString("name"); 
                tas3.setText(tais3);
                rs.next();
                String tais4 = rs.getString("name"); 
                tas4.setText(tais4);
                rs.next();
                String tais5 = rs.getString("name"); 
                tas5.setText(tais5);               
                }
            }
        
        catch (ClassNotFoundException | SQLException e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }    
    
    public void changeScreentoTopSearch1(ActionEvent event) throws IOException{
            tops1 = ts1.getText();
            topicpass = tops1;
            try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                
                String getViews = "select views from views where name = '"+tops1+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+tops1+"';";
                System.out.println(updateViews);
                
                try (Statement st = conn.createStatement()) {
                st.executeUpdate(updateViews);
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
            controller.initData(topicpass);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
            window.setScene(pageViewScene);
            window.show();
        } 
    public void changeScreentoTopSearch2(ActionEvent event) throws IOException{
            tops2 = ts2.getText();
            topicpass = tops2;
            try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                
                String getViews = "select views from views where name = '"+tops2+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+tops2+"';";
                System.out.println(updateViews);
                
                try (Statement st = conn.createStatement()) {
                st.executeUpdate(updateViews);
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
            controller.initData(topicpass);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
            window.setScene(pageViewScene);
            window.show();
        }
    public void changeScreentoTopSearch3(ActionEvent event) throws IOException{
            tops3 = ts3.getText();
            topicpass = tops3;
            try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                
                String getViews = "select views from views where name = '"+tops3+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+tops3+"';";
                System.out.println(updateViews);
                
                try (Statement st = conn.createStatement()) {
                st.executeUpdate(updateViews);
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
            controller.initData(topicpass);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
            window.setScene(pageViewScene);
            window.show();
        }
    public void changeScreentoTopSearch4(ActionEvent event) throws IOException{
            tops4 = ts4.getText();
            topicpass = tops4;
            try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                
                String getViews = "select views from views where name = '"+tops4+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+tops4+"';";
                System.out.println(updateViews);
                
                try (Statement st = conn.createStatement()) {
                st.executeUpdate(updateViews);
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
            controller.initData(topicpass);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
            window.setScene(pageViewScene);
            window.show();
        }
    public void changeScreentoTopSearch5(ActionEvent event) throws IOException{
            tops5 = ts5.getText();
            topicpass = tops5;
            try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                
                String getViews = "select views from views where name = '"+tops5+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+tops5+"';";
                System.out.println(updateViews);
                
                try (Statement st = conn.createStatement()) {
                st.executeUpdate(updateViews);
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
            controller.initData(topicpass);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
            window.setScene(pageViewScene);
            window.show();
        }
    public void changeScreentoTaioloredSearch1(ActionEvent event) throws IOException{
            tais1 = tas1.getText();
            topicpass = tais1;
            try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                
                String getViews = "select views from views where name = '"+tais1+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+tais1+"';";
                System.out.println(updateViews);
                
                try (Statement st = conn.createStatement()) {
                st.executeUpdate(updateViews);
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
            controller.initData(topicpass);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
            window.setScene(pageViewScene);
            window.show();
        }
    public void changeScreentoTaioloredSearch2(ActionEvent event) throws IOException{
            tais2 = tas2.getText();
            topicpass = tais2;
            try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                
                String getViews = "select views from views where name = '"+tais2+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+tais2+"';";
                System.out.println(updateViews);
                
                try (Statement st = conn.createStatement()) {
                st.executeUpdate(updateViews);
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
            controller.initData(topicpass);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
            window.setScene(pageViewScene);
            window.show();
        }
    public void changeScreentoTaioloredSearch3(ActionEvent event) throws IOException{
            tais3 = tas3.getText();
            topicpass = tais3;
            try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                
                String getViews = "select views from views where name = '"+tais3+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+tais3+"';";
                System.out.println(updateViews);
                
                try (Statement st = conn.createStatement()) {
                st.executeUpdate(updateViews);
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
            controller.initData(topicpass);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
            window.setScene(pageViewScene);
            window.show();
        }
    public void changeScreentoTaioloredSearch4(ActionEvent event) throws IOException{
            tais4 = tas4.getText();
            topicpass = tais4;
            try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                
                String getViews = "select views from views where name = '"+tais4+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+tais4+"';";
                System.out.println(updateViews);
                
                try (Statement st = conn.createStatement()) {
                st.executeUpdate(updateViews);
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
            controller.initData(topicpass);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
            window.setScene(pageViewScene);
            window.show();
        }
    public void changeScreentoTaioloredSearch5(ActionEvent event) throws IOException{
            tais5 = tas5.getText();
            topicpass = tais5;
            try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                
                String getViews = "select views from views where name = '"+tais5+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+tais5+"';";
                System.out.println(updateViews);
                
                try (Statement st = conn.createStatement()) {
                st.executeUpdate(updateViews);
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
            controller.initData(topicpass);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
            window.setScene(pageViewScene);
            window.show();
        }
    public void changeScreenButtonPushed(ActionEvent event) throws IOException{
        sename = searchfield.getText();
        namepass = sename;
        
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Results.fxml"));
            Parent pageViewParent = loader.load();
            
            Scene pageViewScene = new Scene(pageViewParent);
            
            ResultsController controller = loader.getController();
            controller.initData(namepass);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(pageViewScene);
        window.show();
        }
    public void changeScreenButtonPushed2(ActionEvent event) throws IOException{
        
        Parent pageViewParent = FXMLLoader.load(getClass().getResource("Mainpage.fxml"));
        Scene pageViewScene = new Scene(pageViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(pageViewScene);
        window.show();
        }
    public void changeScreentoCreate(ActionEvent event) throws IOException{
        
        Parent pageViewParent = FXMLLoader.load(getClass().getResource("Ctopic.fxml"));
        Scene pageViewScene = new Scene(pageViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(pageViewScene);
        window.show();
        }
}