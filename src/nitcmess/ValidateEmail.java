/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nitcmess;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Prashant
 */
public class ValidateEmail {

    public boolean validate(String email)
    {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher m=pattern.matcher(email);
        if(m.matches())
        {
            return true;
        }
        else
        {
        return false;
        }
    }

}
