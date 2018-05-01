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
public class MyMess extends MessManager{
     private   MyConnection MC=new MyConnection();
     private  Statement stmt= MC.DoConnection();
     public MyMess()
     {

     }

    public MyMess(String uid,String name,String email,String itake,String location,String mfor,String type,String dayCharge) throws SQLException
    {


         String insert="insert into nitmess.mess (M_UniqueId,MessName,EmailId,Intake,Location,Type,MessFor,DayCharge) values('"+uid+"','"+name+"','"+email+"','"+itake+"','"+location+"','"+type+"','"+mfor+"','"+dayCharge+"')";
            stmt.executeUpdate(insert);
    }
    public void removeMess(String id) throws SQLException
    {
        String insert="delete from nitmess.mess where M_UniqueId like '"+id+"'";
        stmt.executeUpdate(insert);
    }
    public void updateMess(String id,String mname,String dcharge,String take,String mfor,String loc) throws SQLException
    {
        String insert="update nitmess.mess set MessName='"+mname+"', DayCharge='"+dcharge+"',Intake='"+take+"',MessFor='"+mfor+"',Location='"+loc+"' where M_UniqueId like '"+id+"'";
        stmt.executeUpdate(insert);
    }
    public ResultSet getDetails(String id) throws SQLException
    {
        String insert="select MessName,DayCharge,Intake,MessFor,Location,Type from nitmess.mess where M_UniqueId like '"+id+"'";
        ResultSet RS=stmt.executeQuery(insert);
        return RS;
    }
    public ResultSet getEmail(String id) throws SQLException
    {
         String insert="select EmailId,Password from mess where M_UniqueId like '"+id+"'";
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
