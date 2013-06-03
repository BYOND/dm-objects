package com.byond.dm.model.objects;

import org.junit.Assert;
import org.junit.Test;

public class DatumTest {
	@Test
	public void testParentType() {
		Datum datum = new Datum("/hello/world");
		Assert.assertEquals("/hello", datum.getParentType());
	}
	
	@Test
	public void testNoParentType() {
		Datum datum = new Datum("/world");
		Assert.assertNull(datum.getParentType());
	}
	
	@Test
	public void testNoParentTypeNative() {
		Datum datum = new Datum("text");
		Assert.assertNull(datum.getParentType());
	}
}
