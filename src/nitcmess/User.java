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
public class User {
   // private String uname;
   // private String password;
      private  MyConnection MC=new MyConnection();
       private Statement stmt= MC.DoConnection();
    public  boolean login(String uname,String password,String who) throws SQLException
    {
        if(who.equals("Student"))
        {
              String insert="Select * from nitmess.studentregistration where Password like '"+password+"' and EnrollmentNo like '"+uname+"'";
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
        else
        {
              String insert="Select * from mess where Password like '"+password+"' and M_UniqueId like '"+uname+"'";
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
    }
    public boolean login(String password) throws SQLException
    {
         String insert="Select * from nitmess.chiefwarden where Password like '"+password+"'";
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
    public void setData(String un,String pass,String who) throws SQLException
    {

        if(who.equals("Student"))
        {
            String insert="update studentregistration set Password='"+pass+"' where EmailId like '"+un+"'";
            stmt.executeUpdate(insert);
        }
        else if(who.equals("Manager"))
        {
           String insert=" update nitmess.mess set Password='"+pass+"' where EmailId like '"+un+"'";
            stmt.executeUpdate(insert);
        }
    }
     public void setData(String un,String pass) throws SQLException
    {


            String insert="update studentregistration set Password='"+pass+"' where EnrollmentNo like '"+un+"'";
            stmt.executeUpdate(insert);

    }

}
