/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.AdresyDAO;
import DAO.CzlonkostwaDAO;
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
import javafx.event.ActionEvent;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Button btn_karnet_update;
    @FXML
    private Button btn_karnet_modify;
    @FXML
    private Button btn_karnet_delete;
    @FXML
    private TableView<Karnety> karnet_tabelka;
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
    private Button btn_klient_update;
    @FXML
    private Button btn_klient_modify;
    @FXML
    private Button btn_klient_delete;

    @FXML
    private TableView<Klienci> klient_tabelka;

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
    private TableColumn<Klienci, String> table_klient_powiat = new TableColumn<>("powiat");
    @FXML
    private TableColumn<Klienci, String> table_klient_wojewodztwo = new TableColumn<>("kod_wojewodztwo");
    @FXML
    private TableColumn<Klienci, String> table_klient_miejscowosc = new TableColumn<>("kod_miejscowosc");
    @FXML
    private TableColumn<Klienci, String> table_klient_nr_domu = new TableColumn<>("kod_nr_domu");
    @FXML
    private TableColumn<Klienci, String> table_klient_ulica = new TableColumn<>("kod_ulica");
    @FXML
    private TableColumn<Klienci, String> table_klient_kod_pocztowy = new TableColumn<>("kod_pocztowy");

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
    private TextField text_personel_powiat;
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
    private Button btn_personel_update;
    @FXML
    private Button btn_personel_modify;
    @FXML
    private Button btn_personel_delete;

    @FXML
    private TableView<Personel> personel_tabelka;
    @FXML
    private TableColumn<Personel, String> table_personel_imie;
    @FXML
    private TableColumn<Personel, Integer> table_personel_id;
    @FXML
    private TableColumn<Personel, String> table_personel_nazwisko;
    @FXML
    private TableColumn<Personel, String> table_personel_telefon;
    @FXML
    private TableColumn<Personel, Date> table_personel_dataur;
    @FXML
    private TableColumn<Personel, String> table_personel_funkcja;
    @FXML
    private TableColumn<Personel, String> table_personel_e_mail;
    @FXML
    private TableColumn<Personel, String> table_personel_powiat = new TableColumn<>("powiat");
    @FXML
    private TableColumn<Personel, String> table_personel_wojewodztwo = new TableColumn<>("wojewodztwo");
    @FXML
    private TableColumn<Personel, String> table_personel_miejscowosc = new TableColumn<>("miejscowosc");
    @FXML
    private TableColumn<Personel, String> table_personel_nr_domu = new TableColumn<>("nr_domu");
    @FXML
    private TableColumn<Personel, String> table_personel_ulica = new TableColumn<>("ulica");
    @FXML
    private TableColumn<Personel, String> table_personel_kod_pocztowy = new TableColumn<>("kod_pocztowy");

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
    private Button btn_zajecia_delete;
    @FXML
    private Button btn_zajecia_update;
    @FXML
    private Button btn_zajecia_modify;

    @FXML
    private TableView<Kategorie_zajec> zajecia_tabelka;
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
    private Button btn_czlonkostwo_update;
    @FXML
    private Button btn_czlonkostwo_modify;
    @FXML
    private Button btn_czlonkostwo_delete;

    @FXML
    private TableView<Czlonkostwa> czlonkostwo_tabelka;
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
    @FXML
    private TableColumn<Czlonkostwa, String> table_czlonkostwo_status;

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
            table_view_czlonkostwa();   //wyswietlanie table_view
            personel();
            klient();
            czlonkostwa();
            karnety();
            Kategorie_zajec();

        } catch (SQLException ex) {
            Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void karnety()
    {
        btn_karnet_zapisz.setOnAction((ActionEvent event) -> {
            Karnety karnet = new Karnety();
            karnet.setNazwa(text_karnet_nazwa.getText());
            karnet.setWaznosc(Integer.parseInt(text_karnet_waznosc.getText()));
            karnet.setCena(Integer.parseInt(text_karnet_cena.getText()));
            
            try {
                KarnetyDAO.create(karnet);
                table_view_karnety();
                table_view_czlonkostwa();
            } catch (SQLException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        //
        btn_karnet_update.setOnAction((ActionEvent event) -> {
            Karnety karnet = new Karnety();
            karnet = karnet_tabelka.getSelectionModel().getSelectedItem();
            karnet.setNazwa(text_karnet_nazwa.getText());
            karnet.setWaznosc(Integer.parseInt(text_karnet_waznosc.getText()));
            karnet.setCena(Integer.parseInt(text_karnet_cena.getText()));
            
            try {
                KarnetyDAO.update(karnet);
                table_view_karnety();
                table_view_czlonkostwa();
            } catch (SQLException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        //
        btn_karnet_delete.setOnAction((ActionEvent event) -> {
            Karnety karnet = new Karnety();
            karnet = karnet_tabelka.getSelectionModel().getSelectedItem();       
            
            try {
                KarnetyDAO.delete(karnet);
                table_view_karnety();
                table_view_czlonkostwa();
            } catch (SQLException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        //
        btn_karnet_modify.setOnAction((ActionEvent event) -> {
            Karnety karnet = new Karnety();
            karnet = karnet_tabelka.getSelectionModel().getSelectedItem();  
            text_karnet_nazwa.setText(karnet.getNazwa());
            
            text_karnet_waznosc.setText(Integer.toString(karnet.getWaznosc()));
            text_karnet_cena.setText(Float.toString(karnet.getWaznosc()));
            
        });
        //
        btn_karnet_wyczysc.setOnAction((ActionEvent event) -> {
            text_karnet_nazwa.clear();
            text_karnet_waznosc.clear();
            text_karnet_cena.clear();
        });
    }
    private void Kategorie_zajec()
    {
        btn_zajecia_zapisz.setOnAction((ActionEvent event) -> {                     //Zajecia

            Kategorie_zajec kategoria = new Kategorie_zajec();
            kategoria.setNazwa_zajec(text_zajecia_nazwa.getText());
            kategoria.setRodzaj_zajec(text_zajecia_rodzaj.getText());
            kategoria.setOpis(text_zajecia_opis.getText());

            try {
                Kategorie_zajecDAO.create(kategoria);
                table_view_kategorii();
            } catch (SQLException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        
        btn_zajecia_update.setOnAction((ActionEvent event) -> {                     //Zajecia

            Kategorie_zajec kategoria = new Kategorie_zajec();
            kategoria = zajecia_tabelka.getSelectionModel().getSelectedItem();
            kategoria.setNazwa_zajec(text_zajecia_nazwa.getText());
            kategoria.setRodzaj_zajec(text_zajecia_rodzaj.getText());
            kategoria.setOpis(text_zajecia_opis.getText());

            try {
                Kategorie_zajecDAO.update(kategoria);
                table_view_kategorii();
            } catch (SQLException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        
        btn_zajecia_delete.setOnAction((ActionEvent event) -> {                    

            Kategorie_zajec kategoria = new Kategorie_zajec();
            kategoria = zajecia_tabelka.getSelectionModel().getSelectedItem();
            try {
                Kategorie_zajecDAO.delete(kategoria);
                table_view_kategorii();
            } catch (SQLException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        
        btn_zajecia_modify.setOnAction((ActionEvent event) -> {                  
            Kategorie_zajec kategoria = new Kategorie_zajec();
            kategoria = zajecia_tabelka.getSelectionModel().getSelectedItem();  
            text_zajecia_nazwa.setText(kategoria.getNazwa_zajec());
            text_zajecia_rodzaj.setText(kategoria.getRodzaj_zajec());
            text_zajecia_opis.setText(kategoria.getOpis());

        });
        
        btn_zajecia_wyczysc.setOnAction((ActionEvent event) -> {                    
            text_zajecia_nazwa.clear();
            text_zajecia_rodzaj.clear();
            text_zajecia_opis.clear();
        });
    }
    
    private void czlonkostwa() {
        btn_czlonkostwo_zapisz.setOnAction((ActionEvent event) -> {                     //Czlonkostwa

            Czlonkostwa czlonkostwo = new Czlonkostwa();
            czlonkostwo.setKarnet(choice_czlonkostwo_karnet.getValue());

            int ile_dodac = czlonkostwo.getKarnet().getWaznosc();
            System.out.println(ile_dodac);

            Date d = new Date();
            java.sql.Date sqlactualDate = new java.sql.Date(d.getTime());

            Date dt = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(dt);
            c.add(Calendar.DATE, ile_dodac);
            dt = c.getTime();

            java.sql.Date sqlendDate = new java.sql.Date(dt.getTime());


            czlonkostwo.setKlient(choice_czlonkostwo_klient.getValue());
            czlonkostwo.setData_rozpoczecia(sqlactualDate);
            czlonkostwo.setData_zakonczenia(sqlendDate);

            
            try {
                CzlonkostwaDAO.create(czlonkostwo);
                table_view_czlonkostwa();
                personel_tabelka.setItems(FXCollections.observableList(personelDAO.getAll()));
            } catch (SQLException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        ////
        btn_czlonkostwo_delete.setOnAction((ActionEvent event) -> {
            Czlonkostwa czlonkostwo = new Czlonkostwa();
            czlonkostwo = czlonkostwo_tabelka.getSelectionModel().getSelectedItem();
            czlonkostwo.setId_czlonkostwa(czlonkostwo.getId_czlonkostwa());

            try {
                CzlonkostwaDAO.delete(czlonkostwo);
                czlonkostwo_tabelka.setItems(FXCollections.observableList(czlonkostwaDAO.getAll()));
                table_view_czlonkostwa();
            } catch (SQLException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        ///
        btn_czlonkostwo_update.setOnAction((ActionEvent event) -> {
            Czlonkostwa czlonkostwo = new Czlonkostwa();
            czlonkostwo = czlonkostwo_tabelka.getSelectionModel().getSelectedItem();         
            czlonkostwo.setKarnet(choice_czlonkostwo_karnet.getValue());
            int pomoc = czlonkostwo.getId_czlonkostwa();
            czlonkostwo.setId_czlonkostwa(pomoc);

            int ile_dodac = czlonkostwo.getKarnet().getWaznosc();

            Date d = new Date();
            java.sql.Date sqlactualDate = new java.sql.Date(d.getTime());

            Date dt = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(dt);
            c.add(Calendar.DATE, ile_dodac);
            dt = c.getTime();

            java.sql.Date sqlendDate = new java.sql.Date(dt.getTime());
            
            System.out.println(ile_dodac);

            czlonkostwo.setData_rozpoczecia(sqlactualDate);
            czlonkostwo.setData_zakonczenia(sqlendDate);
            
 
            try {
                CzlonkostwaDAO.update(czlonkostwo);
                czlonkostwo_tabelka.setItems(FXCollections.observableList(czlonkostwaDAO.getAll()));
                table_view_czlonkostwa();
            } catch (SQLException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private void klient() {
        //ZAPISYWANIE KLIENTA
        btn_klient_zapisz.setOnAction((ActionEvent event) -> {
            Klienci klient = new Klienci();
            klient.setImie(text_klient_imie.getText());
            klient.setNazwisko(text_klient_nazwisko.getText());
            klient.setNr_telefonu(text_klient_telefon.getText());
            klient.setE_mail(text_klient_mail.getText());

            java.util.Date date
                    = java.util.Date.from(dataur_klient.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            klient.setData_urodzenia(sqlDate);

            Adresy adres = new Adresy();
            adres.setPowiat(text_klient_powiat.getText());
            adres.setWojewodztwo(text_klient_wojewodztwo.getText());
            adres.setMiejscowosc(text_klient_miejscowosc.getText());
            adres.setUlica(text_klient_ulica.getText());
            adres.setNr_domu(text_klient_nr_domu.getText());
            adres.setKod_pocztowy(text_klient_kod_pocztowy.getText());

            try {
                AdresyDAO.create(adres);
                KlienciDAO.create(klient);
                table_view_klienci();
                table_view_czlonkostwa();
                klient_wyczysc();
            } catch (SQLException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
//Modyfikacja klienta
        btn_klient_update.setOnAction((ActionEvent event) -> {
            Klienci klient = new Klienci();
            klient = klient_tabelka.getSelectionModel().getSelectedItem();
            klient.setImie(text_klient_imie.getText());
            klient.setNazwisko(text_klient_nazwisko.getText());
            klient.setNr_telefonu(text_klient_telefon.getText());

            Adresy adres = new Adresy();
            adres.setId_adresu(klient.getAdres().getId_adresu());
            adres.setPowiat(text_klient_powiat.getText());
            adres.setWojewodztwo(text_klient_wojewodztwo.getText());
            adres.setMiejscowosc(text_klient_miejscowosc.getText());
            adres.setUlica(text_klient_ulica.getText());
            adres.setNr_domu(text_klient_nr_domu.getText());
            adres.setKod_pocztowy(text_klient_kod_pocztowy.getText());

            try {
                KlienciDAO.update(klient);
                AdresyDAO.update(adres);
                klient_tabelka.setItems(FXCollections.observableList(klientDAO.getAll()));
                table_view_klienci();
                klient_wyczysc();
            } catch (SQLException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
//Czysczenie textfieldow klienta
        btn_klient_wyczysc.setOnAction((ActionEvent event) -> {
            klient_wyczysc();
        });
//Przygotowanie przed modyfikacja       
        btn_klient_modify.setOnAction((ActionEvent event) -> {
            Klienci klient = new Klienci();
            klient = klient_tabelka.getSelectionModel().getSelectedItem();
            text_klient_imie.setText(klient.getImie());
            text_klient_nazwisko.setText(klient.getNazwisko());
            text_klient_telefon.setText(klient.getNr_telefonu());
            text_klient_mail.setText(klient.getE_mail());

            Adresy adres = new Adresy();
            adres = klient_tabelka.getSelectionModel().getSelectedItem();
            text_klient_wojewodztwo.setText(klient.getAdres().getWojewodztwo());
            text_klient_powiat.setText(klient.getAdres().getPowiat());
            text_klient_miejscowosc.setText(klient.getAdres().getMiejscowosc());
            text_klient_ulica.setText(klient.getAdres().getUlica());
            text_klient_nr_domu.setText(klient.getAdres().getNr_domu());
            text_klient_kod_pocztowy.setText(klient.getAdres().getKod_pocztowy());

        });
//Usuwanie klienta        
        btn_klient_delete.setOnAction((ActionEvent event) -> {
            Klienci klient = new Klienci();
            klient = klient_tabelka.getSelectionModel().getSelectedItem();

            Adresy adres = new Adresy();
            adres = klient_tabelka.getSelectionModel().getSelectedItem();
            adres.setId_adresu(klient.getAdres().getId_adresu());

            try {
                AdresyDAO.delete(adres);
                klient_tabelka.setItems(FXCollections.observableList(klientDAO.getAll()));
                table_view_klienci();
                table_view_czlonkostwa();
            } catch (SQLException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    private void personel() {
        btn_personel_zapisz.setOnAction((ActionEvent event) -> {
            Personel pracownik = new Personel();
            pracownik.setImie(text_personel_imie.getText());
            pracownik.setNazwisko(text_personel_nazwisko.getText());
            pracownik.setNr_telefonu(text_personel_telefon.getText());
            pracownik.setFunkcja(text_personel_funkcja.getText());

            //pozyskanie daty urodzenia
            java.util.Date date
                    = java.util.Date.from(dataur_personel.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            pracownik.setData_urodzenia(sqlDate);
            //

            Adresy adres = new Adresy();
            adres.setPowiat(text_personel_powiat.getText());
            adres.setWojewodztwo(text_personel_wojewodztwo.getText());
            adres.setMiejscowosc(text_personel_miejscowosc.getText());
            adres.setUlica(text_personel_ulica.getText());
            adres.setNr_domu(text_personel_nr_domu.getText());
            adres.setKod_pocztowy(text_personel_kod_pocztowy.getText());
            try {
                AdresyDAO.create(adres);
                PersonelDAO.create(pracownik);
                table_view_personel();
            } catch (SQLException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
//Aktualizacja personelu        
        btn_personel_update.setOnAction((ActionEvent event) -> {

            Personel pracownik = new Personel();
            pracownik = personel_tabelka.getSelectionModel().getSelectedItem();
            pracownik.setImie(text_personel_imie.getText());
            pracownik.setNazwisko(text_personel_nazwisko.getText());
            pracownik.setNr_telefonu(text_personel_telefon.getText());
            pracownik.setFunkcja(text_personel_funkcja.getText());

            Adresy adres = new Adresy();
            adres.setId_adresu(pracownik.getAdres().getId_adresu());
            adres.setPowiat(text_personel_powiat.getText());
            adres.setWojewodztwo(text_personel_wojewodztwo.getText());
            adres.setMiejscowosc(text_personel_miejscowosc.getText());
            adres.setUlica(text_personel_ulica.getText());
            adres.setNr_domu(text_personel_nr_domu.getText());
            adres.setKod_pocztowy(text_personel_kod_pocztowy.getText());

            try {
                PersonelDAO.update(pracownik);
                AdresyDAO.update(adres);
                personel_tabelka.setItems(FXCollections.observableList(personelDAO.getAll()));
                table_view_personel();
                klient_wyczysc();
            } catch (SQLException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
//Przygotowanie przed modyfikacja        
        btn_personel_modify.setOnAction((ActionEvent event) -> {
            personel_pomoc();
        });
//Czyszczenie textfieldow
        btn_personel_wyczysc.setOnAction((ActionEvent event) -> {
            personel_wyczysc();
        });
//Usuwanie pracownika
        btn_personel_delete.setOnAction((ActionEvent event) -> {
            Personel pracownik = new Personel();
            pracownik = personel_tabelka.getSelectionModel().getSelectedItem();

            Adresy adres = new Adresy();
            adres = personel_tabelka.getSelectionModel().getSelectedItem();
            adres.setId_adresu(pracownik.getAdres().getId_adresu());

            try {
                AdresyDAO.delete(adres);
                personel_tabelka.setItems(FXCollections.observableList(personelDAO.getAll()));
                table_view_personel();
                table_view_czlonkostwa();
            } catch (SQLException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(BorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private void personel_pomoc() {
        Personel pracownik = new Personel();
        pracownik = personel_tabelka.getSelectionModel().getSelectedItem();
        text_personel_imie.setText(pracownik.getImie());
        text_personel_nazwisko.setText(pracownik.getNazwisko());
        text_personel_telefon.setText(pracownik.getNr_telefonu());
        text_personel_funkcja.setText(pracownik.getFunkcja());

        Adresy adres = new Adresy();
        adres = klient_tabelka.getSelectionModel().getSelectedItem();
        text_personel_wojewodztwo.setText(pracownik.getAdres().getWojewodztwo());
        text_personel_powiat.setText(pracownik.getAdres().getPowiat());
        text_personel_miejscowosc.setText(pracownik.getAdres().getMiejscowosc());
        text_personel_ulica.setText(pracownik.getAdres().getUlica());
        text_personel_nr_domu.setText(pracownik.getAdres().getNr_domu());
        text_personel_kod_pocztowy.setText(pracownik.getAdres().getKod_pocztowy());

    }

    private void klient_wyczysc() {
        text_klient_imie.clear();
        text_klient_nazwisko.clear();
        text_klient_telefon.clear();
        text_klient_mail.clear();
        text_klient_powiat.clear();
        text_klient_wojewodztwo.clear();
        text_klient_miejscowosc.clear();
        text_klient_ulica.clear();
        text_klient_nr_domu.clear();
        text_klient_kod_pocztowy.clear();
        dataur_klient.setValue(null);
    }

    private void personel_wyczysc() {
        text_personel_imie.clear();
        text_personel_nazwisko.clear();
        text_personel_telefon.clear();
        text_personel_funkcja.clear();
        text_personel_powiat.clear();
        text_personel_wojewodztwo.clear();
        text_personel_miejscowosc.clear();
        text_personel_ulica.clear();
        text_personel_nr_domu.clear();
        text_personel_kod_pocztowy.clear();
        dataur_personel.setValue(null);
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
        table_klient_mail.setCellValueFactory(new PropertyValueFactory<>("e_mail"));

        table_klient_wojewodztwo.setCellValueFactory(pomoc -> new SimpleStringProperty(pomoc.getValue().getAdres().getWojewodztwo()));
        table_klient_miejscowosc.setCellValueFactory(pomoc -> new SimpleStringProperty(pomoc.getValue().getAdres().getMiejscowosc()));
        table_klient_powiat.setCellValueFactory(pomoc -> new SimpleStringProperty(pomoc.getValue().getAdres().getPowiat()));
        table_klient_miejscowosc.setCellValueFactory(pomoc -> new SimpleStringProperty(pomoc.getValue().getAdres().getMiejscowosc()));
        table_klient_ulica.setCellValueFactory(pomoc -> new SimpleStringProperty(pomoc.getValue().getAdres().getUlica()));
        table_klient_nr_domu.setCellValueFactory(pomoc -> new SimpleStringProperty(pomoc.getValue().getAdres().getNr_domu()));
        table_klient_kod_pocztowy.setCellValueFactory(pomoc -> new SimpleStringProperty(pomoc.getValue().getAdres().getKod_pocztowy()));
        klient_tabelka.setItems(FXCollections.observableList(klientDAO.getAll()));
    }

    private void table_view_personel() throws SQLException {
        table_personel_id.setCellValueFactory(new PropertyValueFactory<>("id_pracownika"));
        table_personel_imie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        table_personel_nazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        table_personel_telefon.setCellValueFactory(new PropertyValueFactory<>("nr_telefonu"));
        table_personel_dataur.setCellValueFactory(new PropertyValueFactory<>("data_urodzenia"));
        table_personel_funkcja.setCellValueFactory(new PropertyValueFactory<>("funkcja"));

        table_personel_wojewodztwo.setCellValueFactory(pomoc -> new SimpleStringProperty(pomoc.getValue().getAdres().getWojewodztwo()));
        table_personel_powiat.setCellValueFactory(pomoc -> new SimpleStringProperty(pomoc.getValue().getAdres().getPowiat()));
        table_personel_miejscowosc.setCellValueFactory(pomoc -> new SimpleStringProperty(pomoc.getValue().getAdres().getMiejscowosc()));
        table_personel_ulica.setCellValueFactory(pomoc -> new SimpleStringProperty(pomoc.getValue().getAdres().getUlica()));
        table_personel_nr_domu.setCellValueFactory(pomoc -> new SimpleStringProperty(pomoc.getValue().getAdres().getNr_domu()));
        table_personel_kod_pocztowy.setCellValueFactory(pomoc -> new SimpleStringProperty(pomoc.getValue().getAdres().getKod_pocztowy()));
        personel_tabelka.setItems(FXCollections.observableList(personelDAO.getAll()));
    }

    private void table_view_karnety() throws SQLException {
        table_karnet_id.setCellValueFactory(new PropertyValueFactory<>("id_karnetu"));
        table_karnet_nazwa.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        table_karnet_waznosc.setCellValueFactory(new PropertyValueFactory<>("waznosc"));
        table_karnet_cena.setCellValueFactory(new PropertyValueFactory<>("cena"));
        karnet_tabelka.setItems(FXCollections.observableList(karnetDAO.getAll()));
    }

    private void table_view_czlonkostwa() throws SQLException, ParseException {

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
        table_czlonkostwo_dataod.setCellValueFactory(new PropertyValueFactory<>("data_rozpoczecia"));
        table_czlonkostwo_datado.setCellValueFactory(new PropertyValueFactory<>("data_zakonczenia"));
        table_czlonkostwo_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        czlonkostwo_tabelka.setItems(FXCollections.observableList(czlonkostwaDAO.getAll()));
    }

}
