package mb224bd_assign1.ferry;

public class Lorry extends Vehicle  {
	
	public Lorry(int nrOfPassengers) {
		int realNrOfPassengers = 1;
		if(nrOfPassengers >= 1 && nrOfPassengers <= 2) {
			realNrOfPassengers = nrOfPassengers;
		} else if(nrOfPassengers > 2) {
			realNrOfPassengers = 2;
		}
		for(int i = 0; i < realNrOfPassengers; i++) {
			Passenger p = new Passenger(VehicleType.LORRY);
			passengers.add(p);
		}
		size = 40;
	}
}