/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.db;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;

/**
 *
 * @author theen
 */
public class DBHelper {

    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String SQCONN = "jdbc:sqlite:D:\\Kuliah\\KMMI\\SQLiteDB\\ProjectAkhir.sqlite";

    public static Connection getConnection(String driver) throws SQLException {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(SQCONN);
            createTable(conn, driver);
        } catch (ClassNotFoundException ex) {
            System.out.println("Library tidak ada");
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static void createTable(Connection conn, String driver) throws SQLException {
        String sqlCreate = "";
        {
            sqlCreate = "CREATE TABLE IF NOT EXISTS  Nasabah (" + "    idNasabah INT (20)       PRIMARY KEY,"
                    + "    nama      VARCHAR (20)," + "    alamat   VARCHAR (20) " + ");"

                    + "CREATE TABLE IF NOT EXISTS Rekening (" + "  noRekening INT (20)       PRIMARY KEY,"
                    + " saldo DOUBLE (20, 2)," 
                    + " idNasabah INT (20) REFERENCES Nasabah (idNasabah) ON DELETE RESTRICT"
                    + " ON UPDATE CASCADE" + ");"
                    
                    + "CREATE TABLE IF NOT EXISTS Perusahaan (" + "    idNasabah INT (20)      PRIMARY KEY"
                    + "                            REFERENCES Nasabah (idNasabah) ON DELETE RESTRICT"
                    + "                                                                  ON UPDATE CASCADE,"
                    + "    nib   INT (20) " + ");" 
                    
                    + "CREATE TABLE IF NOT EXISTS  Individu ("
                    + "    idNasabah INT (20)     PRIMARY KEY"
                    + "                           REFERENCES Nasabah (idNasabah) ON DELETE RESTRICT"
                    + "                                                                 ON UPDATE CASCADE,"
                    + "    nik    INT (20)," + "    npwp INT (20) " + ");";

            String sqls[] = sqlCreate.split(";");
            for (String sql : sqls) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.execute();
            }
        }
    }
}