package capstoneproject;

import javafx.scene.image.Image;

public class Users {
    static String userName;
    static String passWord;
    static String firstName;
    static String lastName;
    static Image profPic;
    static String nationality;
    static String learnTeach;
    static String recAct1;
    static String recAct2;
    static String recAct3;
    static String email;

public Users (String userName, String passWord) {
    Users.userName = userName;
    Users.passWord = passWord;
}

public Users (String firstName){
    Users.firstName = firstName;
}
    
    
public Users (String firstName, String lastName, String nationality, String learnTeach, String email) {
    Users.firstName = firstName;
    Users.lastName = lastName;
    Users.nationality = nationality;
    Users.learnTeach = learnTeach;
    Users.email = email;
}
}