/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javaassignmentfive;



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ashish
 */
public class ReadingData {
    BufferedReader in = null;
    String data=null;
    List<String> courses=new ArrayList<String>();
    List<String> wdata=new ArrayList<String>();
    public void readingData(){
        try{
            in = new BufferedReader(new FileReader("data.txt"));
            while((data=in.readLine())!=null){
               String[] s=data.split(",");
               courses.add(s[0]);
               wdata.add(s[0]+"\t"+s[1]+"\t"+s[2]);
               System.out.println(s[0]+"\t"+s[1]+"\t"+s[2]);
            }
        }
        catch(IOException e){
            System.out.println("one");
        }
        finally{
            try{
                in.close();
            }
            catch(IOException e){
                System.out.println("two");
            }
        }
        
    }
    
    public List<String> getCourses(){
        return courses;
    }
    
    public List<String> getWdata(){
        return wdata;
    }
}
