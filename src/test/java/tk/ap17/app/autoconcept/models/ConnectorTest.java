package tk.ap17.app.autoconcept.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tk.ap17.app.autoconcept.models.Connector;

public class ConnectorTest {
    private Connector connector;

    @Before
    public void setUp() throws Exception {
        connector = new Connector();
    }

    @Test
    public void testGetUri() {
        assertNull(connector.getUri());
        connector.setUri("toto");
        assertEquals("toto", connector.getUri());
    }

}
