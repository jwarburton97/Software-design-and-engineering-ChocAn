/**
 * @author Charity Brown.
 * @version 1.0.
 */

import java.io.*; 
import java.util.Scanner;

/** This class is designed to be an interface for the Manager. */
public class ManagerTerminal {
 MemberList mList2;
 ProviderList pList2;
 ServiceController serviceList;
 
 /** Constructor for the Manager Terminal. */
 public ManagerTerminal(MemberList mList, ProviderList pList, ServiceController sList)
 {
   mList2 = mList;
  pList2 = pList;
  serviceList = sList;
 } 
 /** This function gives the Manager the options to Generate a Member, Provider, or Summary Report. */
 public void run(){
    
   
  int option = 0;
     StringBuilder menu = new StringBuilder();
     menu.append("\t\t\t\t--Manager Terminal--\n\n");
     menu.append("Options are the following : \n");
     menu.append("Enter 0 to exit\n");
     menu.append("Enter 1 to Generate a Member Report\n");
     menu.append("Enter 2 to Generate a Provider Report\n");
     menu.append("Enter 3 to Generate a Summary Report\n");
     
     GenerateReports report = new GenerateReports(mList2, pList2, serviceList);
     if(mList2.isEmpty()){
      System.out.println("No members exist. Exiting... ");
    return;
     }
     if(pList2.isEmpty()){
      System.out.println("No providers exist. Exiting... ");
    return;
     }
     if(serviceList.isEmpty()){
      System.out.println("No providers exist. Exiting... ");
      return;
     }
     do {

      System.out.println(menu.toString());
      Scanner sc=new Scanner(System.in);
     option = sc.nextInt();
     

    
     if (option == 1) {
      System.out.println("Enter Member's ID Number: ");
      int memberID = sc.nextInt();
      report.generateMemberReport(memberID);
     }
     else if (option == 2) {
      System.out.println("Enter Provider's ID Number: ");
      int providerID = sc.nextInt();
      report.generateProviderReport(providerID);
     }
     else if (option == 3) {
      report.generateSummaryReport();
     }
     
      
   }while(option!=0);  
 
 }
 public MemberList getMemberList() {
     return mList2;
    }
    
    public ProviderList getProviderList() {
     return pList2;
    }
    public ServiceController getServiceList()
    {
     return serviceList;
    }
}


