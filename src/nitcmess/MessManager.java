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
public class MessManager extends User {
  //  private String name;
    //private String password;
    private MyConnection MC=new MyConnection();
     private   Statement stmt=MC.DoConnection();
     public ResultSet getCardDetails(String id) throws SQLException
    {
        String insert="select * from messcardentry where MessCardNo like '"+id+"'";
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
    public void addStudent(String mid,String roll,String cid,String dd) throws SQLException
    {
        String insert="insert into joinmess(M_UniqueId,MessCardNo,EnrollmentNo,Date) values('"+mid+"','"+cid+"','"+roll+"','"+dd+"')";
        stmt.executeUpdate(insert);
    }
    public void fillAbsent(String mid,String roll,String todate,String fdate) throws SQLException
    {
         String insert="insert into absentees(M_UniqueId,EnrollmentNo,DateFrom,DateTo) values('"+mid+"','"+roll+"','"+fdate+"','"+todate+"')";
        stmt.executeUpdate(insert);
    }
    public void fillExtra(String mid,String enroll,String dat,String am) throws SQLException
    {
       String insert="insert into extra(M_UniqueId,EnrollmentNo,DateAndTime,Amount) values('"+mid+"','"+enroll+"','"+dat+"','"+am+"')";
        stmt.executeUpdate(insert);
    }

    public String generateBill(String id,String mid,String dd) throws SQLException
    {
        StringBuilder builder=new StringBuilder();
        Double messCh=0.0;
        String mch=null;
        Double extra=0.0;
        Double tot_extra=0.0;
        String ex=null;
        Double total=0.0;
        int absent=0;
        ResultSet RS;
        String date;
        String result[]=dd.split("-");
        int m=Integer.parseInt(result[1]);
        int y=Integer.parseInt(result[0]);
        String q="select * from mess where M_UniqueId like '"+mid+"'";
        RS=stmt.executeQuery(q);
        if(RS.next())
        {
            mch=RS.getString(9);
        }
        messCh=Double.parseDouble(mch);
       String qq="select DateAndTime,Amount from extra where EnrollmentNo like '"+id+"'";
        RS=stmt.executeQuery(qq);
         while(RS.next())
        {

            date=RS.getString(1);
            String str[]=date.split("-");
            int mon=Integer.parseInt(str[1]);
            int yr=Integer.parseInt(str[0]);

            if((m==mon)&&(y==yr))
            {
                ex=RS.getString(2);
                 extra=Double.parseDouble(ex);
                 tot_extra=tot_extra+extra;
            }
        }
         //extra=Double.parseDouble(ex);
        String   qqq="select DateFrom,DateTo from absentees where EnrollmentNo like '"+id+"'";
        RS=stmt.executeQuery(qqq);
          while(RS.next())
        {

            date=RS.getString(1);
            String str[]=date.split("-");
            int mon=Integer.parseInt(str[1]);
            int yr=Integer.parseInt(str[0]);
            int day=Integer.parseInt(str[2]);

            if((m==mon)&&(y==yr))
            {
               String date1=RS.getString(2);
                 String str1[]=date1.split("-");
           int day2=Integer.parseInt(str1[2]);
          absent=day2-day;
                break;
            }
        }
          total=messCh+tot_extra-(absent*60.0);
          builder.append(total).append("-").append(tot_extra).append("-").append(absent);
          String finalResult=null;
                 finalResult =builder.toString();
          return finalResult;


    }
    public void getLeadger()
    {

    }
    public void complain()
    {

    }
    public String activeStudent(String id,String mydate) throws SQLException
    {
        String date;
        String mcid=null;
        String result[]=mydate.split("-");
        int m=Integer.parseInt(result[1]);
        int y=Integer.parseInt(result[0]);
        String insert="select M_UniqueId,Date from joinmess where EnrollmentNo like '"+id+"'";
        ResultSet RS=stmt.executeQuery(insert);
        while(RS.next())
        {

            date=RS.getString(2);
            String str[]=date.split("-");
            int mon=Integer.parseInt(str[1]);
            int yr=Integer.parseInt(str[0]);

            if((m==mon)&&(y==yr))
            {
                mcid=RS.getString(1);
                break;
            }
        }


        return mcid;
    }
    public ResultSet getComplain(String id) throws SQLException
    {
         ResultSet RS=null;
        String insert="select EnrolmentNo,Message from studentcomplaint where M_UniqueId like '"+id+"'";
        RS=stmt.executeQuery(insert);

            return RS;
    }
    public void removeComplain(String id) throws SQLException
    {
        String insert="delete from studentcomplaint where EnrolmentNo like '"+id+"'";
        stmt.executeUpdate(insert);
    }
    public void addBill(String enroll,String dd,String mid,String ex,String tot) throws SQLException
    {
         String insert="insert into Studentbill (EnrollmentNo,Date,M_UniqueId,Extra,Total) values('"+enroll+"','"+dd+"','"+mid+"','"+ex+"','"+tot+"')";
        stmt.executeUpdate(insert);
    }

     public ResultSet getMessCollection(String mid) throws SQLException
    {

        ResultSet RS=null;
        //int m=Integer.parseInt(result[1]);
        //int y=Integer.parseInt(result[0]);
        String insert="select * from studentbill where M_UniqueId like '"+mid+"'";
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
