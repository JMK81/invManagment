/*
 *Confirms that a user wants to input window closed.
 */
package inventorymanagementcontroler;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author jonathankoerber
 */
public class cancel {
    public void cancel(Stage s){
        Stage stage = new Stage();
        StackPane pane = new StackPane();
       
        Label label = new Label("Are You Sure YOU Want to Cancel? ");
        pane.getChildren().add(label);
        Button btn1 = new Button();
        btn1.setText("No");
        btn1.setOnAction((ActionEvent e)->{
            
            stage.close();
        });
        Button btn2 = new Button();
        btn2.setText("Yes");
        btn2.setOnAction((ActionEvent e)->{
            s.close();
            stage.close();
        });
        
        GridPane grid = new GridPane();
        grid.add(label,0,0, 2 ,1);
        grid.add(btn1 ,0,1);
        grid.add(btn2, 1,1);
        grid.setAlignment(Pos.BASELINE_CENTER);
        
        grid.getColumnConstraints().add(new ColumnConstraints(110));
        grid.getColumnConstraints().add(new ColumnConstraints(110));
        grid.getRowConstraints().add(new RowConstraints(50));
        grid.getRowConstraints().add(new RowConstraints(50));
        
       // grid.setPadding(new Insets(10, 10, 10, 10));
      
        pane.getChildren().add(grid);
        Scene scene = new Scene(pane, 275, 150);
        scene.getStylesheets().add("inventorymanagementcontroler/imStyleSheet.css");
        stage.setScene(scene);
        stage.show();
    }
}
