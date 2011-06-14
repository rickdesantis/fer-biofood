package it.aip.mcdonald.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class OffertaTest extends AppEngineTestCase {

    private Offerta model = new Offerta();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
