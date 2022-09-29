import java.time.LocalTime;
import java.util.Scanner;

public class ParkOut implements ParkForOut {

    @Override
    public int parkOut(Slots Sl, Sensors S,boolean GarageIsEmpty) {

        if(GarageIsEmpty){
            CornerSituations.GarageIsEmpty();
            return -1;
        }

        System.out.print("please enter your ID that you picked while parking-in: ");

		Scanner obj = new Scanner(System.in);

		int id = obj.nextInt();
		
		obj = null;
			
		obj = new Scanner(System.in);
		if(!Sl.IDExistsInParkedVehicles(id, S)){
			CornerSituations.NoIdExists();
			return -1;
		}

		Vehicle foundedVehicles = null;

		int location = Sl.searchForID(id, S);
		
		S.turnOfSensore(location);

		foundedVehicles = Sl.getParkedVehicle(location);
		
		Sl.makeEmpty(location);
		
		LocalTime EndTime = LocalTime.now();

		String str = LocalTimeMethods.formatTime(EndTime);
		System.out.println("---------------------");
		System.out.println("your departure time is " + str);

		str = null;

		LocalTime Start =foundedVehicles.StartTime;	

		long result = (LocalTimeMethods.calculateDuration(Start, EndTime));

		result++;

		System.out.println("your parking time is: "+ result+" Hour");

		int ParkingFees =FeesCalculation.Calc(result);

		System.out.println("your parking fees is " + ParkingFees+ " EGP");

		System.out.println("---------------------");

		return ParkingFees;
    }
    
}
