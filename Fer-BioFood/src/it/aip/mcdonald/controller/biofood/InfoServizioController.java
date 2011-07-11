package it.aip.mcdonald.controller.biofood;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class InfoServizioController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("infoServizio.jsp");
    }
}
