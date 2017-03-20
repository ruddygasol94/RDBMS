/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos_b;

import archivos_b.Structure.CamposArchivo;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author ruddygasol94
 */
public class Escritor {
    
    public void escribe(File p_archivo, CamposArchivo[] p_modelo, Object[] p_datos){
        try{
            RandomAccessFile raf = new RandomAccessFile(p_archivo, "rw");
            //verifica si el archivo esta vacio
            if (raf.length() > 0)
                raf.seek(raf.length());
            //Ciclo para recorrer registros
            for (int v_contRegistros = 0; v_contRegistros < p_datos.length; v_contRegistros++){
                Object v_objeTemporal[] = (Object[])p_datos[v_contRegistros];
                //ciclo para recorrer modelo
                for (int v_contCampos = 0; v_contCampos < p_modelo.length; v_contCampos++){
                    //Switch para elegir el tipo de dato a escribir
                    switch(p_modelo[v_contCampos].getA_tipo()){
                        //caso para char
                        case 1:
                            StringBuffer buff = new StringBuffer(v_objeTemporal[v_contCampos].toString());
                            buff.setLength(p_modelo[v_contCampos].getA_tamaño());
                            raf.writeChars(buff.toString());
                            break;
                        //caso para int
                        case 2:
                            int v_valor = Integer.parseInt(v_objeTemporal[v_contCampos].toString());
                            raf.writeInt(v_valor);
                            break;
                        //caso para double
                        case 3:
                            double v_valoD = Double.parseDouble(v_objeTemporal[v_contCampos].toString());
                            raf.writeDouble(v_valoD);
                            break;
                    }
                }
            }
            raf.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    
    public void leer(File p_archivo, CamposArchivo[] p_modelo){
        try{
            long v_apunActual, v_apunFinal;
            
            RandomAccessFile raf = new RandomAccessFile(p_archivo, "r");
            while( (v_apunActual = raf.getFilePointer()) != (v_apunFinal = raf.length())){
                //Ciclo para recorrer los campos del registro
                for (int v_contCampos = 0; v_contCampos < p_modelo.length; v_contCampos++){
                    //switch para saber que tipo de dato se leerá del archivo
                    switch (p_modelo[v_contCampos].getA_tipo()){
                        //case para char
                        case 1:
                            char v_arreglo[] = new char[p_modelo[v_contCampos].getA_tamaño()], temp;
                            for (int v_contLongitud = 0; v_contLongitud < v_arreglo.length; v_contLongitud++){
                                temp = raf.readChar();
                                v_arreglo[v_contLongitud] = temp;
                            }
                            //CT
                            String text = new String(v_arreglo).replace('\0', ' ');
                            System.out.print(text + " ");
                            break;
                        case 2:
                            int entero = raf.readInt();
                            System.out.println(entero + " ");
                            break;
                        case 3:
                            double doble = raf.readDouble();
                            System.out.println(doble + " ");
                            break;
                    }
                    System.out.println("");
                }
                System.out.println("");                
            }
            raf.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    
    public int countRegisters(File p_archivo, CamposArchivo[] p_modelo){
        int v_noRegisters = 0;
        if(p_archivo.length() != 0){
            try{
                long v_apunActual, v_apunFinal;

                RandomAccessFile raf = new RandomAccessFile(p_archivo, "r");
                while( (v_apunActual = raf.getFilePointer()) != (v_apunFinal = raf.length())){
                    //Ciclo para recorrer los campos del registro
                    for (int v_contCampos = 0; v_contCampos < p_modelo.length; v_contCampos++){
                        //switch para saber que tipo de dato se leerá del archivo
                        switch (p_modelo[v_contCampos].getA_tipo()){
                            //case para char
                            case 1:
                                char v_arreglo[] = new char[p_modelo[v_contCampos].getA_tamaño()], temp;
                                for (int v_contLongitud = 0; v_contLongitud < v_arreglo.length; v_contLongitud++){
                                    temp = raf.readChar();
                                    v_arreglo[v_contLongitud] = temp;
                                }
                                //CT
                                String text = new String(v_arreglo).replace('\0', ' ');
                                break;
                            case 2:
                                int entero = raf.readInt();
                                break;
                            case 3:
                                double doble = raf.readDouble();
                                break;
                        }
                    }
                }
                raf.close();
            } catch (IOException ioe){
                ioe.printStackTrace();
            }
        } 
        return v_noRegisters;
    }    
    
}
