/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Karnety;
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
public class KarnetyDAO {

    public List<Karnety> getAll() throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;
        List<Karnety> list = new ArrayList<Karnety>();
        con = JDBC_Connection.getConnections();
        CallableStatement statement = con.prepareCall("{call GETKARNETY(?)}");
        statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        statement.execute();
        ResultSet rs = (ResultSet) statement.getObject(1);

        while (rs.next()) {
            Karnety karnet = new Karnety();

            int id_karnetu = rs.getInt("id_karnetu");
            String nazwa = rs.getString("nazwa");
            Integer waznosc = rs.getInt("waznosc");
            Float cena = rs.getFloat("cena");

            karnet.setId_karnetu(id_karnetu);
            karnet.setNazwa(nazwa);
            karnet.setWaznosc(waznosc);
            karnet.setCena(cena);

            list.add(karnet);
        }

        return list;

    }

    public List<Karnety> searchingOrderUser(String l) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;
        List<Karnety> lista = new ArrayList<Karnety>();
        con = JDBC_Connection.getConnections();
        CallableStatement statement = con.prepareCall("{call SEARCHINKARNETY(?,?,?)}");
        statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        //statement.setInt(2, karnetyDAO.id);
        //statement.setString(3, l);
        statement.execute();
        ResultSet rs = (ResultSet) statement.getObject(1);

        while (rs.next()) {
            Karnety karnet = new Karnety();

            int id_karnetu = rs.getInt("id_karnetu");
            String nazwa = rs.getString("nazwa");
            Integer waznosc = rs.getInt("waznosc");
            Float cena = rs.getFloat("cena");

            karnet.setId_karnetu(id_karnetu);
            karnet.setNazwa(nazwa);
            karnet.setWaznosc(waznosc);
            karnet.setCena(cena);

            lista.add(karnet);
        }

        return lista;
    }

    public static void create(Karnety k) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;

        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call insertKARNETY(?,?,?)}");
        stmt.setString(1, k.getNazwa());
        stmt.setInt(2, k.getWaznosc());
        stmt.setFloat(3, k.getCena());

        stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(2, java.sql.Types.INTEGER);
        stmt.registerOutParameter(3, java.sql.Types.FLOAT);

        stmt.executeUpdate();
    }
    
    public static void update(Karnety k) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call updateKARNETY(?,?,?,?)}");
        stmt.setInt(1, k.getId_karnetu());
        stmt.setString(2, k.getNazwa());
        stmt.setInt(3, k.getWaznosc());
        stmt.setFloat(4, k.getCena());

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(3, java.sql.Types.INTEGER);
        stmt.registerOutParameter(4, java.sql.Types.FLOAT);
        stmt.executeUpdate();

    }
    
        public static void delete(Karnety k) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call deleteKARNETY(?)}");
        stmt.setInt(1, k.getId_karnetu());

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        
        stmt.executeUpdate();

    }
    public KarnetyDAO() {

    }
}
