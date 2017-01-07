package car.advisor;

import car.advisor.model.UserPreferences;
import car.advisor.network.CarAdvisorNetwork;

public class Main {

	public static void main(String[] args) {
		CarAdvisorNetwork net = new CarAdvisorNetwork();
		System.out.println(net.getBestMatches(createUserPreferences()));
	}

	private static UserPreferences createUserPreferences() {
		// Zahardkodowane tymczasowo, do wyciagniecia z guia
		UserPreferences userPrefs = new UserPreferences();
		userPrefs.setCena(new double[] { 0.2, 0.3, 0.5 });
		userPrefs.setKomfortJazdy(new double[] { 0.4, 0.6 });
		userPrefs.setBogateWyposazenie(new double[] { 0.9, 0.1 });
		userPrefs.setPrzeznaczenie(new double[] { 0.3, 0.5, 0.2 });
		userPrefs.setLiczbaMiejsc(new double[] { 0.6, 0.1, 0.3 });
		userPrefs.setNiskieKosztyEksploatacji(new double[] { 0.5, 0.5 });
		userPrefs.setDuzyZasieg(new double[] { 0.7, 0.3 });
		userPrefs.setTypSilnika(new double[] { 0.2, 0.5, 0.3 });
		userPrefs.setBagaznik(new double[] { 0.8, 0.1, 0.1 });
		userPrefs.setWysokieOsiagi(new double[] { 0.3, 0.7 });
		return userPrefs;
	}

}
