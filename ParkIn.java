import java.time.LocalTime;

public class ParkIn implements ParkForIn {

    @Override
    public boolean park(Vehicle veh , Slots Sl, Sensors S,boolean GarageIsFull) {
        
        if(GarageIsFull){
            CornerSituations.GarageIsFull();
            return false;
        }

        System.out.println("---------------------");

        int location = Garage.SearchingWay.Search(Sl,veh,S);

        if(location != -1){

            LocalTime T = LocalTime.now();

            veh.setStartTime(T);

            String str = LocalTimeMethods.formatTime(T);

            System.out.println("your entering time is: " + str);

            str = null;


            System.out.println("Please go to slot number "+ (location+1) + " in order to park");

            veh.SetID();

            Sl.parkCar(veh, location);

            System.out.println("Your ID to delivere at the departure time is " + veh.getID());

            S.makeReserved(location);

            System.out.println("---------------------");

            return true;
        }

        else{
		    CornerSituations.noSutableSlot();
            
            return false;

        }
        

    }
}
    

