package it.aip.mcdonald.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TipoProduttoreTest extends AppEngineTestCase {

    private TipoProduttore model = new TipoProduttore();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
