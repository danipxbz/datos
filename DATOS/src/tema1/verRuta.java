package tema1;
import java.io.*;
public class verRuta {
	public static void main(String[] args) {
		File archivo=new File("./verRuta.java");
		try {
			String ruta=archivo.getCanonicalPath();
			System.out.println("La ruta canonica del archivo es: "+ruta);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}