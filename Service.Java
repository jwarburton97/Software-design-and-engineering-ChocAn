/**
 * @author Jonathan Warburton
 * @version 1.0.
 */
import java.io.Serializable;
import java.text.NumberFormat;

public class Service {

/**
 * The following are all the attributes a Service has,
 * A service has a name, a 9 Digit ID code, and a Cost less than $500
 */
   
  int code;
  String name;
  float cost;

  /**
     * Class Constructor.
     */
  public Service(int thecode, String thename, float thecost) {
      code = thecode;
      name = thename;
      cost = thecost;
  }
  
  /**
   * @return the name of the Service
   */
  
  public String getName()
  {
      return name;
   }
  
  /**
   * @return the cost of a service.
   */
  
  public float getCost()
  {
      return cost;
    }
  
  /**
   * 
   * @return the 9 Digit ID for a Service.
   */
  
  public int getId()
  {
      return code;
  }
  
  /**
   * This allows you to change the cost of a service.
   * @param theCost
   */
  
  public void setCost(float theCost){
     this.cost = theCost;
  }
  
  /**
   * This allows you to change the 9 Digit ID of a Service.
   * @param theCode
   */
  
  public void setCode(int theCode)
  {
       this.code = theCode;
  }
  
  /**
   * This allows you to change the name of a Service.
   * @param theName
   */
  
   public void setName(String theName)
  {
       this.name = theName;
  }
   /**
    * This returns the cost of the Service as a printable string.
    * @return cost as a String
    */
  public String printCost()
  {
      NumberFormat order = NumberFormat.getCurrencyInstance();
      String paper = order.format(cost);
        return paper;
    }
  
  /**
   * This formats the name and code of a service neatly and return it as a string to be printed.
   * @return
   */
  
  public String printName() {
        return  String.format("%-33s %06d", name, code);
  }
}


