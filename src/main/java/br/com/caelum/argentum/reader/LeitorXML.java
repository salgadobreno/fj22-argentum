package br.com.caelum.argentum.reader;

import br.com.caelum.argentum.modelo.Negociacao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.InputStream;
import java.util.List;

/**
 * Created by buzaga on 5/1/14.
 */
public class LeitorXML {
    public List<Negociacao> carrega(InputStream inputStream) {
        XStream stream = new XStream(new DomDriver());
        stream.alias("negociacao", Negociacao.class);
        return (List<Negociacao>) stream.fromXML(inputStream);
    }

}
