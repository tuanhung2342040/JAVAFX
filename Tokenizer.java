/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gooeyvm;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wnlqx
 */

public class Tokenizer {

    private String chopMe;
    private int priorDelim = -1;
    
    
    public Tokenizer(String s) {
        chopMe = s;
        System.out.print ("Ready to tokenize the following string: ");
        System.out.println (chopMe);
    }
    
    public void chopAt(int len) {
        if (len >= chopMe.length()) {
            System.out.println(chopMe);
        }
        else {
            for (int i = 0; i < len; i++) {
                System.out.print(chopMe.charAt(i));
            }
            System.out.println();
            Scanner sc = new Scanner(System.in);
            System.out.println("Would you like to see the rest of the characters?");
            String answer = sc.nextLine();
            if (answer.equals("y")) {
                for (int i = len; i < chopMe.length(); i++) {
                    System.out.print(chopMe.charAt(i));
                }
                System.out.println();
            }
        }
    }
    
    
    public void chopAtEvery(int interval) {    
        int index;
        for (index = interval; index < chopMe.length(); index += interval) {
            System.out.println(chopMe.substring(index - interval , index));
        }
        System.out.println(chopMe.substring(index - interval));   
    }
    
    public void chopAtEvery(char delim) {
        int priorDelim = -1;
        int i;
        for (i = 0; i < chopMe.length(); i++) {
            if (chopMe.charAt(i) == delim) {
                System.out.print("The index of the prior delimiter is ");
                System.out.println(priorDelim);
                System.out.print("The index of the new delimiter is ");
                System.out.println(i);
                System.out.print("The token is ");
                System.out.println(chopMe.substring(priorDelim + 1, i));
                priorDelim = i;
            }
        }
        
        System.out.print("The index of the prior delimiter is ");
        System.out.println(priorDelim);
        System.out.print("The index of the new delimiter is ");
        System.out.println(i);
        System.out.print("The token is ");
        System.out.println(chopMe.substring(priorDelim + 1));
    }
    
    public String nextToken (char delim) {
        int i;
        boolean tokenFound = false;
        String tok = new String();
        int start = priorDelim + 1;
        for (i = start; i < chopMe.length() && tokenFound == false; i++) {
            if (chopMe.charAt(i) == delim) {
                tok = chopMe.substring(priorDelim + 1, i);
                priorDelim = i;
                tokenFound = true;
            }
        }
        if (tokenFound == false) {
            tok = chopMe.substring(start);
        }
        
        return tok;
    }
    
    public String nextToken (int len) {
        int start = priorDelim + 1;
        int end = start + len;
        String tok = chopMe.substring(start, end);
        priorDelim = priorDelim + len;
        return tok;        
    }
 
    
    public ArrayList<String> allTokens (char delim) {
        ArrayList<String> tokens = new ArrayList<String>();
        int priorDelim = -1;
        int i;
        for (i = 0; i < chopMe.length(); i++) {
            if (chopMe.charAt(i) == delim) {
                tokens.add(chopMe.substring(priorDelim + 1, i));
                priorDelim = i;
            }
        }       
        tokens.add(chopMe.substring(priorDelim + 1, i));
        return tokens;
    }

    public ArrayList<String> allTokens(int interval) {
        ArrayList<String> tokens = new ArrayList<String>();
        int index;
        for (index = interval; index < chopMe.length(); index += interval) {
            tokens.add(chopMe.substring(index - interval , index));
        }
        tokens.add(chopMe.substring(index - interval));
        return tokens;
    }
}

   
