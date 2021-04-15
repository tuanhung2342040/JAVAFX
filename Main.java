/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gooeyvm;

import java.util.ArrayList;
import javafx.scene.control.MenuBar;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
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
    TextField tf;
    TextField pcDisp;
  
    TableView students;
    TableView insView;
     private void makeInsView(){ 

         insView = new TableView(); 
         TableColumn<Instructions, Integer> addressCol = new TableColumn("Address"); 
         TableColumn<Instructions, String>  opcCol = new TableColumn("Opcode"); 
         TableColumn<Instructions, Integer> oprCol = new TableColumn("Operand");
         addressCol.setCellValueFactory(new PropertyValueFactory("Addre"));
         opcCol.setCellValueFactory(new PropertyValueFactory("Opco"));
         oprCol.setCellValueFactory(new PropertyValueFactory("Opera"));
         insView.getColumns().addAll(addressCol, opcCol, oprCol); 
         insView.getItems().clear(); 
         ArrayList<Instructions> ins = new ArrayList<>(); 
         ins.add(new Instructions(0, "psh", 1)); 
         ins.add(new Instructions(1, "psh", 2));
         ins.add(new Instructions(2, "add", 0));
         ins.add(new Instructions(3, "fin", 0));
         ObservableList<Instructions> in = FXCollections.observableArrayList(ins);  
         insView.setItems(in); 
     } 
    
     private void makeStudentView(){
        students = new TableView();
        TableColumn<student, String> nameCol = new TableColumn("Name");
        TableColumn<student, Integer> numCol = new TableColumn("Student number");
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        numCol.setCellValueFactory(new PropertyValueFactory("studNum"));
        students.getColumns().addAll(nameCol, numCol);
        students.getItems().clear();
         ArrayList<student> s = new ArrayList<>();
         s.add(new student("John Doe", 1111));
         s.add(new student("Jame Doe", 2222));
         ObservableList<student> ss = FXCollections.observableArrayList(s);
         students.setItems(ss);
}
    
    public void update(boolean b){
        
    }
    
     private MenuBar makeMenuBar(){
         MenuBar m = new MenuBar();
         Menu men = new Menu("Hello"); 
         MenuItem mi = new MenuItem("World"); 
         mi.setOnAction((ActionEvent gwas) ->{ 
             System.out.println("Hello world"); 

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
     private ArrayList<Button> makeButtons(){
         ArrayList<Button> btns = new ArrayList();
         Button btn1 = new Button("Step");
         btn1.setOnAction((ActionEvent e) ->{
             System.out.println("I am on a toolbar!0");
         });
         Button btn2 = new Button("Clear");
         btn1.setOnAction((ActionEvent e) ->{
             update(true);
             System.out.println("I am on a toolbar!1");
         });
         btns.add(btn1);
         btns.add(btn2);
         return btns;
}
     private ToolBar makeToolBar(ArrayList<Button>btns) {
         ToolBar t = new ToolBar();
         for(Button b: btns){
             t.getItems().add(b);
         }
         return t;
     }
        
    @Override
 
    public void start(Stage primaryStage) {
        
        /*TextField tf = new TextField();
        tf.setEditable(false);*/
        
        TextField pcDisp = new TextField();
        pcDisp.setEditable(false);
       
        FlowPane root = new FlowPane();
        
        Label l = new Label("Program Counter");
        VBox vb = new VBox();
        vb.getChildren().add(l);
        Scene scene = new Scene(root, 300, 250);
        Button b = new Button();
        
        
        
        Button stepBtn = new Button();
        stepBtn.setText("step");
        stepBtn.setOnAction((ActionEvent ac) ->{tf.setText("Hello");
        VirtualMachine v = new VirtualMachine();
        v.step(prRamOp, prInsOp);
    });
        
        
        
        
       
        
        VBox menuAndTool = new VBox();
        menuAndTool.getChildren().add(makeMenuBar());
        menuAndTool.getChildren().add(makeToolBar(makeButtons()));
        
        root.getChildren().add(menuAndTool);
        makeInsView();
        root.getChildren().add(insView);
        root.getChildren().add(vb);
        root.getChildren().add(l);
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
