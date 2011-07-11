package it.aip.mcdonald.controller.biofood;

import java.util.ArrayList;
import java.util.List;

import it.aip.mcdonald.meta.BuonoPerEsigenzaMeta;
import it.aip.mcdonald.meta.ProdottoMeta;
import it.aip.mcdonald.model.BuonoPerEsigenza;
import it.aip.mcdonald.model.Prodotto;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class ProdottoController extends Controller {

    @Override
    public Navigation run() throws Exception {
        ProdottoMeta e = ProdottoMeta.get();
        Prodotto tmp = Datastore.query(e).filter(e.nome.equal((String)request.getAttribute("n"))).asSingle();
        
        BuonoPerEsigenzaMeta bpe = BuonoPerEsigenzaMeta.get();
        List<BuonoPerEsigenza> tmp2 = Datastore.query(bpe).asList();
        List<String> esigenze = new ArrayList<String>();
        for (BuonoPerEsigenza b : tmp2) {
            if (b.getProdottoRef().getModel().getNome().equals((String)request.getAttribute("n")))
                esigenze.add(b.getEsigenzaRef().getModel().getNome());
        }
        
        requestScope("esigenze", esigenze);
        requestScope("prodotto", tmp);
        requestScope("produttore", tmp.getProduttoreRef().getModel().getNome());
        requestScope("tipo", tmp.getTipoProdottoRef().getModel().getNome());
        return forward("prodotto.jsp");
    }
}
