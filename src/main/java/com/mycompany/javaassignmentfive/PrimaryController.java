package com.mycompany.javaassignmentfive;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

public class PrimaryController implements Initializable{

    @FXML
    private TextField courses;
    @FXML
    private TextField code;
    @FXML
    private TextField agrade;
    @FXML
    private TextField fgrade;
    @FXML
    private ComboBox<String> courselist;
    @FXML
    private ListView<String> datal;
    
    
    
    private String data="";
    BufferedReader in=null;
    BufferedWriter out=null;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
        abc();  
    }
    
    public void abc(){
        int x=1;
        courselist.getItems().clear();
        datal.getItems().clear();
        try {
            in = new BufferedReader(new FileReader("data.txt"));
            while((data=in.readLine())!=null){
                String[] a=data.split(",");
                if(x==3){
                    courselist.getItems().add(a[0]);
                    datal.getItems().add(a[0]+"\t\t"+a[1]+"\t\t"+a[2]);
                    x=1;
                }
                else{
                  datal.getItems().add(a[0]+"\t\t"+a[1]+"\t\t"+a[2]);
                  x++;  
                }
                
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        finally{
            try{
              in.close();
            }
            catch(IOException ae){
                
            }
        }
    }
    
    public void addign(ActionEvent ae){
        //adding course name to the combobox
        if(!courses.getText().equals("")){
            //courselist.getItems().add(courses.getText());
        
             data= courses.getText()+",quiz,"+code.getText()+"\n"+
                    courses.getText()+",Assignment,"+agrade.getText()+"\n"+
                     courses.getText()+",final,"+fgrade.getText()+"\n";
             
             try{
             out = new BufferedWriter(new FileWriter("data.txt",true));
                 out.write(data);
                 
                }
                catch(IOException e){
                    
                }
                finally{
                    try{
                        out.close();
                    }
                    catch(IOException e){
                        
                    }
                }
        }
        abc();
        courses.setText("");
        code.setText("");
        agrade.setText("");
        fgrade.setText(""); 
        data="";
    } 
    
    public void courseSelect(ActionEvent ae){
        String value=courselist.getValue();
        m(value);
    }
    
    public void m(String value){
        datal.getItems().clear();
        float total=0.0f;
        try {
            in = new BufferedReader(new FileReader("data.txt"));
            while((data=in.readLine())!=null){
                String[] a=data.split(",");
                if(a[0].equals(value)){
                    datal.getItems().add(a[0]+"\t\t"+a[1]+"\t\t"+a[2]);
                    total+=Float.parseFloat(a[2]);
                } 
            }
            datal.getItems().add("total\t\t"+String.valueOf(total));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        finally{
            try{
              in.close();
            }
            catch(IOException ae){
                
            }
        }
    }   
}
