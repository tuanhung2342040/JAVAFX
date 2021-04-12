/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gooeyvm;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    @Override
    public void start(Stage primaryStage) {
       
       
        FlowPane root = new FlowPane();

        Scene scene = new Scene(root, 300, 250);
        Button b = new Button();
        b.setText("Hello World");
        b.setOnAction((ActionEvent ab) ->{
            System.out.println("Hello world");
        });
        root.getChildren().add(b);
        
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
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        launch(args);
    }
    
}
