package it.aip.mcdonald.controller.biofood;

import it.aip.mcdonald.service.ManageWorld;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class ResetDatastoreController extends Controller {
    private ManageWorld world = new ManageWorld();
    
    @Override
    public Navigation run() throws Exception {
        world.wipeAll();
        world.initAllFromXml();
        
        return forward("resetDatastore.jsp");
    }
}
