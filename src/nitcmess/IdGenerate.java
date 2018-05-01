/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nitcmess;

/**
 *
 * @author Prashant
 */
import java.util.UUID;
public class IdGenerate {

    public String getId()
    {
        	UUID uuid = UUID.randomUUID();
                String id = uuid.toString().substring(0,8);
        return id;
    }
     public String getCardId()
    {
        	UUID uuid = UUID.randomUUID();
                String id = uuid.toString().substring(0,15);
        return id;
    }
}
