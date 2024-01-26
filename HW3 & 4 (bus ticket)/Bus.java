package BusTicketSystem;
//Names
//Osman Oğuz Erol , Ahmet Kaan Demirci
//22050111048     , 21050111031
public abstract class Bus {
	private String busType;
	private String plateNumber;
	protected int numberOfRows;
	protected int seatPerRow;
	private int posOfMidDoor;
	protected Seat[][] seat;
	protected int corridorPos;
	private int groupNumber = 0; // A way for separate  groups
	private int numberOfSeats;

	//Constructor for single and double seat buses
	public Bus(String busType, String plateNumber, int numberOfRows, int posOfMidDoor) {

		this.busType = busType;
		this.plateNumber = plateNumber;
		this.numberOfRows = numberOfRows;
		this.posOfMidDoor = posOfMidDoor;
		groupNumber=0;

	}
	//Constructor for dynamic bus which takes position of the corridor and number of seats per row extra
	//Corridor position helps to create new bus and determines right and lef of the bus
	public Bus(String busType, String plateNumber, int numberOfRows, int posOfMidDoor, int corridorPos,int seatPerRow) {

		this.busType = busType;
		this.plateNumber = plateNumber;
		this.numberOfRows = numberOfRows;
		this.posOfMidDoor = posOfMidDoor;
		this.corridorPos = seatPerRow - corridorPos;
		this.seatPerRow = seatPerRow;
		groupNumber=0;
	}
	
	//Sell seat method for tester
	public void sellSeat(Passenger passenger, int seatNum) {
		if(seatNum==0) {
			sellSeat(passenger,0.0);
		}
		for (int i = 0; i < seat[0].length; i++) {
			for (int j = seat.length - 1; j >= 0; j--) {
				if (seat[j][i].getSeatNumber() == seatNum && isRowSuitable(i)&&seat[j][i].getSeatNumber()>0) {
					
					Ticket ticket = new Ticket(passenger, 0);
					seat[j][i].setTicket(ticket);
					return;
				} 
					
			}
		}
		System.out.println("This seat is not avilable");
	}
	//Driver sell seat method
	public void sellSeat(Passenger passenger, double row) {
		if (numOfFreeSeats() == 0) {
			System.out.println("All tickets are sold");
		} else
			sellSeat(passenger, row, 0);
	}
	//Sell seat method
	private void sellSeat(Passenger passenger, double row, int groupNum) {

		int rowPlace = (int) (row * numberOfRows);

		int i = rowPlace;
		int j = rowPlace;
		while (i < numberOfRows || j >= 0) {
			if (i < numberOfRows && i >= 0) {

				for (int z = 0; z < seat.length; z++) {
					Seat st = seat[z][i];
					if (!st.isOccupied() && st.getSeatNumber() > 0) {

						Ticket ticket = new Ticket(passenger, groupNum);
						st.setTicket(ticket);

						if (isRowSuitable(i) == false) {
							makeSeatFree(st);
						} else {
							return;
						}
					}
				}

			}
			if (j >= 0 && j < numberOfRows) {

				for (int z = 0; z < seat.length; z++) {
					Seat st = seat[z][j];
					if (!st.isOccupied() && st.getSeatNumber() > 0) {

						Ticket ticket = new Ticket(passenger, groupNum);
						st.setTicket(ticket);

						if (isRowSuitable(j) == false) {
							makeSeatFree(st);
						} else {
							return;
						}
					}
				}

			}
			j--;
			i++;

		}

	}
	//Sell seat method for multiple passengers(group)
	public void sellSeat(Passenger[] passengers, double row) {
		groupNumber++;
		for (Passenger p : passengers) {
			sellSeat(p, row, groupNumber);
		}

	}
	//Checks if row is suitable
	private boolean isRowSuitable(int rowPlace) {
		Seat st2 = null;

		for (int i = 0; i < seat.length; i++) {
			Seat st1 = seat[i][rowPlace];
			// st1.getTicket().getGroupNumber()!=st2.getTicket().getGroupNumber(
			if (st2 != null && st1.getTicket() != null && st2.getTicket() != null) {
				if (st1.getTicket().getGroupNumber() == 0 && st2.getTicket().getGroupNumber() == 0
						&& st1.getTicket().getOwner().getGender() != st2.getTicket().getOwner().getGender()) {

					return false;

				}
				if (st1.getTicket().getGroupNumber() != st2.getTicket().getGroupNumber()
						&& st1.getTicket().getOwner().getGender() != st2.getTicket().getOwner().getGender()) {

					return false;

				}
			}

			st2 = st1;

		}
		return true;
	}
	//Bus layout
	private String getBusLayout() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		for (Seat[] iterator : this.seat) {
			for (Seat st : iterator) {
				if (st.getTicket() == null) {
					if (st.getSeatNumber() == 0 || st.getSeatNumber() == -1) {
						sb.append("    ");
					} else {

						String str = String.format("%02d", st.getSeatNumber());
						sb.append("(").append(str).append(")");
					}
				} else {
					sb.append("(");
					if (st.getTicket().getOwner().getGender() == Passenger.Gender.MALE) {
						
							sb.append("M").append(st.getTicket().getGroupNumber());
						
						
						
					} else {
						
							sb.append("F").append(st.getTicket().getGroupNumber());
						
					}
					sb.append(")");
				}

			}
			sb.append("\n");
		}
		sb.append("\n");
		return sb.toString();
	}

	private void makeSeatFree(Seat st) {
		st.setFree();

	}

	public void makeSeatFree(int seatNum) {
		for (int i = 0; i < seat[0].length; i++) {
			for (int j = seat.length - 1; j >= 0; j--) {
				if(seatNum==seat[j][i].getSeatNumber()) {
					seat[j][i].setFree();
				}
			}

		}
	}
	//Set frees multiple seats
	public void makeSeatFree(int seatnNums[]) {
		for (int i : seatnNums) {
			makeSeatFree(i);
		}
		
	}
	
	//Creates bus layout from side perspective (Rows are turned 90degree)
	protected void createSeatLayout() {
		this.seat = new Seat[seatPerRow + 1][numberOfRows];
		int seatNumber = 1;
		for (int i = 0; i < seat[0].length; i++) {
			for (int j = seat.length - 1; j >= 0; j--) {
				if (i == posOfMidDoor && j < corridorPos) {
					seat[j][i] = new Seat(0);
				} else if (j == corridorPos) {
					seat[j][i] = new Seat(-1);
				} else {
					seat[j][i] = new Seat(seatNumber++);
				}
			}
		}
		this.numberOfSeats = seatNumber - 1;
	}

	//Getter methods
	public String getBusType() {
		return busType;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public int numOfFreeSeats() {
		int numberOfFreeSeats = 0;
		for (Seat[] st1 : seat) {
			for (Seat st2 : st1) {
				if (st2.getSeatNumber() > 0 && st2.getTicket() == null)
					numberOfFreeSeats++;
			}
		}
		return numberOfFreeSeats;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public double getPosOfMidDoor() {
		return posOfMidDoor;
	}

	@Override
	public String toString() {

		return getBusLayout();
	}

}
