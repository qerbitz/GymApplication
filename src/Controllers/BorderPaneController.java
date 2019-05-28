/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.AdresyDAO;
import DAO.JDBC_Connection;
import DAO.Kategorie_zajecDAO;
import DAO.KlienciDAO;
import DAO.PersonelDAO;
import Models.Adresy;
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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
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
    public TextField text_karnet_nazwa;
    @FXML
    public TextField text_karnet_waznosc;
    @FXML
    public TextField text_karnet_cena;
    @FXML
    public TextField text_karnet_opis;
    @FXML
    public Button btn_karnet_zapisz;
    @FXML
    public Button btn_karnet_wyczysc;
    @FXML
    public TableView karnet_tabelka;
    @FXML
    public TableColumn<Karnety, String> table_karnet_nazwa;
    @FXML
    public TableColumn<Karnety, Integer> table_karnet_waznosc;
    @FXML
    public TableColumn<Karnety, Double> table_karnet_cena;
    @FXML
    public TableColumn<Karnety, String> table_karnet_opis;

    //
    //
    //
    //Zakladka Klienci
    //
    //
    //
    @FXML
    public TextField text_klient_imie;
    @FXML
    public TextField text_klient_nazwisko;
    @FXML
    public TextField text_klient_telefon;
    @FXML
    public DatePicker dataur_klient;
    @FXML
    public TextField text_klient_mail;
    @FXML
    public TextField text_klient_wojewodztwo;
    @FXML
    public TextField text_klient_powiat;
    @FXML
    public TextField text_klient_miejscowosc;
    @FXML
    public TextField text_klient_ulica;
    @FXML
    public TextField text_klient_nr_domu;
    @FXML
    public TextField text_klient_kod_pocztowy;

    @FXML
    public Button btn_klient_zapisz;
    @FXML
    public Button btn_klient_wyczysc;

    @FXML
    public TableView klient_tabelka;

    @FXML
    public TableColumn<Klienci, Integer> table_klient_id;
    @FXML
    public TableColumn<Klienci, String> table_klient_imie;
    @FXML
    public TableColumn<Klienci, String> table_klient_nazwisko;
    @FXML
    public TableColumn<Klienci, String> table_klient_telefon;
    @FXML
    public TableColumn<Klienci, Date> table_klient_dataur;
    @FXML
    public TableColumn<Klienci, String> table_klient_mail;
    @FXML
    public TableColumn<Klienci, String> table_klient_powiat;
    @FXML
    public TableColumn<Klienci, String> table_klient_wojewodztwo;
    @FXML
    public TableColumn<Klienci, String> table_klient_miejscowosc;
    @FXML
    public TableColumn<Klienci, String> table_klient_nr_domu;
    @FXML
    public TableColumn<Klienci, String> table_klient_ulica;
    @FXML
    public TableColumn<Klienci, String> table_klient_kod_pocztowy;

    //
    //
    //
    //Zakladka Personel
    //
    //
    //
    @FXML
    public TextField text_personel_imie;
    @FXML
    public TextField text_personel_nazwisko;
    @FXML
    public TextField text_personel_telefon;
    @FXML
    public TextField text_personel_funkcja;
    @FXML
    public DatePicker dataur_personel;
    @FXML
    public TextField text_personel_mail;
    @FXML
    public TextField text_personel_wojewodztwo;
    @FXML
    public TextField text_personelt_powiat;
    @FXML
    public TextField text_personel_miejscowosc;
    @FXML
    public TextField text_personel_ulica;
    @FXML
    public TextField text_personel_nr_domu;
    @FXML
    public TextField text_personel_kod_pocztowy;

    @FXML
    public Button btn_personel_zapisz;
    @FXML
    public Button btn_personel_wyczysc;

    @FXML
    public TableView personel_tabelka;
    @FXML
    public TableColumn<Personel, String> table_personel_imie;
    @FXML
    public TableColumn<Personel, String> table_personel_nazwisko;
    @FXML
    public TableColumn<Personel, String> table_personel_telefon;
    @FXML
    public TableColumn<Personel, Date> table_personel_dataur;
    @FXML
    public TableColumn<Personel, String> table_personel_mail;

    //
    //
    //
    //Zakladka Produkty
    //
    //
    //
    @FXML
    public TextField text_produkt_nazwa;
    @FXML
    public TextField text_produkt_cena;
    @FXML
    public TextField text_produkt_stan;

    @FXML
    public Button btn_produkt_zapisz;
    @FXML
    public Button btn_produkt_wyczysc;

    @FXML
    public TableView produkt_tabelka;
    @FXML
    public TableColumn<Produkty, String> table_produkt_nazwa;
    @FXML
    public TableColumn<Produkty, Double> table_produkt_cena;
    @FXML
    public TableColumn<Produkty, Integer> table_produkt_stan;
    //
    //
    //
    //Zakladka Zajecia
    //
    //
    //
    @FXML
    public TextField text_zajecia_nazwa;
    @FXML
    public TextField text_zajecia_rodzaj;
    @FXML
    public TextField text_zajecia_opis;

    @FXML
    public Button btn_zajecia_zapisz;
    @FXML
    public Button btn_zajecia_wyczysc;

    @FXML
    public TableView zajecia_tabelka;
    @FXML
    public TableColumn<Kategorie_zajec, String> table_zajecia_id;
    @FXML
    public TableColumn<Kategorie_zajec, String> table_zajecia_nazwa;
    @FXML
    public TableColumn<Kategorie_zajec, String> table_zajecia_rodzaj;
    @FXML
    public TableColumn<Kategorie_zajec, String> table_zajecia_opis;
    //
    //
    //
    //Zakladka Zamowienia
    //
    //
    //
    @FXML
    public ChoiceBox choice_zamowienia_produkt;
    @FXML
    public ChoiceBox choice_zamowienia_klient;
    @FXML
    public DatePicker data_zamowienia;

    @FXML
    public Button btn_zamowienia_zapisz;
    @FXML
    public Button btn_zamowienia_wyczysc;

    @FXML
    public TableView zamowienia_tabelka;
    @FXML
    public TableColumn<Zamowienia, Klienci> table_zamowienia_klient;
    @FXML
    public TableColumn<Zamowienia, Produkty> table_zamowienia_produkt;
    @FXML
    public TableColumn<Zamowienia, Date> table_zamowienia_data;
    @FXML
    public TableColumn<Zamowienia, Integer> table_zamowienia_ilosc;
    //
    //
    //
    //Zakladka Czlonkostwa
    //
    //
    //
    @FXML
    public ChoiceBox choice_czlonkostwo_karnet;
    @FXML
    public ChoiceBox choice_czlonkostwo_klient;
    @FXML
    public DatePicker dataod_czlonkostwo;
    @FXML
    public DatePicker datado_czlonkostwo;

    @FXML
    public Button btn_czlonkostwo_zapisz;
    @FXML
    public Button btn_czlonkostwo_wyczysc;

    @FXML
    public TableView czlonkostwo_tabelka;
    @FXML
    public TableColumn<Zamowienia, Karnety> table_czlonkostwo_karnet;
    @FXML
    public TableColumn<Zamowienia, Klienci> table_czlonkostwo_klient;
    @FXML
    public TableColumn<Zamowienia, Date> table_czlonkostwo_dataod;
    @FXML
    public TableColumn<Zamowienia, Date> table_czlonkostwo_datado;

    private final Kategorie_zajecDAO catDAO = new Kategorie_zajecDAO();
    private final KlienciDAO klientDAO = new KlienciDAO();
    private final PersonelDAO personelDAO = new PersonelDAO();

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

            table_view_kategorii();
            table_view_klienci();
            table_view_personel();
            //table_view_personel();
        } catch (SQLException ex) {
            Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
        }

        btn_klient_zapisz.setOnAction((ActionEvent event) -> {
            System.out.println("klient");

            Klienci klient = new Klienci();
            klient.setImie(text_klient_imie.getText());
            klient.setNazwisko(text_klient_nazwisko.getText());
            klient.setNr_telefonu(text_klient_telefon.getText());

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

}
