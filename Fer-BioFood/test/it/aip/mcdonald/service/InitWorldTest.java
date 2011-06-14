package it.aip.mcdonald.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class InitWorldTest extends AppEngineTestCase {

    private InitWorld service = new InitWorld();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
