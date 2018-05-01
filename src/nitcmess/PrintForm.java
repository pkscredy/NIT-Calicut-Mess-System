/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nitcmess;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileOutputStream;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.text.Document;

/**
 *
 * @author Prashant
 */
public class PrintForm {

    public void print(JTable T)
    {
  MessageFormat header = new MessageFormat("HOSTEL MESS MANAGEMENT ");

        MessageFormat footer = new MessageFormat("page{0,number,integer}");

        try {
            T.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (PrinterException ex) {
            System.err.println(ex);
        }
    }

}
