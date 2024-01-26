package BusTicketSystem;



public class Passenger {

	public enum Gender {
		MALE,
		FEMALE;
	}
	
	
	private String name;
	private Gender gender;

	
	public Passenger(String name,Gender gender) {
		this.gender = gender;
		this.name = name;
		
	}
	
	
	public Gender getGender() {
		return this.gender;
	}


	public String getName() {
		return name;
	}
	
}
