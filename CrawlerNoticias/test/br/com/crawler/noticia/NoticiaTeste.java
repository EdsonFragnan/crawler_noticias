package br.com.crawler.noticia;

import static org.junit.Assert.*;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class NoticiaTeste {
	
	@Test
	public void gerarXML() {
		
		String xmlEsperado = 
				"<item>\n" +
				"  <title>Título notícia</title>\n" +
				"  <description>Descrição notícia</description>\n" +
				"  <link>link.html</link>\n" +
				"</item>";
				
		Noticia noticias = new Noticia("Título notícia", "Descrição notícia", "link.html");
		
		XStream xstream = new XStream();
		xstream.alias("item", Noticia.class);
		String xmlGerado = xstream.toXML(noticias);
		
		assertEquals(xmlEsperado, xmlGerado);
	}
}
