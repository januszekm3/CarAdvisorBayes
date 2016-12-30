package car.advisor.network;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import smile.Network;
import car.advisor.model.CarCompatibility;
import car.advisor.model.UserPreferences;

public class CarAdvisorNetwork {

	private List<String> models = Arrays.asList("Skoda_Citigo", "Audi_Q5");

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

		double[] miejskaTaniochaDef = { 0.2, 0.8, //
				0.3, 0.7, //
				0.4, 0.6, //
				0.5, 0.5, //
				0.6, 0.4, //
				0.7, 0.3 };

		net.setNodeDefinition("Miejska_Taniocha", miejskaTaniochaDef);

		net.addNode(Network.NodeType.Cpt, "Krotkie_Dojazdy");
		net.addOutcome("Krotkie_Dojazdy", "tak");
		net.addOutcome("Krotkie_Dojazdy", "nie");
		net.deleteOutcome("Krotkie_Dojazdy", 0);
		net.deleteOutcome("Krotkie_Dojazdy", 0);

		net.addArc("Duzy_Zasieg", "Krotkie_Dojazdy");
		net.addArc("Typ_Silnika", "Krotkie_Dojazdy");

		double[] krotkieDojazdyDef = { 0.5, 0.5, //
				0.4, 0.6, //
				0.9, 0.1, //
				0.3, 0.7, //
				0.6, 0.4, //
				0.5, 0.5 };

		net.setNodeDefinition("Krotkie_Dojazdy", krotkieDojazdyDef);
	}

	private void createModelNodes() {
		// Modele - tymczasowo randomowe wartosci, do poprawy

		net.addNode(Network.NodeType.Cpt, "Skoda_Citigo");
		net.addOutcome("Skoda_Citigo", "tak");
		net.addOutcome("Skoda_Citigo", "nie");
		net.deleteOutcome("Skoda_Citigo", 0);
		net.deleteOutcome("Skoda_Citigo", 0);

		net.addArc("Cena", "Skoda_Citigo");
		net.addArc("Liczba_Miejsc", "Skoda_Citigo");
		net.addArc("Miejska_Taniocha", "Skoda_Citigo");
		net.addArc("Krotkie_Dojazdy", "Skoda_Citigo");

		// kolejne wiersze oddzielone /**/ jako ze jest duzo wartosci nie
		// wypisalem tego pionowo
		double[] skodaCitigoDef = { 0.3, 0.7, /**/0.6, 0.4, /**/0.1, 0.9, /**/
		0.5, 0.5, /**/0.8, 0.2, /**/0.4, 0.6, /**/0.9, 0.1, /**/
		0.2, 0.8, /**/0.4, 0.6, /**/0.3, 0.7, /**/0.6, 0.4, /**/0.1, 0.9, /**/
		0.5, 0.5, /**/0.8, 0.2, /**/0.4, 0.6, /**/0.9, 0.1, /**/
		0.2, 0.8, /**/0.4, 0.6, /**/0.3, 0.7, /**/0.6, 0.4, /**/0.1, 0.9, /**/
		0.5, 0.5, /**/0.8, 0.2, /**/0.4, 0.6, /**/0.9, 0.1, /**/
		0.2, 0.8, /**/0.4, 0.6, /**/0.3, 0.7, /**/0.6, 0.4, /**/0.1, 0.9, /**/
		0.5, 0.5, /**/0.8, 0.2, /**/0.4, 0.6, /**/0.9, 0.1, /**/
		0.2, 0.8, /**/0.4, 0.6 };

		net.setNodeDefinition("Skoda_Citigo", skodaCitigoDef);

		net.addNode(Network.NodeType.Cpt, "Audi_Q5");
		net.addOutcome("Audi_Q5", "tak");
		net.addOutcome("Audi_Q5", "nie");
		net.deleteOutcome("Audi_Q5", 0);
		net.deleteOutcome("Audi_Q5", 0);

		net.addArc("Cena", "Audi_Q5");
		net.addArc("Komfort_Jazdy", "Audi_Q5");
		net.addArc("Bogate_Wyposazenie", "Audi_Q5");
		net.addArc("Przeznaczenie", "Audi_Q5");

		double[] audiQ5Def = { 0.5, 0.5, /**/0.3, 0.7, /**/0.9, 0.1, /**/
		0.2, 0.8, /**/0.8, 0.2, /**/0.4, 0.6, /**/0.7, 0.3, /**/0.5, 0.5, /**/
		0.4, 0.6, /**/0.5, 0.5, /**/0.3, 0.7, /**/0.9, 0.1, /**/
		0.2, 0.8, /**/0.8, 0.2, /**/0.4, 0.6, /**/0.7, 0.3, /**/0.5, 0.5, /**/
		0.4, 0.6, /**/0.5, 0.5, /**/0.3, 0.7, /**/0.9, 0.1, /**/
		0.2, 0.8, /**/0.8, 0.2, /**/0.4, 0.6, /**/0.7, 0.3, /**/0.5, 0.5, /**/
		0.4, 0.6, /**/0.5, 0.5, /**/0.3, 0.7, /**/0.9, 0.1, /**/
		0.2, 0.8, /**/0.8, 0.2, /**/0.4, 0.6, /**/0.7, 0.3, /**/0.5, 0.5, /**/
		0.4, 0.6 };

		net.setNodeDefinition("Audi_Q5", audiQ5Def);
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
			bestMatches.append(carCompatibility.getName() + " : "
					+ carCompatibility.getCompatibility() + "\n");
		}
		return bestMatches.toString();
	}

	private void setInputNodesDefinitions(UserPreferences userPrefs) {
		net.setNodeDefinition("Cena", userPrefs.getCenaDef());
		net.setNodeDefinition("Komfort_Jazdy", userPrefs.getKomfortJazdyDef());
		net.setNodeDefinition("Bogate_Wyposazenie",
				userPrefs.getBogateWyposazenieDef());
		net.setNodeDefinition("Przeznaczenie", userPrefs.getPrzeznaczenieDef());
		net.setNodeDefinition("Liczba_Miejsc", userPrefs.getLiczbaMiejscDef());
		net.setNodeDefinition("Niskie_Koszty_Eksploatacji",
				userPrefs.getNiskieKosztyEksploatacjiDef());
		net.setNodeDefinition("Duzy_Zasieg", userPrefs.getDuzyZasiegDef());
		net.setNodeDefinition("Typ_Silnika", userPrefs.getTypSilnikaDef());
		net.updateBeliefs();
	}

}
