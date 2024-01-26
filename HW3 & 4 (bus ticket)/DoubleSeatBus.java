package BusTicketSystem;

public class DoubleSeatBus extends Bus {


	public DoubleSeatBus(String busType, String plateNumber, int numberOfRows, int posOfMidDoor) {
		
		super(busType, plateNumber, numberOfRows, posOfMidDoor);
		seatPerRow = 4;
		this.corridorPos = 2;
		createSeatLayout();
	}
}