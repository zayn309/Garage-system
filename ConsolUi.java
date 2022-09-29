import java.util.Scanner;

public class ConsolUi {
    public static Scanner obj = new Scanner(System.in);
    public static Config C = null;
    public static Garage g = null;
    public static void GarageConfigration(){
        System.out.println("---------welcome sir------------");
		System.out.println("--------------------------------");
		
		System.out.println("enter the number of slots in your garage");
		int slotsNum = obj.nextInt();
		obj = null;
		obj = new Scanner(System.in);
		
		while(true){
			System.out.println("enter the configration name you want to make(BF [best fit approach] or FIFS [first in first served])");
			String s  = obj.nextLine();
			obj = null;
			obj = new Scanner(System.in);
			if(s.equals("BF")){C = new BestFit();break; }
			else if (s.equals("FIFS")){ C = new FirstInFirstServed();break;}
			else {
				System.out.println("\n------------------------");
				System.out.println("undefined configration");
				System.out.println("------------------------\n");
				obj = null;
				obj = new Scanner(System.in);
			}
		}
		System.out.println("---------------------------");
		g =  new Garage(slotsNum,C);
		System.out.println("---------------------------");
    }
    public static void Form(){
        while(true){
			
			System.out.println("enter the number corresponding to the action you want to make");
			System.out.println("1-park-in into the garage");
			System.out.println("2-park-out from the garage");
			System.out.println("3-display empty slots");
			System.out.println("--------------------------");
			System.out.println("4-admin functionalities");
			System.out.println("--------------------------");
			int oper;
			oper = obj.nextInt();
			obj = null;
			obj = new Scanner(System.in);
			if(oper == 1){
				if(g.isFull()){
					System.out.println("---------------------------");
					System.out.println("sorry!, the garage is full.");
					System.out.println("---------------------------");
					continue;
				}
				System.out.print("enter your Vehicles width and length recpectivly: ");
				int width = obj.nextInt();
				int len = obj.nextInt();
				obj = null;
				obj = new Scanner(System.in);
				System.out.print("enter your Vehicle's model name: ");
				String modN = obj.nextLine();
				System.out.print("enter your Vehicle's model year: ");
				int modeY = obj.nextInt();
				Vehicle v= new Vehicle(width,len,modN,modeY);
				System.out.print("\n");
				g.park_in(v);
			}
			else if(oper == 2){
				g.park_out();
				
			}
			else if (oper == 3){
				g.DisplayEmptySlots();
			}
			else if (oper == 4){
				if(!(g.LogIntoGarage())){
					System.out.println("---------------------------");
					System.out.println("wrong password");
					System.out.println("---------------------------");
					continue;
				}
				else{
					System.out.println("   welcome admin    ");
					System.out.println("--------------------");
					while(true){
						System.out.println("enter the number of operation you want to make");
						System.out.println("1- view totale income");
						System.out.println("2- view totale number of vehicles that has been use the garage");
						System.out.println("3-change password");
						System.out.println("4- exit");
						int operation = obj.nextInt();
						obj = null;
						obj = new Scanner(System.in);
						if(operation == 1){g.DisplayTotalIncome();}
						else if(operation == 2){g.DisplayTotalNumberOfVeh();}
						else if(operation == 3){
							String s = obj.nextLine();
							obj = null;
							obj = new Scanner(System.in);
							g.resetPassword(s);
						}
						else if(operation == 4){break;}
						else {
							System.out.println("undefined operation");
						}
					}
				}
				
			}
			else if(oper == 0){
				System.out.println("good bye!");
				break;
			}
			else{
				System.out.println("undefined operation");
			}
			
		}

    }
}
