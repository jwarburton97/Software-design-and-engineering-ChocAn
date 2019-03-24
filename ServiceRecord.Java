/*
 * @author Antonio Morgan
 * 
 */

public class ServiceRecord {
 private Member member;
 private Provider provider;
 private Service service;
 private String serviceDate;
 private double cost;
 private String comment;
 
 /*
  *  Returning a formatted version of the service record as a string.
  */
 public String toString() {
  StringBuilder sb = new StringBuilder(); 

  sb.append("Service Date: " + serviceDate + "\n");
  sb.append("Service: " + service.getName() + " (ID: #" + service.getId() + ")\n");
  sb.append("Amount charged: $" + cost + "\n");
  sb.append("Provider: " + provider.getName() + " (ID: #" + provider.getNumber() + ")\n");
  sb.append("Member: " + member.getName() + " (ID: #" + member.getNum() + ")\n");
  sb.append("Comment: " + comment + "\n");
  
  return sb.toString();
 }
 /*
  *  Default Constructor
  */
 public ServiceRecord(Member member, Provider provider, Service service, double cost, String serviceDate, String comment) {
  this.member = member;
  this.provider = provider;
  this.service = service;
  this.cost = cost;
  this.comment = comment;
 }
}
