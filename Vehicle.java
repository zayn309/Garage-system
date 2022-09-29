import java.time.LocalTime;

public class Vehicle {
	private double width;
	private double depth;
	private String modelName;
	private int modelYear;
	public  LocalTime StartTime;
	private int ID;
	private static int StaticID=0;
	//Vehicle() {}
	Vehicle(double wid,double len,String modName,int modYear){
		width = wid;
		depth = len;
		modelName = modName;
		modelYear = modYear;
	}
	public void set(double  wid,double len,String modName,int modYear){
		width = wid;
		depth = len;
		modelName = modName;
		modelYear = modYear;
	
	}
	public void display(){
		System.out.println(width);
		System.out.println(modelName);
		System.out.println(modelYear);
	}
	public double getLen(){return depth;}
	public double getWidth(){return width;}
	public void setStartTime(LocalTime t){StartTime = t;}
	public void SetID(){ID = ++StaticID;}
	public int getID(){return ID;}
}
