package BusTicketSystem;



public class SingleSeatBus extends Bus{
	
	
	public SingleSeatBus(String busType, String plateNumber, int numberOfRows,int posOfMidDoor) {
		super(busType, plateNumber, numberOfRows, posOfMidDoor);
		seatPerRow=3;
		corridorPos=2;
		createSeatLayout();
	}


	
}
