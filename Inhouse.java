/*
 * extends part object implements the object
 */
package inventorymanagementcontroler;

/**
 *
 * @author jonathankoerber
 */
public class Inhouse extends Part {
    int machineID;
    Inhouse(String name, int partId, double price, int instock, int min, int max, int machineID){
        super(name, partId, price, instock, min, max);
        this.setMachineId(machineID);
    }
    public void setMachineId(int machine){
        this.machineID = machine;
    }
    public int getMachineId(){
        return this.machineID;
}
}
