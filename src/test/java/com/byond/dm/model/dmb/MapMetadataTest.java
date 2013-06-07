package com.byond.dm.model.dmb;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class MapMetadataTest extends DMBTest {
	@Test
	public void testBasicMetadata() throws IOException {
		if (stream.skip(45) < 45) {
			throw new IOException("Could not skip to position, DMB is corrupt.");
		}
		MapMetadata metadata = new MapMetadata();
		metadata.read(stream);
		assertEquals(0, metadata.getMaxX());
		assertEquals(0, metadata.getMaxY());
		assertEquals(0, metadata.getMaxZ());
	}
}
