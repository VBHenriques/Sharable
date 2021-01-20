package capstoneproject;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Topics {
    static SimpleStringProperty name;
    static SimpleStringProperty type;
    static SimpleStringProperty dur;
    static SimpleIntegerProperty learners;
    static SimpleIntegerProperty teachers;
    static SimpleStringProperty teacher;
    static SimpleStringProperty cost;
    static String date;
    static String time;
    static String desc;
    static int views;
    static String topicname;
    
public Topics(){
    
}    
    
public Topics (String topicname){
    this.topicname = topicname;
}

public Topics (String name, String type, String dur, Integer learners, Integer teachers){
    Topics.name = new SimpleStringProperty(name);
    Topics.type = new SimpleStringProperty(type);
    Topics.dur = new SimpleStringProperty(dur);
    Topics.learners = new SimpleIntegerProperty(learners);
    Topics.teachers = new SimpleIntegerProperty(teachers);
}    

public Topics (String teacher, String dur, String cost, String type){
    Topics.teacher = new SimpleStringProperty(teacher);
    Topics.dur = new SimpleStringProperty(dur);
    Topics.cost = new SimpleStringProperty(cost);
    Topics.type = new SimpleStringProperty(type);
}

public String getName(){
    return name.get();
}

public void setName(String name){
    Topics.name = new SimpleStringProperty(name);
}

public String getTeacher(){
    return teacher.get();
}

public void setTeacher(String teacher){
    Topics.teacher = new SimpleStringProperty(teacher);
}

public String getCost(){
    return cost.get();
}

public void setCost(String cost){
    Topics.cost = new SimpleStringProperty(cost);
}
public String getType(){
    return type.get();
}

public void setType(String type){
    Topics.type = new SimpleStringProperty(type);
}
public String getDur(){
    return dur.get();
}

public void setDur(String dur){
    Topics.dur = new SimpleStringProperty(dur);
}
public int getLearners(){
    return learners.get();
}

public void setLearners(int learners){
    Topics.learners = new SimpleIntegerProperty(learners);
}
public int getTeachers(){
    return teachers.get();
}

public void setTeachers(int teachers){
    Topics.teachers = new SimpleIntegerProperty(teachers);
}
}
