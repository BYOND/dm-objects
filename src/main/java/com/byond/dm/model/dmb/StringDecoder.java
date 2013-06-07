package com.byond.dm.model.dmb;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;


final class StringDecoder {
	public String decode(final TrackedInputStream stream) throws IOException {
		long salt = stream.getNumberOfReadBytes();
		int length = (int) (readUnsignedShort(stream) ^ salt);
		byte[] data = new byte[length];
		salt = stream.getNumberOfReadBytes();
		stream.read(data);
		for (int i = 0; i < data.length; i++) {
			data[i] = (byte) (data[i] ^ (salt + (i * 9)));
		}
		return new String(data, Charset.forName("US-ASCII"));
	}
	
	private int readUnsignedShort(InputStream stream) throws IOException {
		byte[] verBytes = {0, 0};
		stream.read(verBytes);
		ByteBuffer buffer = ByteBuffer.wrap(verBytes);
		short i = buffer.getShort();
		return i >= 0 ? i : 0x10000 + i;
	}
}
