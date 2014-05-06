package br.com.caelum.argentum.ui;

import br.com.caelum.argentum.indicadores.Indicador;
import br.com.caelum.argentum.indicadores.IndicadorFechamento;
import br.com.caelum.argentum.indicadores.MediaMovelSimples;
import br.com.caelum.argentum.modelo.*;
import br.com.caelum.argentum.ui.graficos.*;
import br.com.caelum.argentum.ws.MockClienteWebService;
import org.primefaces.model.chart.CartesianChartModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.lang.reflect.Constructor;
import java.util.List;

/**
 * Created by buzaga on 5/3/14.
 */
@ManagedBean
@ViewScoped
public class ArgentumBean {

    private CartesianChartModel modeloGrafico;
    private List<Negociacao> negociacoes;
    private String nomeMedia;
    private String nomeIndicadorBase;

    public ArgentumBean() {
        this.negociacoes = new MockClienteWebService().getNegociacoes();
        geraGrafico();
    }

    public void geraGrafico(){
        System.out.println("PLOTANDO: " + nomeMedia + " de " + nomeIndicadorBase);
        List<Candle> candles = new CandleFactory().constroiCandles(negociacoes);
        SerieTemporal serie = new SerieTemporal(candles);

        GeradorModeloGrafico geradorGrafico = new GeradorModeloGrafico(serie, 2, serie.getUltimaPosicao());
        geradorGrafico.plotaIndicador(defineIndicador());
        this.modeloGrafico = geradorGrafico.getModeloGrafico();
    }

    private Indicador defineIndicador() {
        final String pacote = "br.com.caelum.argentum.indicadores.";
        if (nomeIndicadorBase == null || nomeMedia == null) {
            return new MediaMovelSimples(new IndicadorFechamento());
        }
        try {
            Class<?> classeIndicadorBase = Class.forName(pacote + nomeIndicadorBase);
            Indicador indicadorBase = (Indicador) classeIndicadorBase.newInstance();

            Class<?> classMedia = Class.forName(pacote + nomeMedia);
            Constructor<?> construtorMedia = classMedia.getConstructor(Indicador.class);
            Indicador indicador = (Indicador) construtorMedia.newInstance(indicadorBase);
            return indicador;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<Negociacao> getNegociacoes(){
        return negociacoes;
    }

    public CartesianChartModel getModeloGrafico() {
        return modeloGrafico;
    }

    public String getNomeMedia() {
        return nomeMedia;
    }

    public void setNomeMedia(String nomeMedia) {
        this.nomeMedia = nomeMedia;
    }

    public String getNomeIndicadorBase() {
        return nomeIndicadorBase;
    }

    public void setNomeIndicadorBase(String nomeIndicadorBase) {
        this.nomeIndicadorBase = nomeIndicadorBase;
    }
}
