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
		userPrefs.setCenaDef(new double[] { 0.2, 0.3, 0.5 });
		userPrefs.setKomfortJazdyDef(new double[] { 0.4, 0.6 });
		userPrefs.setBogateWyposazenieDef(new double[] { 0.9, 0.1 });
		userPrefs.setPrzeznaczenieDef(new double[] { 0.3, 0.5, 0.2 });
		userPrefs.setLiczbaMiejscDef(new double[] { 0.6, 0.1, 0.3 });
		userPrefs.setNiskieKosztyEksploatacjiDef(new double[] { 0.5, 0.5 });
		userPrefs.setDuzyZasiegDef(new double[] { 0.7, 0.3 });
		userPrefs.setTypSilnikaDef(new double[] { 0.2, 0.5, 0.3 });
		return userPrefs;
	}

}
