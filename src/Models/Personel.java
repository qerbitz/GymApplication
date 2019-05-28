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


public class Personel extends Adresy{

    private int id_pracownika;

    private int id_adresu;

    private String imie;

    private String nazwisko;

    private Date data_urodzenia;

    private String funkcja;

    private String nr_telefonu;

    public Personel(int id_pracownika, int id_adresu, String imie, String nazwisko, Date data_urodzenia, String funkcja, String nr_telefonu) {
        this.id_pracownika = id_pracownika;
        this.id_adresu = id_adresu;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.funkcja = funkcja;
        this.nr_telefonu = nr_telefonu;
    }

    public Personel() {

    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
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

    public Date getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(Date data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getFunkcja() {
        return funkcja;
    }

    public void setFunkcja(String funkcja) {
        this.funkcja = funkcja;
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
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
}
