package tema1;
import java.io.*;
public class escribirLineas {
	public static void main(String[] args) throws IOException {
		BufferedWriter escritura = new BufferedWriter(new FileWriter("./fichero1.txt"));
		for (int i = 0; i < 10; i++) {
			escritura.write("linea numero "+(i+1));
			escritura.flush();
			escritura.newLine();
		}
		escritura.close();
		
		FileInputStream archivo=new FileInputStream("./fichero1.txt");
		int i;
		while ((i=archivo.read())!=-1) {
			System.out.print((char)i);
		}
	}
}