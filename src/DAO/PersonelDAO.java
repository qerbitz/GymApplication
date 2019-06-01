/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Adresy;
import Models.Personel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class PersonelDAO {

    public List<Personel> getAll() throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;
        List<Personel> list = new ArrayList<Personel>();
        con = JDBC_Connection.getConnections();
        CallableStatement statement = con.prepareCall("{call GETPERSONEL(?)}");
        statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        statement.execute();
        ResultSet rs = (ResultSet) statement.getObject(1);

        while (rs.next()) {
            Personel pracownik = new Personel();
            
            int id_pracownika = rs.getInt("id_pracownika");
            String imie = rs.getString("imie");
            String nazwisko = rs.getString("nazwisko");
            String funkcja = rs.getString("funkcja");
            String nr_telefonu = rs.getString("nr_telefonu");
            Date data_urodzenia = rs.getDate("data_urodzenia");
            
            Adresy adres2 = new Adresy();
            int id_adresu = rs.getInt("id_adresu");
            String wojewodztwo = rs.getString("wojewodztwo");
            String kod_pocztowy = rs.getString("kod_pocztowy");
            String nr_domu = rs.getString("nr_domu");
            String miejscowosc = rs.getString("miejscowosc");
            String powiat = rs.getString("powiat");
            String ulica = rs.getString("ulica");
            adres2.setId_adresu(id_adresu);
            adres2.setWojewodztwo(wojewodztwo);
            adres2.setPowiat(powiat);
            adres2.setMiejscowosc(miejscowosc);
            adres2.setNr_domu(nr_domu);
            adres2.setWojewodztwo(wojewodztwo);
            adres2.setUlica(ulica);
            adres2.setKod_pocztowy(kod_pocztowy);
            

            pracownik.setId_pracownika(id_pracownika);
            pracownik.setImie(imie);
            pracownik.setNazwisko(nazwisko);
            pracownik.setFunkcja(funkcja);
            pracownik.setNr_telefonu(nr_telefonu);
            pracownik.setData_urodzenia(data_urodzenia);
            pracownik.setAdres(adres2);

            

            list.add(pracownik);
        }

        return list;

    }

    public static void create(Personel p) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;

        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call insertPERSONEL(?,?,?,?,?)}");
        stmt.setString(1, p.getImie());
        stmt.setString(2, p.getNazwisko());       
        stmt.setDate(3, (Date) p.getData_urodzenia());       
        stmt.setString(4, p.getFunkcja());
        stmt.setString(5, p.getNr_telefonu());

        stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(3, java.sql.Types.DATE);
        stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(5, java.sql.Types.VARCHAR);

        stmt.executeUpdate();
    }
    
     public static void update(Personel k) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call updatePERSONEL(?,?,?,?,?)}");
        stmt.setInt(1, k.getId_pracownika());
        stmt.setString(2, k.getImie());
        stmt.setString(3, k.getNazwisko());
        stmt.setString(4, k.getFunkcja());
        stmt.setString(5, k.getNr_telefonu());

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
        stmt.executeUpdate();

    }
}
