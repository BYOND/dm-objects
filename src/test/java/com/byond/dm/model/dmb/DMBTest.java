package com.byond.dm.model.dmb;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.Before;

public abstract class DMBTest {
	protected TrackedInputStream stream;

	@Before
	public void before() throws FileNotFoundException, URISyntaxException {
		stream = new TrackedInputStream(Thread.currentThread().getContextClassLoader().getResourceAsStream("TestEnvironment/TestEnvironment.dmb"));
	}
	
	@After
	public void after() throws IOException {
		stream.close();
	}
}
