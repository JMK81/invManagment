/*
 * Allow user to input part into the inventory management system
 *@peram int partIdInput next part id 
 *@peram observablelist l the parts list were the parts are stored
 */
package inventorymanagementcontroler;

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
public class AddPart {
    public static void addPart(int partIdInput, ObservableList l){
        
    Stage stage = new Stage();
    StackPane pane = new StackPane();
    GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.getColumnConstraints().add(new ColumnConstraints(120));
        root.getColumnConstraints().add(new ColumnConstraints(200));
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
        root.getStyleClass().addAll("contentLeft");
        
        
    //Stage stage = new Stage();
    //heading to the addPart screen
    
    Label partLabel = new Label("Add Part");
    partLabel.getStyleClass().addAll("pageLabel");
    
//toggle action
    ToggleGroup group = new ToggleGroup();
    RadioButton inhouse = new RadioButton("Inhouse");
    inhouse.setToggleGroup (group);
    inhouse.setSelected(true);
    RadioButton outsourced = new RadioButton("Outsourced");
    outsourced.setToggleGroup (group);
   
    
    HBox radio = new HBox(10, inhouse, outsourced);
    radio.getStyleClass().addAll("radio");
    
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
    Label toggleId = new Label("Machine Id");
    toggleId.getStyleClass().addAll("contentLabel");
   
    //all the fields

    Label idField = new Label("Auto Generated");
    idField.getStyleClass ().addAll("gray");
    idField.getStyleClass ().addAll("paneField", "gray");
    TextField nameField = new TextField();
    nameField.setPromptText("Part Name");
    nameField.getStyleClass ().addAll("paneField");
    TextField invField = new TextField();
    invField.getStyleClass ().addAll("paneField");
    invField.setPromptText("Inventory Level");
    TextField priceField = new TextField();
    priceField.setPromptText("Price/Cost");
    priceField.getStyleClass ().addAll("paneField");    
    
    HBox maxMin = new HBox();
    TextField maxField = new TextField();
    maxField.setPromptText("Max");
    maxField.getStyleClass ().addAll("paneField");
    maxField.setPrefWidth(42);
    Label min = new Label("Min");
    min.setPrefWidth(50);
    min.getStyleClass().addAll("contentLabel");
    min.setPrefWidth(50);
    TextField minField = new TextField();
    minField.setPromptText("Min");
    minField.getStyleClass ().addAll("paneField");
    minField.setPrefWidth(40);
    maxMin.getChildren ().addAll(maxField, min, minField);
    
    TextField toggleField = new TextField();
    toggleField.setPromptText("Mach Id");
    toggleField.getStyleClass ().addAll("paneField");
    
    
    HBox bottomBox = new HBox();
    Button partSave = new Button("Save");
    Label responseLabel = new Label();
   
   //nee to find a way to move the part object to the part list
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
                        System.out.println("cought it");
                        System.out.println(ex.getMessage());
                        
                    }
                    


              if(minInput > maxInput || instockInput < minInput || instockInput > maxInput
                        ||nameInput.equals("") ||  priceInput == 0 || instockInput == 0
                        || minInput == 0 || maxInput == 0 || machineIdInput == 0){
                  if(priceInput == 0 ){
                    responseLabel.setText("the price input has been left blank");
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
        
        Label label = new Label( "Part can not be added. Please check the input types. ");
        
        //label.getStyleClass().addAll("contentLabel");
        Button deleteBtn1 = new Button();
        deleteBtn1.setText("OK");
        
        GridPane deleteGrid1 = new GridPane();
        deleteGrid1.add(label, 0, 0, 3,1);
        deleteGrid1.add(responseLabel, 0, 1, 3, 1);
        deleteGrid1.add(deleteBtn1, 2,2);
        deleteGrid1.setAlignment(Pos.CENTER);
        
        deleteGrid1.getColumnConstraints().add(new ColumnConstraints(110));
        deleteGrid1.getColumnConstraints().add(new ColumnConstraints(110));
        deleteGrid1.getColumnConstraints().add(new ColumnConstraints(110));
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
                    Inhouse h = new Inhouse(nameInput, partIdInput, priceInput, instockInput, minInput,
                        maxInput, machineIdInput);
                    l.add(h);
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
                        System.out.println(ex.getMessage());
                        
                    }
                    
                    if(minInput >= maxInput
                       || instockInput < minInput || instockInput > maxInput
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
        
        Label label = new Label( "Part can not be added. Please check the input types. ");
        //label.getStyleClass().addAll("contentLabel");
        Button deleteBtn1 = new Button();
        deleteBtn1.setText("OK");
        
        GridPane deleteGrid1 = new GridPane();
        deleteGrid1.add(label, 0, 0, 2,1);
        deleteGrid1.add(responseLabel, 0,1,2,1);
        deleteGrid1.add(deleteBtn1, 1,2);
        deleteGrid1.setAlignment(Pos.CENTER);
        
        deleteGrid1.getColumnConstraints().add(new ColumnConstraints(110));
        deleteGrid1.getColumnConstraints().add(new ColumnConstraints(110));
        deleteGrid1.getColumnConstraints().add(new ColumnConstraints(110));
        deleteGrid1.getRowConstraints().addAll(new RowConstraints(50));
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
                    Outsourced h = new Outsourced(nameInput, partIdInput, priceInput, instockInput, minInput,
                        maxInput, companyInput);
                l.add(h);
               stage.close();
                }
            }
            
        }
    });
    Button partCancel = new Button("Cancel");
    partCancel.setOnAction ((ActionEvent e)->{
       cancel c = new cancel();
       c.cancel(stage);
    });
    bottomBox.getStyleClass ().addAll("tableBtns");
    bottomBox.getChildren ().addAll(partSave, partCancel);
    
//all the action 
//toggle method
inhouse.setOnAction((ActionEvent e)->{
        toggleId.setText("Machine ID");
        toggleField.setPromptText("Mach ID");
});
outsourced.setOnAction((ActionEvent e)->{
    System.out.println("Outsourced");
    toggleId.setText("Company Name");
    toggleField.setPromptText("Comp Nm");
});

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
