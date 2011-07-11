package it.aip.mcdonald.controller.biofood;

import it.aip.mcdonald.meta.ProduttoreMeta;
import it.aip.mcdonald.model.Produttore;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

public class ProduttoreController extends Controller {

    @Override
    public Navigation run() throws Exception {
        ProduttoreMeta e = ProduttoreMeta.get();
        Produttore tmp = Datastore.query(e).filter(e.nome.equal((String)request.getAttribute("n"))).asSingle();
        
        requestScope("produttore", tmp);
        requestScope("map", retrieveMapUrl(tmp.getIndirizzo()));
        return forward("produttore.jsp");
    }
    private String retrieveMapUrl(String indirizzo) {
        indirizzo = indirizzo.replaceAll(" ", "+");
        return "https://maps.googleapis.com/maps/api/staticmap?zoom=14&size=300x300&maptype=roadmap&markers=color:red%7Ccolor:red%7C" + indirizzo + "&sensor=false";
    }
}
