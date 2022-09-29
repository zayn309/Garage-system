public class BestFit implements Config { 
	public int Search(Slots Sl,Vehicle v,Sensors S){
		double minArea = 1000000;
		double vehLen = v.getLen();
		double vehWid = v.getWidth();
		int indx =-1;
		for(int i =0;i<Sl.getNumOfSlots() ; i++){
			if(!(S.slotStatue(i)) &&  ((Sl.getLenOfSlot(i) >=  vehLen && Sl.getWidOfSlot(i) >= vehWid) || (Sl.getLenOfSlot(i) >=  vehWid && Sl.getWidOfSlot(i) >= vehLen) ) && minArea >= Sl.getLenOfSlot(i)*Sl.getWidOfSlot(i)){
				minArea = (Sl.getLenOfSlot(i)*Sl.getWidOfSlot(i));
				indx = i;
			}
		}
		return indx;
	}
}