/*
 * @peram part takes in a part and allow user to change it
 * ObserableList l add the modifid part to the list
 */
package inventorymanagementcontroler;

import java.util.Scanner;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author jonathankoerber
 */
public class ModifyPart {
    public static void modifyPart(Part part, ObservableList l, int index){
    Stage stage = new Stage();
    StackPane pane = new StackPane();
    GridPane root = new GridPane();    
        root.setAlignment(Pos.CENTER);
        root.getColumnConstraints().add(new ColumnConstraints(130));
        root.getColumnConstraints().add(new ColumnConstraints(200));
        root.getRowConstraints().add(new RowConstraints(50));
        root.getRowConstraints().add(new RowConstraints(50));  
        root.getRowConstraints().add(new RowConstraints(50));
        root.getRowConstraints().add(new RowConstraints(50));  
        root.getRowConstraints().add(new RowConstraints(50));  
        root.getRowConstraints().add(new RowConstraints(50));
        root.getRowConstraints().add(new RowConstraints(50));
        root.getRowConstraints().add(new RowConstraints(50));
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
    
    Label partLabel = new Label("Modify Part");
    partLabel.getStyleClass().addAll("pageLabel");
    //toggle action
    ToggleGroup group = new ToggleGroup();
    RadioButton inhouse = new RadioButton("Inhouse");
    inhouse.setToggleGroup (group);
    RadioButton outsourced = new RadioButton("Outsourced");
    outsourced.setToggleGroup (group);
    // display part objects correct value inhous outsorced
    
    HBox radio = new HBox(10, inhouse, outsourced);
    radio.getStyleClass().addAll("radio");
//    
//    inhouse.setOnAction(e ->{
//        inhouse.setSelected(true);
//        System.out.println("hello");
//    });
     
    //left will have all the content labels
    
    Label id = new Label("ID");
    id.getStyleClass().addAll("contentLabel");
    Label name = new Label("Name");
    name.getStyleClass().addAll("contentLabel");
    Label inv = new Label("INV");
    inv.getStyleClass().addAll("contentLabel");
    Label price = new Label("Price/Cost");
    price.getStyleClass().addAll("contentLabel");
    Label max = new Label("Max");
    max.getStyleClass().addAll("contentLabel");
    Label toggleId = new Label("Company Name" );
    toggleId.getStyleClass().addAll("contentLabel");

    //all the fields

    Label idField = new Label(""+part.getPartId());
    idField.getStyleClass ().addAll("gray");
    TextField nameField = new TextField(part.getName());
    nameField.getStyleClass ().addAll("paneField");
    TextField invField = new TextField(""+part.getInstock());
    invField.getStyleClass ().addAll("paneField");
    TextField priceField = new TextField(""+part.getPrice());
    priceField.getStyleClass ().addAll("paneField");    
    HBox maxMin = new HBox();
    TextField maxField = new TextField(""+part.getMax());
    maxField.getStyleClass ().addAll("paneField");
    maxField.setId("smallFiedl");
    maxField.setPrefWidth(50);
    Label min = new Label("Min");
    min.getStyleClass().addAll("contentLabel");
    min.setPrefWidth(50);
    TextField minField = new TextField(""+part.getMin());
    minField.getStyleClass ().addAll("paneField");
    minField.setId("smallField");
    minField.setPrefWidth(50);
    maxMin.getChildren ().addAll(maxField, min, minField);
    TextField toggleField = new TextField("Machine Id");
    toggleField.getStyleClass ().addAll("paneField");
   
    
    
    HBox bottomBox = new HBox();
    bottomBox.getStyleClass().addAll("tableBtns");
    Button partSave = new Button("Save");
    
    partSave.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
        
            
            String nameInput = "";//neet to check that this is a string
            double priceInput = 0;//check that this is a double
            int instockInput = 0;//check that it is int
            int minInput = 0;//int and less than the max
            int maxInput = 0;// int and more that min
            int machineIdInput = 0;// int
            String companyInput = ""; //string 
            Label responseLabel = new Label();
            Label errorMessageLabel = new Label();
            if(group.getSelectedToggle().equals(inhouse)){

                    try{
                        nameInput = nameField.getText();
                        priceInput = Double.parseDouble(priceField.getText());
                        minInput = Integer.parseInt(minField.getText());
                        maxInput = Integer.parseInt(maxField.getText());
                        instockInput = Integer.parseInt(invField.getText());
                        machineIdInput = Integer.parseInt(toggleField.getText());
                    }
                    catch(NumberFormatException ex){
                        errorMessageLabel.setText(ex.getMessage());
                       
                    }
                    Scanner scan = new Scanner(System.in);
                    String s = scan.next();


                 if(minInput > maxInput || instockInput < minInput || instockInput > maxInput
                        ||nameInput.equals("") ||  priceInput == 0 || instockInput == 0
                        || minInput == 0 || maxInput == 0 || machineIdInput == 0){
                  if(priceInput == 0 ){
                    responseLabel.setText("the price input has been left" +(" "+priceInput));
                }else if(instockInput == 0){
                    responseLabel.setText("the instock input has been left blank");
                }else if(minInput == 0 ){
                    responseLabel.setText("the min input has been left blank");
                }else if( maxInput == 0){
                    responseLabel.setText("the max input has been left blank");
                }else if(machineIdInput == 0){
                    responseLabel.setText("the machine id input has been left blank");
                }else if(maxInput <= minInput){
                    responseLabel.setText("The max value is less than or equal the min value");
                }else if(minInput > maxInput){
                    responseLabel.setText("The min value is greater than max value");
                }else if(instockInput < minInput){ 
                    responseLabel.setText("The instock value is less than the min value ");
                }else if(instockInput > maxInput){
                    responseLabel.setText("The instck value is greater than the max value");
                }else if(nameInput.equals("")){
                    responseLabel.setText("The name field has been left blank");
                } 
                    
        Stage errorStage = new Stage();
        StackPane errorPane = new StackPane();
        
        Label errorLabel = new Label( "Part can not be added. Please check the input types. ");
        //label.getStyleClass().addAll("contentLabel");
        Button deleteBtn1 = new Button();
        deleteBtn1.setText("OK");
        
        GridPane deleteGrid1 = new GridPane();
        deleteGrid1.add(errorLabel, 0, 0, 3,1);
        deleteGrid1.add(responseLabel, 0, 1, 3,1);
        deleteGrid1.add(deleteBtn1, 1,2);
        deleteGrid1.setAlignment(Pos.CENTER);
        
        deleteGrid1.getColumnConstraints().add(new ColumnConstraints(110));
        deleteGrid1.getColumnConstraints().add(new ColumnConstraints(110));
        deleteGrid1.getColumnConstraints().add(new ColumnConstraints(110));
        deleteGrid1.getRowConstraints().add(new RowConstraints(50));
        deleteGrid1.getRowConstraints().add(new RowConstraints(50));
        deleteGrid1.getRowConstraints().add(new RowConstraints(50));
       // grid.setPadding(new Insets(10, 10, 10, 10));
      
        errorPane.getChildren().add(deleteGrid1);
        Scene errorScene = new Scene(errorPane, 350, 250);
        errorScene.getStylesheets().add("inventorymanagementcontroler/imStyleSheet.css");
        errorStage.setScene(errorScene);
        errorStage.show();
        
        deleteBtn1.setOnAction((ActionEvent e1)->{
            
        errorStage.close();
        
        });   
                }else{
                    Inhouse h = new Inhouse(nameInput, part.getPartId(), priceInput, instockInput, minInput,
                        maxInput, machineIdInput);
                  
            l.remove(index);
            l.add(index, h);
            stage.close();
            
                }
            } else if(group.getSelectedToggle().equals(outsourced)){
                
                   try{
                        nameInput = nameField.getText();
                        priceInput = Double.parseDouble(priceField.getText());
                        minInput = Integer.parseInt(minField.getText());
                        maxInput = Integer.parseInt(maxField.getText());
                        instockInput = Integer.parseInt(invField.getText());
                        companyInput = toggleField.getText();
                    }
                    catch(NumberFormatException ex){
                        System.out.println("cought it");
                        errorMessageLabel.setText(ex.getMessage());
                        priceInput = 0;
                    }
                   // if a user changes the object type to a outsourced and dosent change the machine
                   //id field 
                  {
                       
                   } 

                   
               
                if(minInput > maxInput || instockInput < minInput || instockInput > maxInput
                        ||nameInput.equals("") ||  priceInput == 0 || instockInput == 0
                        || minInput == 0 || maxInput == 0 || companyInput.equals("")){
                 if(priceInput == 0 ){
                    responseLabel.setText("the price input has been left blank");
                }else if(instockInput == 0){
                    responseLabel.setText("the instock input has been left blank");
                }else if(minInput == 0 ){
                    responseLabel.setText("the min input has been left blank");
                }else if( maxInput == 0){
                    responseLabel.setText("the max input has been left blank");
                }else if(companyInput.equals("")){
                    responseLabel.setText("the company name input has been left blank");
                }else if(maxInput  <= minInput){
                    responseLabel.setText("The max value is less than or equal to the min value");
                }else if(minInput > maxInput){
                    responseLabel.setText("The min value is greater than max value");
                }else if(instockInput < minInput){ 
                    responseLabel.setText("The instock value is less than the min value ");
                }else if(instockInput > maxInput){
                    responseLabel.setText("The instck value is greater than the max value");
                }else if(nameInput.equals("")){
                    responseLabel.setText("The name field has been left blank");
                } 
        Stage errorStage = new Stage();
        StackPane errorPane = new StackPane();
        
        Label errorLabel = new Label( "Part can not be modified. Please check the input types. ");
        //label.getStyleClass().addAll("contentLabel");
        Button deleteBtn1 = new Button();
        deleteBtn1.setText("OK");
        
        GridPane deleteGrid1 = new GridPane();
        deleteGrid1.add(errorLabel, 0, 0, 3,1);
        deleteGrid1.add(responseLabel, 0, 1, 3,1);
        deleteGrid1.add(errorMessageLabel, 0, 2, 3, 1);
        deleteGrid1.add(deleteBtn1, 1,3);
        deleteGrid1.setAlignment(Pos.CENTER);
        
        deleteGrid1.getColumnConstraints().add(new ColumnConstraints(110));
        deleteGrid1.getColumnConstraints().add(new ColumnConstraints(110));
        deleteGrid1.getColumnConstraints().add(new ColumnConstraints(110));
        deleteGrid1.getRowConstraints().add(new RowConstraints(50));
        deleteGrid1.getRowConstraints().add(new RowConstraints(50));
        deleteGrid1.getRowConstraints().add(new RowConstraints(50));
        deleteGrid1.getRowConstraints().add(new RowConstraints(50));
       // grid.setPadding(new Insets(10, 10, 10, 10));
      
        errorPane.getChildren().add(deleteGrid1);
        Scene errorScene = new Scene(errorPane, 350, 150);
        errorScene.getStylesheets().add("inventorymanagementcontroler/imStyleSheet.css");
        errorStage.setScene(errorScene);
        errorStage.show();
        
        deleteBtn1.setOnAction((ActionEvent e1)->{
            
        errorStage.close();
        
        });   
                }else{
                    Outsourced h = new Outsourced(nameInput, part.getPartId(), priceInput, instockInput, minInput,
                        maxInput, companyInput);
                         Stage stageModify = new Stage();
        StackPane paneModify = new StackPane();
                
        Label label = new Label("Are You Sure You Want Modify?");
        paneModify.getChildren().add(label);
        Button btn1 = new Button();
        btn1.setText("No");
        
        Button btn2 = new Button();
        btn2.setText("Yes");
        
        GridPane grid = new GridPane();
        grid.add(label,0,0, 2 ,1);
        grid.add(btn1 ,0,1);
        grid.add(btn2, 1,1);
        grid.setAlignment(Pos.BASELINE_CENTER);
        
        grid.getColumnConstraints().add(new ColumnConstraints(110));
        grid.getColumnConstraints().add(new ColumnConstraints(110));
        grid.getRowConstraints().add(new RowConstraints(50));
        grid.getRowConstraints().add(new RowConstraints(50));
      
        paneModify.getChildren().add(grid);
        Scene sceneModify = new Scene(paneModify, 275, 150);
        sceneModify.getStylesheets().add("inventorymanagementcontroler/imStyleSheet.css");
        stageModify.setScene(sceneModify);
        stageModify.show();
       
        btn1.setOnAction((ActionEvent e3)->{              
               stageModify.close();
               });
      
        btn2.setOnAction((ActionEvent e2)->{
            stageModify.close();
            stage.close();
            
            l.remove(index);
            l.add(index, h);
            stage.close();
                    });
                }
            }    
            }
        });
    Button partCancel = new Button("Cancel");      
    partCancel.setOnAction ((ActionEvent e)->{
       cancel c = new cancel();
       c.cancel(stage);
    });
    bottomBox.getStyleClass ().addAll("bottom");
    bottomBox.getChildren ().addAll(partSave, partCancel);
    
    //Radio Action!!
 //displays original content
 //but need to make sure the machine id is not added to the company field
 if(part instanceof Inhouse){
        inhouse.setSelected(true);
        toggleId.setText("Machine ID");
        toggleField.setText(""+((Inhouse) part).getMachineId());
        //toggle select change
        inhouse.setOnAction((ActionEvent e)->{
        toggleId.setText("Machine ID");
        toggleField.setText(""+((Inhouse) part).getMachineId());
          });
       outsourced.setOnAction((ActionEvent e)->{
           toggleId.setText("Company Name");
           toggleField.setPromptText("Comp Nm");
       });
    }else if(part instanceof Outsourced){
     outsourced.setSelected(true);
     toggleId.setText("Compay Name");
     toggleField.setText(""+((Outsourced) part).getCompanyName());
        inhouse.setOnAction((ActionEvent e)->{
            toggleId.setText("Machine ID");
            toggleField.setPromptText("Machine ID");
          });
        outsourced.setOnAction((ActionEvent e)->{
           toggleId.setText("Company Name");
           toggleField.setText(""+((Outsourced)part).getCompanyName());
    });
    }    
  

// Adding elements to the top
//Adding elements to stack pane
    root.add(partLabel,0,0);
    root.add(radio, 1, 0);
        root.add(id ,0,1);
        root.add(idField, 1,1);
        root.add(name, 0, 2);
        root.add(nameField, 1, 2);
        root.add(inv, 0, 3);
        root.add(invField, 1, 3);
        root.add(price, 0, 4);
        root.add(priceField, 1, 4);
        root.add(max, 0, 5);
        root.add(maxMin, 1, 5);
        root.add(toggleId, 0, 6);
        root.add(toggleField, 1, 6);
        root.add(bottomBox,0, 7, 2, 1);
      
    root.setGridLinesVisible(false);
    pane.getChildren().add(root);
    Scene scene = new Scene(pane, 500, 600);
    scene.getStylesheets().add("inventorymanagementcontroler/imStyleSheet.css");
    stage.setScene(scene);
    stage.show();

    }
}
