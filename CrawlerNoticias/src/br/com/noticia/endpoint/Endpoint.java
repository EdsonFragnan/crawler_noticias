package br.com.noticia.endpoint;
import br.com.noticia.ws.NoticiaImpl;

public class Endpoint {
	
	public static void main(String[] args){
	       Endpoint.publish(
	       "http://localhost:8080/ws/noticia", new NoticiaImpl());
	       System.out.println(
	       "\nWeb service publicado @ http://localhost:8080/ws/noticia");
	       System.out.println("Rodando!");
	   }

}
