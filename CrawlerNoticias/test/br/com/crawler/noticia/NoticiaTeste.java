package br.com.crawler.noticia;

import static org.junit.Assert.assertEquals;

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
				"  <creator>Da reda��o de Auto Esporte</creator>\n" +
				"  <guid>1551131</guid>\n" +
				"</item>";
				
		Noticia noticias = new Noticia("T�tulo not�cia", "Descri��o not�cia", "link.html", "Da reda��o de Auto Esporte", "1551131");
		
		XStream xstream = new XStream();
		xstream.alias("item", Noticia.class);
		String xmlGerado = xstream.toXML(noticias);
		assertEquals(xmlEsperado, xmlGerado);
	}
}
