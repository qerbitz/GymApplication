/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


/**
 *
 * @author HP
 */
public class Rezerwacje_zajec {
    
    private int id_rezerwacji;
      
    public Personel pracownik;
    
    public Kategorie_zajec zajecia;
    
    private String dzien;
    
    private String godzina;
    
    private int ilosc;

    public Rezerwacje_zajec(int id_rezerwacji, Personel pracownik, Kategorie_zajec zajecia, String dzien, String godzina, int ilosc) {
        this.id_rezerwacji = id_rezerwacji;
        this.pracownik = pracownik;
        this.zajecia = zajecia;
        this.dzien = dzien;
        this.godzina = godzina;
        this.ilosc = ilosc;
    }

    public Rezerwacje_zajec()
    {
        
    }

    public int getId_rezerwacji() {
        return id_rezerwacji;
    }

    public void setId_rezerwacji(int id_rezerwacji) {
        this.id_rezerwacji = id_rezerwacji;
    }

    public Personel getPracownik() {
        return pracownik;
    }

    public void setPracownik(Personel pracownik) {
        this.pracownik = pracownik;
    }

    public Kategorie_zajec getZajecia() {
        return zajecia;
    }

    public void setZajecia(Kategorie_zajec zajecia) {
        this.zajecia = zajecia;
    }

    public String getDzien() {
        return dzien;
    }

    public void setDzien(String dzien) {
        this.dzien = dzien;
    }

    public String getGodzina() {
        return godzina;
    }

    public void setGodzina(String godzina) {
        this.godzina = godzina;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
    
    
    
}
