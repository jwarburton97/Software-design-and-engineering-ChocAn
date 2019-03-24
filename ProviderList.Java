import java.util.ArrayList;


public class ProviderList {
 private ArrayList<Provider> provider;
 
 public ProviderList()
 {
  provider= new ArrayList<Provider>();
 }
 
 public ArrayList<Provider> getList() {
  return provider;
 }
 
 /** This method adds a new provider to the list.*/
 public void addProvider(Provider pro)
 {
  provider.add(pro);
  return;
 }
 
 public boolean checkNum(int number) 
 {
  for (int i = 0; i < provider.size(); i++)
  {
   if (provider.get(i).getNumber()==number)
    return true;
  }
  return false;
 }
 
 /** This method searches for the provider */
 /** Due to the nature for each class there is no way to create a empty address and provider if DNE.*/
 public Provider searchList(int number)
 {
  for(int i=0;i<provider.size();i++)
  {
   if(provider.get(i).getNumber()==number)
   {
    System.out.println("The provider has been found returning infromation.");
    return provider.get(i);
   }
  }
  System.out.println("The provider has not been found returning Error Provider.");
  Address addr= new Address("DNE","DNE","DNE",-1);
  Provider pro= new Provider("DNE",-1,-1,addr);
  return pro;
 }
 
 /** This method deletes a provider for the list*/
 public void deleteProvider(int number)
 {
  if(provider.size()==0)
  {
   System.out.println("The list of providers is empty.");
   return;
  }
  for(int i=0;i<provider.size();i++)
  {
   if(provider.get(i).getNumber()==number)
   {
    System.out.println("The provider has been found deleting information.");
    provider.remove(i);
    return;
   }
  }
  System.out.println("The provider does not exist in current list.");
  return;
 }
 
 public void updateProvider(int number, Provider providers) 
 {
  if(provider.size()==0) 
  {
   System.out.println("The list of members is empty.");
   return;
  }
  for (int i=0;i<provider.size();i++)
  {
   if(provider.get(i).getNumber()==number)
   {
    provider.set(i, providers);
    return;
   }
  }
 }
 
 
 public void clearList()
 {
  provider.clear();
  return;
 }
 
 public void displayProviderInformation(int number)
 {
  for(int i=0;i<provider.size();i++)
  {
   if(provider.get(i).getNumber()==number)
   {
    System.out.println("The provider has been found displaying information.");
    System.out.println("Provider's name: "+provider.get(i).getName());
    System.out.println("Provider's number: "+provider.get(i).getNumber());
    System.out.println("Provider's weekly fee: "+provider.get(i).getFee());
    System.out.println("Displaying provider's address:");
    provider.get(i).displayAddress();
    System.out.println("Displaying provider's serviceRecords:");
    provider.get(i).displayRecord();
    return;
   }
  }
 }
 public boolean isEmpty(){
  if(provider.size() == 0) return true;
  else return false;
 }
 public void displayList()
 {
  if(provider.size()==0)
  {
   System.out.println("The list of providers is empty.");
   return;
  }
  for(int i=0;i<provider.size();i++)
  {
   System.out.println("Displaying provider's information.");
   System.out.println("Provider's name: "+provider.get(i).getName());
   System.out.println("Provider's number: "+provider.get(i).getNumber());
   System.out.println("Provider's weekly fee: "+provider.get(i).getFee());
   System.out.println("Displaying provider's address:");
   provider.get(i).displayAddress();
   System.out.println("Displaying provider's serviceRecords:");
   provider.get(i).displayRecord();
   System.out.println("-------------------------------");
 
  }
  return;
 }
}
