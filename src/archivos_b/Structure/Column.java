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
public class Column {
    private boolean a_creaResult;
        private final CamposArchivo c1 = new CamposArchivo("Tabid", 2),
                c2 = new CamposArchivo("Colid", 2),
                c3 = new CamposArchivo("Nomcol", 1, 10),
                c4 = new CamposArchivo("coltipo", 1, 1),
                c5 = new CamposArchivo("coltam", 2),
                c6 = new CamposArchivo("tabref", 2),
                c7 = new CamposArchivo("colref", 2);
        
        private final CamposArchivo[] a_modelo = { c1, c2, c3, c4, c5, c6, c7 };
        private final File column;
        
        public Column(String directory){
            column = new File(directory+"/column.dat");
            try{
                column.createNewFile();
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
        
        public File m_getFile(){
            return column;
        }
        
        public CamposArchivo[] m_getModel(){
            return a_modelo;
        }
        
       public void m_inseColumn(Object[] datos){
           Object[] registros = { datos };
           new Escritor().escribe(column, a_modelo, registros);
       } 
}
