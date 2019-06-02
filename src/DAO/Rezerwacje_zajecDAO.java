/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Kategorie_zajec;
import Models.Personel;
import Models.Rezerwacje_zajec;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class Rezerwacje_zajecDAO {

    public List<Rezerwacje_zajec> getAll() throws SQLException, ParseException {

        Connection con = null;
        CallableStatement stmt = null;
        List<Rezerwacje_zajec> list = new ArrayList<Rezerwacje_zajec>();
        con = JDBC_Connection.getConnections();
        CallableStatement statement = con.prepareCall("{call GETREZERWACJE_ZAJEC(?)}");
        statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        statement.execute();
        ResultSet rs = (ResultSet) statement.getObject(1);

        while (rs.next()) {
            Rezerwacje_zajec rezerwacja = new Rezerwacje_zajec();
            int id_rezerwacji = rs.getInt("id_rezerwacji");
            String dzien = rs.getString("dzien");
            String godzina = rs.getString("godzina");
            int ilosc = rs.getInt("max_ilosc_osob");

            Personel pracownik = new Personel();
            int id_pracownika = rs.getInt("id_pracownika");
            String imie = rs.getString("imie");
            String nazwisko = rs.getString("nazwisko");
            pracownik.setImie(imie);
            pracownik.setNazwisko(nazwisko);

            Kategorie_zajec kategoria = new Kategorie_zajec();
            int id_zajec = rs.getInt("id_zajec");
            String nazwa_zajec = rs.getString("nazwa_zajec");
            kategoria.setId_zajec(id_zajec);
            kategoria.setNazwa_zajec(nazwa_zajec);

            rezerwacja.setId_rezerwacji(id_rezerwacji);
            rezerwacja.setZajecia(kategoria);
            rezerwacja.setPracownik(pracownik);
            rezerwacja.setDzien(dzien);
            rezerwacja.setGodzina(godzina);
            rezerwacja.setIlosc(ilosc);

            list.add(rezerwacja);
        }

        return list;

    }


    public static void create(Rezerwacje_zajec r) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;

        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call insertREZERWACJE_ZAJEC(?,?,?,?,?)}");

        stmt.setInt(1, r.zajecia.getId_zajec());
        stmt.setInt(2, r.pracownik.getId_pracownika());
        stmt.setString(3, r.getDzien());
        stmt.setString(4, r.getGodzina());
        stmt.setInt(5, r.getIlosc());

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.registerOutParameter(2, java.sql.Types.INTEGER);
        stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(5, java.sql.Types.INTEGER);

        stmt.executeUpdate();
    }

    public static void delete(Rezerwacje_zajec cz) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call deleteREZERWACJE_ZAJEC(?)}");
        stmt.setInt(1, cz.getId_rezerwacji());

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);

        stmt.executeUpdate();

    }

    public static void update(Rezerwacje_zajec cz) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call updateREZERWACJE_ZAJEC(?,?,?,?)}");
        //stmt.setInt(1, r.zajecia.getId_zajec());
        //stmt.setInt(2, r.pracownik.getId_pracownika());
        //stmt.setString(3, r.getDzien());
        //stmt.setString(4, r.getGodzina());
        //stmt.setInt(5, r.getIlosc());

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.registerOutParameter(2, java.sql.Types.INTEGER);
        stmt.registerOutParameter(3, java.sql.Types.DATE);
        stmt.registerOutParameter(4, java.sql.Types.DATE);

        stmt.executeUpdate();

    }

    public Rezerwacje_zajecDAO() {

    }
}
