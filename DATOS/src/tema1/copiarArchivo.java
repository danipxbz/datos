package tema1;
import java.io.*;
public class copiarArchivo {
	public static void main(String[] args) {
		copiarArchivo cpFl=new copiarArchivo();
		String fromFile=args[0];
		String toFile=args[1];
		
		boolean result= cpFl.copyFile(fromFile, toFile);
		System.out.println(result?"Archivo copiado":"No se ha podido copiar el fichero");	
		}
	
	
	public boolean copyFile(String fromFile, String toFile) {
		File origen=new File(fromFile);
		File destino=new File(toFile);
		
		if (origen.exists()) {
			try {
				InputStream in=new FileInputStream(origen);
				OutputStream out=new FileOutputStream(destino);
				
				byte[] buf=new byte[1024];
				int len;
				while ((len=in.read(buf))>0) {
					out.write(buf, 0, len);
				}
				in.close();
				out.close();
				return true;
				
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		else return false;
	}
}