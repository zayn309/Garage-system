import java.util.Scanner;

public class Slots {
    private Vehicle[]v;
	private double[]len;
	private double[]wid;
    Slots(int slotsNum){
        v= new Vehicle[slotsNum];
		len = new double[slotsNum];
		wid = new double[slotsNum];
        initSlots();
    }
    public void initSlots(){
        Scanner obj = new Scanner(System.in);
		System.out.println("please enter the dimensions of your slots");
		for(int i= 0; i < v.length ; i++){
			System.out.print("enter slot number "+ (i+1) +" length and width respectivly: ");
			Double length = obj.nextDouble();
			Double width = obj.nextDouble();
			setSlotDimensions(i, length, width);
			obj = null;
			obj  = new Scanner(System.in);
		}
    }
    public int getNumOfSlots(){
            return v.length;
    }
    public void setSlotDimensions(int indx, double length,double width){
        len[indx] = length;
        wid[indx] = width;
    }
    public double getLenOfSlot(int indx){
        return len[indx];
    }
    public double getWidOfSlot(int indx){
        return wid[indx];
    }
    public void parkCar(Vehicle veh,int indx){
        v[indx] = veh;
    }
    public Vehicle getParkedVehicle(int indx){
        return v[indx];
    }
    public boolean IDExistsInParkedVehicles(int ID,Sensors S){
        for(int i = 0;i<v.length;i++){
            if((S.slotStatue(i))&& ID == v[i].getID()){
                return true;
            }
        }
        return false;
    }
    public void makeEmpty(int indx){
        v[indx] = null;

    }
    
    public int searchForID(int id, Sensors S){
        int indx = 0;
        for(int i = 0 ; i< getNumOfSlots();i++){
			if(S.slotStatue(i) && id == v[i].getID()){
				indx = i;
			}
		}
        return indx ;
    }

}
