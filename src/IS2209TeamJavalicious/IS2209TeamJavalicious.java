/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IS2209TeamJavalicious;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author 117331683
 */
public class IS2209TeamJavalicious extends Application {
    
    //while creating this class, press ALT + ENTER over errors to auto imports
    @Override
    public void start(Stage primaryStage) {
        
        String username, password;
        username = "Gambler99";
        password = "B3t0n1t";
        
        //GridePane is another layout pane. Last friday we covered the StickPane
        GridPane grid = new GridPane(); //Creates our gridpane
        grid.setAlignment(Pos.CENTER); //Align everything to the center of our gridpane
        grid.setHgap(10); //The Horizontal gap between grid columns
        grid.setVgap(10); // the Vertical gap between the grid rows
        
        Text txtWelcome = new Text("Welcome to Sigma"); //Creates a new 'Text' object which cannot be edited 
        txtWelcome.setFont(Font.font("Veranda", FontWeight.NORMAL, 20)); //Set font options for our text object
        
        //Add Text object to GridPane
        grid.add(txtWelcome, 0, 0, 2, 1); //First two digits -> Column + Row, Second two didgits -> Colummn Span, Row Span
        
        Label lblUserName = new Label("User Name"); //Creates a new 'Label' object 
        grid.add(lblUserName, 0, 1); //Adds the Label object to our GridPane
        
        TextField userTextField = new TextField(); // Creates a new 'TextField' Object, THIS CAN be edited
        grid.add(userTextField, 1, 1); //Adds the Label object to our GridPane
        
        Label lblPassword = new Label("Password"); // Creates a 'Label' obeject
        grid.add(lblPassword, 0,2); //Adds the Label object to our GridPane
        
        PasswordField passwordField = new PasswordField(); //cretates a new 'Password Field ' object.
        grid.add(passwordField, 1, 2); //Adds the Label object to our GridPane
        
        final Text actionText = new Text(); // Creates a new 'Password Field' object
        grid.add(actionText, 1, 6); //Adds the Text object to our GridPane
        
        Button btnLogIn = new Button("Log In"); //Creates a new button object and sets the text TO 'Sign in'
        grid.add(btnLogIn, 1, 5); //adds the Buttion to our GridPane
        
        GridPane.setHalignment(btnLogIn, HPos.RIGHT);
        GridPane.setHalignment(txtWelcome, HPos.CENTER);
        
        
        //Set up an event Handler for our buttons
        btnLogIn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e ){
                if(userTextField.getText().equals(username) && passwordField.getText().equals(password)){
                    actionText.setText("Successful Login!");
                    
                    //source
                    //https://o7planning.org/en/11533/opening-a-new-window-in-javafx
                     Label secondLabel = new Label("I'm a Label on new Window");
 
                     StackPane secondaryLayout = new StackPane();
                     secondaryLayout.getChildren().add(secondLabel);
 
                     Scene secondScene = new Scene(secondaryLayout, 230, 100);
 
                     // New window (Stage)
                     Stage newWindow = new Stage();
                     newWindow.setTitle("Menu");
                     newWindow.setScene(secondScene);
 
                     // Set position of second window, related to primary window.
                     newWindow.setX(primaryStage.getX() + 200);
                     newWindow.setY(primaryStage.getY() + 100);
 
                     newWindow.show();
                     //end source
                
                }else{
                    actionText.setText("Incorrect details. Try Again."); //Can we set a counter/loop to only give them 3 attempts?
                }
            }      
        });

    Scene scene = new Scene(grid, 500, 300); //Create our scene, add our pane, and define dimensions.
    primaryStage.setTitle("Log In"); //Sets the stage title
    primaryStage.setScene(scene);// adds the scene to the stage
    primaryStage.show(); //show the stage
    
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

