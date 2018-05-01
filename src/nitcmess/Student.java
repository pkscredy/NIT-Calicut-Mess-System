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
public class Student extends User{
     private MyConnection MC=new MyConnection();
    private   Statement stmt= MC.DoConnection();
    public void basicInfo(String roll,String hname,String rnum) throws SQLException
    {
        String insert="update student set HostelName='"+hname+"',RoomNo='"+rnum+"' where EnrollmentNo like '"+roll+"'";
        stmt.executeUpdate(insert);
    }
    public void basicInfo(String name,String enrollment,String hostelName,String roomNo) throws SQLException
    {

        String insert="Insert into nitmess.student(Name,EnrollmentNo,HostelName,RoomNo)values('"+name+"','"+enrollment+"','"+hostelName+"','"+roomNo+"')";
            stmt.executeUpdate(insert);
    }
    public ResultSet getInfo(String enroll) throws SQLException
    {
        String insert="select * from student where EnrollmentNo like '"+enroll+"'";
        ResultSet RS=stmt.executeQuery(insert);
        return RS;
    }
    public ResultSet getEmailId(String enroll) throws SQLException
    {
        String insert="select EmailId,Password from studentregistration where EnrollmentNo like '"+enroll+"'";
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
    public boolean basicInfo(String enroll,String email,String contact,String dob,String gender ) throws SQLException
    {
        String mydate="12-12-12";
        String insert="Insert into nitmess.studentregistration(EnrollmentNo,ContactNo,Gender,DOB,EmailId)values('"+enroll+"','"+contact+"','"+gender+"','"+mydate+"','"+email+"')";
        stmt.executeUpdate(insert);
        return true;

    }
    public void removeRecord(String id) throws SQLException
    {
        String insert="delete from student where EnrollmentNo like '"+id+"'";
        stmt.executeUpdate(insert);
    }
    public void sendComplain(String id,String roll,String d,String msg) throws SQLException
    {
        String insert="insert into studentcomplaint(M_UniqueId,EnrolmentNo,Date,Message) values('"+id+"','"+roll+"','"+d+"','"+msg+"')";
        stmt.executeUpdate(insert);
    }
   public ResultSet getBill(String enroll) throws SQLException
    {

       // String dat;
        ResultSet RS=null;
        //String result[]=date.split("-");
        //int m=Integer.parseInt(result[1]);
        //int y=Integer.parseInt(result[0]);
        String insert="select * from studentbill where EnrollmentNo like '"+enroll+"'";
        RS=stmt.executeQuery(insert);
       // while(RS.next())
        //{

          //  date=RS.getString(2);
            //String str[]=date.split("-");
            //int mon=Integer.parseInt(str[1]);
            //int yr=Integer.parseInt(str[0]);

            //if((m==mon)&&(y==yr))
            //{
              //  mcid=RS.getString(1);
                //break;
            //}
        //}


        return RS;
    }
}
