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
    private int school;
    public student (int sn, String n,int school){
        this.name = n;
        this.studNum = sn;
        this.school = school;
    }
    public String getName(){
        return name;
    }
    public int getStudNum(){
        return studNum;
    }
    public int getSchool(){
        return school;
    }
    
   
}
