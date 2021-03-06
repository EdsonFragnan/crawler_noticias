package br.com.noticia.main;

import java.io.IOException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import br.com.noticia.reader.LendoXML;

public class NoticiaMain {

	/**
	 * @param args
	 * @return 
	 * @throws Exception
	 */
	
	public static String stringParaObject() throws IOException, DocumentException {
		try {
			LendoXML xml = new LendoXML();
			JSONObject noticiasJson = XML.toJSONObject(xml.getNoticias());
			JSONObject rss = noticiasJson.getJSONObject("rss");
			JSONObject channel = rss.getJSONObject("channel");
			JSONArray item = channel.getJSONArray("item");
			JSONArray feed = new JSONArray();
			JSONObject json = new JSONObject();
			for (int i=0; i < item.length(); i++) {
				JSONObject noticias = item.getJSONObject(i);
				feed.put(noticias);
				//Elementos title, img, src 
			}
			json.put("feed", feed);
			System.out.println(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Document parse(URL url) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(url);
		return document;
	}

}
