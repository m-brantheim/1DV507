package mb224bd_assign1.ferry;

public class Bus extends Vehicle  {
	
	public Bus(int nrOfPassengers) {
		int realNrOfPassengers = 1;
		if(nrOfPassengers >= 1 && nrOfPassengers <= 20) {
			realNrOfPassengers = nrOfPassengers;
		} else if(nrOfPassengers > 20) {
			realNrOfPassengers = 20;
		}
		for(int i = 0; i < realNrOfPassengers; i++) {
			Passenger p = new Passenger(VehicleType.BUS);
			passengers.add(p);
		}
		size = 20;
	}
}
