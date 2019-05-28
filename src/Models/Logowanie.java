/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name="Logowanie")
public class Logowanie {
    
    @Column(name="id_pracownika")
    @Id
    private int id_pracownika;
    
    @Column(name="login")
    private String login;
    
    @Column(name="haslo")
    private String haslo;

    public Logowanie(int id_pracownika, String login, String haslo) {
        this.id_pracownika = id_pracownika;
        this.login = login;
        this.haslo = haslo;
    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
    
    
}
