package com.byond.dm.model.dmb;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class StringCache implements DMBReadable {
	private List<String> strings = new ArrayList<>();
	
	public List<String> getStrings() {
		return strings;
	}

	public void setStrings(List<String> strings) {
		this.strings = strings;
	}

	@Override
	public void read(TrackedInputStream stream) throws IOException {
		long size = readUnsignedInt(stream);
		strings = new ArrayList<String>((int) size);
		StringDecoder decoder = new StringDecoder();
		for (long i = 0; i < size; i++) {
			strings.add(decoder.decode(stream));
		}
	}
	
	private long readUnsignedInt(InputStream stream) throws IOException {
		byte[] verBytes = {0, 0, 0, 0};
		stream.read(verBytes);
		ByteBuffer buffer = ByteBuffer.wrap(verBytes);
		int i = buffer.getInt();
		return i >= 0 ? i : 0x10000000 + i;
	}
}
