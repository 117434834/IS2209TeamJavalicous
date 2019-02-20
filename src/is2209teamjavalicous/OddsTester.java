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
    
    int intInput1 = 0, intInput2 =0, intInput3 = 0, intInputTotal = 0;
    double dblOutput1 = 0, dblOutput2 = 0, dblOutput3 = 0, dblOutputTotal = 0;
    boolean blnSuccess = false;
    
    public void calculateTotalInputOutput() {
        //Use this to calculate total input and output
        dblOutputTotal = dblOutput1 + dblOutput2 + dblOutput3;
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
    public void testOdds(int intOddsFirstNum1, int intOddsFirstNum2, 
            int intOddsFirstNum3,int intOddsSecondNum1,int intOddsSecondNum2,
            int intOddsSecondNum3, int intLowerBound, int intUpperBound){
        
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
                    
                    calculateTotalInputOutput();
                    
                    if (dblOutputTotal > intInputTotal){
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
        
    }
    }
    
    



