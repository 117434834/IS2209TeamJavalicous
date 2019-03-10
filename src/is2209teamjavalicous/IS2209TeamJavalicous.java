/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is2209teamjavalicous;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author 117434834
 */
public class IS2209TeamJavalicous extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //Simple log in to be inserted here, for test purposes just a button
        Button btn = new Button();
        btn.setText("Log-In");
        
        oddTesterUI oddTestForm = new oddTesterUI();
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                primaryStage.setScene(oddTestForm.show());
            }
        });
        
        StackPane root = new StackPane();
        
        Scene scene = new Scene(root, 300, 250);
        root.getChildren().add(btn);
        
        
        primaryStage.setTitle("Sigma Odds Log-In");
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
