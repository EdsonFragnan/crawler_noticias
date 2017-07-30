package br.com.crawler.noticia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class JornalTeste {
	
	@Test
	public void gerarXML() {
		
		String xmlEsperado = 
				"<channel>"+
						"<item>\n" +
						"  <title>Título notícia 1</title>\n" +
						"  <description>Descrição notícia 1</description>\n" +
						"  <link>link.html</link>\n" +
						"</item>"+
						"<item>\n" +
						"  <title>Título notícia 2</title>\n" +
						"  <description>Descrição notícia 2</description>\n" +
						"  <link>link.html</link>\n" +
						"</item>"+
				"</channel>";
				
	
		Noticia noticia1 = new Noticia("Título notícia 1", "Descrição notícia 1", "link.html");
		Noticia noticia2 = new Noticia("Título notícia 2", "Descrição notícia 2", "link.html");
		
		List<Noticia> noticias = new ArrayList<>();
		noticias.add(noticia1);
		noticias.add(noticia2);		
		
		XStream xstream = new XStream();
		xstream.alias("channel", Noticia.class);
		String xmlGerado = xstream.toXML(noticias);
		assertEquals(xmlEsperado, xmlGerado);
	}
}