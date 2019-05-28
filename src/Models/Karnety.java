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

    private int id_karnetu;

    private String nazwa;

    private int waznosc;

    private double cena;

    public Karnety(int id_karnetu, String nazwa, int waznosc, double cena, String opis) {
        this.id_karnetu = id_karnetu;
        this.nazwa = nazwa;
        this.waznosc = waznosc;
        this.cena = cena;
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

}
