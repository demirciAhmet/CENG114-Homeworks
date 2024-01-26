package BusTicketSystem;

public class Ticket{
    private Passenger owner = null;
    private int price = 20;
    private int groupNumber;
    
    Ticket(Passenger owner,int groupNumber){
        this.owner = owner;
        this.groupNumber = groupNumber;
    }

	public int getGroupNumber() {
		return groupNumber;
	}

	public int getPrice() {
		return price;
	}

	public Passenger getOwner() {
		return owner;
	}
    
    
    
        
}

