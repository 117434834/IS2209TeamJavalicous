/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is2209teamjavalicous;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jacques
 */
public class OddsTester {
    
    //Take in variables
    int intInput1, intInput2, intInput3;
    private int intInputTotal;
    private double dblOutput1 , dblOutput2, dblOutput3;
    private boolean blnSuccess = false;
    ObservableList<String> primesArray = FXCollections.observableArrayList();
    
    public void initialisePrimeArray(){
        File primeFile = new File("Primes.txt");
        try{
            Scanner sc = new Scanner(primeFile);
            while (sc.hasNextLine()){
                primesArray.add(sc.nextLine());
            }
        }catch(FileNotFoundException ex){
            System.out.println(ex);
            System.out.println("Primes File not found");
        }
    }
    
    public void calculateTotalInput() {
        intInputTotal = intInput1 + intInput2 + intInput3;
    }
   
    //Use this to input odds and a possible bet and calculate it's output
    public double calculateIndividualOutput(int intOddsFirstNum, int intOddsSecondNum, int intInput){
        double dblOutput = 0;
        //If odds are 7/1, input * 7 divided by 1
        dblOutput = (intInput * intOddsFirstNum) / intOddsSecondNum;
        
        //Get our initial bet back too
        dblOutput += intInput;
        
        //Return output
        return dblOutput;
    }
    
    //This will compare the multiple odds
    public boolean testOdds(int intOddsFirstNum1, int intOddsFirstNum2, 
            int intOddsFirstNum3,int intOddsSecondNum1,int intOddsSecondNum2,
            int intOddsSecondNum3, int intLowerBound, int intUpperBound){
        
        //Initialise the variable
        blnSuccess = false;
        
        //Loop number 1 to test a home win
        for (intInput1 = intLowerBound; intInput1<=intUpperBound; intInput1++) {
            
            //Loop number 2 to test a draw
            for (intInput2 = intLowerBound; intInput2<=intUpperBound; intInput2++) {
                
                //Loop number 3 to test an away win
                for (intInput3 = intLowerBound; intInput3<=intUpperBound; intInput3++) {
                    
                    if((primesArray.contains(Integer.toString(intInput1)))||
                            (primesArray.contains(Integer.toString(intInput2)))||
                            (primesArray.contains(Integer.toString(intInput3)))){
                        
                        //Run our external code to calculate value if home wins
                        dblOutput1 = calculateIndividualOutput(intOddsFirstNum1, intOddsSecondNum1, intInput1 );

                        //Run our external code to calculate if draw 
                        dblOutput2 = calculateIndividualOutput(intOddsFirstNum2, intOddsSecondNum2, intInput2 );

                        //Run our external code to calculate if draw wins
                        dblOutput3 = calculateIndividualOutput(intOddsFirstNum3, intOddsSecondNum3, intInput3);

                        //Find the sum of the inputs and puts it into our variable
                        calculateTotalInput();


                        //Checks if all outputs exceed total input, if so then set boolean to true
                        //and exit the loop
                        if (dblOutput1 > intInputTotal && 
                                dblOutput2 > intInputTotal && 
                                dblOutput3 > intInputTotal){
                            blnSuccess = true;
                            break;     
                        }
                    }
                }//End Third For Loop
            
                //Exit if completed
                if (blnSuccess){
                    break;
                }
            }//End Second For Loop
         
            //Exit if completed
            if (blnSuccess){
                break;
            }
        }//End First For Looop
        
        //Below code for test purposes only!
        System.out.println("Input 1: " + intInput1);
        System.out.println("Input 2: " + intInput2);
        System.out.println("Input 3: " + intInput3);
        System.out.println("Output 1:" + dblOutput1);
        System.out.println("Output 2:" + dblOutput2);
        System.out.println("Output 3:" + dblOutput3);
        System.out.println("Total Input:" + intInputTotal);
        
        //Output to be used later when data is being returned to user, not yet completed
        return blnSuccess;
        
        
    }
    }
    
    



