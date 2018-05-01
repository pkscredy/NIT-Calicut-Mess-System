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
public class CheckUser {
        private  MyConnection MC=new MyConnection();
          private Statement stmt= MC.DoConnection();

    public ResultSet checkStudent(String enroll) throws SQLException
    {

          String insert="Select * from nitmess.student where EnrollmentNo like '"+enroll+"'";
          ResultSet RS=stmt.executeQuery(insert);
          if(RS.next())
          {
           return RS;
          }
          else
          {
              return null;
          }
    }
    public boolean checkMess(String id) throws SQLException
    {
        String insert="select MessName from nitmess.mess where M_UniqueId like '"+id+"' ";
        ResultSet RS=stmt.executeQuery(insert);
        if(RS.next())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public ResultSet adminEmail() throws SQLException
    {

          String insert="Select EmailId,Password from chiefwarden ";
          ResultSet RS=stmt.executeQuery(insert);
          if(RS.next())
          {
           return RS;
          }
          else
          {
              return null;
          }
    }


}
