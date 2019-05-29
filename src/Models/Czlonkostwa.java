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
public class Czlonkostwa {
    
    private int id_czlonkostwa;
    
    public Karnety karnet;
    
    public Klienci klient;
    
    private Date data_rozpoczecia;
    
    private Date data_zakonczenia;

    public Czlonkostwa(int id_czlonkostwa, Karnety karnet, Klienci klient, Date data_rozpoczecia, Date data_zakonczenia) {
        this.id_czlonkostwa = id_czlonkostwa;
        this.karnet = karnet;
        this.klient = klient;
        this.data_rozpoczecia = data_rozpoczecia;
        this.data_zakonczenia = data_zakonczenia;
    }
    
    public Czlonkostwa()
    {
        
    }

    public int getId_czlonkostwa() {
        return id_czlonkostwa;
    }

    public void setId_czlonkostwa(int id_czlonkostwa) {
        this.id_czlonkostwa = id_czlonkostwa;
    }

    public Karnety getKarnet() {
        return karnet;
    }

    public void setKarnet(Karnety karnet) {
        this.karnet = karnet;
    }

    public Klienci getKlient() {
        return klient;
    }

    public void setKlient(Klienci klient) {
        this.klient = klient;
    }

    public Date getData_rozpoczecia() {
        return data_rozpoczecia;
    }

    public void setData_rozpoczecia(Date data_rozpoczecia) {
        this.data_rozpoczecia = data_rozpoczecia;
    }

    public Date getData_zakonczenia() {
        return data_zakonczenia;
    }

    public void setData_zakonczenia(Date data_zakonczenia) {
        this.data_zakonczenia = data_zakonczenia;
    }
    
   
    
}
