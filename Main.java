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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
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
         Menu men = new Menu("Hello");
         MenuItem mi = new MenuItem("World");
         mi.setOnAction((ActionEvent gwas) ->{
             System.out.println("Hellow world");
         });
         men.getItems().add(mi);
         m.getMenus().add(men);
         CheckMenuItem cmi = new CheckMenuItem();
         men.getItems().add(cmi);
         
         Menu con = new Menu("Controls");
         MenuItem co = new MenuItem("Step");

         con.getItems().add(co);
         MenuItem c = new MenuItem("Clear");
         c.setOnAction((ActionEvent ae) ->{
             mi.setText(null);
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
       
       
        FlowPane root = new FlowPane();

        Scene scene = new Scene(root, 300, 250);
        Button b = new Button();
        
        root.getChildren().add(makeMenuBar());
        Button stepBtn = new Button();
        stepBtn.setText("step");
        b.setOnAction((ActionEvent ac) ->{
        VirtualMachine v = new VirtualMachine();
        v.step(prRamOp, prInsOp);
    });
        root.getChildren().add(stepBtn);
        
        Button clearBtn = new Button();
        clearBtn.setText("clear");
        
        b.setOnAction((ActionEvent ad) ->{
        vm = new VirtualMachine();
        vm.assemble("/..program.txt");
    });
        root.getChildren().add(clearBtn);
        
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
