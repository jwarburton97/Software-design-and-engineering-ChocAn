/**
 * @author Andy Letterle
 */
 

import java.util.ArrayList;

public class Member {
 private Address address;
 private String user;
 private int memberNumber;
 private boolean currentMember;
 public ArrayList<ServiceRecord> record;
 
 /** This only constructor use by the Member class.*/
 public Member(String n,int num, Address addr)
 {
  user=n;
  memberNumber=num;
  address=addr;
  currentMember=true;
  record= new ArrayList<ServiceRecord>();
 }
 
 /** The following is set methods for the class of Member*/
 public String getName()
 {
  return user;
 }
 public int getNum()
 {
  return memberNumber;
 }
 public Address getAddress()
 {
  return address;
 }
 public boolean getMemberStatus()
 {
  return currentMember;
 }
 public ArrayList<ServiceRecord> getServicesForWeek()
 {
  return record;
 }
 
 
 
 /** The following is set methods for the class of Member.*/
 public void setName(String n)
 {
  user=n;
  return;
 }
 public void setNum(int num)
 {
  memberNumber=num;
  return;
 }
 public void setAddress(Address addr)
 {
  address=addr;
  return;
 }
 public void setMemberStatus(boolean change)
 {
  currentMember=change;
  return;
 }
 
 
 
 /** The method add a new ServiceRecord to the ArrayList.*/
 public void addRecordsForWeek(ServiceRecord rec)
 {
  record.add(rec);
  return;
 }
 
 public void displayAddress()
 {
  System.out.println("Member's street: "+address.getStreet());
  System.out.println("Member's city: "+address.getCity());
  System.out.println("Member's state: "+address.getState());
  System.out.println("Member's zipcode: "+address.getZip());
  return;
 }
 public void displayRecord()
 {
  if(record.size()==0)
  {
   System.out.println("Member has no service records.");
   return;
  }
  for(int i=0;i<record.size();i++)
  {
   System.out.println(record.get(i).toString());
   }
 }
 
}
