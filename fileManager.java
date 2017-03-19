public class FileManager {
  
  public void m_writeFile(File p_file, FieldFile[] p_model, Object[] p_data){
    try{
      RandomAccessFile raf = new RandomAccessFile(p_file, "rw");
      //verify if the file is empty
      if (raf.length() > 0)
        raf.seek(raf.length());
      //loop for consume the model
      for (int v_registerCounter = 0; v_registerCounter < p_model.length; v_registerCounter++){
        Object[] v_tem
      }
    }
  }
}
