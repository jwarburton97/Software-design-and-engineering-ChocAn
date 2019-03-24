/**
 * @author Andrew Letterle
 * @version 1.0.
 */

import java.io.*;

/** This class generates EFT data from the information passed in from the GenerateReports class. */
public class EFT {
 /** EFT class Constructor. */
 public EFT() {
  
 }
 public void writeEFT(String providername, int number,  double weeklyfee){
 
  String name = providername;
  
  try {
   /** Creates a new file by the name of the Provider. */
   FileWriter file = new FileWriter(name+".txt" , true);
   
   /** Wraps FileReader in BufferedReader. */
   BufferedWriter bufferedWriter =
                new BufferedWriter(file);
   
   /** Prints to file provider name, provider idNumber, provider weekly fee. */
            bufferedWriter.write(providername);
            bufferedWriter.newLine();
            bufferedWriter.write(new Integer(number).toString());
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(weeklyfee));
            bufferedWriter.newLine();
            /** Closes File. */
            bufferedWriter.close();
  }
   catch(IOException ex) {
    /** Error Message. */
             ex.printStackTrace();
             
            }
        }
}
