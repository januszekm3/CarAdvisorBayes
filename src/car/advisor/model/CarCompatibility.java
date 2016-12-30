package car.advisor.model;

public class CarCompatibility {

	private String name;

	private Double compatibility;

	public CarCompatibility(String name, Double compatibility) {
		this.name = name;
		this.compatibility = compatibility;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCompatibility() {
		return compatibility;
	}

	public void setCompatibility(double compatibility) {
		this.compatibility = compatibility;
	}

}
