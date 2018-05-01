/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nitcmess;

import java.sql.*;

/**
 *
 * @author Prashant
 */
public class MyConnection {
      private static final String username="root";
    private static final String password="";
    private static final String conn_string="jdbc:mysql://localhost/nitmess";
     Connection conn;
        Statement stat=null;

    public Statement DoConnection()
    {
        Statement stmt=null;

        try
        {
            conn=DriverManager.getConnection(conn_string,username,password);
           stmt =(Statement)conn.createStatement();


        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        return stmt;
    }
}
