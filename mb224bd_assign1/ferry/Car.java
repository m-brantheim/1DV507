package mb224bd_assign1.ferry;

public class Car extends Vehicle  {
	
	public Car(int nrOfPassengers) {
		int realNrOfPassengers = 1;
		if(nrOfPassengers >= 1 && nrOfPassengers <= 4) {
			realNrOfPassengers = nrOfPassengers;
		} else if(nrOfPassengers > 4) {
			realNrOfPassengers = 4;
		}
		for(int i = 0; i < realNrOfPassengers; i++) {
			Passenger p = new Passenger(VehicleType.CAR);
			passengers.add(p);
		}
		size = 5;
	}
}