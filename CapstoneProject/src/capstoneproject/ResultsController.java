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

public class ResultsController implements Initializable {

    @FXML
    private ImageView title;

    
    @FXML
    private ImageView back;

    @FXML
    private Button back2;
    
    @FXML
    private Label namelab,typelab,durlab,learnerslab,teacherslab,searched;
    
    @FXML
    private Label name1,type1,dur1,teach1,learn1;
    
    @FXML
    private Label name2,type2,dur2,teach2,learn2;
        
    @FXML
    private Label name3,type3,dur3,teach3,learn3;
    
    @FXML
    private Label name4,type4,dur4,teach4,learn4;
    
    @FXML
    private Label name5,type5,dur5,teach5,learn5;
    
    @FXML
    private Label name6,type6,dur6,teach6,learn6;
    
    @FXML
    private Label name7,type7,dur7,teach7,learn7;
    
    @FXML
    private Button v1,v2,v3,v4,v5,v6,v7;
    
    String topicpass;
    int views;
    
    public void initData(String namepass) {
        searched.setText(namepass);
        
        try {

        String myDriver = "com.mysql.jdbc.Driver";

        String myUrl = "jdbc:mysql://localhost:3306/capstone";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");

        String resultsearch = "select name, learners, teachers from topics where name like '%"+searched.getText()+"%' limit 7 ;";
        System.out.println(resultsearch);
        System.out.println(searched);

            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(resultsearch);
                rs.next();
                name1.setText(rs.getString("name"));
                learn1.setText(Integer.toString(rs.getInt("learners")));
                teach1.setText(Integer.toString(rs.getInt("teachers")));
                rs.next();     
                name2.setText(rs.getString("name"));
                learn2.setText(Integer.toString(rs.getInt("learners")));
                teach2.setText(Integer.toString(rs.getInt("teachers")));     
                rs.next();     
                name3.setText(rs.getString("name"));
                learn3.setText(Integer.toString(rs.getInt("learners")));
                teach3.setText(Integer.toString(rs.getInt("teachers")));
                rs.next();     
                name4.setText(rs.getString("name"));
                learn4.setText(Integer.toString(rs.getInt("learners")));
                teach4.setText(Integer.toString(rs.getInt("teachers")));
                rs.next();     
                name5.setText(rs.getString("name"));
                learn5.setText(Integer.toString(rs.getInt("learners")));
                teach5.setText(Integer.toString(rs.getInt("teachers")));
                rs.next();     
                name6.setText(rs.getString("name"));
                learn6.setText(Integer.toString(rs.getInt("learners")));
                teach6.setText(Integer.toString(rs.getInt("teachers")));
                rs.next();     
                name7.setText(rs.getString("name"));
                learn7.setText(Integer.toString(rs.getInt("learners")));
                teach7.setText(Integer.toString(rs.getInt("teachers")));     
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
        
            String resultsearch = "select avg(duration), type from insttopicst where name = '"+name1.getText()+"';";
            System.out.println(resultsearch);

            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(resultsearch);
                rs.next();
                dur1.setText(rs.getString("avg(duration)"));
                type1.setText(rs.getString("type"));
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
        
            String resultsearch = "select avg(duration), type from insttopicst where name = '"+name2.getText()+"';";
            System.out.println(resultsearch);

            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(resultsearch);
                rs.next();
                dur2.setText(rs.getString("avg(duration)"));
                type2.setText(rs.getString("type"));
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
        
            String resultsearch = "select avg(duration), type from insttopicst where name = '"+name3.getText()+"';";
            System.out.println(resultsearch);

            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(resultsearch);
                rs.next();
                dur3.setText(rs.getString("avg(duration)"));
                type3.setText(rs.getString("type"));
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
        
            String resultsearch = "select avg(duration), type from insttopicst where name = '"+name4.getText()+"';";
            System.out.println(resultsearch);

            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(resultsearch);
                rs.next();
                dur4.setText(rs.getString("avg(duration)"));
                type4.setText(rs.getString("type"));
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
        
            String resultsearch = "select avg(duration), type from insttopicst where name = '"+name5.getText()+"';";
            System.out.println(resultsearch);

            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(resultsearch);
                rs.next();
                dur5.setText(rs.getString("avg(duration)"));
                type5.setText(rs.getString("type"));
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
        
            String resultsearch = "select avg(duration), type from insttopicst where name = '"+name6.getText()+"';";
            System.out.println(resultsearch);

            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(resultsearch);
                rs.next();
                dur6.setText(rs.getString("avg(duration)"));
                type6.setText(rs.getString("type"));
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
        
            String resultsearch = "select avg(duration), type from insttopicst where name = '"+name7.getText()+"';";
            System.out.println(resultsearch);

            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(resultsearch);
                rs.next();
                dur7.setText(rs.getString("avg(duration)"));
                type7.setText(rs.getString("type"));
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
            back.setImage(image2);
            namelab.setText("Name");
            typelab.setText("Type");
            durlab.setText("Duration");
            learnerslab.setText("Learners");
            teacherslab.setText("Teachers");
            v1.setText("View");
            v2.setText("View");
            v3.setText("View");
            v4.setText("View");
            v5.setText("View");
            v6.setText("View");
            v7.setText("View");
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());            
        }

    
    }
    
    public void changeScreentoView1(ActionEvent event) throws IOException{
        String top1 = name1.getText();
        topicpass = top1;
        
        try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                
                String getViews = "select views from views where name = '"+top1+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+top1+"';";
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
        public void changeScreentoView2(ActionEvent event) throws IOException{
        String top2 = name2.getText();
        topicpass = top2;
        
        try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                
                String getViews = "select views from views where name = '"+top2+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+top2+"';";
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
        public void changeScreentoView3(ActionEvent event) throws IOException{
        String top3 = name3.getText();
        topicpass = top3;
        
        try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                
                String getViews = "select views from views where name = '"+top3+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+top3+"';";
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
        public void changeScreentoView4(ActionEvent event) throws IOException{
        String top4 = name4.getText();
        topicpass = top4;
        
        try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                
                String getViews = "select views from views where name = '"+top4+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+top4+"';";
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
        public void changeScreentoView5(ActionEvent event) throws IOException{
        String top5 = name5.getText();
        topicpass = top5;
        
        try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                
                String getViews = "select views from views where name = '"+top5+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+top5+"';";
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
        public void changeScreentoView6(ActionEvent event) throws IOException{
        String top6 = name6.getText();
        topicpass = top6;
        
        try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                
                String getViews = "select views from views where name = '"+top6+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+top6+"';";
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
        public void changeScreentoView7(ActionEvent event) throws IOException{
        String top7 = name7.getText();
        topicpass = top7;
        
        try {

                String myDriver = "com.mysql.jdbc.Driver";

                String myUrl = "jdbc:mysql://localhost:3306/capstone";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");
                
                String getViews = "select views from views where name = '"+top7+"';";
                
                try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(getViews);
                rs.next();
                views = rs.getInt("views");
                }    
                String updateViews = "update views set views = "+(views+1)+" where name = '"+top7+"';";
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
        
        Parent pageViewParent = FXMLLoader.load(getClass().getResource("Search.fxml"));
        Scene pageViewScene = new Scene(pageViewParent);
        
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
