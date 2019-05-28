/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javax.persistence.Column;

/**
 *
 * @author HP
 */
public class Karnety {
    
    @Column(name="imie", unique=true)
    private int id_karnetu;
    
    @Column(name="nazwa")
    private String nazwa;
    
    @Column(name="waznosc")
    private int waznosc;
    
    @Column(name="cena")
    private double cena;
    
    @Column(name="opis")
    private String opis;

    public Karnety(int id_karnetu, String nazwa, int waznosc, double cena, String opis) {
        this.id_karnetu = id_karnetu;
        this.nazwa = nazwa;
        this.waznosc = waznosc;
        this.cena = cena;
        this.opis = opis;
    }

    public int getId_karnetu() {
        return id_karnetu;
    }

    public void setId_karnetu(int id_karnetu) {
        this.id_karnetu = id_karnetu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getWaznosc() {
        return waznosc;
    }

    public void setWaznosc(int waznosc) {
        this.waznosc = waznosc;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    
    
}
