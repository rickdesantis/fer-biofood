package it.aip.mcdonald.controller.biofood;

import java.util.List;

import it.aip.mcdonald.meta.FotoProduttoreMeta;
import it.aip.mcdonald.meta.ProduttoreMeta;
import it.aip.mcdonald.model.FotoProduttore;
import it.aip.mcdonald.model.Produttore;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class ProduttoreController extends Controller {

    @Override
    public Navigation run() throws Exception {
        ProduttoreMeta e = ProduttoreMeta.get();
        String nome = (String)request.getAttribute("n");
        if (nome.indexOf("+") > -1)
            nome = nome.replaceAll("+", " ");
        Produttore tmp = Datastore.query(e).filter(e.nome.equal(nome)).asSingle();
        
        FotoProduttoreMeta fp = FotoProduttoreMeta.get();
        List<FotoProduttore> tmp3 = Datastore.query(fp).asList();
        for (FotoProduttore foto : tmp3) {
            if (foto.getProduttoreRef().getModel().getNome().equals(nome)) {
                requestScope("foto", foto.getContenuto().replaceAll(" ", "%20"));
                break;
            }
        }
        
        requestScope("produttore", tmp);
        requestScope("map", retrieveMapUrl(tmp.getIndirizzo()));
        return forward("produttore.jsp");
    }
    private String retrieveMapUrl(String indirizzo) {
        indirizzo = indirizzo.replaceAll(" ", "+");
        return "https://maps.googleapis.com/maps/api/staticmap?zoom=14&size=300x300&maptype=roadmap&markers=color:red%7Ccolor:red%7C" + indirizzo + "&sensor=false";
    }
}
