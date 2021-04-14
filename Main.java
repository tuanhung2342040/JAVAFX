/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gooeyvm;

import javafx.scene.control.MenuBar;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 2342040
 */
public class Main extends Application {
    private Boolean prRamOp;
    private Boolean prInsOp;
    private VirtualMachine vm;
    
     private MenuBar makeMenuBar(){
         MenuBar m = new MenuBar();
        
         
         Menu con = new Menu("Controls");
         MenuItem co = new MenuItem("Step");
         

         con.getItems().add(co);
         MenuItem c = new MenuItem("Clear");
         c.setOnAction((ActionEvent ae) ->{
            System.out.println("Ready to tokenize the following string: psh 1"); 
        
         });
         con.getItems().add(c);
         m.getMenus().add(con);
         
         Menu mo = new Menu("Mode");
         CheckMenuItem cm = new CheckMenuItem();
         mo.getItems().add(cm);
         m.getMenus().add(mo);
         
         
        
         
         
         return m;
     }
        
    @Override
 
    public void start(Stage primaryStage) {
        TextField tf = new TextField();
        tf.setEditable(false);
        
        TextField pcDisp = new TextField();
        pcDisp.setEditable(false);
       
        FlowPane root = new FlowPane();
        
        Label l = new Label("This is a string");
        VBox vb = new VBox();
        
      

        Scene scene = new Scene(root, 300, 250);
        Button b = new Button();
        
        
        
        Button stepBtn = new Button();
        stepBtn.setText("step");
        stepBtn.setOnAction((ActionEvent ac) ->{tf.setText("Hello");
        VirtualMachine v = new VirtualMachine();
        v.step(prRamOp, prInsOp);
    });
      
        root.getChildren().add(makeMenuBar());
        root.getChildren().add(vb);
        root.getChildren().add(pcDisp);
        
        
        
        Button clearBtn = new Button();
        clearBtn.setText("clear");
        
        clearBtn.setOnAction((ActionEvent ad) ->{
        vm = new VirtualMachine();
        vm.assemble("/..program.txt");
    });
        
        
        primaryStage.setTitle("Hellow World");
        primaryStage.setScene(scene);
        primaryStage.show();
        
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        launch(args);
        
    }
    
}
