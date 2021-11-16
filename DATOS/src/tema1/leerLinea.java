package tema1;
import java.io.*;
public class leerLinea {

	public static void main(String[] args) throws IOException {
		//Leer byte a byte
		FileInputStream archivo=new FileInputStream("./fichero1.txt");
		int i;
		while ((i=archivo.read())!=-1) {
			System.out.println((char)i);
		}
	}
}
