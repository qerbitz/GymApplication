/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Czlonkostwa;
import Models.Karnety;
import Models.Klienci;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;

/**
 *
 * @author HP
 */
public class CzlonkostwaDAO {

    public List<Czlonkostwa> getAll() throws SQLException, ParseException {

        Connection con = null;
        CallableStatement stmt = null;
        List<Czlonkostwa> list = new ArrayList<Czlonkostwa>();
        con = JDBC_Connection.getConnections();
        CallableStatement statement = con.prepareCall("{call GETCZLONKOSTWA(?)}");
        statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        statement.execute();
        ResultSet rs = (ResultSet) statement.getObject(1);

        while (rs.next()) {
            Czlonkostwa czlonkostwo = new Czlonkostwa();
            int id_czlonkostwa = rs.getInt("id_czlonkostwa");
            Date data_rozpoczecia = rs.getDate("data_rozpoczecia");
            Date data_zakonczenia = rs.getDate("data_zakonczenia");

            String status = compareDate(data_rozpoczecia, data_zakonczenia);

            Karnety karnet = new Karnety();
            int id_karnetu = rs.getInt("id_karnetu");
            String nazwa = rs.getString("nazwa");
            karnet.setNazwa(nazwa);

            Klienci klient = new Klienci();
            int id_klienta = rs.getInt("id_klienta");
            String imie = rs.getString("imie");
            String nazwisko = rs.getString("nazwisko");
            klient.setImie(imie);
            klient.setNazwisko(nazwisko);

            czlonkostwo.setId_czlonkostwa(id_czlonkostwa);
            czlonkostwo.setKarnet(karnet);
            czlonkostwo.setKlient(klient);
            czlonkostwo.setData_rozpoczecia(data_rozpoczecia);
            czlonkostwo.setData_zakonczenia(data_zakonczenia);
            czlonkostwo.setStatus(status);

            list.add(czlonkostwo);
        }

        return list;

    }

    public static String compareDate(Date startowa, Date docelowa) throws ParseException {
        String pomocnicza = null;
        int wyniczek = 0;

        java.util.Date d = new java.util.Date();
        java.sql.Date sqlactualDate = new java.sql.Date(d.getTime());


        if (sqlactualDate.compareTo(docelowa) > 0) {
            pomocnicza = "Nieaktywny";
        } else if (sqlactualDate.compareTo(docelowa) < 0) {
            pomocnicza = "Aktywny";
        } else if (sqlactualDate.equals(docelowa)) {
            pomocnicza = "Aktywny";
        } else {
            ;
        }
        return pomocnicza;
    }

    public static void create(Czlonkostwa cz) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;

        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call insertCZLONKOSTWA(?,?,?,?)}");

        stmt.setInt(1, cz.karnet.getId_karnetu());
        stmt.setInt(2, cz.klient.getId_klienta());
        stmt.setDate(3, (Date) cz.getData_rozpoczecia());
        stmt.setDate(4, (Date) cz.getData_zakonczenia());

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.registerOutParameter(2, java.sql.Types.INTEGER);
        stmt.registerOutParameter(3, java.sql.Types.DATE);
        stmt.registerOutParameter(4, java.sql.Types.DATE);

        stmt.executeUpdate();
    }
}
