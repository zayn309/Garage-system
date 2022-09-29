public class Garage {

	Slots Sl;
	Sensors S;
	private int income;
	private int currentNumOfVehicles;
	public static Config SearchingWay;
	private int totalVehiclesUsedGarage;
	private authentication auth;
	private ParkForIn p1;
	private ParkForOut p2;

	Garage(int slotsNum, Config Con){
		p1 = new ParkIn();
		income= 0;
		Sl = new Slots(slotsNum);
		income =0;
		currentNumOfVehicles =0;
		S = new Sensors(slotsNum);
		SearchingWay = Con;
		totalVehiclesUsedGarage = 0;
		auth = new authentication();
		p1 = new ParkIn() ;
		p2 = new ParkOut();
		
	}
	public void park_in(Vehicle veh){
		if(p1.park(veh, Sl, S, currentNumOfVehicles==Sl.getNumOfSlots())){
			currentNumOfVehicles++;
		}
		else
			return;
		
	}
	public void park_out(){
		int Fees = p2.parkOut(Sl, S, currentNumOfVehicles == 0);
		if(Fees != -1){
			income += Fees;
			totalVehiclesUsedGarage++;
			currentNumOfVehicles--;
		}
	}

	public void DisplayTotalIncome(){

		System.out.println(income);

	}
	public void DisplayEmptySlots(){
		if(isFull()){
			CornerSituations.GarageIsFull();
			return;
		}
		S.displayEmptySlots();
	}
	public boolean isFull(){
		if(currentNumOfVehicles == Sl.getNumOfSlots()){
			return true;
		}
		else{
			return false;
		}
	}
	public void DisplayTotalNumberOfVeh(){
		
		System.out.println("the totale number of vehicles that has been used the garage is: "+totalVehiclesUsedGarage);
	
	}
	public void resetPassword(String s){
		auth.changePassword(s);
	}
	public boolean LogIntoGarage(){
		return auth.LogIntoGarage();
	}
}
