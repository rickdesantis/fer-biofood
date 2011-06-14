package it.aip.mcdonald.controller.biofood;

import it.aip.mcdonald.service.InitWorld;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class ResetDatastoreController extends Controller {
    private InitWorld init = new InitWorld();
    
    @Override
    public Navigation run() throws Exception {
        init.initAll();
        
        return forward("resetDatastore.jsp");
    }
}
