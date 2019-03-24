import java.util.Scanner;

/**
 * @author Antonio Morgan
 */

public class OperatorTerminal {
    private MemberList memberList;
    private ProviderList providerList;
    private ServiceController serviceList;
    
    /**
     * The main function of the operator terminal.
     * This lets the user input a selection to choose which function to execute and whether to generate a report or
     * add/update/delete members or providers.
     */
    
    public void start() {
        int selection = 0;

        StringBuilder menu = new StringBuilder();
        menu.append("\t\t\t\t--Operator Terminal--\n\n");
        menu.append("Possible options: \n");
        menu.append("0. Exit\n");
        menu.append("1. Add Member\n");
        menu.append("2. Update Member\n");
        menu.append("3. Delete Member\n");
        menu.append("4. Add Provider\n");
        menu.append("5. Update Provider\n");
        menu.append("6. Delete Provider\n");
        menu.append("7. Generate Report\n\n");

        do {
         Scanner input = new Scanner(System.in);
            System.out.println(menu.toString());

            System.out.print("Enter your choice: ");
            selection = input.nextInt();
            while (!(selection >= 0 && selection <= 7)) {
                System.out.print("Invalid choice. Try again: ");
                selection = input.nextInt();
            }
            switch(selection){
                case 1:
                    addMember();
                    break;
                case 2:
                    updateMember();
                    break;
                case 3:
                    deleteMember();
                    break;
                case 4:
                    addProvider();
                    break;
                case 5:
                    updateProvider();
                    break;
                case 6:
                    deleteProvider();
                    break;
                case 7:
                    generateReport();
                    break;
                default:
                 break;
            }
            
        } while (selection != 0);
    }

    /**
     * Adds a new member
     * 
     */
    private void addMember() {
        Scanner intSC = new Scanner(System.in);
        Scanner stringSC = new Scanner(System.in);
        
        System.out.println("--Adding new member--\n");
        
        System.out.print("Enter Member Number (9 digits): ");
        int memberNumber = intSC.nextInt();

        while(memberList.checkNum(memberNumber) || memberNumber > 999999999 || memberNumber < 100000000){
            if (memberNumber > 999999999 || memberNumber < 100000000){
                System.out.print("Invalid number. Try again: ");
                memberNumber = intSC.nextInt();
            } else {
                System.out.print("Number is already taken. Try again: ");
                memberNumber = intSC.nextInt();
            }
        }

        System.out.print("Enter member name: ");
        String memberName = stringSC.nextLine();
        while (memberName.length() > 25){
            System.out.print("Name must be under 25 characters. Try again: ");
            memberName = stringSC.nextLine();
        }
        
        System.out.println("Enter address below: \n");

        System.out.print("Street Address: ");
        String streetAddress = stringSC.nextLine();
        while (streetAddress.length() > 30){
            System.out.print("Street address has to be under 30 characters. Try again: ");
            streetAddress = stringSC.nextLine();
        }

        System.out.print("City: ");
        String city = stringSC.nextLine();
        while (city.length() > 20){
            System.out.print("City must be under 20 characters. Try again: ");
            city = stringSC.nextLine();
        }

        System.out.print("State (abbreviated): ");
        String state = stringSC.nextLine();
        while (state.length() != 2){
            System.out.print("State must be 2 characters. Try again: ");
            state = stringSC.nextLine();
        }

        System.out.print("Zip Code: ");
        int zip = intSC.nextInt();
        while (zip > 99999 || zip < 10000){
            System.out.print("Zip code must be 5 digits. Try again: ");
            zip = intSC.nextInt();
        }

        Address address = new Address(streetAddress, city, state, zip);
        Member newMember = new Member(memberName, memberNumber, address);
        memberList.addMember(newMember);
        System.out.println("\n" + newMember.getName() + " has been registered as a new member.");
        
        
    }

    /**
     * Updates an existing member
     */
    private void updateMember() {
        Scanner intSC = new Scanner(System.in);
        Scanner stringSC = new Scanner(System.in);
        memberList.displayList();
        System.out.println("--Updating member--\n");
        
        System.out.print("Enter the number of the member to update (0 to quit): ");
        int memberNumber = intSC.nextInt();

        while(!memberList.checkNum(memberNumber)) {
         if(memberNumber == 0) return;
            System.out.print("Invalid number. Try again (0 to quit): ");
            memberNumber = intSC.nextInt();
        }

        Member member = memberList.searchList(memberNumber);

        int selection = 0;

        StringBuilder menu = new StringBuilder();
        menu.append("Please select an item to update:\n");
        menu.append("0.  Exit\n");
        menu.append("1.  Name\n");
        menu.append("2.  Member Number\n");
        menu.append("3.  Address\n");
        menu.append("4.  Membership Status\n");

        do {
            System.out.println("Editing information for: \n");
            System.out.println(member.toString() + "\n");
            System.out.println(menu.toString());

            System.out.print("Enter your selection: ");
            selection = intSC.nextInt();
            while (!(selection >= 0 && selection <= 4)) {
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
                    member.setName(newName);
                    break;
                case 2:
                    System.out.print("Enter new member number: ");
                    int newNumber = intSC.nextInt();
                    while (memberList.checkNum(newNumber) || newNumber > 999999999 || newNumber < 100000000) {
                        if (newNumber > 999999999 || newNumber < 100000000) {
                            System.out.print("Invalid number. Try again: ");
                            newNumber = intSC.nextInt();
                        } else {
                            System.out.print("Number is already taken. Try again: ");
                            newNumber = intSC.nextInt();
                        }
                    }
                    member.setNum(newNumber);
                    break;
                case 3:
                    System.out.println("Enter updated address below: \n");

                    System.out.print("Street Address: ");
                    String streetAddress = stringSC.nextLine();
                    while (streetAddress.length() > 30) {
                        System.out.print("Street address must be under 30 characters. Try again: ");
                        streetAddress = stringSC.nextLine();
                    }

                    System.out.print("City: ");
                    String city = stringSC.nextLine();
                    while (city.length() > 20) {
                        System.out.print("City must be under 20 characters.");
                        city = stringSC.nextLine();
                    }

                    System.out.print("State (abbreviated): ");
                    String state = stringSC.nextLine();
                    while (state.length() != 2) {
                        System.out.print("State must be 2 characters. Try again: ");
                        state = stringSC.nextLine();
                    }

                    System.out.print("Zip Code: ");
                    int zip = intSC.nextInt();
                    while (zip > 99999 || zip < 10000)  {
                        System.out.print("Zip code must be 5 digits. Try again: ");
                        zip = intSC.nextInt();
                    }

                    Address address = new Address(streetAddress, city, state, zip);
                    member.setAddress(address);
                    break;
                case 4:
                    System.out.print("Enter member status (1 = Valid, 0 = Invalid): "); 
                    int valid = intSC.nextInt();
                    while (valid > 1 || valid < 0) {
                        System.out.print("Invalid choice. Try again: ");
                        valid = intSC.nextInt();
                    }
                    if(valid == 0) {
                        member.setMemberStatus(true);
                    } else {
                        member.setMemberStatus(false);
                    }
                    break;
            }
            memberList.updateMember(memberNumber, member);
        } while (selection != 0);
        
       
    }
    
    /**
     * Deletes an existing member
     * 
     */
    private void deleteMember() {
        Scanner intSC = new Scanner(System.in);
        Scanner stringSC = new Scanner(System.in);
        memberList.displayList();
        System.out.println("--Deleting member--\n");
        
        System.out.print("Enter the number of the member to delete (0 to quit): ");
        int memberNumber = intSC.nextInt();
        while(!memberList.checkNum(memberNumber)) {
         if(memberNumber == 0) return;
            System.out.print("Invalid number. Try again (0 to quit): ");
            memberNumber = intSC.nextInt();
        }

        Member member = memberList.searchList(memberNumber);
        if (member != null){
            System.out.println("You are about to remove " + member.getName() + " from the member database.");
            System.out.println("Are you sure yout want to delete this member? (1 = Yes, 0 = No) ");
            int ans = intSC.nextInt();
            while (ans > 1 || ans < 0) {
                System.out.print("Invalid choice. Try again: ");
                ans = intSC.nextInt();
            }
            if (ans == 1){
                memberList.deleteMember(memberNumber);
                System.out.println("\n" + member.getName() + " has been removed.");
            } else {
                System.out.println("\nOperation canceled.");
            }
        }
        else System.out.println("No member with that number exists.");
        
        
    }
    /**
     * Adds a new provider
     * 
     */
    public void addProvider() {
        Scanner intSC = new Scanner(System.in);
        Scanner stringSC = new Scanner(System.in);
        
        System.out.println("--Adding new provider--\n");
        
        System.out.print("Enter provider number (9 digits): ");
        int providerNumber = intSC.nextInt();

        while(providerList.checkNum(providerNumber) || providerNumber > 999999999 || providerNumber < 100000000) {
            if (providerNumber > 999999999 || providerNumber < 100000000){
                System.out.print("Invalid number. Try again: ");
                providerNumber = intSC.nextInt();
            } else {
                System.out.print("Number is already taken. Try again: ");
                providerNumber = intSC.nextInt();
            }
        }

        System.out.print("Enter name: ");
        String providerName = stringSC.nextLine();
        while (providerName.length() > 25){
            System.out.print("Name must be under 25 characters. Try again: ");
            providerName = stringSC.nextLine();
        }
        
        System.out.print("Enter cost of service: ");
        double fee = intSC.nextDouble();
        while (fee > 500 || fee < 0) {
            System.out.print("Fee must be less than $500.00. Try again: ");
            fee = intSC.nextDouble();
        }
        
        System.out.println("Enter address below: \n");


        System.out.print("Street Address: ");
        String streetAddress = stringSC.nextLine();
        while (streetAddress.length() > 25){
            System.out.print("Street address must be under 25 characters. Try again: ");
            streetAddress = stringSC.nextLine();
        }

        System.out.print("City: ");
        String city = stringSC.nextLine();
        while (city.length() > 14) {
            System.out.print("City must be under 14 characters. Try again: ");
            city = stringSC.nextLine();
        }

        System.out.print("State (abbreviated): ");
        String state = stringSC.nextLine();
        while (state.length() != 2){
            System.out.print("State must be 2 characters. Try again: ");
            state = stringSC.nextLine();
        }

        System.out.print("Zip Code: ");
        int zip = intSC.nextInt();
        while (zip > 99999 || zip < 10000){
            System.out.print("Zip code must be 5 digits. Try again: ");
            zip = intSC.nextInt();
        }

        Address address = new Address(streetAddress, city, state, zip);
        Provider provider = new Provider(providerName, providerNumber, fee, address);
        providerList.addProvider(provider);
        System.out.println("\n" + provider.getName() + " has been added as a new provider.");
        
        
    }

    /**
     * Updates an existing provider
     * 
     */
    private void updateProvider() {
        Scanner intSC = new Scanner(System.in);
        Scanner stringSC = new Scanner(System.in);
        providerList.displayList();
        System.out.println("--Updating provider--\n");
        
        System.out.print("Enter number of the provider to update (0 to quit): ");
        int providerNumber = intSC.nextInt();

        while(!providerList.checkNum(providerNumber)) {
         if(providerNumber == 0) return;
            System.out.print("Invalid number. Try again (0 to quit): ");
            providerNumber = intSC.nextInt();
        }

        Provider provider = providerList.searchList(providerNumber);

        int selection = 0;

        StringBuilder menu = new StringBuilder();
        menu.append("Select an attribute to update:\n");
        menu.append("0.  Exit\n");
        menu.append("1.  Name\n");
        menu.append("2.  Provider Number\n");
        menu.append("3.  Address\n");

        do {
            System.out.println("Editing provider information for: \n");
            System.out.println(provider.toString() + "\n\n");
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
                    provider.setName(newName);
                    break;
                case 2:
                    System.out.print("Enter new provider number (9 digits): ");
                    int newNumber = intSC.nextInt();
                    while (providerList.checkNum(newNumber) || newNumber > 999999999 || newNumber < 100000000) {
                        if (newNumber > 999999999 || newNumber < 100000000) {
                            System.out.print("Invalid number. Try again: ");
                            newNumber = intSC.nextInt();
                        } else {
                            System.out.print("Number is already taken. Try again: ");
                            newNumber = intSC.nextInt();
                        }
                    }
                    provider.setNumber(newNumber);
                    break;
                case 3:
                    System.out.println("Enter updated address: \n");

                    System.out.print("Street Address: ");
                    String streetAddress = stringSC.nextLine();
                    while (streetAddress.length() > 25) {
                        System.out.print("Street address must be under 25 characters. Try again: ");
                        streetAddress = stringSC.nextLine();
                    }

                    System.out.print("City: ");
                    String city = stringSC.nextLine();
                    while (city.length() > 14) {
                        System.out.print("City must be under 14 characters. Try again: ");
                        city = stringSC.nextLine();
                    }

                    System.out.print("State (abbreviated): ");
                    String state = stringSC.nextLine();
                    while (state.length() != 2) {
                        System.out.print("State must be 2 characters. Try again: ");
                        state = stringSC.nextLine();
                    }

                    System.out.print("Zip Code: ");
                    int zip = intSC.nextInt();
                    while (zip > 99999 || zip < 10000) {
                        System.out.print("Zip code must be 5 digits. Try again: ");
                        zip = intSC.nextInt();
                    }

                    Address address = new Address(streetAddress, city, state, zip);
                    provider.setAddress(address);
                    break;
            }
            providerList.updateProvider(providerNumber, provider);

        } while (selection != 0);
        
      
    }

    /**
     * Deletes an existing provider from the provider list
     * 
     */
    private void deleteProvider() {
        Scanner intSC = new Scanner(System.in);
        Scanner stringSC = new Scanner(System.in);
        providerList.displayList();
        System.out.println("--Deleting provider--\n");
        
        System.out.print("Enter number of the provider to delete (0 to quit): ");
        int providerNumber = intSC.nextInt();
        while(!providerList.checkNum(providerNumber)) {
         if(providerNumber == 0) return;
            System.out.print("Invalid number. Try again (0 to quit): ");
            providerNumber = intSC.nextInt();
        }
        
        Provider provider = providerList.searchList(providerNumber);
        if (provider != null) {
            System.out.println("\nYou are about to remove " + provider.getName() + " from the provider database.");
            System.out.println("Are you sure yout want to delete this member? (1 = Yes, 0 = No) ");
            int ans = intSC.nextInt();
            while (ans > 1 || ans < 0) {
                System.out.print("Invalid choice. Try again: ");
                ans = intSC.nextInt();
            }
            if (ans == 1){
                providerList.deleteProvider(providerNumber);
                System.out.println("\n" + provider.getName() + " has been removed.");
            } else {
                System.out.println("\nOperation canceled.");
            }
        } else {
            System.out.println("No provider with that number exists.");
        }
        
    }
    
    /**
     *  Prints the specified report to the terminal window or to a file
     * 
     */
    private void generateReport() {
     GenerateReports report = new GenerateReports(memberList, providerList, serviceList);
        Scanner intSC = new Scanner(System.in);
        Scanner stringSC = new Scanner(System.in);
        StringBuilder menu = new StringBuilder();
        
        menu.append("Select an option: \n");
        menu.append("0.  Exit\n");
        menu.append("1.  Generate Summary Report\n");
        menu.append("2.  Generate All Reports\n");
        menu.append("3.  Generate Provider Report\n");
        menu.append("4.  Generate Member Report\n");

        int selection = 0;
        do {
            System.out.println(menu.toString());
            
            System.out.print("Enter your selection: ");
            selection = intSC.nextInt();
            while (!(selection >= 0 && selection <= 4)) {
                System.out.print("Invalid choice. Try again: ");
                selection = intSC.nextInt();
            }

            switch(selection){
            case 1:
                System.out.println("Printing summary report.\n");
                System.out.println("-----------------------------------------------------");
                
                report.generateSummaryReport();
                break;
            case 2:
                System.out.println("Printing all reports.\n");
                System.out.println("-----------------------------------------------------");
                
                report.generateAll();
                break;
            case 3:
                System.out.print("Enter the provider number: ");
                int providerNumber = intSC.nextInt();
                while(!providerList.checkNum(providerNumber)){
                    System.out.print("Invalid number. Try again: ");
                    providerNumber = intSC.nextInt();
                }
                System.out.println("Printing provider report.\n");
                System.out.println("-----------------------------------------------------");
                
                report.generateProviderReport(providerNumber);
                break;
            case 4:
                System.out.print("Enter the member number: ");
                int memberNumber = intSC.nextInt();
                while(!memberList.checkNum(memberNumber)) {
                    System.out.print("Invalid number. Try again: ");
                    memberNumber = intSC.nextInt();
                }
                
                System.out.println("Printing member report.\n");
                System.out.println("-----------------------------------------------------");

                report.generateMemberReport(memberNumber);
                break;
            }
        } while (selection != 0);
        
       
    }
    
    /**
     * allows any changes to the member, provider or service lists to persist upon closing the operator terminal but not beyond
     * the termination of the program as a whole.
     * @return memberList, providerList, serviceList
     */
    
    public MemberList getMemberList() {
     return memberList;
    }
    
    public ProviderList getProviderList() {
     return providerList;
    }
    public ServiceController getServiceList() {
     return serviceList;
    }
    
    /**
     * Operator terminal constructor
     * @param mList
     * @param pList
     * @param sList
     */
    
    public OperatorTerminal(MemberList mList, ProviderList pList, ServiceController sList) {
     memberList = mList;
     providerList = pList;
     serviceList = sList;
    }
}
