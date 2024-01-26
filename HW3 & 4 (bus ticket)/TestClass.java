import BusTicketSystem.DoubleSeatBus;
import BusTicketSystem.DynamicSeatBus;
import BusTicketSystem.Passenger;
import BusTicketSystem.SingleSeatBus;

public class TestClass {
    //0 means non group people other numbers represents groups
    public static void main(String[] args) {
    	Passenger m1 = new Passenger("Osman",Passenger.Gender.MALE);
    	Passenger m2 = new Passenger("Ahmet",Passenger.Gender.MALE);
    	Passenger m3 = new Passenger("Mehmet",Passenger.Gender.MALE);
    	Passenger m4 = new Passenger("Emre",Passenger.Gender.MALE);
    	Passenger m5 = new Passenger("Osman",Passenger.Gender.MALE);
    	Passenger m6 = new Passenger("Ahmet",Passenger.Gender.MALE);
    	Passenger m7 = new Passenger("Mehmet",Passenger.Gender.MALE);
    	Passenger m8 = new Passenger("Emre",Passenger.Gender.MALE);
    	Passenger m9 = new Passenger("Osman",Passenger.Gender.MALE);
    	Passenger m10 = new Passenger("Ahmet",Passenger.Gender.MALE);
    	Passenger m11 = new Passenger("Mehmet",Passenger.Gender.MALE);
    	Passenger m12 = new Passenger("Emre",Passenger.Gender.MALE);
    	Passenger m13 = new Passenger("Osman",Passenger.Gender.MALE);
    	Passenger m14 = new Passenger("Ahmet",Passenger.Gender.MALE);
    	Passenger m15 = new Passenger("Mehmet",Passenger.Gender.MALE);
    	Passenger m16 = new Passenger("Emre",Passenger.Gender.MALE);
    	Passenger m17 = new Passenger("Mehmet",Passenger.Gender.MALE);
    	Passenger m18 = new Passenger("Emre",Passenger.Gender.MALE);
    	Passenger m19 = new Passenger("Osman",Passenger.Gender.MALE);
    	Passenger m20 = new Passenger("Ahmet",Passenger.Gender.MALE);
    	Passenger m21 = new Passenger("Mehmet",Passenger.Gender.MALE);
    	Passenger m22 = new Passenger("Emre",Passenger.Gender.MALE);
    	Passenger m23 = new Passenger("Osman",Passenger.Gender.MALE);
    	Passenger m24 = new Passenger("Ahmet",Passenger.Gender.MALE);
    	
        
        
    	Passenger f1 = new Passenger("Ayşe",Passenger.Gender.FEMALE);
    	Passenger f2 = new Passenger("Elif",Passenger.Gender.FEMALE);
    	Passenger f3 = new Passenger("Fatma",Passenger.Gender.FEMALE);
    	Passenger f4 = new Passenger("Sıla",Passenger.Gender.FEMALE);
    	Passenger f5 = new Passenger("Ayşe",Passenger.Gender.FEMALE);
    	Passenger f6 = new Passenger("Elif",Passenger.Gender.FEMALE);
    	Passenger f7 = new Passenger("Fatma",Passenger.Gender.FEMALE);
    	Passenger f8 = new Passenger("Sıla",Passenger.Gender.FEMALE);
    	Passenger f9 = new Passenger("Ayşe",Passenger.Gender.FEMALE);
    	Passenger f10 = new Passenger("Elif",Passenger.Gender.FEMALE);
    	Passenger f11 = new Passenger("Fatma",Passenger.Gender.FEMALE);
    	Passenger f12 = new Passenger("Sıla",Passenger.Gender.FEMALE);
    	Passenger f13 = new Passenger("Ayşe",Passenger.Gender.FEMALE);
    	Passenger f14 = new Passenger("Elif",Passenger.Gender.FEMALE);
    	Passenger f15 = new Passenger("Fatma",Passenger.Gender.FEMALE);
    	Passenger f16 = new Passenger("Sıla",Passenger.Gender.FEMALE);
    	Passenger f17 = new Passenger("Fatma",Passenger.Gender.FEMALE);
    	Passenger f18 = new Passenger("Sıla",Passenger.Gender.FEMALE);
    	Passenger f19 = new Passenger("Ayşe",Passenger.Gender.FEMALE);
    	Passenger f20 = new Passenger("Elif",Passenger.Gender.FEMALE);
    	Passenger f21 = new Passenger("Fatma",Passenger.Gender.FEMALE);
    	Passenger f22 = new Passenger("Sıla",Passenger.Gender.FEMALE);
    	Passenger f23 = new Passenger("Ayşe",Passenger.Gender.FEMALE);
    	Passenger f24 = new Passenger("Fatma",Passenger.Gender.FEMALE);
        
        Passenger[] g1 = new Passenger[] {f6,m7,m6,f7};
        Passenger[] g2 = new Passenger[] {m7,f8,m8,f9,m9,f10,m10};
        Passenger[] g3 = new Passenger[] {m11,f11,f12,f13,m12,m13,f14,m14};
        Passenger[] g4 = new Passenger[] {m21,f21,f22,f23,m22,m23,f24};
        Passenger[] g5 = new Passenger[] {m15,f15,m16,f16,m17,m18,m19,m20,f17,f18,f19,f20};
        Passenger[] g6 = new Passenger[] {m1,m2,m3,f1,f2,m4,m5,f3,f4,f5};
        
    	
    	
    	//Type PlateNumber numberOfRows(Long) posOfMiddoor 
        SingleSeatBus singleBus = new SingleSeatBus("Single", "35 SB 1332", 10, 3);
        DoubleSeatBus doubleBus= new DoubleSeatBus("Double", "09 DB 3643", 10, 3);
        
        //Type PlateNumber numberOfRows(Long) posOfMiddoor posOfcorridor numPerSeat
        DynamicSeatBus dynamicBus = new DynamicSeatBus("Dynamic", "06 DY 3509", 10, 3, 3,5);
        
        //Single empty single bus test:
        System.out.println("-------------------------------------------------------------");
        System.out.println("-------------------Single Bus Test Cases---------------------");
        System.out.println("-------------------------------------------------------------");
        System.out.println("");
        System.out.println("Bus Type: "+singleBus.getBusType());
        System.out.println("Bus Plates number: "+singleBus.getPlateNumber());
        System.out.println("Number of seats: "+singleBus.getNumberOfSeats());
        System.out.println("Bus layout:");
        System.out.println(singleBus);
        System.out.println("Number of free seats: " + singleBus.numOfFreeSeats());
        
        
        //Test for single ticket test:
        singleBus.sellSeat(m1, 0.2);
        System.out.println("");
        System.out.println("-------------------------------------------------------------");
        System.out.println();
        System.out.println("After selling a ticket for single person: ");
        System.out.println(singleBus);
        System.out.println("Number of free seats: " + singleBus.numOfFreeSeats());
        
        
        //Test for a few individual person ticket:
        singleBus.sellSeat(f1, 0.2);
        singleBus.sellSeat(m2, 0.2);
        singleBus.sellSeat(m3, 0.2);
        singleBus.sellSeat(m4, 0.2);
        singleBus.sellSeat(m5, 0.0);
        singleBus.sellSeat(f2, 0.0);
        singleBus.sellSeat(f3, 0.9);
        singleBus.sellSeat(f4, 1.0);
        singleBus.sellSeat(f5, 0.6);
        System.out.println("");
        System.out.println("-------------------------------------------------------------");
        System.out.println();
        System.out.println("After selling a few tickets for individual people: ");
        System.out.println(singleBus);
        System.out.println("Number of free seats: " + singleBus.numOfFreeSeats());
        
        
        //Test for a group ticket:
        singleBus.sellSeat(g1, 0.0);
        System.out.println("");
        System.out.println("-------------------------------------------------------------");
        System.out.println();
        System.out.println("After selling tickets for single group: ");
        System.out.println(singleBus);
        System.out.println("Number of free seats: " + singleBus.numOfFreeSeats());
        
       
     
        //Test for a few group ticket:
        singleBus.sellSeat(g2, 0.3);
        singleBus.sellSeat(g3, 0.3);
        System.out.println("");
        System.out.println("-------------------------------------------------------------");
        System.out.println();
        System.out.println("After selling a few tickets for multiple groups: ");
        System.out.println(singleBus);
        System.out.println("Number of free seats: " + singleBus.numOfFreeSeats());
        
        
        //Test for method makeSeatFree():
        singleBus.makeSeatFree(13);
        int[] arr = new int[]{1,4,7,11,12,26,28};
        singleBus.makeSeatFree(arr);
        System.out.println();
        System.out.println("-------------------------------------------------------------");
        System.out.println();
        System.out.println("After making seets free: ");
        System.out.println(singleBus);
        System.out.println("Number of free seats: " + singleBus.numOfFreeSeats());
        
        //Test for empty double bus test:
        System.out.println("\n" + "-------------------------------------------------------------");
        System.out.println("-------------------Double Bus Test Cases---------------------");
        System.out.println("-------------------------------------------------------------");
        System.out.println("");
        System.out.println("Bus Type: "+doubleBus.getBusType());
        System.out.println("Bus Plates number: "+doubleBus.getPlateNumber());
        System.out.println("Number of seats: "+doubleBus.getNumberOfSeats());
        System.out.println("Bus layout:");
        System.out.println(doubleBus);
        System.out.println("Number of free seats: " + doubleBus.numOfFreeSeats());
        
        
        //Test for a few individual person ticket:
        doubleBus.sellSeat(m15, 0.2);
        doubleBus.sellSeat(f15, 0.2);
        doubleBus.sellSeat(m16, 0.2);
        doubleBus.sellSeat(f16, 0.2);
        doubleBus.sellSeat(m17, 0.3);
        doubleBus.sellSeat(f17, 0.3);
        doubleBus.sellSeat(m18, 0.4);
        doubleBus.sellSeat(f18, 0.5);
        doubleBus.sellSeat(m19, 0.3);
        doubleBus.sellSeat(f19, 0.6);
        doubleBus.sellSeat(m20, 0.7);
        doubleBus.sellSeat(f20, 0.2);
        
        System.out.println("");
        System.out.println("-------------------------------------------------------------");
        System.out.println();
        System.out.println("After selling a few tickets for individual people: ");
        System.out.println(doubleBus);
        System.out.println("Number of free seats: " + doubleBus.numOfFreeSeats());
        
        
        //Test for a group selling:
        doubleBus.sellSeat(g1, 0.7);

        System.out.println("");
        System.out.println("-------------------------------------------------------------");
        System.out.println();
        System.out.println("After selling tickets for a group: ");
        System.out.println(doubleBus);
        System.out.println("Number of free seats: " + doubleBus.numOfFreeSeats());
        
        
        //Test for a group selling:
        doubleBus.sellSeat(g2, 0.3);

        System.out.println("");
        System.out.println("-------------------------------------------------------------");
        System.out.println();
        System.out.println("After selling tickets for a group: ");
        System.out.println(doubleBus);
        System.out.println("Number of free seats: " + doubleBus.numOfFreeSeats());
        
        
        //Test for a group selling:
        doubleBus.sellSeat(g3, 0.2);

        System.out.println("");
        System.out.println("-------------------------------------------------------------");
        System.out.println();
        System.out.println("After selling tickets for a group: ");
        System.out.println(doubleBus);
        System.out.println("Number of free seats: " + doubleBus.numOfFreeSeats());
        
        
        //Test for a group selling:
        doubleBus.sellSeat(g4, 0.9);
  
        System.out.println("");
        System.out.println("-------------------------------------------------------------");
        System.out.println();
        System.out.println("After selling tickets for a group: ");
        System.out.println(doubleBus);
        System.out.println("Number of free seats: " + doubleBus.numOfFreeSeats());
        
        
        //Test for empty double bus test:
        System.out.println("\n" + "-------------------------------------------------------------");
        System.out.println("-------------------Dynamic Bus Test Cases---------------------");
        System.out.println("-------------------------------------------------------------");
        System.out.println("");
        System.out.println("Bus Type: "+dynamicBus.getBusType());
        System.out.println("Bus Plates number: "+dynamicBus.getPlateNumber());
        System.out.println("Number of seats: "+dynamicBus.getNumberOfSeats());
        System.out.println("Bus layout:");
        System.out.println(dynamicBus);
        System.out.println("Number of free seats: " + dynamicBus.numOfFreeSeats());
        
        
        //Test for a group selling:
        dynamicBus.sellSeat(g1, 0.7);
  
        System.out.println("");
        System.out.println("-------------------------------------------------------------");
        System.out.println();
        System.out.println("After selling tickets for a group: ");
        System.out.println(dynamicBus);
        System.out.println("Number of free seats: " + dynamicBus.numOfFreeSeats());
        
        
        //Test for a group selling:
        dynamicBus.sellSeat(g2, 0.3);
  
        System.out.println("");
        System.out.println("-------------------------------------------------------------");
        System.out.println();
        System.out.println("After selling tickets for a group: ");
        System.out.println(dynamicBus);
        System.out.println("Number of free seats: " + dynamicBus.numOfFreeSeats());
        
        
        //Test for a group selling:
        dynamicBus.sellSeat(g3, 0.2);
  
        System.out.println("");
        System.out.println("-------------------------------------------------------------");
        System.out.println();
        System.out.println("After selling tickets for a group: ");
        System.out.println(dynamicBus);
        System.out.println("Number of free seats: " + dynamicBus.numOfFreeSeats());
        
        
        //Test for a group selling:
        dynamicBus.sellSeat(g4, 0.9);
  
        System.out.println("");
        System.out.println("-------------------------------------------------------------");
        System.out.println();
        System.out.println("After selling tickets for a group: ");
        System.out.println(dynamicBus);
        System.out.println("Number of free seats: " + dynamicBus.numOfFreeSeats());
        
        //Test for a group selling:
        dynamicBus.sellSeat(g5, 0.9);
  
        System.out.println("");
        System.out.println("-------------------------------------------------------------");
        System.out.println();
        System.out.println("After selling tickets for a group: ");
        System.out.println(dynamicBus);
        System.out.println("Number of free seats: " + dynamicBus.numOfFreeSeats());
        
        //Test for a group selling:
        dynamicBus.sellSeat(g6, 0.5);
  
        System.out.println("");
        System.out.println("-------------------------------------------------------------");
        System.out.println();
        System.out.println("After selling tickets for a group: ");
        System.out.println(dynamicBus);
        System.out.println("Number of free seats: " + dynamicBus.numOfFreeSeats());
        System.out.println("");
        System.out.println("-------------------------------------------------------------");

        
    }

}