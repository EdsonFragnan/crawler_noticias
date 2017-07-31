package br.com.noticia.ws;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.dom4j.DocumentException;

import br.com.noticia.main.NoticiaMain;

@WebService(endpointInterface = "br.com.noticia.ws.Noticia")
public class NoticiaImpl implements Noticia{
	NoticiaMain noticiaMain = new NoticiaMain();
	@Resource
    WebServiceContext wsctx;
 
    @Override
    public String getNoticia() {
 
        MessageContext mctx = wsctx.getMessageContext();
 
        // Use the request headers to get the details
        Map http_headers =
            (Map) mctx.get(
            MessageContext.HTTP_REQUEST_HEADERS);
        List<String> userList = (List) http_headers.get("Username");
        List<String> passList = (List) http_headers.get("Password");
 
        String username = "";
        String password = "";
 
        if (userList != null) {
            username = userList.get(0);
        }
 
        if (passList != null) {
            password = passList.get(0);
 
        }
 
        if (username.equals("DevUser")
            &&
            password.equals("password")) {
            try {
				return NoticiaMain.stringParaObject();
			} catch (IOException | DocumentException e) {
				e.printStackTrace();
			}
        } else {
            return " Usuario inválido!";
        }
		return null;
    }
 
}
