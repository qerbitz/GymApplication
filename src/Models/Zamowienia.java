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

import java.util.Date;

/**
 *
 * @author HP
 */

public class Zamowienia {
    
    
    private int id_zamowienia;
    
    private int id_produktu;
    
    private int id_klienta;
    
    private Date data_kupna;
    
    private int ilosc;

    public Zamowienia(int id_zamowienia, int id_produktu, int id_klienta, Date data_kupna, int ilosc) {
        this.id_zamowienia = id_zamowienia;
        this.id_produktu = id_produktu;
        this.id_klienta = id_klienta;
        this.data_kupna = data_kupna;
        this.ilosc = ilosc;
    }

    public int getId_zamowienia() {
        return id_zamowienia;
    }

    public void setId_zamowienia(int id_zamowienia) {
        this.id_zamowienia = id_zamowienia;
    }

    public int getId_produktu() {
        return id_produktu;
    }

    public void setId_produktu(int id_produktu) {
        this.id_produktu = id_produktu;
    }

    public int getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
    }

    public Date getData_kupna() {
        return data_kupna;
    }

    public void setData_kupna(Date data_kupna) {
        this.data_kupna = data_kupna;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
    
    
}
