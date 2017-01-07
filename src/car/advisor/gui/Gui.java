package car.advisor.gui;

import java.awt.GridLayout;
import java.util.Hashtable;

import javax.swing.*;

import car.advisor.model.UserPreferences;

/**
 * Created by Janusz on 07-01-2017.
 */
public class Gui {

    public static void main(String[] args) {
        Gui.run();
    }

    private static void run() {

        Hashtable labelTable = new Hashtable();
        for (int i = 0; i < 101; i += 20)
            labelTable.put(new Integer(i), new JLabel("" + i + "%"));

        JFrame frame = new JFrame();

        JPanel cenyPanel = new JPanel();
        cenyPanel.setBorder(BorderFactory.createTitledBorder("Cena"));

        JLabel cenaMalaJLabel = new JLabel("Mala", JLabel.CENTER);
        JSlider cenaMalaJSlider = new JSlider(0, 100);
        cenaMalaJSlider.setLabelTable(labelTable);
        cenaMalaJSlider.setPaintLabels(true);
        cenyPanel.add(cenaMalaJLabel);
        cenyPanel.add(cenaMalaJSlider);

        JLabel cenaSredniaJLabel = new JLabel("Srednia", JLabel.CENTER);
        JSlider cenaSredniaJSlider = new JSlider(0, 100);
        cenaSredniaJSlider.setLabelTable(labelTable);
        cenaSredniaJSlider.setPaintLabels(true);
        cenyPanel.add(cenaSredniaJLabel);
        cenyPanel.add(cenaSredniaJSlider);

        JLabel cenaDuzaJLabel = new JLabel("Duza", JLabel.CENTER);
        JSlider cenaDuzaJSlider = new JSlider(0, 100);
        cenaDuzaJSlider.setLabelTable(labelTable);
        cenaDuzaJSlider.setPaintLabels(true);
        cenyPanel.add(cenaDuzaJLabel);
        cenyPanel.add(cenaDuzaJSlider);

        JPanel komfortJazdyPanel = new JPanel();
        komfortJazdyPanel.setBorder(BorderFactory.createTitledBorder("Komfort jazdy"));

        JSlider komfortJazdyJSlider = new JSlider(0, 100);
        komfortJazdyJSlider.setLabelTable(labelTable);
        komfortJazdyJSlider.setPaintLabels(true);
        komfortJazdyPanel.add(komfortJazdyJSlider);

        JPanel bogateWyposazeniePanel = new JPanel();
        bogateWyposazeniePanel.setBorder(BorderFactory.createTitledBorder("Bogate wyposazenie"));

        JSlider bogateWyposazenieJSlider = new JSlider(0, 100);
        bogateWyposazenieJSlider.setLabelTable(labelTable);
        bogateWyposazenieJSlider.setPaintLabels(true);
        bogateWyposazeniePanel.add(bogateWyposazenieJSlider);

        JPanel przeznaczeniePanel = new JPanel();
        przeznaczeniePanel.setBorder(BorderFactory.createTitledBorder("Przeznaczenie"));

        JLabel przeznaczenieMiastoJLabel = new JLabel("Miasto", JLabel.CENTER);
        JSlider przeznaczenieMiastoJSlider = new JSlider(0, 100);
        przeznaczenieMiastoJSlider.setLabelTable(labelTable);
        przeznaczenieMiastoJSlider.setPaintLabels(true);
        przeznaczeniePanel.add(przeznaczenieMiastoJLabel);
        przeznaczeniePanel.add(przeznaczenieMiastoJSlider);

        JLabel przeznaczenieTrasaJLabel = new JLabel("Trasa", JLabel.CENTER);
        JSlider przeznaczenieTrasaJSlider = new JSlider(0, 100);
        przeznaczenieTrasaJSlider.setLabelTable(labelTable);
        przeznaczenieTrasaJSlider.setPaintLabels(true);
        przeznaczeniePanel.add(przeznaczenieTrasaJLabel);
        przeznaczeniePanel.add(przeznaczenieTrasaJSlider);

        JLabel przeznaczenieTerenJLabel = new JLabel("Teren", JLabel.CENTER);
        JSlider przeznaczenieTerenJSlider = new JSlider(0, 100);
        przeznaczenieTerenJSlider.setLabelTable(labelTable);
        przeznaczenieTerenJSlider.setPaintLabels(true);
        przeznaczeniePanel.add(przeznaczenieTerenJLabel);
        przeznaczeniePanel.add(przeznaczenieTerenJSlider);

        JPanel liczbaMiejscPanel = new JPanel();
        liczbaMiejscPanel.setBorder(BorderFactory.createTitledBorder("Liczba miejsc"));

        JLabel liczbaMiejscMniejJLabel = new JLabel("Mniej niz 5", JLabel.CENTER);
        JSlider liczbaMiejscMniejJSlider = new JSlider(0, 100);
        liczbaMiejscMniejJSlider.setLabelTable(labelTable);
        liczbaMiejscMniejJSlider.setPaintLabels(true);
        liczbaMiejscPanel.add(liczbaMiejscMniejJLabel);
        liczbaMiejscPanel.add(liczbaMiejscMniejJSlider);

        JLabel liczbaMiejscDokladnieJLabel = new JLabel("Dokladnie 5", JLabel.CENTER);
        JSlider liczbaMiejscDokladnieJSlider = new JSlider(0, 100);
        liczbaMiejscDokladnieJSlider.setLabelTable(labelTable);
        liczbaMiejscDokladnieJSlider.setPaintLabels(true);
        liczbaMiejscPanel.add(liczbaMiejscDokladnieJLabel);
        liczbaMiejscPanel.add(liczbaMiejscDokladnieJSlider);

        JLabel liczbaMiejscWiecejJLabel = new JLabel("Wiecej niz 5", JLabel.CENTER);
        JSlider liczbaMiejscWiecejJSlider = new JSlider(0, 100);
        liczbaMiejscWiecejJSlider.setLabelTable(labelTable);
        liczbaMiejscWiecejJSlider.setPaintLabels(true);
        liczbaMiejscPanel.add(liczbaMiejscWiecejJLabel);
        liczbaMiejscPanel.add(liczbaMiejscWiecejJSlider);

        JPanel niskieKosztyEksploatacjiPanel = new JPanel();
        niskieKosztyEksploatacjiPanel.setBorder(BorderFactory.createTitledBorder("Niskie koszty eksploatacji"));

        JSlider niskieKosztyEksploatacjiJSlider = new JSlider(0, 100);
        niskieKosztyEksploatacjiJSlider.setLabelTable(labelTable);
        niskieKosztyEksploatacjiJSlider.setPaintLabels(true);
        niskieKosztyEksploatacjiPanel.add(niskieKosztyEksploatacjiJSlider);

        JPanel duzyZasiegPanel = new JPanel();
        duzyZasiegPanel.setBorder(BorderFactory.createTitledBorder("Duzy zasieg"));

        JSlider duzyZasiegJSlider = new JSlider(0, 100);
        duzyZasiegJSlider.setLabelTable(labelTable);
        duzyZasiegJSlider.setPaintLabels(true);
        duzyZasiegPanel.add(duzyZasiegJSlider);

        JPanel typSilnikaPanel = new JPanel();
        typSilnikaPanel.setBorder(BorderFactory.createTitledBorder("Typ silnika"));

        JLabel typSilnikaBenzynaJLabel = new JLabel("Benzyna", JLabel.CENTER);
        JSlider typSilnikaBenzynaJSlider = new JSlider(0, 100);
        typSilnikaBenzynaJSlider.setLabelTable(labelTable);
        typSilnikaBenzynaJSlider.setPaintLabels(true);
        typSilnikaPanel.add(typSilnikaBenzynaJLabel);
        typSilnikaPanel.add(typSilnikaBenzynaJSlider);

        JLabel typSilnikaDieselJLabel = new JLabel("Diesel", JLabel.CENTER);
        JSlider typSilnikaDieselJSlider = new JSlider(0, 100);
        typSilnikaDieselJSlider.setLabelTable(labelTable);
        typSilnikaDieselJSlider.setPaintLabels(true);
        typSilnikaPanel.add(typSilnikaDieselJLabel);
        typSilnikaPanel.add(typSilnikaDieselJSlider);

        JLabel typSilnikaHybrydaJLabel = new JLabel("Hybryda", JLabel.CENTER);
        JSlider typSilnikaHybrydaJSlider = new JSlider(0, 100);
        typSilnikaHybrydaJSlider.setLabelTable(labelTable);
        typSilnikaHybrydaJSlider.setPaintLabels(true);
        typSilnikaPanel.add(typSilnikaHybrydaJLabel);
        typSilnikaPanel.add(typSilnikaHybrydaJSlider);

        JPanel bagaznikPanel = new JPanel();
        bagaznikPanel.setBorder(BorderFactory.createTitledBorder("Bagaznik"));

        JLabel bagaznikMalyJLabel = new JLabel("Maly", JLabel.CENTER);
        JSlider bagaznikMalyJSlider = new JSlider(0, 100);
        bagaznikMalyJSlider.setLabelTable(labelTable);
        bagaznikMalyJSlider.setPaintLabels(true);
        bagaznikPanel.add(bagaznikMalyJLabel);
        bagaznikPanel.add(bagaznikMalyJSlider);

        JLabel bagaznikPraktycznyJLabel = new JLabel("Praktyczny", JLabel.CENTER);
        JSlider bagaznikPraktycznyJSlider = new JSlider(0, 100);
        bagaznikPraktycznyJSlider.setLabelTable(labelTable);
        bagaznikPraktycznyJSlider.setPaintLabels(true);
        bagaznikPanel.add(bagaznikPraktycznyJLabel);
        bagaznikPanel.add(bagaznikPraktycznyJSlider);

        JLabel bagaznikObszernyJLabel = new JLabel("Obszerny", JLabel.CENTER);
        JSlider bagaznikObszernyJSlider = new JSlider(0, 100);
        bagaznikObszernyJSlider.setLabelTable(labelTable);
        bagaznikObszernyJSlider.setPaintLabels(true);
        bagaznikPanel.add(bagaznikObszernyJLabel);
        bagaznikPanel.add(bagaznikObszernyJSlider);

        JPanel wysokieOsiagiPanel = new JPanel();
        wysokieOsiagiPanel.setBorder(BorderFactory.createTitledBorder("Wysokie osiagi"));

        JSlider wysokieOsiagiJSlider = new JSlider(0, 100);
        wysokieOsiagiJSlider.setLabelTable(labelTable);
        wysokieOsiagiJSlider.setPaintLabels(true);
        wysokieOsiagiPanel.add(wysokieOsiagiJSlider);

        frame.setLayout(new GridLayout(11, 1));
        frame.add(cenyPanel);
        frame.add(komfortJazdyPanel);
        frame.add(bogateWyposazeniePanel);
        frame.add(przeznaczeniePanel);
        frame.add(liczbaMiejscPanel);
        frame.add(niskieKosztyEksploatacjiPanel);
        frame.add(duzyZasiegPanel);
        frame.add(typSilnikaPanel);
        frame.add(bagaznikPanel);
        frame.add(wysokieOsiagiPanel);

        JPanel carAdvisorPanel = new JPanel();
        JButton chooseButton = new JButton("Szukaj");
        carAdvisorPanel.add(chooseButton);
        frame.add(carAdvisorPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1400, 800);
        frame.setVisible(true);

        UserPreferences preferences = new UserPreferences();

        chooseButton.addActionListener(ae -> {
            double sum = 0.0;
            sum = cenaMalaJSlider.getValue() + cenaSredniaJSlider.getValue() + cenaDuzaJSlider.getValue();
            preferences.setCena(new double[] { cenaMalaJSlider.getValue() / sum, cenaSredniaJSlider.getValue() / sum,
                    cenaDuzaJSlider.getValue() / sum});
            preferences.setKomfortJazdy(new double[] { komfortJazdyJSlider.getValue()/100.0,
                    1 - komfortJazdyJSlider.getValue()/100.0});
            preferences.setBogateWyposazenie(new double[] { bogateWyposazenieJSlider.getValue()/100.0,
                    1 - bogateWyposazenieJSlider.getValue()/100.0});
            sum = przeznaczenieMiastoJSlider.getValue() + przeznaczenieTerenJSlider.getValue()
                    + przeznaczenieTrasaJSlider.getValue();
            preferences.setPrzeznaczenie(new double[] { przeznaczenieMiastoJSlider.getValue() / sum,
                    przeznaczenieTerenJSlider.getValue() / sum, przeznaczenieTrasaJSlider.getValue() / sum});
            sum = liczbaMiejscMniejJSlider.getValue() + liczbaMiejscDokladnieJSlider.getValue()
                    + liczbaMiejscWiecejJSlider.getValue();
            preferences.setLiczbaMiejsc(new double[] { liczbaMiejscMniejJSlider.getValue() / sum,
                    liczbaMiejscDokladnieJSlider.getValue() / sum, liczbaMiejscWiecejJSlider.getValue() / sum});
            preferences.setNiskieKosztyEksploatacji(new double[] { niskieKosztyEksploatacjiJSlider.getValue()/100.0,
                    1 - niskieKosztyEksploatacjiJSlider.getValue()/100.0});
            preferences.setDuzyZasieg(new double[] { duzyZasiegJSlider.getValue()/100.0,
                    1 - duzyZasiegJSlider.getValue()/100.0});
            sum = typSilnikaBenzynaJSlider.getValue() + typSilnikaDieselJSlider.getValue()
                    + typSilnikaHybrydaJSlider.getValue();
            preferences.setTypSilnika(new double[] { typSilnikaBenzynaJSlider.getValue() / sum,
                    typSilnikaDieselJSlider.getValue() / sum, typSilnikaHybrydaJSlider.getValue() / sum});
            sum = bagaznikMalyJSlider.getValue() + bagaznikPraktycznyJSlider.getValue()
                    + bagaznikObszernyJSlider.getValue();
            preferences.setBagaznik(new double[] { bagaznikMalyJSlider.getValue() / sum,
                    bagaznikPraktycznyJSlider.getValue() / sum, bagaznikObszernyJSlider.getValue() / sum});
            preferences.setWysokieOsiagi(new double[] { wysokieOsiagiJSlider.getValue()/100.0,
                    1 - wysokieOsiagiJSlider.getValue()/100.0});
        });
    }
}