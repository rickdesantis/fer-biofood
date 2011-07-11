package it.aip.mcdonald.controller.biofood;

import java.util.ArrayList;
import java.util.List;

import it.aip.mcdonald.meta.BuonoPerEsigenzaMeta;
import it.aip.mcdonald.meta.FotoProdottoMeta;
import it.aip.mcdonald.meta.ProdottoMeta;
import it.aip.mcdonald.model.BuonoPerEsigenza;
import it.aip.mcdonald.model.FotoProdotto;
import it.aip.mcdonald.model.Prodotto;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class ProdottoController extends Controller {

    @Override
    public Navigation run() throws Exception {
        ProdottoMeta e = ProdottoMeta.get();
        String nome = (String)request.getAttribute("n");
        if (nome.indexOf("+") > -1)
            nome = nome.replaceAll("+", " ");
        
        Prodotto tmp = Datastore.query(e).filter(e.nome.equal(nome)).asSingle();
        
        BuonoPerEsigenzaMeta bpe = BuonoPerEsigenzaMeta.get();
        List<BuonoPerEsigenza> tmp2 = Datastore.query(bpe).asList();
        List<String> esigenze = new ArrayList<String>();
        for (BuonoPerEsigenza b : tmp2) {
            if (b.getProdottoRef().getModel().getNome().equals(nome))
                esigenze.add(b.getEsigenzaRef().getModel().getNome());
        }
        
        // requestScope("foto", "images/cc-carne.gif");
        FotoProdottoMeta fp = FotoProdottoMeta.get();
        List<FotoProdotto> tmp3 = Datastore.query(fp).asList();
        for (FotoProdotto foto : tmp3) {
            if (foto.getProdottoRef().getModel().getNome().equals(nome)) {
                requestScope("foto", foto.getContenuto().replaceAll(" ", "%20"));
                break;
            }
        }
        
        requestScope("esigenze", esigenze);
        requestScope("prodotto", tmp);
        requestScope("produttore", tmp.getProduttoreRef().getModel().getNome());
        requestScope("tipo", tmp.getTipoProdottoRef().getModel().getNome());
        return forward("prodotto.jsp");
    }
}
