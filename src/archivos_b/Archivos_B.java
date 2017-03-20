/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos_b;

import archivos_b.Structure.CamposArchivo;
import archivos_b.Structure.Tabla;
import java.io.File;

/**
 *
 * @author ruddygasol94
 */
public class Archivos_B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Libro lib = new Libro();
        
        File data = new File("datos.dat");
        System.out.println(Double.BYTES + " tamaño");
        //lib.m_escrArchMaestro(data);
        System.out.println("Secuencial");
        lib.m_leerSecuMaestro(data);
        System.out.println("---------------");
        System.out.println("Busqueda del registro 4");
        if (!lib.m_leerAleaMaestro(data, 4))
            System.out.println("no Encontrado");
        System.out.println("------------------");
        System.out.println("Borrando registro 2");
        /*if (lib.m_borrRegistro(data, 2))
            System.out.println("Borrado satisfactoriamente");
        else System.out.println("no Encontrado");
        System.out.println("-------------------");
        System.out.println("Leer archivo");
        lib.m_leerSecuMaestro(data);*/
        /*
        CamposArchivo c1 = new CamposArchivo("Nombtab", 1, 8),
                      c2 = new CamposArchivo("Archivo", 1, 12),
                      c3 = new CamposArchivo("Tabid", 2),
                      c4 = new CamposArchivo("Tamreng", 2),
                      c5 = new CamposArchivo("Ncols", 2),
                      c6 = new CamposArchivo("Nrengs", 3),
                      c7 = new CamposArchivo("Nindex", 2);
        CamposArchivo tablAlumno[] = { c1, c2, c3, c4, c5, c6, c7 };
        
        Object reg1[] = {"Alumnos", "alumnos.dat", 1, 128, 5, 0, 0},
               reg2[] = {"Maestros", "maestros.dat", 2, 140, 4, 0, 0};
        Object registros[] = { reg1, reg2 };
        
        for(int v_contRegistros = 0; v_contRegistros < registros.length; v_contRegistros++){
            for(int v_contador = 0; v_contador < tablAlumno.length; v_contador++){
                System.out.print(tablAlumno[v_contador].getA_nombCampo() + ": ");
                Object objT[] = (Object[])registros[v_contRegistros];
                switch(tablAlumno[v_contador].getA_tipo()){
                    case 1 :
                        // char
                        StringBuffer buff = new StringBuffer(objT[v_contador].toString());
                        buff.setLength(tablAlumno[v_contador].getA_tamaño());
                        System.out.print(buff.toString());
                        ;break;
                    case 2 :
                        // int
                        System.out.print(Integer.parseInt(objT[v_contador].toString()));
                        break;
                    case 3 :
                        // double
                        System.out.print(Double.parseDouble(objT[v_contador].toString()));
                        break;
                    default : System.out.println("Valor no reconocido");
                }
                System.out.println("");
            }
            System.out.println("");
        }*/
        
        //Tabla a = new Tabla();
        //a.m_inseTabla(reg2);
        Creates c = new Creates();
        
        //prueba creación
        if(!c.m_creaDatabase("prueba")){
            System.out.println("Error");
        } else System.out.println("Database succesfully created.");
        
        //prueba seleccionar
        if (c.m_setDatabase("prueba"))
            System.out.println("Database selected.");
        else {
            System.out.println("No existe");
        }
        
        //tabla
        CamposArchivo c1 = new CamposArchivo("id", 2),
                c2 = new CamposArchivo("nombre", 1, 20),
                c3 = new CamposArchivo("apellido", 1, 20),
                c4 = new CamposArchivo("edad", 1),
                c5 = new CamposArchivo("sueldo", 3);
        CamposArchivo[] a_data = { c1, c2, c3, c4, c5 };
        c.m_creaTable("persona", a_data);
    }
    
}
