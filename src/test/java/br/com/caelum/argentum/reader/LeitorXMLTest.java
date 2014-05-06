package br.com.caelum.argentum.reader;

import br.com.caelum.argentum.modelo.Negociacao;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by buzaga on 5/1/14.
 */
public class LeitorXMLTest {
    @Test
    public void testCarregaXmlComUmaNegociacaoEmListaUnitaria() throws Exception {
        String xmlDeTeste = "<list>"
            .concat("<negociacao>")
            .concat("<preco>43.5</preco>")
            .concat("<quantidade>1000</quantidade>")
            .concat("<data><time>1322233344455</time></data>")
            .concat("</negociacao>")
            .concat("</list>");

            LeitorXML leitorXML = new LeitorXML();

        InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
        List<Negociacao> negociacoes = leitorXML.carrega(xml);

        assertEquals(1, negociacoes.size());
        assertEquals(43.5, negociacoes.get(0).getPreco(), 0.0001);
        assertEquals(1000, negociacoes.get(0).getQuantidade(), 0.0001);

    }
}
