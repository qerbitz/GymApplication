/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.AdresyDAO;
import DAO.CzlonkostwaDAO;
import DAO.JDBC_Connection;
import DAO.KarnetyDAO;
import DAO.Kategorie_zajecDAO;
import DAO.KlienciDAO;
import DAO.PersonelDAO;
import Models.Adresy;
import Models.Czlonkostwa;
import Models.Karnety;
import Models.Kategorie_zajec;
import Models.Klienci;
import Models.Personel;
import Models.Produkty;
import Models.Zamowienia;
import javafx.event.Event;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class BorderPaneController implements Initializable {

    //Zakladka Karnety
    @FXML
    private TextField text_karnet_nazwa;
    @FXML
    private TextField text_karnet_waznosc;
    @FXML
    private TextField text_karnet_cena;
    @FXML
    private Button btn_karnet_zapisz;
    @FXML
    private Button btn_karnet_wyczysc;
    @FXML
    private TableView karnet_tabelka;
    @FXML
    private TableColumn<Karnety, String> table_karnet_nazwa;
    @FXML
    private TableColumn<Karnety, Integer> table_karnet_waznosc;
    @FXML
    private TableColumn<Karnety, Float> table_karnet_cena;
    @FXML
    private TableColumn<Karnety, Integer> table_karnet_id;

    //
    //
    //
    //Zakladka Klienci
    //
    //
    //
    @FXML
    private TextField text_klient_imie;
    @FXML
    private TextField text_klient_nazwisko;
    @FXML
    private TextField text_klient_telefon;
    @FXML
    private DatePicker dataur_klient;
    @FXML
    private TextField text_klient_mail;
    @FXML
    private TextField text_klient_wojewodztwo;
    @FXML
    private TextField text_klient_powiat;
    @FXML
    private TextField text_klient_miejscowosc;
    @FXML
    private TextField text_klient_ulica;
    @FXML
    private TextField text_klient_nr_domu;
    @FXML
    private TextField text_klient_kod_pocztowy;

    @FXML
    private Button btn_klient_zapisz;
    @FXML
    private Button btn_klient_wyczysc;

    @FXML
    private TableView klient_tabelka;

    @FXML
    private TableColumn<Klienci, Integer> table_klient_id;
    @FXML
    private TableColumn<Klienci, String> table_klient_imie;
    @FXML
    private TableColumn<Klienci, String> table_klient_nazwisko;
    @FXML
    private TableColumn<Klienci, String> table_klient_telefon;
    @FXML
    private TableColumn<Klienci, Date> table_klient_dataur;
    @FXML
    private TableColumn<Klienci, String> table_klient_mail;
    @FXML
    private TableColumn<Klienci, String> table_klient_powiat;
    @FXML
    private TableColumn<Klienci, String> table_klient_wojewodztwo;
    @FXML
    private TableColumn<Klienci, String> table_klient_miejscowosc;
    @FXML
    private TableColumn<Klienci, String> table_klient_nr_domu;
    @FXML
    private TableColumn<Klienci, String> table_klient_ulica;
    @FXML
    private TableColumn<Klienci, String> table_klient_kod_pocztowy;

    //
    //
    //
    //Zakladka Personel
    //
    //
    //
    @FXML
    private TextField text_personel_imie;
    @FXML
    private TextField text_personel_nazwisko;
    @FXML
    private TextField text_personel_telefon;
    @FXML
    private TextField text_personel_funkcja;
    @FXML
    private DatePicker dataur_personel;
    @FXML
    private TextField text_personel_mail;
    @FXML
    private TextField text_personel_wojewodztwo;
    @FXML
    private TextField text_personelt_powiat;
    @FXML
    private TextField text_personel_miejscowosc;
    @FXML
    private TextField text_personel_ulica;
    @FXML
    private TextField text_personel_nr_domu;
    @FXML
    private TextField text_personel_kod_pocztowy;

    @FXML
    private Button btn_personel_zapisz;
    @FXML
    private Button btn_personel_wyczysc;

    @FXML
    private TableView personel_tabelka;
    @FXML
    private TableColumn<Personel, String> table_personel_imie;
    @FXML
    private TableColumn<Personel, String> table_personel_nazwisko;
    @FXML
    private TableColumn<Personel, String> table_personel_telefon;
    @FXML
    private TableColumn<Personel, Date> table_personel_dataur;
    @FXML
    private TableColumn<Personel, String> table_personel_mail;

    //
    //
    //
    //Zakladka Produkty
    //
    //
    //
    @FXML
    private TextField text_produkt_nazwa;
    @FXML
    private TextField text_produkt_cena;
    @FXML
    private TextField text_produkt_stan;

    @FXML
    private Button btn_produkt_zapisz;
    @FXML
    private Button btn_produkt_wyczysc;

    @FXML
    private TableView produkt_tabelka;
    @FXML
    private TableColumn<Produkty, String> table_produkt_nazwa;
    @FXML
    private TableColumn<Produkty, Double> table_produkt_cena;
    @FXML
    private TableColumn<Produkty, Integer> table_produkt_stan;
    //
    //
    //
    //Zakladka Zajecia
    //
    //
    //
    @FXML
    private TextField text_zajecia_nazwa;
    @FXML
    private TextField text_zajecia_rodzaj;
    @FXML
    private TextField text_zajecia_opis;

    @FXML
    private Button btn_zajecia_zapisz;
    @FXML
    private Button btn_zajecia_wyczysc;

    @FXML
    private TableView zajecia_tabelka;
    @FXML
    private TableColumn<Kategorie_zajec, String> table_zajecia_id;
    @FXML
    private TableColumn<Kategorie_zajec, String> table_zajecia_nazwa;
    @FXML
    private TableColumn<Kategorie_zajec, String> table_zajecia_rodzaj;
    @FXML
    private TableColumn<Kategorie_zajec, String> table_zajecia_opis;
    //
    //
    //
    //Zakladka Zamowienia
    //
    //
    //
    @FXML
    private ChoiceBox choice_zamowienia_produkt;
    @FXML
    private ChoiceBox<Klienci> choice_zamowienia_klient;
    @FXML
    private DatePicker data_zamowienia;

    @FXML
    private Button btn_zamowienia_zapisz;
    @FXML
    private Button btn_zamowienia_wyczysc;

    @FXML
    private TableView zamowienia_tabelka;
    @FXML
    private TableColumn<Zamowienia, Klienci> table_zamowienia_klient;
    @FXML
    private TableColumn<Zamowienia, Produkty> table_zamowienia_produkt;
    @FXML
    private TableColumn<Zamowienia, Date> table_zamowienia_data;
    @FXML
    private TableColumn<Zamowienia, Integer> table_zamowienia_ilosc;
    //
    //
    //
    //Zakladka Czlonkostwa
    //
    //
    //
    @FXML
    private ChoiceBox<Karnety> choice_czlonkostwo_karnet;
    @FXML
    private ChoiceBox<Klienci> choice_czlonkostwo_klient;
    @FXML
    private DatePicker dataod_czlonkostwo;
    @FXML
    private DatePicker datado_czlonkostwo;

    @FXML
    private Button btn_czlonkostwo_zapisz;
    @FXML
    private Button btn_czlonkostwo_wyczysc;

    @FXML
    private TableView czlonkostwo_tabelka;
    @FXML
    private TableColumn<Czlonkostwa, Integer> table_czlonkostwo_id;
    @FXML
    private TableColumn<Czlonkostwa, String> table_czlonkostwo_karnet = new TableColumn<>("karnet");
    @FXML
    private TableColumn<Czlonkostwa, String> table_czlonkostwo_imie = new TableColumn<>("klient");
    @FXML
    private TableColumn<Czlonkostwa, String> table_czlonkostwo_nazwisko = new TableColumn<>("klient");
    @FXML
    private TableColumn<Czlonkostwa, Date> table_czlonkostwo_dataod;
    @FXML
    private TableColumn<Czlonkostwa, Date> table_czlonkostwo_datado;

    private final Kategorie_zajecDAO catDAO = new Kategorie_zajecDAO();
    private final KlienciDAO klientDAO = new KlienciDAO();
    private final PersonelDAO personelDAO = new PersonelDAO();
    private final KarnetyDAO karnetDAO = new KarnetyDAO();
    private final CzlonkostwaDAO czlonkostwaDAO = new CzlonkostwaDAO();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override

    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO

            table_view_kategorii();     //wyswietlanie table_view
            table_view_klienci();       //wyswietlanie table_view
            table_view_personel();      //wyswietlanie table_view
            table_view_karnety();       //wyswietlanie table_view
            table_view_czlonkostwa();

        } catch (SQLException ex) {
            Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
        }

        btn_klient_zapisz.setOnAction((ActionEvent event) -> {
            System.out.println("klient");

            Klienci klient = new Klienci();
            klient.setImie(text_klient_imie.getText());
            klient.setNazwisko(text_klient_nazwisko.getText());
            klient.setNr_telefonu(text_klient_telefon.getText());
            klient.setData_urodzenia(dataur_klient.getValue().toString());

            Adresy adres = new Adresy();
            adres.setPowiat(text_klient_powiat.getText());

            try {
                AdresyDAO.create(adres);
                KlienciDAO.create(klient);
                table_view_klienci();

            } catch (SQLException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        btn_personel_zapisz.setOnAction((ActionEvent event) -> {
            System.out.println("personel");

            Personel pracownik = new Personel();
            pracownik.setImie(text_personel_imie.getText());
            pracownik.setNazwisko(text_personel_nazwisko.getText());
            pracownik.setNr_telefonu(text_personel_telefon.getText());
            pracownik.setFunkcja(text_personel_funkcja.getText());

            Adresy adres = new Adresy();
            try {
                AdresyDAO.create(adres);
                PersonelDAO.create(pracownik);
                table_view_personel();
            } catch (SQLException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        btn_produkt_zapisz.setOnAction((ActionEvent event) -> {
            System.out.println("produkt");

        });

        btn_zajecia_wyczysc.setOnAction((ActionEvent event) -> {

        });

        btn_zajecia_zapisz.setOnAction((ActionEvent event) -> {
            System.out.println("zajecia");

            Kategorie_zajec kategoria = new Kategorie_zajec();
            kategoria.setNazwa_zajec(text_zajecia_nazwa.getText());
            kategoria.setRodzaj_zajec(text_zajecia_rodzaj.getText());
            kategoria.setOpis(text_zajecia_opis.getText());

            try {
                Kategorie_zajecDAO.create(kategoria);
            } catch (SQLException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        btn_karnet_zapisz.setOnAction((ActionEvent event) -> {
            System.out.println("karnet");

        });

        btn_czlonkostwo_zapisz.setOnAction((ActionEvent event) -> {
            System.out.println("czlonkostwo");

            Czlonkostwa czlonkostwo = new Czlonkostwa();

            czlonkostwo.setKarnet(choice_czlonkostwo_karnet.getValue());
            czlonkostwo.setKlient(choice_czlonkostwo_klient.getValue());
            try {
                CzlonkostwaDAO.create(czlonkostwo);
                table_view_czlonkostwa();
            } catch (SQLException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        btn_zamowienia_zapisz.setOnAction((ActionEvent event) -> {
            System.out.println("zamowienia");

        });

    }

    private void table_view_kategorii() throws SQLException {
        table_zajecia_id.setCellValueFactory(new PropertyValueFactory<>("id_zajec"));
        table_zajecia_nazwa.setCellValueFactory(new PropertyValueFactory<>("nazwa_zajec"));
        table_zajecia_rodzaj.setCellValueFactory(new PropertyValueFactory<>("rodzaj_zajec"));
        table_zajecia_opis.setCellValueFactory(new PropertyValueFactory<>("opis"));
        zajecia_tabelka.setItems(FXCollections.observableList(catDAO.getAll()));
    }

    private void table_view_klienci() throws SQLException {
        table_klient_id.setCellValueFactory(new PropertyValueFactory<>("id_klienta"));
        table_klient_imie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        table_klient_nazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        table_klient_telefon.setCellValueFactory(new PropertyValueFactory<>("nr_telefonu"));
        table_klient_dataur.setCellValueFactory(new PropertyValueFactory<>("data_urodzenia"));
        table_klient_wojewodztwo.setCellValueFactory(new PropertyValueFactory<>("wojewodztwo"));
        table_klient_powiat.setCellValueFactory(new PropertyValueFactory<>("powiat"));
        table_klient_miejscowosc.setCellValueFactory(new PropertyValueFactory<>("miejscowosc"));
        //table_klient_powiat.setCellValueFactory(new PropertyValueFactory<>("nr_domu"));
        //table_klient_powiat.setCellValueFactory(new PropertyValueFactory<>("ulica"));           
        klient_tabelka.setItems(FXCollections.observableList(klientDAO.getAll()));
    }

    private void table_view_personel() throws SQLException {
        //table_personel_id.setCellValueFactory(new PropertyValueFactory<>("id_klienta"));
        table_personel_imie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        table_personel_nazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        table_personel_telefon.setCellValueFactory(new PropertyValueFactory<>("nr_telefonu"));
        personel_tabelka.setItems(FXCollections.observableList(personelDAO.getAll()));
    }

    private void table_view_karnety() throws SQLException {
        table_karnet_id.setCellValueFactory(new PropertyValueFactory<>("id_karnetu"));
        table_karnet_nazwa.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        table_karnet_waznosc.setCellValueFactory(new PropertyValueFactory<>("waznosc"));
        table_karnet_cena.setCellValueFactory(new PropertyValueFactory<>("cena"));
        karnet_tabelka.setItems(FXCollections.observableList(karnetDAO.getAll()));
    }

    private void table_view_czlonkostwa() throws SQLException {

        choice_czlonkostwo_karnet.setConverter(new StringConverter<Karnety>() {
            @Override
            public String toString(Karnety object) {
                return object.getNazwa();
            }

            @Override
            public Karnety fromString(String string) {
                return null;
            }

        });
        choice_czlonkostwo_klient.setConverter(new StringConverter<Klienci>() {
            @Override
            public String toString(Klienci object) {
                return object.getImie() + " " + object.getNazwisko();
            }

            @Override
            public Klienci fromString(String string) {
                return null;
            }

        });
        choice_czlonkostwo_klient.setItems(FXCollections.observableArrayList(klientDAO.getAll()));
        choice_czlonkostwo_karnet.setItems(FXCollections.observableArrayList(karnetDAO.getAll()));
        table_czlonkostwo_id.setCellValueFactory(new PropertyValueFactory<>("id_czlonkostwa"));
        table_czlonkostwo_imie.setCellValueFactory(pomoc -> new SimpleStringProperty(pomoc.getValue().getKlient().getImie()));
        table_czlonkostwo_nazwisko.setCellValueFactory(pomoc -> new SimpleStringProperty(pomoc.getValue().getKlient().getNazwisko()));
        table_czlonkostwo_karnet.setCellValueFactory(pomoc -> new SimpleStringProperty(pomoc.getValue().getKarnet().getNazwa()));      
        czlonkostwo_tabelka.setItems(FXCollections.observableList(czlonkostwaDAO.getAll()));
    }

}
