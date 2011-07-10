package it.aip.mcdonald.controller.biofood;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import it.aip.mcdonald.meta.OffertaMeta;
import it.aip.mcdonald.model.Offerta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OfferteController extends Controller {

    @Override
    public Navigation run() throws Exception {
        OffertaMeta e = OffertaMeta.get();
        List<Offerta> list = Datastore.query(e).asList();
        ArrayList<String> prodotti = new ArrayList<String>();
        ArrayList<Date> scadenze = new ArrayList<Date>();
        
        for ( Offerta u: list) {
            prodotti.add(u.getProdottoRef().getModel().getNome());
            scadenze.add(u.getFineOfferta());
        }
        
        requestScope("prodotti", prodotti);
        requestScope("scadenze", scadenze);
        return forward("offerte.jsp");
    }
}
