package br.com.caelum.argentum.ws;

import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.reader.LeitorXML;
import br.com.caelum.argentum.util.GeradorAleatorioDeXML;

import java.io.InputStream;
import java.util.List;

/**
 * Created by buzaga on 5/3/14.
 */
public class MockClienteWebService extends ClienteWebService {

    public List<Negociacao> getNegociacoes() {
        InputStream content = GeradorAleatorioDeXML.getXMLAleatorio();
        return new LeitorXML().carrega(content);
    }

}
