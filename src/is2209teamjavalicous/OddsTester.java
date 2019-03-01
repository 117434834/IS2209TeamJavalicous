/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is2209teamjavalicous;

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
    
    public void calculateTotalInput() {
        intInputTotal = intInput1 + intInput2 + intInput3;
    }
    
    public double calculateIndividualOutput(int intOddsFirstNum, int intOddsSecondNum, int intInput){
        double dblOutput = 0;
        //If odds are 7/1, input * 7 divided by 1
        dblOutput = (intInput * intOddsFirstNum) / intOddsSecondNum;
        
        //Get our initial bet back too
        dblOutput += intInput;
        
        //Return output
        return dblOutput;
    }
    public boolean testOdds(int intOddsFirstNum1, int intOddsFirstNum2, 
            int intOddsFirstNum3,int intOddsSecondNum1,int intOddsSecondNum2,
            int intOddsSecondNum3, int intLowerBound, int intUpperBound){
        
        blnSuccess = false;
        for (intInput1 = intLowerBound; intInput1<=intUpperBound; intInput1++) {
            //Run our external code
            dblOutput1 = calculateIndividualOutput(intOddsFirstNum1, intOddsSecondNum1, intInput1 );
            
            //Second embedded loop
            for (intInput2 = intLowerBound; intInput2<=intUpperBound; intInput2++) {
                //Run our external code
                dblOutput2 = calculateIndividualOutput(intOddsFirstNum2, intOddsSecondNum2, intInput2 );
                
                //Third embedded loop
                for (intInput3 = intLowerBound; intInput3<=intUpperBound; intInput3++) {
                    //Run our external code
                    dblOutput3 = calculateIndividualOutput(intOddsFirstNum3, intOddsSecondNum3, intInput3);
                    
                    calculateTotalInput();
                    
                    if (dblOutput1 > intInputTotal && 
                            dblOutput2 > intInputTotal && 
                            dblOutput3 > intInputTotal){
                        blnSuccess = true;
                        break;     
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
        
        System.out.println("Input 1: " + intInput1);
        System.out.println("Input 2: " + intInput2);
        System.out.println("Input 3: " + intInput3);
        System.out.println("Output 1:" + dblOutput1);
        System.out.println("Output 2:" + dblOutput2);
        System.out.println("Output 3:" + dblOutput3);
        
        return blnSuccess;
        
        
    }
    }
    
    



