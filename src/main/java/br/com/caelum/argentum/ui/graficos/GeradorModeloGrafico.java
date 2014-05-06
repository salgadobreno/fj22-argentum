package br.com.caelum.argentum.ui.graficos;

import br.com.caelum.argentum.indicadores.Indicador;
import br.com.caelum.argentum.modelo.SerieTemporal;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 * Created by buzaga on 5/5/14.
 */
public class GeradorModeloGrafico {

    private SerieTemporal serie;
    private int comeco;
    private int fim;
    private CartesianChartModel modeloGrafico;

    public GeradorModeloGrafico(SerieTemporal serie, int comeco, int fim) {
        this.serie = serie;
        this.comeco = comeco;
        this.fim = fim;
        this.modeloGrafico = new CartesianChartModel();
    }

    public void plotaIndicador(Indicador indicador){
        LineChartSeries chartSeries = new LineChartSeries(indicador.toString());

        for (int i = comeco; i <= fim; i++) {
            double valor = indicador.calcula(i, serie);
            chartSeries.set(i, valor);
        }
        this.modeloGrafico.addSeries(chartSeries);
    }

    public CartesianChartModel getModeloGrafico() {
        return modeloGrafico;
    }
}
