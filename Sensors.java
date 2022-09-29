public class Sensors {
    private boolean []taken;
    Sensors(int slotsNum){
        taken = new boolean[slotsNum];
        for(int i = 0; i<slotsNum;i++){
            taken[i] = false;
        }
    }
    public boolean slotStatue(int indx){
        return taken[indx];
    }
    public void makeReserved(int indx){
        taken[indx] = true;
    }
    public void turnOfSensore(int indx){
        taken[indx] = false;
    }
    public void displayEmptySlots(){
        System.out.println("---------------------------");
        for(int i= 0; i < taken.length; i++){
			if(!taken[i]){
				System.out.println("Slot number "+ (i+1)+"        [Empty]");
			}
		}
		System.out.println("---------------------------");
    }
}
