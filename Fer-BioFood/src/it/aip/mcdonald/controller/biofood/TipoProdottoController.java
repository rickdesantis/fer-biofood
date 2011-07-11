package it.aip.mcdonald.controller.biofood;

import it.aip.mcdonald.meta.ProdottoMeta;
import it.aip.mcdonald.model.Prodotto;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class TipoProdottoController extends Controller {

    @Override
    public Navigation run() throws Exception {
        ProdottoMeta e = ProdottoMeta.get();
        List<Prodotto> list = Datastore.query(e).asList();
        ArrayList<String> prodotti = new ArrayList<String>();
        
        for (Prodotto p : list) {
            String tmp = (String)request.getAttribute("n");
            if (tmp.indexOf("+") > -1)
                tmp = tmp.replaceAll("+", " ");
            if (p.getTipoProdottoRef().getModel().getNome().equals(tmp))
                prodotti.add(p.getNome());
        }
        
        requestScope("prodotti", prodotti);
        
        return forward("tipoProdotto.jsp");
    }
}
