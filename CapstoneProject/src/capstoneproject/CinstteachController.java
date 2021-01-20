package capstoneproject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CinstteachController implements Initializable {
    
    @FXML
    private Label typeofclasslab;

    @FXML
    private ChoiceBox typeofclassbox;

    @FXML
    private ImageView title;

    @FXML
    private Button createbut;

    @FXML
    private Label timelab;

    @FXML
    private ChoiceBox timebox;

    @FXML
    private ImageView backimg;

    @FXML
    private ChoiceBox durofclassbox;

    @FXML
    private Label durofclasslab;

    @FXML
    private Label desclab;

    @FXML
    private TextField descarea;

    @FXML
    private Button backbut;

    @FXML
    private Label datelab;

    @FXML
    private DatePicker datebox;

    @FXML
    private ChoiceBox pricebox;

    @FXML
    private Label pricelab;

    @FXML
    private Label title2;
        
    String name,date,time,type,desc,dur,price,topicpass,emailofteach;
    int teachers;
    
    public void initData(String topicpass) {
        title2.setText(topicpass);
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
            typeofclasslab.setText("Type of class:");
            datelab.setText("Date:");
            pricelab.setText("Price:");
            desclab.setText("Change description?");
            timelab.setText("Time:");
            durofclasslab.setText("Duration(mins):");
            typeofclassbox.getItems().addAll("Not selected","One on one","One on five","One on x");
            typeofclassbox.setValue("Not selected");
            durofclassbox.getItems().addAll("Not selected","30","60","90","120");
            durofclassbox.setValue("Not selected");
            timebox.getItems().addAll("Not selected","8:00","8:30","9:00","9:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30");
            timebox.setValue("Not selected");
            pricebox.getItems().addAll("Not selected","1","2","3","4","5","6","7","8","9","10");
            pricebox.setValue("Not selected");
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());   
        
        }

    }
    public void changeScreenback(ActionEvent event) throws IOException{
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
    public void changeScreentocreate(ActionEvent event) throws IOException{
        name = title2.getText();
        date = datebox.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        time = (String) timebox.getValue();
        type = (String) typeofclassbox.getValue();
        dur = (String) durofclassbox.getValue();
        price = (String) pricebox.getValue();
        desc = descarea.getText();
        emailofteach = (Users.email);
        
        try {

            String myDriver = "com.mysql.jdbc.Driver";

            String myUrl = "jdbc:mysql://localhost:3306/capstone";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "Password123");

            String query = "insert into insttopicst (name, type, duration, price, date, time, description, teacher) " + "values ('"+name+"', '"+type+"', '"+dur+"', '"+price+"', '"+date+"', '"+time+"', '"+desc+"', '"+emailofteach+"');";
            System.out.println(query);

                try (Statement st = conn.createStatement()) {
                    st.executeUpdate(query);
                   
            }                           
            String getLearners = "select teachers from topics where name = '"+name+"';";
                
                try (Statement st = conn.createStatement()) {
                    ResultSet rs = st.executeQuery(getLearners);
                    rs.next();
                    teachers = rs.getInt("teachers");
                }
                
            String updateTeachers = "update topics set teachers = "+(teachers+1)+" where name = '"+name+"';";
            System.out.println(updateTeachers);
                
                try (Statement st = conn.createStatement()) {
                    st.executeUpdate(updateTeachers);
                }   
            }
                catch (ClassNotFoundException | SQLException e) {
                    System.err.println("Got an exception! ");
                    System.err.println(e.getMessage());
                }   
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Mainpage.fxml"));
            Parent pageViewParent = loader.load();
            
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