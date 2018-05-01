/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nitcmess;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Prashant
 */
public interface NewMess {
     public void addMess(String uid,String name,String email,String itake,String location,String mfor,String type,String dayCharge)throws SQLException;

    public void removeMess(String id)throws SQLException;
    public void updateMess(String id,String mname,String dcharge,String take,String mfor,String loc)throws SQLException;
    public ResultSet getDetails(String id)throws SQLException;
    public ResultSet getEmail(String id)throws SQLException;

}
