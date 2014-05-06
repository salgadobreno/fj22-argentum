package br.com.caelum.argentum.ws;

import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.reader.LeitorXML;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by buzaga on 5/1/14.
 */
public class ClienteWebService {
    private static final String URL_WEBSERVICE = "";

    public List<Negociacao> getNegociacoes() {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(URL_WEBSERVICE);
            HttpResponse response = client.execute(request);
            InputStream content = response.getEntity().getContent();
            return new LeitorXML().carrega(content);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
