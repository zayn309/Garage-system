public class FirstInFirstServed implements Config {

	 public int Search(Slots Sl,Vehicle v,Sensors S){
		double vehLen = v.getLen();
		double vehWid = v.getWidth();
		for(int i = 0;i<Sl.getNumOfSlots();i++)	
			if(!(S.slotStatue(i)) &&((Sl.getLenOfSlot(i) >=  vehLen && Sl.getWidOfSlot(i)>= vehWid) || (Sl.getLenOfSlot(i) >=  vehWid && Sl.getWidOfSlot(i) >= vehLen) ) ){
				return i;
			}
		return -1;		
	}
}