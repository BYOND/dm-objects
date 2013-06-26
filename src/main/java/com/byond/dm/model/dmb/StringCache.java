package com.byond.dm.model.dmb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.byond.dm.model.dmb.utils.ByteUtils;

public class StringCache implements DMBReadable {
	private final int expectedSize;
	private final List<String> strings;
	
	public StringCache(TrackedInputStream stream) throws IOException {
		expectedSize = (int) ByteUtils.readUnsignedInt(stream);
		strings = new ArrayList<String>((int) expectedSize);
	}
	
	public List<String> getStrings() {
		return strings;
	}

	@Override
	public void read(TrackedInputStream stream) throws IOException {
		StringDecoder decoder = new StringDecoder();
		for (long i = 0; i < expectedSize; i++) {
			strings.add(decoder.decode(stream));
		}
	}
}
