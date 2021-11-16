package tema1;
import java.io.*;
public class sumaLineas {
	public static void main(String[] args) throws IOException {
		
		BufferedReader archivo = new BufferedReader(new FileReader("./suma.txt"));
		int suma=0;
		int resul=0;
		String linea;
		while ((linea=archivo.readLine())!=null) {
			suma=Integer.parseInt(linea);
			resul=resul+suma;
		}
		System.out.print(resul);
	}
}