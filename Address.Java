/**
 * @author Charity Brown.
 * @version 1.0.
 */

/** This class saves a Address for a specific Member or Provider. */ 
public class Address
{
 private String streetAddress;
 private String city;   
 private String state;    
 private int zipcode;   
 
 /** The following is the constructor class used for Address.*/
 public Address(String s, String c, String st, int z)
 {
  streetAddress=s;
  city=c;
  state=st;
  zipcode=z;
 }
 
 /** The following are get methods for the Address class.*/
 public String getStreet()
 {
  return streetAddress;
 }
 public String getCity()
 {
  return city;
 }
 public String getState()
 {
  return state;
 }
 public int getZip()
 {
  return zipcode;
 }
 
 /** The following are set methods for the Address class.*/
 public void setStreet(String s)
 {
  streetAddress=s;
  return;
 }
 public void setCity(String c)
 {
  city=c;
  return;
 }
 public void setState(String s)
 {
  state=s;
  return;
 }
 public void setZip(int z)
 {
  zipcode=z;
  return;
 }
}
