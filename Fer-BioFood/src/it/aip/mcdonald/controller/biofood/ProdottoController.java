package it.aip.mcdonald.controller.biofood;

import it.aip.mcdonald.meta.ProdottoMeta;
import it.aip.mcdonald.model.Prodotto;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class ProdottoController extends Controller {

    @Override
    public Navigation run() throws Exception {
        ProdottoMeta e = ProdottoMeta.get();
        Prodotto tmp = Datastore.query(e).filter(e.nome.equal((String)request.getAttribute("n"))).asSingle();
        
        requestScope("prodotto", tmp);
        return forward("prodotto.jsp");
    }
}
