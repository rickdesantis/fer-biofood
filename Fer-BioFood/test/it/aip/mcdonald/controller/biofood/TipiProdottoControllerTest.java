package it.aip.mcdonald.controller.biofood;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TipiProdottoControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/biofood/tipiProdotto");
        TipiProdottoController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/biofood/tipiProdotto.jsp"));
    }
}
