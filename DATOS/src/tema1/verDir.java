package tema1;

import java.io.*;

public class verDir {
	public static void main(String[] args) {
		String dir=".";
		File f=new File (dir);
		String [] archivos=f.list();
		System.out.println("Ficheros del directorio actual:\n"+archivos.length);
		
		for (int i = 0; i < archivos.length; i++) {
			File f2=new File(f, archivos[i]);
			System.out.printf("Nombre:%s, �es fichero?: %b, �Es directorio? %b%n",archivos[i],f2.isFile(),f2.isDirectory());
		}
	}
}