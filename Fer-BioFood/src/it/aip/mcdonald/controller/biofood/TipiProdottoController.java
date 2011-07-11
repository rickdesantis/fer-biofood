package it.aip.mcdonald.controller.biofood;

import java.util.List;

import it.aip.mcdonald.meta.ProdottoMeta;
import it.aip.mcdonald.meta.TipoProdottoMeta;
import it.aip.mcdonald.model.Prodotto;
import it.aip.mcdonald.model.TipoProdotto;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class TipiProdottoController extends Controller {

    @Override
    public Navigation run() throws Exception {
        TipoProdottoMeta e = TipoProdottoMeta.get();
        List<TipoProdotto> list = Datastore.query(e).asList();
        ProdottoMeta pm = ProdottoMeta.get();
        List<Prodotto> lp = Datastore.query(pm).asList();
        for (TipoProdotto u : list) {
            int nprod = 0;
            for (int i = 0; i < lp.size(); ++i) {
                if (lp.get(i).getTipoProdottoRef().getModel().getNome() == u.getNome()) {
                    ++nprod;
                    lp.remove(i--);
                }
            }
            requestScope(u.getNome() + "_count", nprod);
        }
        
        return forward("tipiProdotto.jsp");
    }
}
