package mb224bd_assign1.ferry;

public class Bike extends Vehicle  {
	
	public Bike() {
		Passenger p = new Passenger(VehicleType.BIKE);
		passengers.add(p);
		size = 1;
	}
}
