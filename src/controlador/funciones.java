/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author darkn
 */
public class funciones {
    public static void setColor(JPanel panel,Color c){        
        panel.setBackground(c);
    }
    public static void resetColor(JPanel panel,Color c){
        panel.setBackground(c);
    }
    public static void overSideBar(JLabel texto){
        texto.setForeground(Color.yellow);        
    }
    public static void outSideBar(JLabel texto){        
        texto.setForeground(new Color(204,204,204));        
    }
    public static void subrayar(JLabel texto){
        Font font = texto.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        texto.setFont(font.deriveFont(attributes));
    }
    public static void dessubrayar(JLabel texto){
        Font font = texto.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, -1);
        texto.setFont(font.deriveFont(attributes));
    }
    public static void limpiarCaja(JTextField texto){
        texto.setText("");
    }
    public static boolean isInteger(String s) {
        boolean isValidInteger = false;
        try{
           Integer.parseInt(s);
           isValidInteger = true;
        }
        catch (NumberFormatException ex){
           // s is not an integer
        }
        return isValidInteger;
    }
    public static void cargarContenidoTabla(String a,String b,String c,String d,String e,String f,JTable t){
        Object[] row = { a, b, c, d, e, f };
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        model.addRow(row);
    }
    
}
