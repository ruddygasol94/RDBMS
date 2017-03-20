/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos_b.Structure;

/**
 *
 * @author ruddygasol94
 */
public class CamposArchivo {
    private String a_nombCampo;
    private int a_tipo;
    private int a_tamaño;
    
    public CamposArchivo(String p_nombCampo, int p_tipo, int p_tamaño){
        a_nombCampo = p_nombCampo;
        a_tipo = p_tipo;
        a_tamaño = p_tamaño;
    }

    public CamposArchivo(String p_nombCampo, int p_tipo){
        a_nombCampo = p_nombCampo;
        a_tipo = p_tipo;
    }
    
    public String getA_nombCampo() {
        return a_nombCampo;
    }

    public int getA_tipo() {
        return a_tipo;
    }

    public int getA_tamaño() {
        return a_tamaño;
    }
    
    public int getByteSize(){
        if (a_tipo == 1)
            return a_tamaño * 2;
        else if (a_tipo == 2)
            return 2;
        else if (a_tipo == 3)
            return 8;
        else if (a_tipo == 4)
            return 6;
        else return 0;
    }
    
    public char m_getTipoColuChar(){
        if (a_tipo == 1)
            return 'C';
        else if (a_tipo == 2)
            return 'I';
        else if (a_tipo == 3)
            return 'D';
        else return 'F';
    }
    
}
