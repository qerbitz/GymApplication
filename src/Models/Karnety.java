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

    private float cena;

    public Karnety(int id_karnetu, String nazwa, int waznosc, float cena) {
        this.id_karnetu = id_karnetu;
        this.nazwa = nazwa;
        this.waznosc = waznosc;
        this.cena = cena;
    }
    
    public Karnety()
    {
        
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

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

}
