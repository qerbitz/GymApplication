/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Adresy;
import Models.Klienci;
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
public class KlienciDAO {

    public List<Klienci> getAll() throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;
        List<Klienci> list = new ArrayList<Klienci>();
        con = JDBC_Connection.getConnections();
        CallableStatement statement = con.prepareCall("{call GETKLIENCI(?)}");
        statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        statement.execute();
        ResultSet rs = (ResultSet) statement.getObject(1);

        while (rs.next()) {
            Klienci klient = new Klienci();

            int id_klienta = rs.getInt("id_klienta");
            String imie = rs.getString("imie");
            String nazwisko = rs.getString("nazwisko");
            String nr_telefonu = rs.getString("nr_telefonu");
            String e_mail = rs.getString("e_mail");
            Date data_urodzenia = rs.getDate("data_urodzenia");

            Adresy adres = new Adresy();
            int id_adresu = rs.getInt("id_adresu");
            String wojewodztwo = rs.getString("wojewodztwo");
            String kod_pocztowy = rs.getString("kod_pocztowy");
            String nr_domu = rs.getString("nr_domu");
            String miejscowosc = rs.getString("miejscowosc");
            String powiat = rs.getString("powiat");
            String ulica = rs.getString("ulica");
            adres.setId_adresu(id_adresu);
            adres.setWojewodztwo(wojewodztwo);
            adres.setPowiat(powiat);
            adres.setMiejscowosc(miejscowosc);
            adres.setNr_domu(nr_domu);
            adres.setWojewodztwo(wojewodztwo);
            adres.setUlica(ulica);
            adres.setKod_pocztowy(kod_pocztowy);

            klient.setId_klienta(id_klienta);
            klient.setImie(imie);
            klient.setNazwisko(nazwisko);
            klient.setNr_telefonu(nr_telefonu);
            klient.setE_mail(e_mail);
            klient.setData_urodzenia(data_urodzenia);
            klient.setAdres(adres);

            list.add(klient);
        }

        return list;

    }

    public static void create(Klienci k) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;

        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call insertKLIENCI(?,?,?,?,?)}");
        stmt.setString(1, k.getImie());
        stmt.setString(2, k.getNazwisko());
        stmt.setString(3, k.getNr_telefonu());
        stmt.setDate(4, (Date) k.getData_urodzenia());
        stmt.setString(5, k.getE_mail());

        stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(4, java.sql.Types.DATE);
        stmt.registerOutParameter(5, java.sql.Types.VARCHAR);

        stmt.executeUpdate();
    }

    public static void update(Klienci k) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call updateKLIENCI(?,?,?,?)}");
        stmt.setInt(1, k.getId_klienta());
        stmt.setString(2, k.getImie());
        stmt.setString(3, k.getNazwisko());
        stmt.setString(4, k.getNr_telefonu());
        //stmt.setDate(4, (Date) k.getData_urodzenia());
        //stmt.setString(5, k.getE_mail());

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
        
        stmt.executeUpdate();

    }
    
    public KlienciDAO() {

    }

}
