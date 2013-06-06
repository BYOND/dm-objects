package com.byond.dm.model.dmb;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DMBMetadataTest {
	private InputStream stream;

	@Before
	public void before() throws FileNotFoundException, URISyntaxException {
		stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("TestEnvironment/TestEnvironment.dmb");
	}
	
	@After
	public void after() throws IOException {
		stream.close();
	}
	
	@Test
	public void testBasicMetadata() throws IOException {
		DMBMetadata metadata = new DMBMetadata();
		metadata.read(stream);
		assertEquals(499, metadata.getCompiledVersion());
		assertEquals(490, metadata.getMinimumVersion());
	}
}
