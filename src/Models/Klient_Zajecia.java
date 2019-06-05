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
public class Klient_Zajecia {
    
    public Rezerwacje_zajec rezerwacja;
    
    public Klienci klient;
    
    public int pomoc;

    public Klient_Zajecia(Rezerwacje_zajec rezerwacja, Klienci klient) {
        this.rezerwacja = rezerwacja;
        this.klient = klient;
    }
    
    public Klient_Zajecia()
    {
        
    }

    public Rezerwacje_zajec getRezerwacja() {
        return rezerwacja;
    }

    public void setRezerwacja(Rezerwacje_zajec rezerwacja) {
        this.rezerwacja = rezerwacja;
    }

    public Klienci getKlient() {
        return klient;
    }

    public void setKlient(Klienci klient) {
        this.klient = klient;
    }

    public int getPomoc() {
        return pomoc;
    }

    public void setPomoc(int pomoc) {
        this.pomoc = pomoc;
    }
    
    
    
}
