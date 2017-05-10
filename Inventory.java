/*
 *contains the product objects 
*/
package inventorymanagementcontroler;

import java.util.ArrayList;

/**
 *
 * @author jonathankoerber
 */
public class Inventory {
    ArrayList<Product>products = new ArrayList();
    
    public void addProducts(Product p){
        products.add(p);
    }
    
    public ArrayList getProducts(){
        ArrayList<Product>p = new ArrayList(products);
        return p;
    }
    
    public boolean removeProduct(int i){
        products.remove(i);
        return true;
    }
   
    public int lookupProduct(Product p){
        return 1;
    }
    
    public void updateProduct(int i){
       
    }
}
