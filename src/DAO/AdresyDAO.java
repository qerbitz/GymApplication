/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Adresy;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class AdresyDAO {
    
    public static void create(Adresy a) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;

        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call insertADRESY(?,?,?,?,?,?)}");
        
        stmt.setString(1, a.getWojewodztwo());
        stmt.setString(2, a.getPowiat());
        stmt.setString(3, a.getMiejscowosc());
        stmt.setString(4, a.getUlica());
        stmt.setString(5, a.getNr_domu());
        stmt.setString(6, a.getKod_pocztowy());
        

        stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(6, java.sql.Types.VARCHAR);   
        

        stmt.executeUpdate();
    }
    
}
