package it.aip.mcdonald.controller.biofood;

import it.aip.mcdonald.service.AggiungiProduttoreService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

public class AccettaProduttoreController extends Controller {
    
    private AggiungiProduttoreService aps = new AggiungiProduttoreService();

    @Override
    public Navigation run() throws Exception {
        aps.doAggiungi(new RequestMap(request));
        return redirect("index.jsp");
    }
}
