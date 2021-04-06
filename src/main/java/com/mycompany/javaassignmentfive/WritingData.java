/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javaassignmentfive;

import java.io.*;

/**
 *
 * @author ashish
 */
public class WritingData {
    BufferedWriter out=null;
    public void writeData(String data){
        
        try{
             out = new BufferedWriter(new FileWriter("data.txt",true));
                 out.write(data);
             
        }
        catch(IOException e){
            System.out.println("one");
        }
        finally{
            try{
                out.close();
            }
            catch(IOException e){
                System.out.println("two");
            }
        }
        
    }
}
