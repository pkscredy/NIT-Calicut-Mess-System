/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nitcmess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Prashant
 */
public class ChiefWarden extends User implements NewMess
{
    private String passwd;
    private MyConnection MC=new MyConnection();
     private   Statement stmt=MC.DoConnection();
    public void addStudent(String name,String enroll,String hname,String rname) throws SQLException
    {
       Student Stud=new Student();
       Stud.basicInfo(name,enroll,hname,rname);


    }
    @Override
    public void addMess(String id,String name,String memail,String intake,String location,String type,String mfor,String charge) throws SQLException
    {


     //  MyMess M=new MyMess(id,name,memail,intake,location,mfor,type,charge);
         String insert="insert into nitmess.mess (M_UniqueId,MessName,EmailId,Intake,Location,Type,MessFor,DayCharge) values('"+id+"','"+name+"','"+memail+"','"+intake+"','"+location+"','"+type+"','"+mfor+"','"+charge+"')";
            stmt.executeUpdate(insert);

    }
    @Override
    public void removeMess(String id) throws SQLException
    {
       // MyMess M=new MyMess();
        //M.removeMess(id);
        String insert="delete from nitmess.mess where M_UniqueId like '"+id+"'";
        stmt.executeUpdate(insert);

    }
    @Override
    public void updateMess(String id,String mname,String dcharge,String take,String mfor,String loc) throws SQLException
    {
       // MyMess M=new MyMess();
        //M.updateMess(id,mname,dcharge,take,mfor,loc);
         String insert="update nitmess.mess set MessName='"+mname+"', DayCharge='"+dcharge+"',Intake='"+take+"',MessFor='"+mfor+"',Location='"+loc+"' where M_UniqueId like '"+id+"'";
        stmt.executeUpdate(insert);
    }
    public ResultSet getDetails(String id) throws SQLException
    {
       // MyMess M=new MyMess();
        //return M.getDetails(id);
         String insert="select MessName,DayCharge,Intake,MessFor,Location,Type from nitmess.mess where M_UniqueId like '"+id+"'";
        ResultSet RS=stmt.executeQuery(insert);
        return RS;
    }
    public void cardEntry(String roll,String card,String dd,String stat) throws SQLException
    {

        String insert="insert into MessCardEntry (EnrollmentNo,MessCardNo,Date,Status) values('"+roll+"','"+card+"','"+dd+"','"+stat+"')";
        stmt.executeUpdate(insert);
    }

    @Override
    public ResultSet getEmail(String id) throws SQLException {
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
