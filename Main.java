/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gooeyvm;

import java.io.File;
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
import javafx.stage.FileChooser;
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
         TableColumn<Instruction, Integer> addressCol = new TableColumn("Address"); 
         TableColumn<Instruction, String>  opcCol = new TableColumn("Opcode"); 
         TableColumn<Instruction, Integer> oprCol = new TableColumn("Operand");
         addressCol.setCellValueFactory(new PropertyValueFactory("addr"));
         opcCol.setCellValueFactory(new PropertyValueFactory("opc"));
         oprCol.setCellValueFactory(new PropertyValueFactory("opr"));
         insView.getColumns().addAll(addressCol, opcCol, oprCol); 
         insView.getItems().clear(); 
         ArrayList<Instruction> ins = new ArrayList<>(); 
         ins.add(new Instruction(0, "psh", 1)); 
         ins.add(new Instruction(1, "psh", 2));
         ins.add(new Instruction(2, "add", 0));
         ins.add(new Instruction(3, "fin", 0));
         ObservableList<Instruction> in = FXCollections.observableArrayList(ins);  
         insView.setItems(in); 
     } 
    
     private void makeStudentView(){
        students = new TableView();
        TableColumn<student, String> nameCol = new TableColumn("Name");
        TableColumn<student, Integer> numCol = new TableColumn("Student number");
        TableColumn<student, Integer> schoolCol = new TableColumn("Operand");
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        numCol.setCellValueFactory(new PropertyValueFactory("studNum"));
        schoolCol.setCellValueFactory(new PropertyValueFactory("opr"));
        
        students.getColumns().addAll(nameCol, numCol, schoolCol);
        students.getItems().clear();
         ArrayList<student> s = new ArrayList<>();
         s.add(new student(0, "John", 1));
         s.add(new student(0, "Jesse", 1));
         
         
         
         ObservableList<student> ss = FXCollections.observableArrayList(s);
         students.setItems(ss);
}
    
    public void update(boolean b){
       
    }
    
     private MenuBar makeMenuBar(Stage s){
         MenuBar m = new MenuBar();
       
         Menu men = new Menu("Hello"); 
         MenuItem mi = new MenuItem("World"); 
         mi.setOnAction((ActionEvent gwas) ->{ 
          System.out.println("Ready to tokenize the following string: psh 1"); 
        System.out.println("Ready to tokenize the following string: psh 2"); 
        System.out.println("Ready to tokenize the following string: add"); 
        System.out.println("Ready to tokenize the following string: fin"); 
        System.out.println("Printing contents in RAM, from bottom");
        System.out.println("Slot 0: 1");
        System.out.println("Printing contents in RAM, from bottom");
            System.out.println("Slot 0: 1");
            System.out.println("Slot 1: 2");

         }); 
         men.getItems().add(mi); 
         m.getMenus().add(men); 
         
         Menu file = new Menu("File");
         MenuItem open = new MenuItem("Open...");
         open.setOnAction((ActionEvent e)->{
         File f = new FileChooser().showOpenDialog(s);
            System.out.println(f.getAbsolutePath());
         });
         
         file.getItems().add(open);
         m.getMenus().add(file);
         
         
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
        VBox vb = new VBox();
        TextField pcDisp = new TextField();
        Label l = new Label("Program Counter");
        vb.getChildren().add(l);
        vb.getChildren().add(pcDisp);
        pcDisp.setText("1");
        pcDisp.setEditable(true);
       
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root, 300, 250);
        Button b = new Button();
        Button stepBtn = new Button();
        stepBtn.setText("step");
        stepBtn.setOnAction((ActionEvent ac) ->{tf.setText("Hello");
        VirtualMachine v = new VirtualMachine();
        v.step(prRamOp, prInsOp);
    });  
        VBox menuAndTool = new VBox();
        menuAndTool.getChildren().add(makeMenuBar(primaryStage));
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
        update(true);
    });
        
        
        primaryStage.setTitle("Hellow World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) { 
        launch(args); 
    }
    
}
