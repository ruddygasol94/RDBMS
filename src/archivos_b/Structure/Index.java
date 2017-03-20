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
public class Index {
    private boolean a_creaResult;
    private final CamposArchivo
            c1 = new CamposArchivo("tabid", 2),
            c2 = new CamposArchivo("indid", 2),
            c3 = new CamposArchivo("nomind", 1, 10),
            c4 = new CamposArchivo("indtipo", 1, 1),
            c5 = new CamposArchivo("colid1", 2),
            c6 = new CamposArchivo("colid2", 2),
            c7 = new CamposArchivo("colid3", 2),
            c8 = new CamposArchivo("colid4", 2);
    
    private final CamposArchivo[] a_modelo = { c1, c2, c3, c4, c5, c6, c7, c8 };
    public final File index;
    
    public Index(String directory){
        index = new File(directory + "/index.dat");
        try{
            index.createNewFile();
        } catch (IOException ioe){
            a_creaResult = false;
            ioe.printStackTrace();
        } finally {
            a_creaResult = true;
        }
    }
    
    public boolean m_giveResult(){
            return a_creaResult;
        }
    
    public void m_inseIndex(Object[] p_data){
        Object[] registers = { p_data };
        new Escritor().escribe(index, a_modelo, p_data);
    }
}
