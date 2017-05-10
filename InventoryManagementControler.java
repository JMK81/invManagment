/*
 * main screen for the apication guides user input into the in
 *inventory management system
 */
package inventorymanagementcontroler;

import static inventorymanagementcontroler.AddPart.addPart;
import static inventorymanagementcontroler.AddProduct.addProduct;
import static inventorymanagementcontroler.ModifyPart.modifyPart;
import static inventorymanagementcontroler.ModifyProduct.modifyProduct;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
public class InventoryManagementControler extends Application {
    
        @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        FlowPane root = new FlowPane();
        root.getStyleClass().addAll("root");
        //initilize arrays to make them exsesable 
         
       ObservableList<Part> partList = FXCollections.observableArrayList(
              new Inhouse("nail1",1, .25, 100, 100, 3000, 1298),
               new Inhouse("nail2",2, .25, 10000, 100, 30000, 1298),
               new Inhouse("nail3", 3,.25, 10000, 100, 30000, 1298),
               new Inhouse("nail4", 4,.25, 10000, 100, 30000, 1298),
               new Inhouse("nail5", 5,.25, 10000, 100, 30000, 1298),
               new Inhouse("nail6", 6, .25, 10000, 100, 30000, 1298),
               new Inhouse("nail7", 7, .25, 10000, 100, 30000, 1298),
               new Inhouse("nail8",8, .25, 10000, 100, 30000, 1298),
               new Inhouse("nail9", 9, .25, 10000, 100, 30000, 1298),
               new Inhouse("nail10",10, .25, 10000, 100, 30000, 1298),
               new Inhouse("screw",11, .25, 10000, 100, 30000, 1298),
               new Inhouse("nail",12, .25, 10000, 100, 30000, 1298),
               new Inhouse("nail",13, .25, 10000, 100, 30000, 1298),
               new Inhouse("nail",14, .25, 10000, 100, 30000, 1298),
               new Inhouse("nail",16, .25, 10000, 100, 30000, 1298),
               new Inhouse("nail", 17,.25, 10000, 100, 30000, 1298),
               new Inhouse("nail", 18,.25, 10000, 100, 30000, 1298),
               new Inhouse("nail", 19,.25, 10000, 100, 30000, 1298),
               new Inhouse("nail", 20, .25, 10000, 100, 30000, 1298),
               new Inhouse("nail", 22, .25, 10000, 100, 30000, 1298),
               new Inhouse("nail",13, .25, 10000, 100, 30000, 1298),
               new Inhouse("nail", 24,.25, 10000, 100, 30000, 1298),
               new Inhouse("nail", 25, .25, 10000, 100, 30000, 1298),
               new Inhouse("nail",26, .25, 10000, 100, 30000, 1298),
               new Inhouse("nail",27, .25, 10000, 100, 30000, 1298),
               new Inhouse("nail",28, .25, 10000, 100, 30000, 1298),
               new Inhouse("nail",29, .25, 10000, 100, 30000, 1298),
               new Inhouse("nail", 30, .25, 10000, 100, 30000, 1298),
               new Inhouse("nail",31,  .25, 10000, 100, 30000, 1298),
               new Inhouse("nail", 32, .25, 10000, 100, 30000, 1298)
               );
               
               
        
        Inventory inventory = new Inventory();
        ObservableList<Product> productList = 
                       FXCollections.observableArrayList(inventory.getProducts());
       
        //assint a id to the differnt labels so they make it look better
        HBox top = new HBox();
        Label inventoryLabel = new Label("Inventory Managment System");
        inventoryLabel.getStyleClass().addAll("pageLabel");
        top.getChildren().add(inventoryLabel);
        top.prefWidthProperty().bind(primaryStage.widthProperty());
        
        VBox partsContainer = new VBox();
        partsContainer.setPrefWidth(542);
        HBox partsGrp = new HBox();
        partsContainer.getStyleClass().addAll("contentLeft");
        Label partsLabel = new Label("Parts");
        partsLabel.getStyleClass().addAll("contentLabel");
        partsGrp.getStyleClass().addAll("contentGrp");
       
        Button partsSearchBtn = new Button("Search");
        partsSearchBtn.setId("searchBtn");
        TextField partsSearchTxt = new TextField();
        partsSearchTxt.setPromptText("Search Parts by Name");
        partsSearchTxt.setPrefWidth(250);
        partsGrp.getChildren().addAll(partsLabel, partsSearchBtn, partsSearchTxt);

 //need to get the searchListPart into a table view <<maybe store that partsList in inventory call             
         
        //table view:)

        TableView<Part> tvParts;
        
        tvParts = new TableView<>(partList);
        //part id
        TableColumn<Part, String>partId = new TableColumn<>("Part Id");
        partId.setCellValueFactory(new PropertyValueFactory<>("partId"));
        tvParts.getColumns().add(partId);
        partId.setPrefWidth(125);
        //part name
        TableColumn<Part, String>pName = new TableColumn<>("Part Name");
        pName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tvParts.getColumns().add(pName);
        pName.setPrefWidth(125);
        //part inventory level
        TableColumn<Part, String>inventoryLevel = new TableColumn<>("Inventory Level");
        inventoryLevel.setCellValueFactory(new PropertyValueFactory<>("instock"));
        tvParts.getColumns().add(inventoryLevel);
        inventoryLevel.setPrefWidth(125);
        //part cost / per unit
        TableColumn<Part, String>price = new TableColumn<>("Cost/Per Unit");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        tvParts.getColumns().add(price);
        price.setPrefWidth(125);
        tvParts.setPrefHeight(300);
        tvParts.setPrefWidth(500);
        
        
        FilteredList<Part> filteredData = new FilteredList<>(partList, p -> true);
        
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
    
    //Refresh();
        
       
        HBox partsBtns = new HBox();
        partsBtns.getStyleClass().addAll("tableBtns");
        Button partsAddBtn = new Button("Add");
        partsAddBtn.setId("vboxBtn");
        partsAddBtn.setOnAction((ActionEvent event)->{
            int newPartId = 1;
            for(Part p : partList){
                if(newPartId < p.getPartId()){
                    newPartId = p.getPartId() + 1;
                }
                    
            }
            addPart(newPartId, partList);
            
    });
        Button partsModifyBtn = new Button("Modify");
        
        partsModifyBtn.setId("vboxBtn");
        partsModifyBtn.setOnAction((ActionEvent e)->{
        Part selectedPart = tvParts.getSelectionModel().getSelectedItem();
        if(selectedPart != null){
            for(int i = 0;i < partList.size(); i++){
                if(partList.get(i).equals(selectedPart)){
                    modifyPart(selectedPart, partList, i);
                    
                }
            }
        }   
        });
       
        Button partsDeleteBtn = new Button("Delete");
        partsDeleteBtn.setId("vboxBtn");
        partsDeleteBtn.getStyleClass().addAll("tableBtns");
        partsDeleteBtn.setOnAction((ActionEvent e)->{
        Part selectedPart = tvParts.getSelectionModel().getSelectedItem();
        Boolean selectedPartUsed = false;
        for(Product p : productList){
            for(Part part : p.getPart()){
                if(part.equals(selectedPart)){
                    selectedPartUsed = true;
                
        Stage stageDelete1 = new Stage();
        StackPane paneDelete1 = new StackPane();
       
        Label label = new Label(selectedPart.getName()+ " can't be deleted is being used in a product. ");
        Button deleteBtn1 = new Button();
        deleteBtn1.setText("OK");
        
        GridPane deleteGrid1 = new GridPane();
        deleteGrid1.add(label,0,0, 3 ,1);
        deleteGrid1.add(deleteBtn1 ,2,1);
        deleteGrid1.setAlignment(Pos.CENTER);
        
        deleteGrid1.getColumnConstraints().add(new ColumnConstraints(110));
        deleteGrid1.getColumnConstraints().add(new ColumnConstraints(110));
        deleteGrid1.getRowConstraints().add(new RowConstraints(35));
        deleteGrid1.getRowConstraints().add(new RowConstraints(50));
       // grid.setPadding(new Insets(10, 10, 10, 10));
      
        paneDelete1.getChildren().add(deleteGrid1);
        Scene sceneDelete1 = new Scene(paneDelete1, 375, 150);
        sceneDelete1.getStylesheets().add("inventorymanagementcontroler/imStyleSheet.css");
        stageDelete1.setScene(sceneDelete1);
        stageDelete1.show();
        
        deleteBtn1.setOnAction((ActionEvent e1)->{
            
            stageDelete1.close();
        });   
                }
            }
        }
        
        if(selectedPart != null && !selectedPartUsed){
        Stage stageDelete = new Stage();
        StackPane paneDelete = new StackPane();
       
        Label label = new Label("Are You Sure You Want to Delete? ");
        pane.getChildren().add(label);
        Button deleteBtn1 = new Button();
        deleteBtn1.setText("No");
        
        Button deleteBtn2 = new Button();
        deleteBtn2.setText("Yes");
        
       GridPane deleteGrid = new GridPane();
        deleteGrid.add(label,0,0, 3 ,1);
        deleteGrid.add(deleteBtn1 ,0,1);
        deleteGrid.add(deleteBtn2, 1,1);
        deleteGrid.setAlignment(Pos.CENTER);
        
        deleteGrid.getColumnConstraints().add(new ColumnConstraints(110));
        deleteGrid.getColumnConstraints().add(new ColumnConstraints(110));
        deleteGrid.getRowConstraints().add(new RowConstraints(35));
        deleteGrid.getRowConstraints().add(new RowConstraints(50));
       // grid.setPadding(new Insets(10, 10, 10, 10));
      
        paneDelete.getChildren().add(deleteGrid);
        Scene sceneDelete = new Scene(paneDelete, 300, 150);
        sceneDelete.getStylesheets().add("inventorymanagementcontroler/imStyleSheet.css");
        stageDelete.setScene(sceneDelete);
        stageDelete.show();
        
        deleteBtn1.setOnAction((ActionEvent e1)->{
            
            stageDelete.close();
        });    
        deleteBtn2.setOnAction((ActionEvent e2)->{
            for(int  i = 0; i < partList.size(); i++){
                if(partList.get(i).equals(selectedPart)){
                    partList.remove(i);
                    tvParts.refresh();
                    stageDelete.close();
                }
              }
        });
        }
    });
    
        
        partsBtns.getChildren().addAll(partsAddBtn, partsModifyBtn, partsDeleteBtn);
        partsContainer.getChildren().addAll(partsGrp, tvParts, partsBtns);
        
    //products box
        VBox productsContainer = new VBox();
        productsContainer.setPrefWidth(542);
        HBox productsGrp = new HBox();
        productsGrp.getStyleClass().addAll("contentGrp");
        productsContainer.getStyleClass().addAll("contentLeft");
        Label productsLabel = new Label("Products");
        productsLabel.getStyleClass().addAll("contentLabel");
        Button productsSearchBtn = new Button("Search");
        productsSearchBtn.setId("searchBtn");
        TextField productsSearchTxt = new TextField();
        productsSearchTxt.setPromptText("Search Products by Name");
        productsSearchTxt.setPrefWidth(250);
        productsSearchBtn.setOnAction((ActionEvent e)->{
            String txt = productsSearchTxt.getText();
            ArrayList<Part>searchListProduct = new ArrayList<>();
            
            if(txt instanceof String){
                for(Part p : partList){
                    if(txt.length()>0)
                         if(p.getName().equals(txt)){
                        searchListProduct.add(p);
                }
               }
            }
        });
        

        TableView<Product> tvProducts;
        
        tvProducts = new TableView<>(productList);
        //product id
        TableColumn<Product, String>productId = new TableColumn<>("Product Id");
        productId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        tvProducts.getColumns().add(productId);
        productId.setPrefWidth(120);
        //produce name
        TableColumn<Product, String>productName = new TableColumn<>("Product Name");
        productName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tvProducts.getColumns().add(productName);
        productName.setPrefWidth(120);
        //product inventory level
        TableColumn<Product, String>productLevel = new TableColumn<>("Inventory Name");
        productLevel.setCellValueFactory(new PropertyValueFactory<>("instock"));
        tvProducts.getColumns().add(productLevel);
        productLevel.setPrefWidth(120);
        //product cost / per unit
        TableColumn<Product, String>cost = new TableColumn<>("Cost / Per Unit");
        cost.setCellValueFactory(new PropertyValueFactory<>("price"));
        tvProducts.getColumns().add(cost);
        cost.setPrefWidth(120);
        tvProducts.setPrefHeight(300);
        tvProducts.setPrefWidth(500);
       
        HBox productsBtns = new HBox();
        productsBtns.getStyleClass().addAll("tableBtns");
        Button productsAddBtn = new Button("Add");
        productsAddBtn.setId("vboxBtn");
        productsAddBtn.setOnAction((ActionEvent e)->{
            int newProductId = 1;
            if(productList.size() > 0){
                System.out.println("inside if");
            for(Product p : productList){
                System.out.println("inside for");
                if(newProductId <= p.getProductId()){
                    System.out.println("inside second if"+ p.getProductId());
                    newProductId = p.getProductId() + 1;
                    System.out.println("affter newProductId assingment "+ newProductId);
                }
            }
            
            System.out.println(""+ newProductId+" from imc");
        }
            addProduct(partList, productList, newProductId);
            
    });
        Button productsModifyBtn = new Button("Modify");
        productsModifyBtn.setId("vboxBtn");
        productsModifyBtn.setOnAction((ActionEvent e)->{
        Product selectedProduct = tvProducts.getSelectionModel().getSelectedItem();
        if(selectedProduct != null){
            for(int  i = 0; i< productList.size(); i++){
                if(productList.get(i).equals(selectedProduct)){
                    modifyProduct(productList.get(i), partList, productList);
                }
            }
        }   
        });
        FilteredList<Product> filteredProductData = new FilteredList<>(productList, p -> true);
        
        productsSearchTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredProductData.setPredicate(product -> {
                // If filter text is empty, display all parts.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                     
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
// Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (product.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
               } //else if (""+(part.getPartId()).toLowerCase().contains(lowerCaseFilter)) {
//                    return true; // Filter matches last name.
//                }
                return false; // Does not match.
            });
        });
        SortedList<Product> sortedProductData = new SortedList<>(filteredProductData);
        sortedData.comparatorProperty().bind(tvParts.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tvProducts.setItems(sortedProductData);
    
            
        Button productsDeleteBtn = new Button("Remove");
        productsDeleteBtn.setId("vboxBtn");
        productsDeleteBtn.getStyleClass().addAll("tableBtns");
        productsDeleteBtn.setOnAction((ActionEvent e)->{
        Product selectedProduct = tvProducts.getSelectionModel().getSelectedItem();
        if(selectedProduct != null){
        Stage stageDelete = new Stage();
        StackPane paneDelete = new StackPane();
       
        Label label = new Label("Are You Sure You Want to Remove Product? ");
        pane.getChildren().add(label);
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
        deleteGrid.getRowConstraints().add(new RowConstraints(35));
        deleteGrid.getRowConstraints().add(new RowConstraints(50));
       // grid.setPadding(new Insets(10, 10, 10, 10));
      
        paneDelete.getChildren().add(deleteGrid);
        Scene sceneDelete = new Scene(paneDelete, 375, 150);
        sceneDelete.getStylesheets().add("inventorymanagementcontroler/imStyleSheet.css");
        stageDelete.setScene(sceneDelete);
        stageDelete.show();
        
        deleteBtn1.setOnAction((ActionEvent e1)->{
            
            stageDelete.close();
        });    
        deleteBtn2.setOnAction((ActionEvent e2)->{
            for(int  i = 0; i < partList.size(); i++){
                if(productList.get(i).equals(selectedProduct)){
                    productList.remove(i);
                    tvProducts.refresh();
                    stageDelete.close();
                }
            }
        });
      }
    });
           
        productsGrp.getChildren().addAll(productsLabel, productsSearchBtn, productsSearchTxt);
        productsGrp.getStyleClass().addAll("inline");
        productsBtns.getChildren().addAll(productsAddBtn, productsModifyBtn, productsDeleteBtn);
        productsBtns.getStyleClass().addAll("inline");
        productsContainer.getChildren().addAll(productsGrp, tvProducts, productsBtns);
               
      
        HBox bottom = new HBox();
        Button btnExit = new Button("Exit");
        btnExit.setId("exitBtn");
        btnExit.setOnAction((ActionEvent event) -> {
            System.out.println("bye world");
            primaryStage.close();
        });
        bottom.getChildren().add(btnExit);
        bottom.getStyleClass().addAll("bottom");
        bottom.prefWidthProperty().bind(primaryStage.widthProperty());
        
        pane.getChildren().add(root);
        Scene scene = new Scene(pane, 1200, 600);
        scene.getStylesheets().add("inventorymanagementcontroler/imStyleSheet.css");
        root.getChildren().addAll(top, partsContainer, productsContainer, bottom);
        
        primaryStage.setTitle("Inventory Management System");
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
