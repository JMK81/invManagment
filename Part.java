
/*
 * abstract class contains the common variables that are needed outsourced and inhouse
 */

/**
 *
 * @author jonathankoerber
 */
package inventorymanagementcontroler;

public  abstract class Part {
    private String name;
    private int partId;
    private double price;
    private int instock;
    private int min;
    private int max;
    Part(String name, int partId,double price, int instock, int min, int max){
        this.setName(name);
        this.setPartId(partId);
        this.setPrice(price);
        this.setInstock(instock);
        this.setMin(min);
        this.setMax(max);
    }
    public void setName(String name){
     this.name = name;
    }
    public String getName(){
    return  (this.name);
            }
    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return this.price;
    }
    public void setInstock(int instock){
        this.instock = instock;
    }
    public int getInstock(){
        return this.instock;
    }
    public void setMin(int min){
        this.min = min;
    }
    public int getMin(){
        return this.min;
    }
    public void setMax(int max){
        this.max = max;
    }
    public int getMax(){
        return this.max;
    }
    public void setPartId(int partId){
        
        this.partId = partId;
    }
    public int getPartId(){
        return this.partId;
    }
}
