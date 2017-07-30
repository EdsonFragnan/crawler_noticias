package br.com.crawler.noticia;

import java.util.ArrayList;
import java.util.List;

public class Jornal {
	private List<Noticia> noticias = new ArrayList<>();

	public Jornal(List<Noticia> noticias) {
		this.noticias = noticias;
	}
	
}