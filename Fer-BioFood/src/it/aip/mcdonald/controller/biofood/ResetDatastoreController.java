package it.aip.mcdonald.controller.biofood;

import it.aip.mcdonald.service.ManageWorld;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class ResetDatastoreController extends Controller {
    private ManageWorld world = new ManageWorld();
    
    @Override
    public Navigation run() throws Exception {
        String s = (String)request.getAttribute("n");
        if (s != null) {
            if (s.equals("tuttoproduttore")) {
                world.wipeTipoProduttore();
                world.wipeProduttore();
                world.wipeFotoProduttore();
                world.initTipoProduttore();
                world.initProduttore();
                world.initFotoProduttori();
            }
            else if (s.equals("tipoproduttore")) {
                world.wipeTipoProduttore();
                world.initTipoProduttore();
            }
            else if (s.equals("produttore")) {
                world.wipeProduttore();
                world.initProduttore();
            }
            else if (s.equals("fotoproduttori")) {
                world.wipeFotoProduttore();
                world.initFotoProduttori();
            }
            else if (s.equals("tuttoprodotti")) {
                world.wipeTipoProdotto();
                world.wipeEsigenza();
                world.wipeProdotto();
                world.wipeFotoProdotto();
                world.wipeOfferta();
                world.initTipoProdotto();
                world.initEsigenza();
                world.initProdotto();
                world.initFotoProdotto();
                world.initOfferta();
            }
            else if (s.equals("tipoprodotto")) {
                world.wipeTipoProdotto();
                world.initTipoProdotto();
            }
            else if (s.equals("esigenze")) {
                world.wipeEsigenza();
                world.initEsigenza();
            }
            else if (s.equals("prodotto")) {
                world.wipeProdotto();
                world.initProdotto();
            }
            else if (s.equals("fotoprodotti")) {
                world.wipeFotoProdotto();
                world.initFotoProdotto();
            }
            else if (s.equals("offerte")) {
                world.wipeOfferta();
                world.initOfferta();
                
            }
            
            requestScope("done", s);
           
            // world.wipeAll();
            // world.initAllFromXml();
        }
        
        return forward("resetDatastore.jsp");
    }
}
