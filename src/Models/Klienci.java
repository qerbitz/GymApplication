/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author HP
 */
public class Klienci extends Adresy{

    private int id_klienta;
    
    private Adresy adres;
    
    private String imie;

    private String nazwisko;

    private String nr_telefonu;

    private Date data_urodzenia;

    private String e_mail;

    public Klienci(int id_klienta, String imie, String nazwisko, String nr_telefonu, Date data_urodzenia, String e_mail) {
        this.id_klienta = id_klienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_telefonu = nr_telefonu;
        //this.data_urodzenia = data_urodzenia;
        this.e_mail = e_mail;

    }

    public Adresy getAdres() {
        return adres;
    }

    public void setAdres(Adresy adres) {
        this.adres = adres;
    }
    
    
    public Klienci() {

    }

    public int getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    
    public Date getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(Date data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }
    
}
