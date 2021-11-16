package tema1;
import java.io.*;
public class leerFichero {

	public static void main(String[] args) throws IOException {
		
		//Leer caracter a caracter
		FileReader archivo=new FileReader("./fichero1.txt");
		int i;
		while ((i=archivo.read())!=-1) {
			System.out.print((char)i);
		}
		archivo.close();
	}
}