package br.com.crawler.noticia;

import static org.junit.Assert.*;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class NoticiaTeste {
	
	@Test
	public void gerarXML() {
		
		String xmlEsperado = 
				"<item>\n" +
				"  <title>T�tulo not�cia</title>\n" +
				"  <description>Descri��o not�cia</description>\n" +
				"  <link>link.html</link>\n" +
				"</item>";
				
		Noticia noticias = new Noticia("T�tulo not�cia", "Descri��o not�cia", "link.html");
		
		XStream xstream = new XStream();
		xstream.alias("item", Noticia.class);
		String xmlGerado = xstream.toXML(noticias);
		
		assertEquals(xmlEsperado, xmlGerado);
	}
}
