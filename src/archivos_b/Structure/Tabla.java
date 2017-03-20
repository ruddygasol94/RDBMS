/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos_b.Structure;

import archivos_b.Escritor;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author ruddygasol94
 */
public class Tabla {
    private boolean a_creaResult;
    private final CamposArchivo c1 = new CamposArchivo("Nombtab", 1, 8),
                      c2 = new CamposArchivo("Archivo", 1, 12),
                      c3 = new CamposArchivo("Tabid", 2),
                      c4 = new CamposArchivo("Tamreng", 2),
                      c5 = new CamposArchivo("Ncols", 2),
                      c6 = new CamposArchivo("Nrengs", 3),
                      c7 = new CamposArchivo("Nindex", 2);
    private final CamposArchivo[] a_modelo = { c1, c2, c3, c4, c5, c6, c7 }; 
    private final File tabla;
    
    public Tabla(String directory){
        tabla = new File(directory+"/table.dat");
        
        try{
            tabla.createNewFile();
        } catch (IOException ioe){
            a_creaResult = false;
            ioe.printStackTrace();
        } finally {
            a_creaResult = true;
        }
    }
    
    public CamposArchivo[] m_giveModel(){
        return a_modelo;
    }
    
    public File m_giveFile(){
        return tabla;
    }
    
    public boolean m_giveResult(){
            return a_creaResult;
        }
    
    public void m_inseTabla(Object[] datos){
        Object[] registros = { datos };
        new Escritor().escribe(tabla, a_modelo, registros);
        new Escritor().leer(tabla, a_modelo);
    }
    
    
    
}
