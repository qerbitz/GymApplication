/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 *
 * @author HP
 */
public class Produkty {
    
    private int id_produktu;
    
    private String nazwa;
    
    private double cena;
    
    private int stan_magazynu;

    public Produkty(int id_produktu, String nazwa, double cena, int stan_magazynu) {
        this.id_produktu = id_produktu;
        this.nazwa = nazwa;
        this.cena = cena;
        this.stan_magazynu = stan_magazynu;
    }

    public int getId_produktu() {
        return id_produktu;
    }

    public void setId_produktu(int id_produktu) {
        this.id_produktu = id_produktu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getStan_magazynu() {
        return stan_magazynu;
    }

    public void setStan_magazynu(int stan_magazynu) {
        this.stan_magazynu = stan_magazynu;
    }
    
    
}
