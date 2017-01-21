package mb224bd_assign1.ferry;

public class Passenger {
	
	private VehicleType vehicleType;
	
	public Passenger(VehicleType vt) {
		vehicleType = vt;
	}
	
	// Default constructor sets VehicleType to NONE (passenger is not in a vehicle)
	public Passenger() {
		vehicleType = VehicleType.NONE;
	}
	
	public VehicleType getVehicleType() {
		return vehicleType;
	}
}
