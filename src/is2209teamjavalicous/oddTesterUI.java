
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is2209teamjavalicous;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


/**
 *
 * @author Jacques
 */
public class oddTesterUI {
    
    public Scene show() {
        
        //Gridpane
        GridPane gridOddsTester = new GridPane();
        gridOddsTester.setAlignment(Pos.CENTER);
        
        //Labels
        Label lblHome = new Label("Home Odds:");
        gridOddsTester.add(lblHome, 1, 2);
        
        Label lblDraw = new Label("Draw Odds:");
        gridOddsTester.add(lblDraw, 1, 3);
        
        Label lblAway = new Label("Away Odds:");
        gridOddsTester.add(lblAway, 1, 4);
        
        Label lblHomeSlash = new Label("/");
        gridOddsTester.add(lblHomeSlash, 3, 2);
        
        Label lblDrawSlash = new Label("/");
        gridOddsTester.add(lblDrawSlash, 3, 3);
        
        Label lblAwaySlash = new Label("/");
        gridOddsTester.add(lblAwaySlash, 3, 4);
        
        Label lblUpperBound = new Label("Upper Bound:");
        gridOddsTester.add(lblUpperBound, 6,2);
        
        Label lblLowerBound = new Label("Lower Bound:");
        gridOddsTester.add(lblLowerBound,6,3);
        
        //Text fields
        TextField txtHomeFirstNum = new TextField();
        gridOddsTester.add(txtHomeFirstNum, 2,2);
        
        TextField txtHomeSecondNum = new TextField();
        gridOddsTester.add(txtHomeSecondNum, 4,2);
        
        TextField txtDrawFirstNum = new TextField();
        gridOddsTester.add(txtDrawFirstNum, 2,3);
        
        TextField txtDrawSecondNum = new TextField();
        gridOddsTester.add(txtDrawSecondNum, 4,3);
        
        TextField txtAwayFirstNum = new TextField();
        gridOddsTester.add(txtAwayFirstNum, 2,4);
        
        TextField txtAwaySecondNum = new TextField();
        gridOddsTester.add(txtAwaySecondNum, 4,4);
        
        TextField txtUpperBound = new TextField();
        gridOddsTester.add(txtUpperBound, 7, 2);
        
        TextField txtLowerBound = new TextField();
        gridOddsTester.add(txtLowerBound, 7, 3);
        
        //Button
        Button btnTest = new Button();
        btnTest.setText("Test odds");
        
        OddsTester testObject = new OddsTester();
        btnTest.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                testObject.testOdds(Integer.parseInt(txtHomeFirstNum.getText()),
                        Integer.parseInt(txtDrawFirstNum.getText()),
                        Integer.parseInt(txtAwayFirstNum.getText()),
                        Integer.parseInt(txtHomeSecondNum.getText()),
                        Integer.parseInt(txtDrawSecondNum.getText()),
                        Integer.parseInt(txtAwaySecondNum.getText()),
                        Integer.parseInt(txtUpperBound.getText()),
                        Integer.parseInt(txtLowerBound.getText())  );
            }
        });
        
        gridOddsTester.add(btnTest, 2, 6);
        
        Scene scene = new Scene(gridOddsTester);
        
        return scene;
    }
    
    

    
    
}
