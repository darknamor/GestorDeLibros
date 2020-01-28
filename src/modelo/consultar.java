/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author darkn
 */
public class consultar {
    
    private Connection con;
    private ResultSet rs; //contenedor
    private ResultSetMetaData mtd; //
    private String[] columnas;
    private String consulta,error;
    
    public consultar(Connection c,String sql){
        this.con = c;
        this.consulta = sql;
            try {
                Statement st = con.createStatement();
                
                rs = st.executeQuery(consulta);
                mtd = rs.getMetaData();
                error = null;
            } catch(SQLException ex){
                error = ex.getMessage();
            }
    }
    public String getError(){
        return this.error;
    }
    public ResultSet getResultado(){
        return this.rs;
    }
    public String[] getNombresColumnas(){
        try{
            int numColumnas = mtd.getColumnCount();
            this.columnas = new String[numColumnas];
            for(int i=0;i<numColumnas;i++){
                columnas [i]=mtd.getColumnLabel(i+1);
            }
        }catch(SQLException ex){
            Logger.getLogger(consultar.class.getName()).log(Level.SEVERE,null,ex);
        }
        return columnas;
    }
}
