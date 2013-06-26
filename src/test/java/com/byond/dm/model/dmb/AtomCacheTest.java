package com.byond.dm.model.dmb;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class AtomCacheTest extends DMBTest {
	@Test
	public void initializeCache() throws IOException {
		if (stream.skip(55) < 55) {
			throw new IOException("Could not skip to position, DMB is corrupt.");
		}
		AtomCache cache = new AtomCache(stream);
		cache.read(stream);
		Assert.assertEquals(12, cache.getAtomPrototypes().size());
	}
}
