

/**
 * @author Jonathan Warburton
 * @version 1.0.
 */
import java.util.ArrayList;

public class ServiceController{

    private ArrayList<Service> services;
    
    /**
     * Class constuctor
     */
    public ServiceController(){
        services= new ArrayList<Service>();
    }
    /**
     * Get a list of all Services
     */
    public ArrayList<Service> getServiceList(){
        return services;
    }

    /**
     * Add a new service to the storage device
     */
    public void addService(Service newService){
        services.add(newService);
        
    }
    public ArrayList<Service> getList() {
  return services;
 }
    /**
     * Remove a service from storage device
     */
    public void removeService(int service){
        if(services.size()==0)
  {
   System.out.println("The list of services is empty.");
   return;
  }
  for(int i=0;i<services.size();i++)
  {
   if(services.get(i).getId()==service)
   {
    System.out.println("The Service has been found deleting information.");
    services.remove(i);
    return;
   }
  }
  System.out.println("The service does not exist in current list.");
  return;
    }
    /**
     * Checks whether the list of services has a service with the ID given as a parameter.
     * @param number
     * @return boolean
     */
    public boolean checkNum(int number) 
    {
        for (int i = 0; i < services.size(); i++)
        {
            if (services.get(i).getId()==number)
                return true;
        }
        return false;
    }
    /**
     * This updates the service in the service list with a given ID.
     * 
     */
    public void updateService(int number, Service service) 
    {
        if(services.size()==0) 
        {
            System.out.println("The list of services is empty.");
            return;
        }
        for (int i=0;i<services.size();i++)
        {
            if(services.get(i).getId()==number)
            {
                services.set(i, service);
                return;
            }
        }
}
    /**
     * This is a function that allows terminals to determine if a list of services is empty.
     * @return boolean
     */
    public boolean isEmpty(){
  if(services.size() == 0) return true;
  else return false;
 }
    
    public Service searchList(int number)
    {
        for(int i=0;i<services.size();i++)
        {
            if(services.get(i).getId()==number)
            {
                System.out.println("The service has been found returning member");
                return services.get(i);
            }
        }
        System.out.println("The services has not been found returning Error Member.");
        return null;
    }

}
