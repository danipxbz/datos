package tema1;
import java.io.*;
public class escribirFichero {

	public static void main(String[] args) throws IOException {
		FileWriter fichero=new FileWriter("./fichero1.txt");
		fichero.write("hola titi");
		fichero.close();
		
//		FileReader archivo=new FileReader("./fichero1.txt");
//		int i;
//		while ((i=archivo.read())!=-1) {
//			System.out.print((char)i);
//		}
//		archivo.close();
	}

}