/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nitcmess;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Prashant
 */
public class SaveImage {

     public void SavePaint(JFrame F)
    {


        try
        {
            BufferedImage image = new BufferedImage(F.getWidth(), F.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = image.createGraphics();
            F.paint(graphics2D);
            ImageIO.write(image,"jpeg", new File("image.jpeg"));
        }
        catch(Exception ex)
        {
          System.err.println(ex);
        }
    }

    protected void paintComponent(Graphics g)
    {
        g.drawRect(50,50,50,50);
    }

}
