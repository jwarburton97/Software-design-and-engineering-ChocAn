/**
 * @author Charity Brown.
 * @version 1.0.
 */
 

import java.io.*;
import java.util.ArrayList;

/** This class generates either an individual Member, Provider, Summary Report, or either all Reports. It can be accessed by either Operator or Manager. */
public class GenerateReports {
 MemberList memberList;
 ProviderList providerList;
 ServiceController service;
 
 /** Prints to Console an individual Member Report based on the Member idNumber passed in. */
 public void generateMemberReport(int idNumber) {
  /** Searches the List of Members inside of the MemberList class for the desired Member object. */
  Member member = memberList.searchList(idNumber);          
  ArrayList<Member> array = memberList.getList();
                       
  int size = array.size();               
  /** Prints out Member Report with Member Name, Number, Address, and all Services. */
        System.out.println("Member Name: " + member.getName());
        System.out.println("Member Number: " + idNumber);
        member.displayAddress();
       
        for(int i = 0; i < size; i++) {
         Member currentMember = array.get(i);
         currentMember.displayRecord(); 
         System.out.println(" ");
        }
    }
 /** Prints to Console an individual Provider Report based on the Provider idNumber passed in. */
 public void generateProviderReport(int idNumber) {
  /** Searches the List of Providers inside of the ProviderList class for the desired Provider object. */
        Provider provider = providerList.searchList(idNumber);
        
        /** Prints out Provider Report with Member Name, Number, Address, and all Services Provided. */
        System.out.println("Provider Name: " + provider.getName());
        System.out.println ("Number: " + provider.getNumber());
        provider.displayAddress();
        provider.displayRecord();
        ArrayList<Provider> record = providerList.getList();
        int consultations = record.size();
        
        /** Calls on the EFT Class to generate EFT Data for the Provider. */
        EFT eft = new EFT();
        eft.writeEFT(provider.getName(), idNumber, (double)provider.getFee()); 
        System.out.println("Total Consultations: " + consultations);
 }
 /** Prints to Console a Summary Report. */
 public void generateSummaryReport() {
        String name = " ";
        int idNum = 0;
        int totalConsultations = 0;
        double total = 0.00;
        double weeklyFee = 0.00;

   
        System.out.println("Summary Report");
        System.out.println("_______________________________________________________________");
        System.out.println("EFT Data: ");
/** Walks through the Provider List to print out each Provider's information. */
        try {
         String line = null;
         ArrayList<Provider> array;
         array = providerList.getList();
         int size = array.size();
            // Walk through list of EFT Data
         for(int i = 0; i < size; i++) {
          /** Sets current provider. */
          Provider currentProvider = array.get(i);
          /** Grabs array of Service records for individual provider (in class "Provider.java" to calculate number of consultations. */
          ArrayList<ServiceRecord> record;
          record = currentProvider.getRecord();
          totalConsultations = record.size() + totalConsultations;
          
             /** Opens EFT file per individual Provider. */        
          FileReader fileReader =  new FileReader(array.get(i).getName() + ".txt");

          /** Wraps FileReader in BufferedReader. */
          BufferedReader bufferedReader =  new BufferedReader(fileReader);

          /** Read file until it has not reached end of file. */
          while((line = bufferedReader.readLine()) != null) {
           /** Set the following values. */
           name = line;
           idNum = bufferedReader.read();
           weeklyFee = bufferedReader.read();
           total = weeklyFee + total;
           /** If the account is payable add EFT data to Summary Report. */
           if(weeklyFee > 0) {  
            System.out.println(name);
            System.out.println(idNum);
            System.out.println("$" + weeklyFee); 
            System.out.println(" ");
                   }
          } 
          /** Closes file. */
          bufferedReader.close();
         }
         System.out.println("Total Number of Providers: " + size );
         System.out.println("Number of Consultations: " + totalConsultations); 
         System.out.println("Overall fees: $" + total); 
        }    
        catch(FileNotFoundException ex) {
         System.out.println(
            "File not found " );                
        }
        catch(IOException ex) {
         ex.printStackTrace();
        }
}
 /** Prints to console all Member, Provider and Summary Reports. */
 public void generateAll() {  // Timer or Operator  Friday @ Midnight
        /** Prints all Member Reports. */
        System.out.println("All Member Reports");
        System.out.println("_______________________________________________________________");
        memberList.displayList();
        System.out.println(" ");

        /**Prints all Provider Reports. */
        System.out.println("All Provider Reports");
        System.out.println("_______________________________________________________________");
        providerList.displayList();
        System.out.println(" ");

        /** Prints Summary Report. */
        System.out.println("Summary Report");
        System.out.println("_______________________________________________________________");
        generateSummaryReport();
        System.out.println(" ");

}
 /** Constructor for GenerateReports Class. */
 public GenerateReports (MemberList mList, ProviderList pList, ServiceController sList) {
  memberList = mList;
  providerList = pList;
  service = sList;
 }

}
