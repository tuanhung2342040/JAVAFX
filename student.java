/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gooeyvm;

/**
 *
 * @author 2342040
 */
public class student {
    private String name;
    private int studNum;
    
    public student (String n, int sn){
        this.name = n;
        this.studNum = sn;
    }
    public String getName(){
        return name;
    }
    public int getStudentNum(){
        return studNum;
    }
   
}
