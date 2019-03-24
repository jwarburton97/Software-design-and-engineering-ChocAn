
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jonathan Warburton
 *
 */
public class ProviderTerminal{
    Scanner scanner = new Scanner(System.in);
    ProviderList providerController = new ProviderList();;
    ServiceController serviceController = new ServiceController();
    MemberList memberController = new MemberList();
    Provider prov;
    Service serve;
    Member mem;
    
    /**
     * This constructor passes the lists of services, providers, and members allowing them
     * to persist through the programs execution as we move in and out of the terminal
     * @param MemberList ProviderList ServiceController
     */
   
    public ProviderTerminal(MemberList mList, ProviderList pList, ServiceController sList)
   {
	   memberController = mList;
	   providerController = pList;
	   serviceController = sList;
    }
   /**
    * This is the main function of the provider terminal, it is what executes when the main function calls it.
    * Takes no parameters
    */
   
    public void run() {
        int selection = 0;
		
		StringBuilder menu = new StringBuilder();
        menu.append("\t\t\t\t--Provider Terminal--\n\n");
        menu.append("Possible options: \n");
        menu.append("0. Exit\n");
        menu.append("1. Add Service\n");
        menu.append("2. Update Service\n");
        menu.append("3. Delete Service\n");
        menu.append("4. Bill ChocAn\n");
        menu.append("5. Request Service Directory\n");
      
        /**
         * The above menu displays the available functions that the terminal can execute using the selection 
         * method in the do while loop below. 
         */
        
        do {
			Scanner scan = new Scanner(System.in);
			System.out.println(menu.toString());
            selection = scan.nextInt();            
            if (selection == 1) {
               addService();
            }
            else if(selection == 2){
                updateService();
            }
			else if(selection == 3){
                deleteService();
            }
			else if(selection == 4){
                billChocAn();
            }
			else if(selection == 5){
                requestProviderDirectory();
            }
             
        } while (selection != 0);
        
    }

    /**
     * Prompt for provider to bill ChocAn
     * Requires user input and requires members, providers, and services to exist before it can execute.
     */
     private void billChocAn(){
        Scanner memberId = new Scanner(System.in);
		Scanner provide = new Scanner(System.in);
		Scanner serviceId = new Scanner(System.in);
		Scanner stringSC = new Scanner(System.in);
		if(memberController.isEmpty()){
			System.out.println("No members exist to Bill. Exiting... ");
			return;
		}
		if(providerController.isEmpty()){
			System.out.println("No providers exist. Exiting... ");
			return;
		}
		if(serviceController.isEmpty()){
			System.out.println("No services exist. Exiting... ");
			return;
		}
        System.out.println("Billing for a service.  Please complete the information below. \n");
        System.out.println("Enter Member ID: ");
        int member = memberId.nextInt();
        int length = Integer.toString(member).length();
        while (length!=9){
            System.out.println("Error: Member IDs must be 9 digits long, try again!");
            member = memberId.nextInt();
        }
        while(!memberController.checkNum(member))
        {
            System.out.println("Invalid number. Try again!");
            member = memberId.nextInt();
        }        
        mem = memberController.searchList(member);
        
        System.out.println("Enter Provider ID: ");
        int provider = provide.nextInt();
        while (length!=9){
            System.out.println("Error: Provider IDs must be 9 digits long, try again!");
            provider = provide.nextInt();
        }
        while(!providerController.checkNum(provider))
        {
			System.out.println("No Provider found by that ID. Please try again!");
			provider = provide.nextInt();	
		}
        prov = providerController.searchList(provider);
        
        System.out.print("Date provided (MM-dd-yyyy): ");
        String date = stringSC.nextLine();
        
        System.out.println("Enter Service ID: ");
        int serviceID = serviceId.nextInt();
        while (!serviceController.checkNum(serviceID)) {
            System.out.println("A service with that number does not exist. Try again!");
            serviceID = serviceId.nextInt();
        }
        serve = serviceController.searchList(serviceID);    
        
        System.out.println("Provided service: " + serve.getName()); 
        System.out.print("Comments (<= 100 characters): ");
        String comment = provide.nextLine();
        while (comment.length() > 100){
        	System.out.print("Comment too long, please try again: ");
            comment = provide.nextLine();
        }
        System.out.println("The fee to be paid for this service is " + serve.printCost() + ".\n");
        ServiceRecord record = new ServiceRecord(mem, prov, serve, serve.getCost(), date, comment);
        prov.addRecordForWeek(record);
        mem.addRecordsForWeek(record);
        
        
    }
    /**
     * Print the provider directory to the screen
     */
    private void requestProviderDirectory() {
        System.out.println("\t   Service Directory\n\n");
        System.out.println("Service Name                      Code\n");
        System.out.println("----------------------------------------\n");  
              
       ArrayList <Service> serviceList = serviceController.getServiceList();
        
       for (int i=0; i < serviceList.size(); i++)
    	   System.out.println(i+1 + ". " + serviceList.get(i).getName() + "\t\t" + serviceList.get(i).getId());
       
    }
    /**
     * This method adds a service to the list of services that the provider can provide.
     * Takes no parameters but input is taken and parsed through the function itself.
     */
    
	private void addService() {
		Scanner intSC = new Scanner(System.in);
		Scanner stringSC = new Scanner(System.in);
		
		System.out.println("--Adding new service--\n");
		
		System.out.print("Enter service number (9 digits)");
		int serviceNumber = intSC.nextInt();
		
		while(serviceController.checkNum(serviceNumber) || serviceNumber > 999999999 || serviceNumber <100000000)
		{
			if(serviceNumber > 999999999 || serviceNumber < 100000000)
			{
				System.out.println("Invalid number. Try again: ");
				serviceNumber = intSC.nextInt();
			}
			else
			{
				System.out.println("Number is already taken. Try again: ");
				serviceNumber = intSC.nextInt();
			}
		}
		System.out.print("Enter name: ");
        String serviceName = stringSC.nextLine();
        while (serviceName.length() > 25){
            System.out.print("Name must be under 25 characters. Try again: ");
            serviceName = stringSC.nextLine();
        }
        
        System.out.print("Enter cost of service: ");
        float fee = intSC.nextFloat();
        while (fee > 500 || fee < 0) {
            System.out.print("Fee must be less than $500.00. Try again: ");
            fee = intSC.nextFloat();
        }
		Service service = new Service(serviceNumber, serviceName, fee);
		serviceController.addService(service);
        System.out.println("\n" + service.getName() + " has been added as a new service.");
        
       
	}
	
	/**
	 * This method requires a service to exist to execute but then when prompted, will
	 * open a menu allowing you to select what about a service, from its service ID,
	 * you wish to change. This could be the name of the service, the cost, or the ID itself.
	 */
	
	private void updateService() {
        Scanner intSC = new Scanner(System.in);
        Scanner stringSC = new Scanner(System.in);
        if(serviceController.isEmpty()){
			System.out.println("No services exist. Exiting... ");
			return;
		}
        System.out.println("--Updating service--\n");
        
        System.out.print("Enter the number of the service to update: ");
        int serviceNumber = intSC.nextInt();

        while(!serviceController.checkNum(serviceNumber)) {
            System.out.print("Invalid number. Try again: ");
            serviceNumber = intSC.nextInt();
        }

        Service service = serviceController.searchList(serviceNumber);

        int selection = 0;

        StringBuilder menu = new StringBuilder();
        menu.append("Please select an item to update:\n");
        menu.append("0.  Exit\n");
        menu.append("1.  Name\n");
        menu.append("2.  Service Number\n");
        menu.append("3.  Service Cost\n");

        do {
            System.out.println("Editing information for: " + service.getName() + "\n");
            System.out.println(menu.toString());

            System.out.print("Enter your selection: ");
            selection = intSC.nextInt();
            while (!(selection >= 0 && selection <= 3)) {
                System.out.print("Invalid choice. Try again: ");
                selection = intSC.nextInt();
            }

            switch(selection){
                case 1:
                    System.out.print("Enter new name: ");
                    String newName = stringSC.nextLine();
                    while (newName.length() > 25) {
                        System.out.print("Name must be under 25 characters. Try again: ");
                        newName = stringSC.nextLine();
                    }
                    service.setName(newName);
                    break;
                case 2:
                    System.out.print("Enter new service number: ");
                    int newNumber = intSC.nextInt();
                    while (serviceController.checkNum(newNumber) || newNumber > 999999999 || newNumber < 100000000) {
                        if (newNumber > 999999999 || newNumber < 100000000) {
                            System.out.print("Invalid number. Try again: ");
                            newNumber = intSC.nextInt();
                        } else {
                            System.out.print("Number is already taken. Try again: ");
                            newNumber = intSC.nextInt();
                        }
                    }
                    service.setCode(newNumber);
                    break;
                case 3:
                	System.out.print("Enter new service cost: ");
                    int newCost = intSC.nextInt();
                    while (newCost > 500 || newCost < 0) {
                    	System.out.print("Invalid price. Try again: ");
                    	newCost = intSC.nextInt();
                    }
                    service.setCost(newCost);
                    break;
            }
            serviceController.updateService(serviceNumber, service);
        } while (selection != 0);
    }
	
	/**
	 * This method prompts for the ID of a service you wish to delete and removes it from the list of services
	 * once you confirm your decision to delete it.
	 */
	
	private void deleteService() {
        Scanner intSC = new Scanner(System.in);
        Scanner stringSC = new Scanner(System.in);
        if(serviceController.isEmpty()){
			System.out.println("No services exist. Exiting... ");
			return;
		}
        System.out.println("--Deleting service--\n");
        
        System.out.print("Enter number of the provider to delete: ");
        int serviceNumber = intSC.nextInt();
        while(!serviceController.checkNum(serviceNumber)) {
            System.out.print("Invalid number. Try again: ");
            serviceNumber = intSC.nextInt();
        }
        
        Service service = serviceController.searchList(serviceNumber);
        if (service != null) {
            System.out.println("\nYou are about to remove " + service.getName() + " from the service database.");
            System.out.println("Are you sure yout want to delete this service? (1 = Yes, 0 = No) ");
            int ans = intSC.nextInt();
            while (ans > 1 || ans < 0) {
                System.out.print("Invalid choice. Try again: ");
                ans = intSC.nextInt();
            }
            if (ans == 1){
                serviceController.removeService(serviceNumber);
                System.out.println("\n" + service.getName() + " has been removed.");
            } else {
                System.out.println("\nOperation canceled.");
            }
        } else {
            System.out.println("No service with that number exists.");
        }
        
    }
	
	/**
	 * The three functions below allow the main function to receive any edits to any of the lists
	 * the provider terminal has made.
	 * @return list of members - list of providers - list of services.
	 */
	
    public MemberList getMemberList() {
       	return memberController;
    }
       
    public ProviderList getProviderList() {
       	return providerController;
    }
    public ServiceController getServiceList() {
    	return serviceController;
    }
}
