import java.util.Scanner;

/**
 * 
 * @author Andrew Letterle
 *
 */

public class Main {

	/**
	 * Calls the run function which executes the program. 
	 *
	 * @param args
	 */
	
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
    
    /**
     * This function is the true execution of the program.
     * Displays a menu of options in a loop allowing you to execute an option 
     * and return to the menu and make a new selection after you have finished what you had done.
     * This calls the provider terminal, operator terminal, and manager terminal upon request.
     */
    
    public void run() {
    	Scanner scan = new Scanner(System.in);
    	MemberList mList = new MemberList();
    	ProviderList pList = new ProviderList();
    	ServiceController sList = new ServiceController();
        int selection = 0;
        
        do{
            

            System.out.println("Please select a Terminal to Access:\n");
            System.out.println("0.   Exit\n");
            System.out.println("1.   Operator Terminal\n");
            System.out.println("2.   Provider Terminal\n");
            System.out.println("3.   Manager Terminal\n");
            System.out.println("Please enter a valid number: ");
            selection = scan.nextInt();
            
            if(selection == 1) {
                OperatorTerminal terminal1 = new OperatorTerminal(mList, pList, sList);
                System.out.flush();
                terminal1.start();
                mList = terminal1.getMemberList();
                pList = terminal1.getProviderList();
                sList = terminal1.getServiceList();
            }
            else if (selection == 2) {
                ProviderTerminal terminal2 = new ProviderTerminal(mList, pList, sList);
                System.out.flush();
                terminal2.run();
                mList = terminal2.getMemberList();
                pList = terminal2.getProviderList();
                sList = terminal2.getServiceList();
            }
            else if (selection == 3) {
                ManagerTerminal terminal3 = new ManagerTerminal(mList, pList, sList);
                System.out.flush();
                terminal3.run();
                mList = terminal3.getMemberList();
                pList = terminal3.getProviderList();
                sList = terminal3.getServiceList();
            }
        }while (selection != 0);
        System.out.println("Thank you. Now exiting.");
        
       
    }
}

