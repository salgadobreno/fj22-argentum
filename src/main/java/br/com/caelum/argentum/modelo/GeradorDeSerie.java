package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by buzaga on 5/4/14.
 */
public class GeradorDeSerie {
    public static SerieTemporal criaSerie(double ... valores) {
        List<Candle> candles = new ArrayList<>();
        for (double d : valores) {
            candles.add(new Candle(d, d, d, d, 1000, Calendar.getInstance()));
        }
        return new SerieTemporal(candles);
    }
}
