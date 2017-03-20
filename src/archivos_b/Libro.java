/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos_b;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author ruddygasol94
 */
public class Libro {
    private int a_llave;
    private String a_titulo;
    private double a_clasificacion;
    
    public void m_escrArchMaestro(File p_archivo){
        try{
            int n;
            StringBuffer buffer = null;
            RandomAccessFile raf = new RandomAccessFile(p_archivo, "rw");
            Scanner in = new Scanner(System.in);
            do{
                if (raf.length() > 0)
                    raf.seek(raf.length());
                System.out.println("Clave del libro");
                a_llave = in.nextInt();
                
                raf.writeInt(a_llave);
                System.out.println("Título del libro");
                a_titulo = in.next();
                buffer = new StringBuffer(a_titulo);
                buffer.setLength(15);
                raf.writeChars(buffer.toString());
                System.out.println("Clasificación del Libro");
                a_clasificacion = in.nextDouble();
                raf.writeDouble(a_clasificacion);
                System.out.println("Desea ingresar otro libro?: Si = 1, No = 0");
                n = in.nextInt();
            } while (n == 1);
            raf.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    
    public void m_leerSecuMaestro(File p_archivo){
        try{
            long v_apunActual, v_apunFinal;
            
            RandomAccessFile raf = new RandomAccessFile(p_archivo, "r");
            while ( (v_apunActual = raf.getFilePointer()) != (v_apunFinal = raf.length())){
                a_llave = raf.readInt();
                System.out.println(a_llave);
                char nombre[] = new char[15], temp;
                for (int c = 0; c < nombre.length; c++){
                    temp = raf.readChar();
                    nombre[c] = temp;
                }
                a_titulo = new String(nombre).replace('\0', ' ');
                System.out.println(a_titulo);
                a_clasificacion = raf.readDouble();
                System.out.println(a_clasificacion);
            }
            raf.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    
    public boolean m_leerAleaMaestro(File p_archivo, int p_llave){
        boolean bandera = false;
        try{
            int n, dl;
            long lreg, desplaza;
            
            RandomAccessFile raf = new RandomAccessFile(p_archivo, "r");
            Scanner in = new Scanner(System.in);
            raf.readInt();
            for(int c = 0; c < 15; c++)
                raf.readChar();
            raf.readDouble();
            lreg = raf.getFilePointer();
            
            dl = p_llave;
            desplaza = (dl - 1) * lreg;
            if (desplaza < raf.length()){
                raf.seek(desplaza);
                a_llave = raf.readInt();
                System.out.println("Datos:");
                System.out.println(a_llave);
                char nombre[] = new char[15], temp;
                for (int c1 = 0; c1 < nombre.length; c1++){
                    temp = raf.readChar();
                    nombre[c1] = temp;
                }
                a_titulo = new String(nombre).replace('\0', ' ');
                System.out.println(a_titulo);
                a_clasificacion = raf.readDouble();
                System.out.println(a_clasificacion);
                bandera = true;
            } 
            raf.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        return bandera;
    }
    
    public boolean m_borrRegistro(File p_archivo, int p_llave){
        boolean coincidencia = false;
        try{
            long v_apunActual, v_apunFinal;
            
            RandomAccessFile raf = new RandomAccessFile(p_archivo,"r");
            File v_archTemporal = new File("auxiliar");
            RandomAccessFile rafT = new RandomAccessFile(v_archTemporal, "rw");
            
            while( (v_apunActual = raf.getFilePointer()) != (v_apunFinal = raf.length())){
                int v_llave = raf.readInt();
                if (v_llave != p_llave){
                    rafT.writeInt(v_llave);
                    char nombre[] = new char[15], temp;
                    for (int i = 0; i < nombre.length; i++){
                        temp = raf.readChar();
                        nombre[i] = temp;
                    }
                    String v_titulo = new String(nombre).replace('\0', ' ');
                    StringBuffer buff = new StringBuffer(v_titulo);
                    buff.setLength(15);
                    rafT.writeChars(buff.toString());
                    double v_class = raf.readDouble();
                    rafT.writeDouble(v_class);
                } else {
                    for(int o = 0; o < 15; o++)
                        raf.readChar();
                    raf.readDouble();
                    coincidencia = true;
                }
            }
            raf.close();
            rafT.close();
            String name = p_archivo.getName();
            p_archivo.delete();
            File f2 = new File(name);
            v_archTemporal.renameTo(f2);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        return coincidencia;
    }
}
