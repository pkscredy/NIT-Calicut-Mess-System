/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nitcmess;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Prashant
 */
public class getCurrentDate {

    private int d;
    private int m;
    private int y;
    public String getDate()
    {
        Date date=new Date();
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        y=cal.get(Calendar.YEAR);
        m=cal.get(Calendar.MONTH)+1;
        d=cal.get(Calendar.DAY_OF_MONTH);
        String dd=y+"-"+m+"-"+d;

        System.err.println(dd);
        return dd;
    }

}
