/*
 * class to made into objects
 */
package inventorymanagementcontroler;

import java.util.ArrayList;


/**
 *
 * @author jonathankoerber
 */
public class Product {
    private ArrayList<Part>parts;
    private int productId;
    private String name;
    private double price;
    private int instock;
    private int min;
    private int max;

   public Product(ArrayList<Part> parts, int productId, String name, double price, 
    int instock, int min, int max){
        this.parts = parts;//need of find out how to use an arrayList in a constructor 
        this.setPart(parts);
        this.setName(name);
        this.setProductId(productId);
        this.setPrice(price);
        this.setInstock(instock);
        this.setMin(min);
        this.setMax(max);
    }
    public void setPart(ArrayList<Part> p){
        this.parts = new ArrayList<>(p);
    }
    public ArrayList<Part> getPart(){
        return this.parts;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
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
    public void addPart(Part p){
        parts.add(p);
    }
    public void removePart(Part p){
        parts.remove(p);
    }
    //need a search method
    public Part lookUpPart(Part p){
        return p;
    }
    //need a delete method
    public void upDatePart(Part p){
        
    }
    public void setProductId(int id){
        this.productId = id;
    }
    public int getProductId(){
        return this.productId;
    }
}
