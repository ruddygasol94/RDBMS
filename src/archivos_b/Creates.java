/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos_b;

import archivos_b.Structure.CamposArchivo;
import archivos_b.Structure.Column;
import archivos_b.Structure.Index;
import archivos_b.Structure.Tabla;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author ruddygasol94
 */
public class Creates {
    private String a_actuDataBase;
    
    public boolean m_setDatabase(String p_dataBaseName){
        if (!new File(p_dataBaseName + ".dat").mkdir()){
            a_actuDataBase = p_dataBaseName;
            return true;
        } else {
            System.out.println("The database doesn't exists.");
            return false;
        }
    }
        
    public boolean m_creaDatabase(String p_name){
        boolean result = false;
        if(new File(p_name+".dat").mkdir()){
            Tabla t = new Tabla(p_name+".dat");
            Column c = new Column(p_name + ".dat");
            Index i = new Index(p_name + ".dat");
            if (t.m_giveResult() && c.m_giveResult() && i.m_giveResult())
                result = true;
        } else System.out.println("The database already exists");
        //send error number 100
        return result;
    }
    
    public boolean m_creaTable(String p_name, CamposArchivo[] columns){
        boolean v_result = false;
        Tabla t = new Tabla(a_actuDataBase+".dat");
        int v_numeRegisters = new Escritor().countRegisters(t.m_giveFile(), t.m_giveModel()) + 1;
        System.out.println(v_numeRegisters);
        StringBuffer buffer = new StringBuffer(p_name);
        buffer.setLength(8);
        Object[] a_tablData = { buffer.toString(), buffer.toString() + ".dat", v_numeRegisters, m_getBytesSum(columns), columns.length, 0, 0 };
        t.m_inseTabla(a_tablData);
        new Escritor().leer(t.m_giveFile(), t.m_giveModel());
        System.out.println("=====================");
        m_creaColumn(v_numeRegisters, columns);
        return v_result;
    }
    
    public void m_creaColumn(int p_idTable, CamposArchivo[] columns){
        Column c = new Column(a_actuDataBase+".dat");
        
        for (int v_coluCounter = 0; v_coluCounter < columns.length; v_coluCounter++){
            int v_numeRegisters = new Escritor().countRegisters(c.m_getFile(), c.m_getModel()) + 1;
            CamposArchivo ca = columns[v_coluCounter];
            StringBuffer buffer = new StringBuffer(ca.getA_nombCampo());
            buffer.setLength(10);
            Object[] p_coluData = { p_idTable, v_numeRegisters, buffer.toString(), ca.m_getTipoColuChar(), ca.getByteSize(), 0, 0, };
            c.m_inseColumn(p_coluData);
        }
        new Escritor().leer(c.m_getFile(), c.m_getModel());
    }
    
    public int m_getBytesSum(CamposArchivo[] columns){
        int suma = 0;
        for (int v_counter = 0; v_counter < columns.length; v_counter++){
            CamposArchivo ca = columns[v_counter];
            suma += ca.getByteSize();
        }
        return suma;
    }
    
}
