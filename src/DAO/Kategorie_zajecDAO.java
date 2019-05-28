/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.JDBC_Connection.connection;
import Models.Kategorie_zajec;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class Kategorie_zajecDAO {

    public List<Kategorie_zajec> getAll() throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;
        List<Kategorie_zajec> list = new ArrayList<Kategorie_zajec>();
        con = JDBC_Connection.getConnections();
        CallableStatement statement = con.prepareCall("{call GETKATEGORIEZAJEC(?)}");
        statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        statement.execute();
        ResultSet rs = (ResultSet) statement.getObject(1);

        while (rs.next()) {
            Kategorie_zajec kategoria = new Kategorie_zajec();
            int id_zajec = rs.getInt("id_zajec");
            String nazwa_zajec = rs.getString("nazwa_zajec");
            String rodzaj_zajec = rs.getString("rodzaj_zajec");
            String opis = rs.getString("opis");
            kategoria.setId_zajec(id_zajec);
            kategoria.setNazwa_zajec(nazwa_zajec);
            kategoria.setRodzaj_zajec(rodzaj_zajec);
            kategoria.setOpis(opis);

            list.add(kategoria);
        }
  
        return list;

    }

    ;
    
    public static void create(Kategorie_zajec k) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;

        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call insertKATEGORIE_ZAJEC(?,?,?)}");
        stmt.setString(1, k.getNazwa_zajec());
        stmt.setString(2, k.getRodzaj_zajec());
        stmt.setString(3, k.getOpis());

        stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(3, java.sql.Types.VARCHAR);

        stmt.executeUpdate();
    }
    
    public Kategorie_zajecDAO()
    {
        
    }

}
