package it.aip.mcdonald.controller.biofood;

import it.aip.mcdonald.service.ManageWorld;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

public class AccettaProduttoreController extends Controller {
    private ManageWorld world = new ManageWorld();

    @Override
    public Navigation run() throws Exception {
        world.aggiungiProduttore(new RequestMap(request));
        return redirect("index");
    }
}
