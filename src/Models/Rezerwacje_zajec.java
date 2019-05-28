/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Time;

/**
 *
 * @author HP
 */
public class Rezerwacje_zajec {
    
    private int id_rezerwacji;
    
    private int id_klienta;
    
    private int id_pracownika;
    
    private int id_zajec;
    
    private String dzien;
    
    private Time godzina_rozpoczecia;
    
    private Time godzina_zakonczenia;
    
    private int max_ilosc_osob;

    public Rezerwacje_zajec(int id_rezerwacji, int id_klienta, int id_pracownika, int id_zajec, String dzien, Time godzina_rozpoczecia, Time godzina_zakonczenia, int max_ilosc_osob) {
        this.id_rezerwacji = id_rezerwacji;
        this.id_klienta = id_klienta;
        this.id_pracownika = id_pracownika;
        this.id_zajec = id_zajec;
        this.dzien = dzien;
        this.godzina_rozpoczecia = godzina_rozpoczecia;
        this.godzina_zakonczenia = godzina_zakonczenia;
        this.max_ilosc_osob = max_ilosc_osob;
    }

    public int getId_rezerwacji() {
        return id_rezerwacji;
    }

    public void setId_rezerwacji(int id_rezerwacji) {
        this.id_rezerwacji = id_rezerwacji;
    }

    public int getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public int getId_zajec() {
        return id_zajec;
    }

    public void setId_zajec(int id_zajec) {
        this.id_zajec = id_zajec;
    }

    public String getDzien() {
        return dzien;
    }

    public void setDzien(String dzien) {
        this.dzien = dzien;
    }

    public Time getGodzina_rozpoczecia() {
        return godzina_rozpoczecia;
    }

    public void setGodzina_rozpoczecia(Time godzina_rozpoczecia) {
        this.godzina_rozpoczecia = godzina_rozpoczecia;
    }

    public Time getGodzina_zakonczenia() {
        return godzina_zakonczenia;
    }

    public void setGodzina_zakonczenia(Time godzina_zakonczenia) {
        this.godzina_zakonczenia = godzina_zakonczenia;
    }

    public int getMax_ilosc_osob() {
        return max_ilosc_osob;
    }

    public void setMax_ilosc_osob(int max_ilosc_osob) {
        this.max_ilosc_osob = max_ilosc_osob;
    }
    
    
}
