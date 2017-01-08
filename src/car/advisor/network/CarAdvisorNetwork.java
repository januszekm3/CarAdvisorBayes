package car.advisor.network;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import smile.Network;
import car.advisor.model.CarCompatibility;
import car.advisor.model.UserPreferences;

public class CarAdvisorNetwork {

	private List<String> models = Arrays.asList("Skoda_Citigo", "Audi_Q5",
			"Ford_Focus_ST", "Lexus_CT_200H");

	private Network net;

	public CarAdvisorNetwork() {
		net = new Network();
		initNetwork();
	}

	private void initNetwork() {
		createInputNodes();
		createIntermediateNodes();
		createModelNodes();
	}

	private void createInputNodes() {
		// Wezly wejsciowe

		net.addNode(Network.NodeType.Cpt, "Cena");
		net.addOutcome("Cena", "mala");
		net.addOutcome("Cena", "srednia");
		net.addOutcome("Cena", "duza");
		// usuwanie defaultowo stworzonych outcomes
		net.deleteOutcome("Cena", 0);
		net.deleteOutcome("Cena", 0);

		net.addNode(Network.NodeType.Cpt, "Komfort_Jazdy");
		net.addOutcome("Komfort_Jazdy", "tak");
		net.addOutcome("Komfort_Jazdy", "nie");
		net.deleteOutcome("Komfort_Jazdy", 0);
		net.deleteOutcome("Komfort_Jazdy", 0);

		net.addNode(Network.NodeType.Cpt, "Bogate_Wyposazenie");
		net.addOutcome("Bogate_Wyposazenie", "tak");
		net.addOutcome("Bogate_Wyposazenie", "nie");
		net.deleteOutcome("Bogate_Wyposazenie", 0);
		net.deleteOutcome("Bogate_Wyposazenie", 0);

		net.addNode(Network.NodeType.Cpt, "Przeznaczenie");
		net.addOutcome("Przeznaczenie", "miasto");
		net.addOutcome("Przeznaczenie", "miasto_trasa");
		net.addOutcome("Przeznaczenie", "miasto_trasa_teren");
		net.deleteOutcome("Przeznaczenie", 0);
		net.deleteOutcome("Przeznaczenie", 0);

		net.addNode(Network.NodeType.Cpt, "Liczba_Miejsc");
		net.addOutcome("Liczba_Miejsc", "mniej");
		net.addOutcome("Liczba_Miejsc", "miejsc5");
		net.addOutcome("Liczba_Miejsc", "wiecej");
		net.deleteOutcome("Liczba_Miejsc", 0);
		net.deleteOutcome("Liczba_Miejsc", 0);

		net.addNode(Network.NodeType.Cpt, "Niskie_Koszty_Eksploatacji");
		net.addOutcome("Niskie_Koszty_Eksploatacji", "tak");
		net.addOutcome("Niskie_Koszty_Eksploatacji", "nie");
		net.deleteOutcome("Niskie_Koszty_Eksploatacji", 0);
		net.deleteOutcome("Niskie_Koszty_Eksploatacji", 0);

		net.addNode(Network.NodeType.Cpt, "Duzy_Zasieg");
		net.addOutcome("Duzy_Zasieg", "tak");
		net.addOutcome("Duzy_Zasieg", "nie");
		net.deleteOutcome("Duzy_Zasieg", 0);
		net.deleteOutcome("Duzy_Zasieg", 0);

		net.addNode(Network.NodeType.Cpt, "Typ_Silnika");
		net.addOutcome("Typ_Silnika", "benzyna");
		net.addOutcome("Typ_Silnika", "diesel");
		net.addOutcome("Typ_Silnika", "hybryda");
		net.deleteOutcome("Typ_Silnika", 0);
		net.deleteOutcome("Typ_Silnika", 0);

		net.addNode(Network.NodeType.Cpt, "Bagaznik");
		net.addOutcome("Bagaznik", "maly");
		net.addOutcome("Bagaznik", "praktyczny");
		net.addOutcome("Bagaznik", "obszerny");
		net.deleteOutcome("Bagaznik", 0);
		net.deleteOutcome("Bagaznik", 0);

		net.addNode(Network.NodeType.Cpt, "Wysokie_Osiagi");
		net.addOutcome("Wysokie_Osiagi", "tak");
		net.addOutcome("Wysokie_Osiagi", "nie");
		net.deleteOutcome("Wysokie_Osiagi", 0);
		net.deleteOutcome("Wysokie_Osiagi", 0);
	}

	private void createIntermediateNodes() {
		// Wezly posrednie - tymczasowo randomowe wartosci, do poprawy

		net.addNode(Network.NodeType.Cpt, "Miejska_Taniocha");
		net.addOutcome("Miejska_Taniocha", "tak");
		net.addOutcome("Miejska_Taniocha", "nie");
		net.deleteOutcome("Miejska_Taniocha", 0);
		net.deleteOutcome("Miejska_Taniocha", 0);

		net.addArc("Przeznaczenie", "Miejska_Taniocha");
		net.addArc("Niskie_Koszty_Eksploatacji", "Miejska_Taniocha");

		// The order of these probabilities is given by considering the state
		// of the first parent of the node as the most significant
		// coordinate, then the second parent, then the third (and so on)

		// jeden wiersz odpowiada jednej kolumnie z tabelki graficznego genie
		// ( wartosci sumuja sie do 1.0 )
		// w tym przypadku sa 2 stany wynikowe "tak" - pierwsza kolumna, "nie" -
		// druga kolumna
		// wiersz to prawdopodobienstwa stanow node'a pod warunkiem konkretnych
		// stanow rodzicow
		// czyli dla pierwszego wiersza to prawdopodobienstwa pod warunkiem
		// Przeznaczenie = miasto, Nieskie_Koszty_Eksploatacji = tak

		double[] miejskaTaniochaDef = { 0.8, 0.2, //
				0.7, 0.3, //
				0.6, 0.4, //
				0.5, 0.5, //
				0.4, 0.6, //
				0.3, 0.7 };

		net.setNodeDefinition("Miejska_Taniocha", miejskaTaniochaDef);

		net.addNode(Network.NodeType.Cpt, "Krotkie_Dojazdy");
		net.addOutcome("Krotkie_Dojazdy", "tak");
		net.addOutcome("Krotkie_Dojazdy", "nie");
		net.deleteOutcome("Krotkie_Dojazdy", 0);
		net.deleteOutcome("Krotkie_Dojazdy", 0);

		net.addArc("Duzy_Zasieg", "Krotkie_Dojazdy");
		net.addArc("Typ_Silnika", "Krotkie_Dojazdy");

		double[] krotkieDojazdyDef = { 0.5, 0.5, //
				0.6, 0.4, //
				0.1, 0.9, //
				0.7, 0.3, //
				0.4, 0.6, //
				0.5, 0.5 };

		net.setNodeDefinition("Krotkie_Dojazdy", krotkieDojazdyDef);

		net.addNode(Network.NodeType.Cpt, "Rodzinne");
		net.addOutcome("Rodzinne", "tak");
		net.addOutcome("Rodzinne", "nie");
		net.deleteOutcome("Rodzinne", 0);
		net.deleteOutcome("Rodzinne", 0);

		net.addArc("Liczba_Miejsc", "Rodzinne");
		net.addArc("Komfort_Jazdy", "Rodzinne");
		net.addArc("Bagaznik", "Rodzinne");

		double[] rodzinneDef = { 0.5, 0.5, /**/0.4, 0.6, /**/0.6, 0.4, /**/
		0.5, 0.5, /**/0.3, 0.7, /**/0.5, 0.5, /**/
		0.5, 0.5, /**/0.4, 0.6, /**/0.6, 0.4, /**/
		0.5, 0.5, /**/0.3, 0.7, /**/0.5, 0.5, /**/
		0.5, 0.5, /**/0.4, 0.6, /**/0.6, 0.4, /**/
		0.5, 0.5, /**/0.3, 0.7, /**/0.5, 0.5 };

		net.setNodeDefinition("Rodzinne", rodzinneDef);

		net.addNode(Network.NodeType.Cpt, "Studencki_Standard");
		net.addOutcome("Studencki_Standard", "tak");
		net.addOutcome("Studencki_Standard", "nie");
		net.deleteOutcome("Studencki_Standard", 0);
		net.deleteOutcome("Studencki_Standard", 0);

		net.addArc("Komfort_Jazdy", "Studencki_Standard");
		net.addArc("Bogate_Wyposazenie", "Studencki_Standard");
		net.addArc("Wysokie_Osiagi", "Studencki_Standard");

		double[] studenckiStandardDef = { 0.8, 0.2, //
				0.6, 0.4, //
				0.5, 0.5, //
				0.5, 0.5, //
				0.7, 0.3, //
				0.1, 0.9, //
				0.2, 0.8, //
				0.4, 0.6 };

		net.setNodeDefinition("Studencki_Standard", studenckiStandardDef);

		net.addNode(Network.NodeType.Cpt, "Zazdrosc_Sasiadow");
		net.addOutcome("Zazdrosc_Sasiadow", "tak");
		net.addOutcome("Zazdrosc_Sasiadow", "nie");
		net.deleteOutcome("Zazdrosc_Sasiadow", 0);
		net.deleteOutcome("Zazdrosc_Sasiadow", 0);

		net.addArc("Bogate_Wyposazenie", "Zazdrosc_Sasiadow");
		net.addArc("Wysokie_Osiagi", "Zazdrosc_Sasiadow");

		double[] zazdroscSasiadowDef = { 0.8, 0.2, //
				0.6, 0.4, //
				0.4, 0.6, //
				0.3, 0.7 };

		net.setNodeDefinition("Zazdrosc_Sasiadow", zazdroscSasiadowDef);

		net.addNode(Network.NodeType.Cpt, "Szybka_Bestia");
		net.addOutcome("Szybka_Bestia", "tak");
		net.addOutcome("Szybka_Bestia", "nie");
		net.deleteOutcome("Szybka_Bestia", 0);
		net.deleteOutcome("Szybka_Bestia", 0);

		net.addArc("Wysokie_Osiagi", "Szybka_Bestia");
		net.addArc("Niskie_Koszty_Eksploatacji", "Szybka_Bestia");

		double[] szybkaBestiaDef = { 0.75, 0.25, //
				0.95, 0.05, //
				0.1, 0.9, //
				0.0, 1.0 };

		net.setNodeDefinition("Szybka_Bestia", szybkaBestiaDef);

		net.addNode(Network.NodeType.Cpt, "Dlugodystansowiec");
		net.addOutcome("Dlugodystansowiec", "tak");
		net.addOutcome("Dlugodystansowiec", "nie");
		net.deleteOutcome("Dlugodystansowiec", 0);
		net.deleteOutcome("Dlugodystansowiec", 0);

		net.addArc("Niskie_Koszty_Eksploatacji", "Dlugodystansowiec");
		net.addArc("Duzy_Zasieg", "Dlugodystansowiec");

		double[] dlugodystansowiecDef = { 0.9, 0.1, //
				0.7, 0.3, //
				0.1, 0.9, //
				0.4, 0.6 };

		net.setNodeDefinition("Dlugodystansowiec", dlugodystansowiecDef);

		net.addNode(Network.NodeType.Cpt, "Eko");
		net.addOutcome("Eko", "tak");
		net.addOutcome("Eko", "nie");
		net.deleteOutcome("Eko", 0);
		net.deleteOutcome("Eko", 0);

		net.addArc("Dlugodystansowiec", "Eko");
		net.addArc("Typ_Silnika", "Eko");

		double[] ekoDef = { 0.6, 0.4, //
				0.6, 0.4, //
				0.8, 0.2, //
				0.4, 0.6, //
				0.2, 0.8, //
				0.1, 0.9 };

		net.setNodeDefinition("Eko", ekoDef);
	}

	private void createModelNodes() {
		// Modele - tymczasowo randomowe wartosci, do poprawy

		net.addNode(Network.NodeType.Cpt, "Skoda_Citigo");
		net.addOutcome("Skoda_Citigo", "tak");
		net.addOutcome("Skoda_Citigo", "nie");
		net.deleteOutcome("Skoda_Citigo", 0);
		net.deleteOutcome("Skoda_Citigo", 0);

		net.addArc("Cena", "Skoda_Citigo");
		net.addArc("Krotkie_Dojazdy", "Skoda_Citigo");
		net.addArc("Liczba_Miejsc", "Skoda_Citigo");
		net.addArc("Miejska_Taniocha", "Skoda_Citigo");

		// kolejne wiersze oddzielone /**/ jako ze jest duzo wartosci nie
		// wypisalem tego pionowo
		double[] skodaCitigoDef = { /**/
		0.9, 0.1, /**/0.8, 0.2, /**/0.8, 0.2, /**/
		0.7, 0.3, /**/0.6, 0.4, /**/0.4, 0.6, /**/
		0.7, 0.3, /**/0.5, 0.5, /**/0.6, 0.4, /**/
		0.4, 0.6, /**/0.4, 0.6, /**/0.3, 0.7, /**/
		0.5, 0.5, /**/0.3, 0.7, /**/0.4, 0.6, /**/
		0.5, 0.5, /**/0.2, 0.8, /**/0.1, 0.9, /**/
		0.4, 0.6, /**/0.3, 0.7, /**/0.3, 0.7, /**/
		0.2, 0.8, /**/0.2, 0.8, /**/0.1, 0.9, /**/
		0.5, 0.5, /**/0.3, 0.7, /**/0.4, 0.6, /**/
		0.3, 0.7, /**/0.3, 0.7, /**/0.2, 0.8, /**/
		0.3, 0.7, /**/0.2, 0.8, /**/0.4, 0.6, /**/
		0.2, 0.8, /**/0.1, 0.9, /**/0.1, 0.9 };

		net.setNodeDefinition("Skoda_Citigo", skodaCitigoDef);

		net.addNode(Network.NodeType.Cpt, "Audi_Q5");
		net.addOutcome("Audi_Q5", "tak");
		net.addOutcome("Audi_Q5", "nie");
		net.deleteOutcome("Audi_Q5", 0);
		net.deleteOutcome("Audi_Q5", 0);

		net.addArc("Komfort_Jazdy", "Audi_Q5");
		net.addArc("Bogate_Wyposazenie", "Audi_Q5");
		net.addArc("Przeznaczenie", "Audi_Q5");
		net.addArc("Cena", "Audi_Q5");

		double[] audiQ5Def = { /**/
		0.1, 0.9, /**/0.3, 0.7, /**/0.55, 0.45, /**/
		0.05, 0.95, /**/0.35, 0.65, /**/0.5, 0.5, /**/
		0.05, 0.95, /**/0.15, 0.85, /**/0.45, 0.55, /**/
		0.0, 1.0, /**/0.1, 0.9, /**/0.35, 0.65, /**/
		0.15, 0.85, /**/0.35, 0.65, /**/0.8, 0.2, /**/
		0.1, 0.9, /**/0.3, 0.7, /**/0.6, 0.4, /**/
		0.1, 0.9, /**/0.35, 0.65, /**/0.7, 0.3, /**/
		0.05, 0.95, /**/0.15, 0.85, /**/0.35, 0.65, /**/
		0.15, 0.85, /**/0.45, 0.55, /**/0.95, 0.05, /**/
		0.1, 0.9, /**/0.4, 0.6, /**/0.85, 0.15, /**/
		0.1, 0.9, /**/0.35, 0.65, /**/0.65, 0.35, /**/
		0.05, 0.95, /**/0.25, 0.75, /**/0.5, 0.5 };

		net.setNodeDefinition("Audi_Q5", audiQ5Def);

		net.addNode(Network.NodeType.Cpt, "Ford_Focus_ST");
		net.addOutcome("Ford_Focus_ST", "tak");
		net.addOutcome("Ford_Focus_ST", "nie");
		net.deleteOutcome("Ford_Focus_ST", 0);
		net.deleteOutcome("Ford_Focus_ST", 0);

		net.addArc("Szybka_Bestia", "Ford_Focus_ST");
		net.addArc("Typ_Silnika", "Ford_Focus_ST");
		net.addArc("Cena", "Ford_Focus_ST");
		net.addArc("Dlugodystansowiec", "Ford_Focus_ST");

		double[] fordFocusSTDef = { /**/
		0.2, 0.8, /**/0.3, 0.7, /**/0.25, 0.75, /**/
		0.3, 0.7, /**/0.95, 0.05, /**/0.9, 0.1, /**/
		0.1, 0.9, /**/0.1, 0.9, /**/0.1, 0.9, /**/
		0.1, 0.9, /**/0.1, 0.9, /**/0.1, 0.9, /**/
		0.1, 0.9, /**/0.1, 0.9, /**/0.1, 0.9, /**/
		0.1, 0.9, /**/0.1, 0.9, /**/0.1, 0.9, /**/
	    0.1, 0.9, /**/0.1, 0.9, /**/0.1, 0.9, /**/
		0.1, 0.9, /**/0.1, 0.9, /**/0.1, 0.9, /**/
		0.1, 0.9, /**/0.1, 0.9, /**/0.1, 0.9, /**/
		0.1, 0.9, /**/0.1, 0.9, /**/0.1, 0.9, /**/
		0.1, 0.9, /**/0.1, 0.9, /**/0.1, 0.9, /**/
		0.1, 0.9, /**/0.1, 0.9, /**/0.1, 0.9, /**/};

		net.setNodeDefinition("Ford_Focus_ST", fordFocusSTDef);

		net.addNode(Network.NodeType.Cpt, "Lexus_CT_200H");
		net.addOutcome("Lexus_CT_200H", "tak");
		net.addOutcome("Lexus_CT_200H", "nie");
		net.deleteOutcome("Lexus_CT_200H", 0);
		net.deleteOutcome("Lexus_CT_200H", 0);

		net.addArc("Cena", "Lexus_CT_200H");
		net.addArc("Eko", "Lexus_CT_200H");
		net.addArc("Bogate_Wyposazenie", "Lexus_CT_200H");
		net.addArc("Bagaznik", "Lexus_CT_200H");

		double[] lexusCT200HDef = { /**/
		0.25, 0.75, /**/0.3, 0.7, /**/0.25, 0.75, /**/
		0.15, 0.85, /**/0.25, 0.75, /**/0.15, 0.85, /**/
		0.15, 0.85, /**/0.25, 0.75, /**/0.15, 0.85, /**/
		0.0, 1.0, /**/0.1, 0.9, /**/0.0, 1.0, /**/
		0.6, 0.4, /**/0.7, 0.3, /**/0.4, 0.6, /**/
		0.5, 0.5, /**/0.6, 0.4, /**/0.4, 0.6, /**/
		0.4, 0.6, /**/0.5, 0.5, /**/0.3, 0.7, /**/
		0.35, 0.65, /**/0.45, 0.55, /**/0.25, 0.75, /**/
		0.85, 0.15, /**/1.0, 0.0, /**/0.8, 0.2, /**/
		0.6, 0.4, /**/0.75, 0.25, /**/0.5, 0.5, /**/
		0.35, 0.65, /**/0.7, 0.3, /**/0.45, 0.55, /**/
		0.3, 0.7, /**/0.65, 0.35, /**/0.2, 0.8, /**/
		};

		net.setNodeDefinition("Lexus_CT_200H", lexusCT200HDef);
	}

	public String getBestMatches(UserPreferences userPrefs) {
		setInputNodesDefinitions(userPrefs);
		StringBuilder bestMatches = new StringBuilder();
		List<CarCompatibility> carCompatibilities = new ArrayList<>(
				models.size());
		for (String model : models) {
			String[] modelOutcomeIds = net.getOutcomeIds(model);
			int outcomeIndex;
			for (outcomeIndex = 0; outcomeIndex < modelOutcomeIds.length; outcomeIndex++)
				if ("tak".equals(modelOutcomeIds[outcomeIndex]))
					break;
			double[] modelValues = net.getNodeValue(model);
			double modelCompatibility = modelValues[outcomeIndex];
			carCompatibilities.add(new CarCompatibility(model,
					modelCompatibility));
		}
		carCompatibilities.sort(Comparator.comparing(
				CarCompatibility::getCompatibility).reversed());
		for (CarCompatibility carCompatibility : carCompatibilities) {
			bestMatches.append(carCompatibility.getName() + ": "
					+ BigDecimal.valueOf(100*carCompatibility.getCompatibility())
                    .setScale(2, RoundingMode.HALF_UP).doubleValue() + "%\n");
		}
		return bestMatches.toString();
	}

	private void setInputNodesDefinitions(UserPreferences userPrefs) {
		net.setNodeDefinition("Cena", userPrefs.getCena());
		net.setNodeDefinition("Komfort_Jazdy", userPrefs.getKomfortJazdy());
		net.setNodeDefinition("Bogate_Wyposazenie",
				userPrefs.getBogateWyposazenie());
		net.setNodeDefinition("Przeznaczenie", userPrefs.getPrzeznaczenie());
		net.setNodeDefinition("Liczba_Miejsc", userPrefs.getLiczbaMiejsc());
		net.setNodeDefinition("Niskie_Koszty_Eksploatacji",
				userPrefs.getNiskieKosztyEksploatacji());
		net.setNodeDefinition("Duzy_Zasieg", userPrefs.getDuzyZasieg());
		net.setNodeDefinition("Typ_Silnika", userPrefs.getTypSilnika());
		net.setNodeDefinition("Bagaznik", userPrefs.getBagaznik());
		net.setNodeDefinition("Wysokie_Osiagi", userPrefs.getWysokieOsiagi());
		net.updateBeliefs();
	}
}
