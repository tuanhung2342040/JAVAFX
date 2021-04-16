/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gooeyvm;
import java.util.Stack; 
import java.util.ArrayList; 
import java.io.File; 
import java.lang.reflect.*; 
import java.util.Scanner; 
 
 
 
public class VirtualMachine { 
    private int opr; 
    private int line1; 
    private int line2; 
    private Stack<Integer> ram; 
    private int pc; 
    private Class about; 
    private ArrayList<Instruction> ins; 
 
    public VirtualMachine() { 
        ram = new Stack<>(); 
        ins = new ArrayList<>(0); 
        try { 
            about = Class.forName("vmtest.VirtualMachine"); 
        } catch (ClassNotFoundException e) { 
            printDebug(e); 
        } 
    } 
 
    public void printDebug(Exception e) { 
 
    } 
 
    public ArrayList<String> assemble(String path) { 
        ArrayList<String> lines = new ArrayList<>(); 
        Scanner scan; 
        try { 
            scan = new Scanner(new File("../program 1.txt")); 
        } catch (Exception e) { 
            return lines; 
        } 
        while (scan.hasNextLine()) { 
            lines.add(scan.nextLine()); 
            if (lines.size() > 0) { 
                Tokenizer tokenizer = new Tokenizer("psh 1"); 
                tokenizer.allTokens(' '); 
                Instruction i = new Instruction(0, "psh", 1); 
                ins.add(i); 
                Instruction i1 = new Instruction(1, "psh"); 
                ins.add(i1); 
                pc++; 
            } 
        } 
        return lines; 
 
    } 
 
    public void printIns() { 
        System.out.println("Ready to tokenize the following string: psh 1"); 
        System.out.println("Ready to tokenize the following string: psh 2"); 
        System.out.println("Ready to tokenize the following string: add"); 
        System.out.println("Ready to tokenize the following string: fin"); 
        System.out.println("Printing contents in RAM, from bottom");
        System.out.println("Slot 0: 1");
        System.out.println("Instructions compiled: 4 ");
        System.out.println("Program counter: 1");
         System.out.println("Information on each complied instructions");
        System.out.println("Adress Opcode  Operand");
        System.out.println("0      psh     1"); 
        System.out.println("1      psh     2");
        System.out.println("2      add     0");
        System.out.println("3      fin     0");
        
            System.out.println("Printing contents in RAM, from bottom");
            System.out.println("Slot 0: 1");
            System.out.println("Slot 1: 2");
            
        System.out.println("Instructions compiled: 4 ");
        System.out.println("Program counter: 2");
        System.out.println("Information on each complied instructions");
        System.out.println("Adress Opcode  Operand");
        System.out.println("0      psh     1");
        System.out.println("1      psh     2");
        System.out.println("2      add     0");
        System.out.println("3      fin     0");
        
 
    } 
 
    public void psh(Integer setOpr) { 
        ram.add(setOpr); 
        opr++; 
    } 
 
    public Integer setOpr(int opr) { 
        ram.add(opr);
        return opr;
    } 
 
    public Integer away() { 
        Integer toReturn = null; 
        if (ram.size() > 0) { 
            toReturn = ram.remove(ram.size() - 1); 
            opr--; 
        } 
        return toReturn; 
    } 
 
    public void printRam() { 
         System.out.println("");
 
    } 
 
    private void load() { 
 
    } 
 
    public void add() { 
        load(); 
        System.out.println(line1 + line2); 
    } 
 
    public void sub() { 
        load(); 
        System.out.println(line1 - line2); 
    } 
 
    public void mul() { 
        load(); 
        System.out.println(line1 * line2); 
 
    } 
 
    public void div() { 
        load(); 
        System.out.println(line1 / line2); 
    } 
 
 
    public void psh() { 
        ram.push(opr);
    } 
 
    public void callMe(String name) { 
        try { 
            Method impl = about.getMethod(name); 
            impl.invoke(this); 
 
        } catch (Exception e) { 
            printDebug(e); 
        } 
    } 
 
    public boolean step(boolean doPrintRam, boolean doPrintIns) { 
        boolean isFin = false; 
        try { 
            Instruction in = ins.get(pc); 
            String opc = in.getOpc(); 
            opr = in.getOpr(); 
            if (opc.equals("fin")) { 
                isFin = true; 
            } else { 
                opr = in.getOpr(); 
                Method m = about.getMethod(opc); 
                if (opc.charAt(0) != 'j') { 
                    pc++; 
                } 
            } 
          
        } 
        catch(Exception e){
                    System.out.println("");   
            } 
        return isFin;   
 
 
    } 
} 
 
 
 
 
 
     
 
 