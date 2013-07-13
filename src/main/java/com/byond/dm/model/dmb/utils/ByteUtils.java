package com.byond.dm.model.dmb.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class ByteUtils {
	public static short readStringShort(InputStream stream) throws IOException {
		byte[] verBytes = {0, 0, 0};
		stream.read(verBytes);
		return Short.parseShort(new String(verBytes));
	}
	
	public static int readUnsignedShort(InputStream stream) throws IOException {
		byte[] verBytes = {0, 0};
		stream.read(verBytes);
		ByteBuffer buffer = ByteBuffer.wrap(verBytes);
		short i = buffer.getShort();
		return i >= 0 ? i : 0x10000 + i;
	}
	
	public static long readUnsignedInt(InputStream stream) throws IOException {
		byte[] verBytes = {0, 0, 0, 0};
		stream.read(verBytes);
		ByteBuffer buffer = ByteBuffer.wrap(verBytes);
		int i = buffer.getInt();
		return i >= 0 ? i : 0x10000000 + i;
	}
}
