package tk.ap17.app.autoconcept.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tk.ap17.app.autoconcept.models.Connecteur;

public class connecteurTest2 {
	private Connecteur connecteur;

	@Before
	public void setUp() throws Exception {
		connecteur = new Connecteur();
	}

	@Test
	public void testGetUri() {
		assertNull(connecteur.getUri());
		connecteur.setUri("toto");
		assertEquals("toto", connecteur.getUri());
	}

}
