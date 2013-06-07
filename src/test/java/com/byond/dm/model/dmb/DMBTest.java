package com.byond.dm.model.dmb;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.Before;

public abstract class DMBTest {
	protected InputStream stream;

	@Before
	public void before() throws FileNotFoundException, URISyntaxException {
		stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("TestEnvironment/TestEnvironment.dmb");
	}
	
	@After
	public void after() throws IOException {
		stream.close();
	}
}
