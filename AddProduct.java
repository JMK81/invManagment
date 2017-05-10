/*
 *Takes user input and makes a new product object.
 *@peram p parts list
 *@peram l products list
 *@peram productId next part id
 */
package inventorymanagementcontroler;

import inventorymanagementcontroler.Inventory.*;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jonathankoerber
 */
public class AddProduct {//p == partList l == productList 
    public static void addProduct(ObservableList p,ObservableList l, int newProductId){
      System.out.println("from inside addProduct" + newProductId);
    Stage stage = new Stage();
    StackPane pane = new StackPane();
    FlowPane flow = new FlowPane();
    flow.getStyleClass().addAll("pane");
    flow.setHgap(10);
    flow.setVgap(10);
            
    
    GridPane grid = new GridPane();
        grid.getColumnConstraints().add(new ColumnConstraints(150));
        grid.getColumnConstraints().add(new ColumnConstraints(250));
        grid.getRowConstraints().add(new RowConstraints(50));
        grid.getRowConstraints().add(new RowConstraints(50));  
        grid.getRowConstraints().add(new RowConstraints(50));
        grid.getRowConstraints().add(new RowConstraints(50));  
        grid.getRowConstraints().add(new RowConstraints(50));  
        grid.getRowConstraints().add(new RowConstraints(50));
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
       // grid.getStyleClass().addAll("contentLeft");
       grid.setAlignment(Pos.CENTER_RIGHT);
    
    //Stage stage = new Stage();
    //heading to the addPart screen
    
    VBox product = new VBox();
    
    Label partLabel = new Label("Add Product");
    partLabel.getStyleClass().addAll("pageLabel");
 
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
    
    //all the fields

    Label idField = new Label("Auto Generate");
    idField.getStyleClass().addAll("gray");
    TextField nameField = new TextField();
    nameField.setPromptText("Product Name");
    nameField.getStyleClass ().addAll("paneField");
    TextField invField = new TextField();
    invField.setPromptText("Inventory Label");
    invField.getStyleClass ().addAll("paneField");
    TextField priceField = new TextField();
    priceField.setPromptText("Price/Cost");
    priceField.getStyleClass ().addAll("paneField");    
    HBox maxMin = new HBox();
    TextField maxField = new TextField();
    maxField.setPromptText("Max");
    maxField.getStyleClass ().addAll("paneField");
    maxField.setPrefWidth(42);
    Label min = new Label("Min");
    min.getStyleClass().addAll("contentLabel");
    TextField minField = new TextField();
    minField.setPromptText("Min");
    minField.getStyleClass ().addAll("paneField");
    minField.setPrefWidth(42);
    maxMin.getChildren ().addAll(maxField, min, minField);

// Adding elements to the top
//Adding elements to stack pane
        grid.add(partLabel,0,0, 2 ,1);
        grid.add(id ,0,1);
        grid.add(idField, 1,1);
        grid.add(name, 0, 2);
        grid.add(nameField, 1, 2);
        grid.add(inv, 0, 3);
        grid.add(invField, 1, 3);
        grid.add(price, 0, 4);
        grid.add(priceField, 1, 4);
        grid.add(max, 0, 5);
        grid.add(maxMin, 1, 5);
        
       
    grid.setPrefWidth(450);
    grid.setPrefHeight(350);
    
    VBox addPartProduct = new VBox();
    addPartProduct.getStyleClass().addAll("contentRight");
    HBox searchAddProduct = new HBox();
     Button partsSearchBtn = new Button("Search");
        partsSearchBtn.getStyleClass().addAll("searchTxt");
        partsSearchBtn.setId("searchBtn");
        TextField partsSearchTxt = new TextField();
        partsSearchTxt.setPromptText("Search by part Name");
        partsSearchTxt.setPrefWidth(250);
        searchAddProduct.getChildren().addAll(partsSearchBtn, partsSearchTxt);
           
     ObservableList<Part> partList = FXCollections.observableArrayList(p);
     ObservableList<Part> productPartsList = FXCollections.observableArrayList();
    //these are all parts avalible need a search function
        TableView<Part> tvParts;
        
        tvParts = new TableView<>(partList);
        //part id
        TableColumn<Part, String>partId = new TableColumn<>("Part Id");
        partId.setCellValueFactory(new PropertyValueFactory<>("partId"));
        tvParts.getColumns().add(partId);
        partId.setPrefWidth(110);
        //part name
        TableColumn<Part, String>pName = new TableColumn<>("Part Name");
        pName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tvParts.getColumns().add(pName);
        pName.setPrefWidth(110);
        //part inventory level
        TableColumn<Part, String>inventoryLevel = new TableColumn<>("Inventory Level");
        inventoryLevel.setCellValueFactory(new PropertyValueFactory<>("instock"));
        tvParts.getColumns().add(inventoryLevel);
        inventoryLevel.setPrefWidth(110);
        //part cost / per unit
        TableColumn<Part, String>partPrice = new TableColumn<>("Cost/Per Unit");
        partPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tvParts.getColumns().add(partPrice);
        price.setPrefWidth(110);
        
        tvParts.setPrefWidth(400);
        tvParts.setPrefHeight(145);
        
        FilteredList<Part> filteredData = new FilteredList<>(partList, p3 -> true);
        
        partsSearchTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(part -> {
                // If filter text is empty, display all parts.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                     
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
// Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (part.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
               } 


                return false; // Does not match.
            });
        });
        SortedList<Part> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tvParts.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tvParts.setItems(sortedData);
    
        
        HBox addBtnBox = new HBox();
        Button tvPartsAddBtn = new Button("Add");
        addBtnBox.getStyleClass().addAll("tableBtns");
        addBtnBox.getChildren().add(tvPartsAddBtn);
         tvPartsAddBtn.setOnAction((ActionEvent e)->{
            System.out.println(tvParts.getSelectionModel().getSelectedItem());
            Part selectedPart = tvParts.getSelectionModel().getSelectedItem();
            for(int  i = 0; i < partList.size(); i++){
                if(partList.get(i).equals(selectedPart)){
                    partList.remove(i);
                    tvParts.refresh();
                    productPartsList.add(selectedPart);
                }
            }
        });
        
        // secont tabel view 
        //these are the parts that will go into the array that is inside the product object
         
    
        TableView<Part> tvPartsProduct;
        
        tvPartsProduct = new TableView<>(productPartsList);
        //part id
        TableColumn<Part, String>partIdList = new TableColumn<>("Part Id");
        partIdList.setCellValueFactory(new PropertyValueFactory<>("partId"));
        tvPartsProduct.getColumns().add(partIdList);
        partId.setPrefWidth(110);
        //part name
        TableColumn<Part, String>pNameList = new TableColumn<>("Part Name");
        pNameList.setCellValueFactory(new PropertyValueFactory<>("name"));
        tvPartsProduct.getColumns().add(pNameList);
        pNameList.setPrefWidth(110);
        //part inventory level
        TableColumn<Part, String>inventoryLevelList = new TableColumn<>("Inventory Level");
        inventoryLevelList.setCellValueFactory(new PropertyValueFactory<>("instock"));
        tvPartsProduct.getColumns().add(inventoryLevelList);
        inventoryLevelList.setPrefWidth(110);
        //part cost / per unit
        TableColumn<Part, String>priceList = new TableColumn<>("Cost/Per Unit");
        priceList.setCellValueFactory(new PropertyValueFactory<>("price"));
        tvPartsProduct.getColumns().add(priceList);
        priceList.setPrefWidth(110);
      
        tvPartsProduct.setPrefWidth(450);
        tvPartsProduct.setPrefHeight(150);
        //saved to the product array in the constuctor that will go into the 
                
    //bottom on the page butons 
    //delete will only remove a part from the productPartslist
    HBox deleteBox = new HBox();
    deleteBox.getStyleClass().addAll("tableBtns");
//    deleteBox.prefWidthProperty().bind(stage.widthProperty());
           
    Button delete = new Button("Delete");
    deleteBox.getChildren().add(delete);
    delete.getStyleClass().addAll("tableBtns");
    //THIS MAY NOT WORK IN THE ARREA 
      delete.setOnAction((ActionEvent e)->{
        Stage stageDelete = new Stage();
        StackPane paneDelete = new StackPane();
       
        Label label = new Label("Are You Sure You Want to Delete? ");
        Button deleteBtn1 = new Button();
        deleteBtn1.setText("No");
        
        Button deleteBtn2 = new Button();
        deleteBtn2.setText("Yes");
        
       GridPane deleteGrid = new GridPane();
        deleteGrid.add(label,0,0, 2 ,1);
        deleteGrid.add(deleteBtn1 ,0,1);
        deleteGrid.add(deleteBtn2, 1,1);
        deleteGrid.setAlignment(Pos.CENTER);
        
        deleteGrid.getColumnConstraints().add(new ColumnConstraints(110));
        deleteGrid.getColumnConstraints().add(new ColumnConstraints(110));
        deleteGrid.getRowConstraints().add(new RowConstraints(50));
        deleteGrid.getRowConstraints().add(new RowConstraints(50));
       // grid.setPadding(new Insets(10, 10, 10, 10));
      
        paneDelete.getChildren().add(deleteGrid);
        Scene sceneDelete = new Scene(paneDelete, 275, 150);
        sceneDelete.getStylesheets().add("inventorymanagementcontroler/imStyleSheet.css");
        stageDelete.setScene(sceneDelete);
        stageDelete.show();
        
        deleteBtn1.setOnAction((ActionEvent e1)->{
                stageDelete.close();
        });    
        deleteBtn2.setOnAction((ActionEvent e2)->{
           
            Part selectedPart = tvPartsProduct.getSelectionModel().getSelectedItem();
            for(int  i = 0; i < productPartsList.size(); i++){
                if(productPartsList.get(i).equals(selectedPart)){
                    productPartsList.remove(i);
                    tvPartsProduct.refresh();
                    partList.add(selectedPart);
                    stageDelete.close();
                }
            }
        });    
    });
    
    HBox bottomBox = new HBox();
    //save construture
    Button productSave = new Button("Save");
    productSave.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
               double minPrice = 0;
               for(Part p : productPartsList){
                   minPrice = minPrice + p.getPrice();
               }
              ArrayList<Part>partsInput = new ArrayList<>();
              String nameInput = "";
              int instockInput = 0;
              double priceInput=0;
              int maxInput=0;
              int minInput = 0;
              Label catchLabel = new Label();
              Label responseLabel = new Label();
                    try{
                       partsInput = new ArrayList<>(productPartsList);
                        nameInput = nameField.getText();
                        instockInput = Integer.parseInt(invField.getText());
                        priceInput = Double.parseDouble(priceField.getText());
                        maxInput = Integer.parseInt(maxField.getText());
                        minInput = Integer.parseInt(minField.getText());
                    }
                    catch(NumberFormatException ex){
                        catchLabel.setText("Error: "+ex.getMessage());
                    }
                    


                if(minInput > maxInput || instockInput < minInput || instockInput > maxInput
                        ||nameInput.equals("") ||  priceInput < minPrice
                        || minInput == 0 || maxInput == 0 || partsInput.isEmpty()){
                  if(priceInput == 0 ){
                    responseLabel.setText("the price input has been left blank");
                }else if(instockInput == 0){
                    responseLabel.setText("the instock input has been left blank");
                }else if(minInput == 0 ){
                    responseLabel.setText("the min input has been left blank");
                }else if( maxInput == 0){
                    responseLabel.setText("the max input has been left blank");
                }else if(maxInput < minInput){
                    responseLabel.setText("The max value is less than or equal the min value");
                }else if(minInput > maxInput){
                    responseLabel.setText("The min value is greater than max value");
                }else if(instockInput < minInput){ 
                    responseLabel.setText("The instock value is less than the min value ");
                }else if(instockInput > maxInput){
                    responseLabel.setText("The instOck value is greater than the max value");
                }else if(nameInput.equals("")){
                    responseLabel.setText("The name field has been left blank");
                }else if(partsInput.isEmpty()){
                    responseLabel.setText("There are no parts assignded to " + nameInput);
                }else if(priceInput < minPrice){
                 responseLabel.setText("The inputed price is less the the summ of its parts");   
                }
        Stage errorStage = new Stage();
        StackPane errorPane = new StackPane();
        
        Label errorLabel = new Label( "Product can not be added. Please check the input types. ");
        //label.getStyleClass().addAll("contentLabel");
        Button deleteBtn1 = new Button();
        deleteBtn1.setText("OK");
        
        GridPane deleteGrid1 = new GridPane();
        
        deleteGrid1.getColumnConstraints().add(new ColumnConstraints(110));
        deleteGrid1.getColumnConstraints().add(new ColumnConstraints(110));
        deleteGrid1.getColumnConstraints().add(new ColumnConstraints(110));
        deleteGrid1.getRowConstraints().add(new RowConstraints(30));
        deleteGrid1.getRowConstraints().add(new RowConstraints(30));
        deleteGrid1.getRowConstraints().add(new RowConstraints(30));
        deleteGrid1.getRowConstraints().add(new RowConstraints(50));
        
        deleteGrid1.add(errorLabel, 0, 0, 3,1);
        deleteGrid1.add(catchLabel, 0, 1, 3, 1);
        deleteGrid1.add(responseLabel, 0, 2, 3, 1);
        deleteGrid1.add(deleteBtn1, 2,3);
        deleteGrid1.setAlignment(Pos.CENTER);
       // grid.setPadding(new Insets(10, 10, 10, 10));
      
        errorPane.getChildren().add(deleteGrid1);
        Scene errorScene = new Scene(errorPane, 500, 175);
        errorScene.getStylesheets().add("inventorymanagementcontroler/imStyleSheet.css");
        errorStage.setScene(errorScene);
        errorStage.show();
        
        deleteBtn1.setOnAction((ActionEvent e1)->{
            
        errorStage.close();
        
        });   
                }else{
                    Product newProduct = new Product(partsInput, newProductId,  nameInput,  priceInput,
                         instockInput, minInput, maxInput);
                   
                    
        System.out.println("trying to add" + (""+newProductId));
        l.add(newProduct);
        
        stage.close();
                }
            
        }
    });
    //need diolog box for cancel button
    Button productCancel = new Button("Cancel");
    productCancel.setOnAction ((ActionEvent e)->{
       cancel c = new cancel();
       c.cancel(stage);
    });
    
    bottomBox.getStyleClass ().addAll("tableBtns");
    bottomBox.getChildren ().addAll(productSave, productCancel);
    //bottomBox.prefWidthProperty().bind(stage.widthProperty());
    
    //adding elements
    product.getChildren().add(grid);
    product.getStyleClass().addAll("contentRight");
    addPartProduct.getChildren().addAll(searchAddProduct,tvParts, tvPartsAddBtn, 
            tvPartsProduct, deleteBox, bottomBox);
    flow.getChildren().addAll(product, addPartProduct);
    pane.getChildren().add(flow);
    Scene scene = new Scene(pane, 1100, 600);
    scene.getStylesheets().add("inventorymanagementcontroler/imStyleSheet.css");
    stage.setScene(scene);
    stage.show();
}
}
