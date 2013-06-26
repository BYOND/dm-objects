package com.byond.dm.model.dmb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.byond.dm.model.dmb.utils.ByteUtils;

public class AtomCache implements DMBReadable {
	private final List<AtomPrototype> atomPrototypes;
	private final int expectedSize;
	
	public AtomCache(TrackedInputStream stream) throws IOException {
		expectedSize = ByteUtils.readUnsignedShort(stream);
		atomPrototypes = new ArrayList<AtomPrototype>(expectedSize);
	}
	
	public List<AtomPrototype> getAtomPrototypes() {
		return atomPrototypes;
	}
	
	@Override
	public void read(TrackedInputStream stream) throws IOException {
		for (int i = 0; i < expectedSize; i++) {
			AtomPrototype prototype = new AtomPrototype();
			prototype.read(stream);
			atomPrototypes.add(prototype);
		}
	}
}
