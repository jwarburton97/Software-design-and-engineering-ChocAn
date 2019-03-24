import java.util.ArrayList;

/**
 * 
 * @author Andrew Letterle
 *
 */

public class Provider{
 private String name;
 private int providerNumber;
 private double totalWeeklyFee;
 private ArrayList<ServiceRecord> record;
 private Address address;
 
 /**
  * 
  * @param name
  * @param number
  * @param fee - should be initialized to 0
  * @param address
  */
 
 public Provider(String n, int num, double fee, Address a)
 {
  name=n;
  providerNumber=num;
  totalWeeklyFee=fee;
  address= a;
  record= new ArrayList<ServiceRecord>();
 }
 
 /** The following are get method for the Provider class that includes Address and ServiceRecordss.*/
 public String getName()
 {
  return name;
 }
 public int getNumber()
 {
  return providerNumber;
 }
 public double getFee()
 {
  return totalWeeklyFee;
 }

 public ArrayList<ServiceRecord> getRecord()
 {
  return record;
 }
 public Address getAddress()
 {
  return address;
 }

 /** The following are set method for the Provider class that include Address and ServiceRecordss.*/
 public void setName(String n)
 {
  name=n;
  return;
 }
 public void setNumber(int n)
 {
  providerNumber=n;
  return;
 }
 public void setFees(double f)
 {
  totalWeeklyFee=f;
 }
 public void setAddress(Address a)
 {
  address=a;
  return;
 }
 public void setRecord(ArrayList<ServiceRecord> rec)
 {
  record=rec;
  return;
 }
 
 /** The method add a new ServiceRecords to the ArrayList.*/
 public void addRecordForWeek(ServiceRecord rec)
 {
  record.add(rec);
  return;
 }
 
 /** These method are used to display the instances of the classes called in provider.*/
 public void displayAddress()
 {
  System.out.println("Provider's street: "+address.getStreet());
  System.out.println("Provider's city: "+address.getCity());
  System.out.println("Provider's state: "+address.getState());
  System.out.println("Provider's zipcode: "+address.getZip());
  return;
 }
 public void displayRecord()
 {
  if(record.size()==0)
  {
   System.out.println("Provider has no service records.");
   return;
  }
  for(int i=0;i<record.size();i++)
  {
   System.out.println(record.get(i).toString());
  }
 }
}
