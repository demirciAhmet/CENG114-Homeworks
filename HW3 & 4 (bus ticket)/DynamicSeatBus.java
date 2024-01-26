package BusTicketSystem;

//Dynamic bus class for new buses
public class DynamicSeatBus extends Bus {
	
	public DynamicSeatBus(String busType, String plateNumber, int numberOfRows,int posOfMidDoor, int corridorPos,int seatPerRow) {
		super(busType, plateNumber, numberOfRows, posOfMidDoor, corridorPos, seatPerRow);
		this.seatPerRow = seatPerRow;
		
		createSeatLayout();
	}

}
