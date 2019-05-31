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
public class Klienci extends Adresy {

    private int id_klienta;

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

    @Override
    public String getPowiat() {
        return powiat;
    }

    @Override
    public String getWojewodztwo() {
        return wojewodztwo;
    }

    @Override
    public String getMiejscowosc() {
        return miejscowosc;
    }

    @Override
    public String getUlica() {
        return ulica;
    }

    @Override
    public String getNr_domu() {
        return nr_domu;
    }

    @Override
    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    //@Override
    //public String toString() {
    //    return "Klienci [id_klienta=" + id_klienta + ", id_adresu= " + id_adresu + ", imie=" + imie
    //            + ", nazwisko=" + nazwisko + ", nr_telefonu=" + nr_telefonu + ", data urodzenia" + data_urodzenia
    //            + ", e-mail=" + e_mail + "]";
    //}
}
