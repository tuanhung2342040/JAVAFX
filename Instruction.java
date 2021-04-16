/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gooeyvm;

public class Instruction { 
    private int opr; 
    private String opc; 
    private int addr; 
    public Instruction(int addr, String opc, int opr){ 
        this.opr = opr; 
        this.opc = opc; 
        this.addr = addr; 
    } 
    public Instruction(int opr, String opc){ 
        this.opc = opc; 
        this.opr = opr; 
    } 
    
    public void setOpr(int opr){ 
        this.opr = opr; 
    } 
    public void setOpc(String opc){ 
        this.opc = opc; 
    } 
    public void setAddr(int addr){ 
        this.addr = addr; 
    } 
    public int getOpr(){ 
        return opr; 
    } 
    public String getOpc(){ 
        return opc; 
    } 
    public int getAddr(){ 
        return addr; 
    } 
 
} 
 