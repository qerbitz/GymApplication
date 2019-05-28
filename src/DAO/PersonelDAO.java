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
            
            String powiat = rs.getString("powiat");
            String miejscowosc = rs.getString("miejscowosc");
            String ulica = rs.getString("ulica");
            String wojewodztwo = rs.getString("wojewodztwo");
            String kod_pocztowy = rs.getString("kod_pocztowy");
            String nr_domu = rs.getString("nr_domu");
            

            pracownik.setId_pracownika(id_pracownika);
            pracownik.setImie(imie);
            pracownik.setNazwisko(nazwisko);
            pracownik.setNazwisko(funkcja);
            pracownik.setNr_telefonu(nr_telefonu);
            
            pracownik.setPowiat(powiat);
            pracownik.setMiejscowosc(miejscowosc);
           // klient.setNr_domu(nr_domu);
            pracownik.setWojewodztwo(wojewodztwo);
            pracownik.setUlica(ulica);
            //klient.setKod_pocztowy(kod_pocztowy);

            

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
}
