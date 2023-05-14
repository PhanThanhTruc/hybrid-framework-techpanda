package carFactory;

public class CarFactory {
	public static Car getCartype(CarType carType) {
		switch (carType) {
		case HONDA:
			return new HonDa();
		case TOYOTA:
			return new Toyota();
		default:
			throw new IllegalArgumentException("This car type is unsport");
		}
	}

}
