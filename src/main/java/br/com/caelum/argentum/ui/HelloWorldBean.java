package br.com.caelum.argentum.ui;

import javax.faces.bean.ManagedBean;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by buzaga on 5/2/14.
 */
@ManagedBean
public class HelloWorldBean {

    private String name;

    public String getHorario(){
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        return "Atualizado em " + sdf.format(new Date());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
