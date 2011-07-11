package it.aip.mcdonald.controller.biofood;

import it.aip.mcdonald.meta.BuonoPerEsigenzaMeta;
import it.aip.mcdonald.model.BuonoPerEsigenza;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class EsigenzaController extends Controller {

    @Override
    public Navigation run() throws Exception {
        BuonoPerEsigenzaMeta e = BuonoPerEsigenzaMeta.get();
        List<BuonoPerEsigenza> list = Datastore.query(e).asList();
        ArrayList<String> prodotti = new ArrayList<String>();
        
        for (BuonoPerEsigenza p : list) {
            String tmp = (String)request.getAttribute("n");
            if (tmp.indexOf("+") > -1)
                tmp = tmp.replaceAll("+", " ");
            if (p.getEsigenzaRef().getModel().getNome().equals(tmp))
                prodotti.add(p.getProdottoRef().getModel().getNome());
        }
        
        requestScope("prodotti", prodotti);
        return forward("esigenza.jsp");
    }
}
