package mb224bd_assign1.ferry;

public class FerryMain {
	
	public static void main(String[] args) {
		FerryArrayListImpl ferry = new FerryArrayListImpl();
		Passenger p = new Passenger();
		
		// Should print 0
		System.out.println(ferry.countPassengers());
		ferry.embark(p);
		// Should print 1
		System.out.println(ferry.countPassengers());
		
		Car car = new Car(3);
		ferry.embark(car);
		// Should print 4
		System.out.println(ferry.countPassengers());
		
		Car car2 = new Car(3);
		ferry.embark(car2);
		// Should print 10 (5 x 2)
		System.out.println(ferry.countVehicleSpace());
		
		// Should print 7
		System.out.println(ferry.countPassengers());
		Passenger p2 = new Passenger();
		ferry.embark(p2);
		
		System.out.println(ferry.countVehicleSpace());
		Car car3 = new Car(3);
		ferry.embark(car3);
		// Should not embark same vehicle
		ferry.embark(car3);
		System.out.println(ferry.countVehicleSpace());
		
		// Should print 475
		System.out.println(ferry.countMoney());
		
		Bike bike = new Bike();
		ferry.embark(bike);
		
		// Should print 515
		System.out.println(ferry.countMoney());
		
		Bus bus = new Bus(8);
		ferry.embark(bus);
		
		// Should print 795
		System.out.println(ferry.countMoney());
		
		Lorry lorry = new Lorry(2);
		ferry.embark(lorry);
		
		// Should print 1125
		System.out.println(ferry.countMoney());
		
		System.out.println(ferry.toString());
		
		ferry.disembark();
		// Should print 0
		System.out.println(ferry.countVehicleSpace());
		// Should print 0
		System.out.println(ferry.countPassengers());
		// Should print 1125
		System.out.println(ferry.getMoneyEarned());
		
		System.out.println(ferry.toString());
	}
}
