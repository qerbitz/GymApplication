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
public class Adresy {

    private int id_adresu;

    public String wojewodztwo;

    public String powiat;

    public String miejscowosc;

    public String ulica;

    public String nr_domu;

    public String kod_pocztowy;

    public Adresy(int id_adresu, String wojewodztwo, String powiat, String miejscowosc, String ulica, String nr_domu, String kod_pocztowy) {
        this.id_adresu = id_adresu;
        this.wojewodztwo = wojewodztwo;
        this.powiat = powiat;
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.nr_domu = nr_domu;
        this.kod_pocztowy = kod_pocztowy;
        
    }

    public Adresy() {

    }

    public Adresy(String string) {
        
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    public String getWojewodztwo() {
        return wojewodztwo;
    }

    public void setWojewodztwo(String wojewodztwo) {
        this.wojewodztwo = wojewodztwo;
    }

    public String getPowiat() {
        return powiat;
    }

    public void setPowiat(String powiat) {
        this.powiat = powiat;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNr_domu() {
        return nr_domu;
    }

    public void setNr_domu(String nr_domu) {
        this.nr_domu = nr_domu;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }

    @Override
    public String toString() {
        return "Adresy [id_adresu=" + id_adresu + ", wojewodztwo=" + wojewodztwo + ", powiat=" + powiat + ", miejscowosc="
                + miejscowosc + ", ulica=" + ulica + ", nr_domu=" + nr_domu + ", kod_pocztowy=" + kod_pocztowy + "]";
    }
}
