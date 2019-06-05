/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Klienci;
import Models.Klient_Zajecia;
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
public class Klient_ZajeciaDAO {
    
    public List<Klient_Zajecia> getAll() throws SQLException, ParseException {

        Connection con = null;
        CallableStatement stmt = null;
        List<Klient_Zajecia> list = new ArrayList<Klient_Zajecia>();
        con = JDBC_Connection.getConnections();
        CallableStatement statement = con.prepareCall("{call GETKLIENT_ZAJECIA(?)}");
        statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        statement.execute();
        ResultSet rs = (ResultSet) statement.getObject(1);

        while (rs.next()) {
            Rezerwacje_zajec rezerwacja = new Rezerwacje_zajec();
            int id_rezerwacji = rs.getInt("id_rezerwacji");
            rezerwacja.setId_rezerwacji(id_rezerwacji);

            Klienci klient = new Klienci();
            int id_klienta = rs.getInt("id_klienta");
            String imie = rs.getString("imie");
            String nazwisko = rs.getString("nazwisko");
            klient.setId_klienta(id_klienta);
            klient.setImie(imie);
            klient.setNazwisko(nazwisko);

            Klient_Zajecia kz = new Klient_Zajecia();
            int pomoc = id_rezerwacji;
            
            kz.setKlient(klient);
            kz.setRezerwacja(rezerwacja);
            kz.setPomoc(pomoc);
            list.add(kz);
        }

        return list;

    }
    
    public static void create(Klient_Zajecia r) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;

        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call insertKLIENT_ZAJECIA(?,?)}");

        stmt.setInt(1, r.klient.getId_klienta());
        stmt.setInt(2, r.rezerwacja.getId_rezerwacji());

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.registerOutParameter(2, java.sql.Types.INTEGER);

        stmt.executeUpdate();
    }
    
    public Klient_ZajeciaDAO(){
        
    }
}
