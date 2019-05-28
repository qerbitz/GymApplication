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
public class Kategorie_zajec {

    private int id_zajec;

    private String nazwa_zajec;

    private String rodzaj_zajec;

    private String opis;

    public Kategorie_zajec(int id_zajec, String nazwa_zajec, String rodzaj_zajec, String opis) {
        this.id_zajec = id_zajec;
        this.nazwa_zajec = nazwa_zajec;
        this.rodzaj_zajec = rodzaj_zajec;
        this.opis = opis;
    }
    
    public Kategorie_zajec()
    {
        
    }

    public int getId_zajec() {
        return id_zajec;
    }

    public void setId_zajec(int id_zajec) {
        this.id_zajec = id_zajec;
    }

    public String getNazwa_zajec() {
        return nazwa_zajec;
    }

    public void setNazwa_zajec(String nazwa_zajec) {
        this.nazwa_zajec = nazwa_zajec;
    }

    public String getRodzaj_zajec() {
        return rodzaj_zajec;
    }

    public void setRodzaj_zajec(String rodzaj_zajec) {
        this.rodzaj_zajec = rodzaj_zajec;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

}
