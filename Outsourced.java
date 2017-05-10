/*
 * instanceates part
 */

/**
 *
 * @author jonathankoerber
 */
package inventorymanagementcontroler;

public class Outsourced extends Part {
    String companyName;
    Outsourced(String name,  int partId, double price, int instock, 
                int min, int max, String companyName){
        super(name, partId, price, instock, min, max);
        this.companyName = companyName;
    }
    public void setCompanyName(String cName){
        this.companyName = cName;
    }
    public String getCompanyName(){
      
        return this.companyName;
    }
    
}
