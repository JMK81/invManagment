/*
 * Takes a exsiting product allows a user to change the fields;
 * @peram Product p, ObservableList l, ObservableList mainProductList
 * 
 */
package inventorymanagementcontroler;

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
public class ModifyProduct {
public static void modifyProduct(Product p, ObservableList l, ObservableList mainProductList){    
    Stage stage = new Stage();
    StackPane pane = new StackPane();
    FlowPane flow = new FlowPane();
    flow.getStyleClass().addAll("pane");
    flow.setHgap(10);
    flow.setVgap(10);
            
    
    GridPane grid = new GridPane();
        grid.getColumnConstraints().add(new ColumnConstraints(130));
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
        
        grid.setAlignment(Pos.CENTER_RIGHT);
    
    //Stage stage = new Stage();
    //heading to the addPart screen
    
    VBox product = new VBox();
    
    Label partLabel = new Label("Modify Product");
    partLabel.getStyleClass().addAll("pageLabel");
    //toggle action
    final ToggleGroup sourcedGroup = new ToggleGroup();
    RadioButton inhouse = new RadioButton("Inhouse");
    inhouse.setToggleGroup (sourcedGroup);
    RadioButton outsourced = new RadioButton("Outsourced");
    outsourced.setToggleGroup (sourcedGroup);
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
    
    //all the fields

    Label idField = new Label(""+p.getProductId());
    idField.getStyleClass ().addAll("gray");
    TextField nameField = new TextField(""+p.getName());
    nameField.getStyleClass ().addAll("paneField");
    TextField invField = new TextField(""+p.getInstock());
    invField.getStyleClass ().addAll("paneField");
    TextField priceField = new TextField(""+p.getPrice());
    priceField.getStyleClass ().addAll("paneField");    
    HBox maxMin = new HBox();
    TextField maxField = new TextField(""+p.getMax());
    maxField.getStyleClass ().addAll("paneField");
    maxField.setPrefWidth(50);
    maxField.setId("smallFiedl");
    Label min = new Label("Min");
    min.setPrefWidth(50);
    min.getStyleClass().addAll("contentLabel");
    TextField minField = new TextField(""+p.getMin());
    minField.setPrefWidth(50);
    minField.getStyleClass ().addAll("paneField");
    minField.setId("smallField");
    maxMin.getChildren ().addAll(maxField, min, minField);
    
    
    //All the action!!
    //Radio Action!!
   

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
        
        
       
    grid.setPrefWidth(350);
    grid.setPrefHeight(400);
    grid.setGridLinesVisible(false);
    //table pars

    VBox addPartProduct = new VBox();
    addPartProduct.getStyleClass().addAll("contentRight");
    HBox searchAddProduct = new HBox();
     Button partsSearchBtn = new Button("Search");
        partsSearchBtn.getStyleClass().addAll("searchTxt");
        partsSearchBtn.setId("searchBtn");
        TextField partsSearchTxt = new TextField();
        partsSearchTxt.setPrefWidth(250);
        partsSearchTxt.setPromptText("Search for Parts by name");
        searchAddProduct.getChildren().addAll(partsSearchBtn, partsSearchTxt);
        
    ObservableList<Part> partList = FXCollections.observableArrayList(l);
    
        TableView<Part> tvParts;
        tvParts = new TableView<>(partList);
        //part id
        TableColumn<Part, String>partId = new TableColumn<>("Part Id");
        partId.setCellValueFactory(new PropertyValueFactory<>("partId"));
        tvParts.getColumns().add(partId);
        partId.setPrefWidth(115);
        //part name
        TableColumn<Part, String>pName = new TableColumn<>("Part Name");
        pName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tvParts.getColumns().add(pName);
        pName.setPrefWidth(115);
        //part inventory level
        TableColumn<Part, String>inventoryLevel = new TableColumn<>("Inventory Level");
        inventoryLevel.setCellValueFactory(new PropertyValueFactory<>("instock"));
        tvParts.getColumns().add(inventoryLevel);
        inventoryLevel.setPrefWidth(115);
        //part cost / per unit
        TableColumn<Part, String>partPrice = new TableColumn<>("Cost/Per Unit");
        partPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tvParts.getColumns().add(partPrice);
        price.setPrefWidth(115);
        tvParts.setPrefHeight(150);
        tvParts.setPrefWidth(375);
        
        FilteredList<Part> filteredData = new FilteredList<>(partList, fp -> true);
        
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
                    return true; // Filter matches first name.
               } //else if (""+(part.getPartId()).toLowerCase().contains(lowerCaseFilter)) {
//                    return true; // Filter matches last name.
//                }
                return false; // Does not match.
            });
        });
        SortedList<Part> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tvParts.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tvParts.setItems(sortedData);
    ObservableList<Part> productPartsList = FXCollections.observableArrayList(p.getPart());
        
    HBox addBtnBox = new HBox();
        Button tvPartsAddBtn = new Button("Add");
        addBtnBox.getStyleClass().addAll("tableBtns");
        addBtnBox.getChildren().add(tvPartsAddBtn);
        addBtnBox.setPrefHeight(50);
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
        
       // TableView<Part> tvParts;
        // secont tabel view 
         
    
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
        pName.setPrefWidth(110);
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
      
        tvPartsProduct.setPrefWidth(550);
        tvPartsProduct.setPrefHeight(150);
                
    //bottom on the page butons 
    HBox deleteBox = new HBox();
    deleteBox.getStyleClass().addAll("tableBtns");

    Button delete = new Button("Delete");
    deleteBox.getChildren().add(delete);
    delete.getStyleClass().addAll("tableBtns");
    delete.setOnAction((ActionEvent e)->{
        Stage stageDelete = new Stage();
        StackPane paneDelete = new StackPane();
       
        Label label = new Label("Are You Sure You Want to Delete? ");
        pane.getChildren().add(label);
        Button deleteBtn1 = new Button();
        deleteBtn1.setText("No");
        
        Button deleteBtn2 = new Button();
        deleteBtn2.setText("Yes");
        
       GridPane deleteGrid = new GridPane();
        deleteGrid.add(label,0,0, 2 ,1);
        deleteGrid.add(deleteBtn1 ,0,1);
        deleteGrid.add(deleteBtn2, 1,1);
        deleteGrid.setAlignment(Pos.BASELINE_CENTER);
        
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
                    
                    if(minInput >= maxInput || instockInput < minInput || instockInput > maxInput
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
                }else if(maxInput <= minInput){
                    responseLabel.setText("The max value is less than the min value");
                }else if(minInput > maxInput){
                    responseLabel.setText("The min value is greater than max value");
                }else if(instockInput < minInput){ 
                    responseLabel.setText("The instock value is less than the min value ");
                }else if(instockInput > maxInput){
                    responseLabel.setText("The instck value is greater than the max value");
                }else if(nameInput.equals("")){
                    responseLabel.setText("The name field has been left blank");
                } else if(partsInput.isEmpty()){
                    responseLabel.setText("There are no parts assignded to " + nameInput);
                }else if(priceInput < minPrice){
                 responseLabel.setText("The inputed price is less the the summ of its parts");   
                }
        Stage errorStage = new Stage();
        StackPane errorPane = new StackPane();
        
        Label errorLabel = new Label( "Part can not be added. Please check the input types. ");
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
        
        deleteGrid1.add(errorLabel, 0, 0, 3, 1);
        deleteGrid1.add(catchLabel, 0, 1, 3, 1);
        deleteGrid1.add(responseLabel, 0, 2, 3, 1);
        deleteGrid1.add(deleteBtn1, 1,3);
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
                    Product newProduct = new Product(partsInput, p.getProductId(),  nameInput,  priceInput,
                         instockInput, minInput, maxInput);
                    
        mainProductList.remove(p);
        mainProductList.add(newProduct);
        //stageModify.close();
        stage.close();
                }
            
        }
    });

        
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
    Scene scene = new Scene(pane, 1200, 600);
    scene.getStylesheets().add("inventorymanagementcontroler/imStyleSheet.css");
    stage.setScene(scene);
    stage.show();
        }
}

