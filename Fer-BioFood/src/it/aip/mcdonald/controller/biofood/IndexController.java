package it.aip.mcdonald.controller.biofood;

import it.aip.mcdonald.service.InitWorld;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {
//        InitWorld init = new InitWorld();
//        init.init();
        
        return forward(basePath);
    }
}
