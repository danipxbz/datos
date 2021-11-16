package XML;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class ejemplo1 {
	public static void main(String[] args) throws ParserConfigurationException, IOException, TransformerFactoryConfigurationError, TransformerException {
		File file=new File("AleatorioEmple.dat");
		RandomAccessFile rFile=new RandomAccessFile(file, "r");
		
		int id, dep, position=0;
		Double salario;
		char apellido[]=new char[10], aux;
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		DOMImplementation implementation=builder.getDOMImplementation();
		Document document= implementation.createDocument(null, "Empleados", null);
		document.setXmlVersion("1.0");
		
		for (;;) {
			rFile.seek(position);
			id=rFile.readInt();
			for (int i = 0; i < apellido.length; i++) {
				aux=rFile.readChar();
				apellido[i]=aux;
			}
			String apellidos=new String(apellido);
			dep=rFile.readInt();
			salario=rFile.readDouble();
			
			if(id>0) {
				Element raiz=document.createElement("empleado");
				document.getDocumentElement().appendChild(raiz);
				crearElemento("id", Integer.toString(id), raiz, document);
				crearElemento("apellido", apellidos.trim(), raiz, document);
				crearElemento("dep", Integer.toString(dep), raiz, document);
				crearElemento("salario", Double.toString(salario), raiz, document);
			}
			position=position+36;
			if (rFile.getFilePointer()==rFile.length()) break;
			
		}
		Source source=new DOMSource(document);
		Result result=new StreamResult(new java.io.File("Empleados.xml"));
		Transformer transformer=TransformerFactory.newInstance().newTransformer();
		transformer.transform(source, result);
		rFile.close();
		
	}

	private static void crearElemento(String datoemple, String valor, Element raiz, Document document) {
		Element elem=document.createElement(datoemple);
		Text text = document.createTextNode(valor);
		raiz.appendChild(elem);
		elem.appendChild(text);
		
	}
}
