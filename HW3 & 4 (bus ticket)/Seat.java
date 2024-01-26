package BusTicketSystem;

public class Seat {
	private int seatNumber;
	

	private Ticket ticket;

	public Seat(int seatNumber) {
        this.ticket=null;
        this.seatNumber = seatNumber;
       
	}
	public void setFree() {
		this.ticket=null;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public Ticket getTicket() {
		return this.ticket;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public boolean isOccupied() {
		return this.ticket!=null;
	}
	
	public String toString() {
		return ""+this.seatNumber;
	}
	
	
	
}
