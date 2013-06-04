package com.byond.dm.model.dmb;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class DMBMetadata implements DMBReadable {
	private short compiledVersion;
	private int flags;
	private short minimumVersion;
	
	public short getCompiledVersion() {
		return compiledVersion;
	}
	
	public int getFlags() {
		return flags;
	}
	
	public short getMinimumVersion() {
		return minimumVersion;
	}
	
	public void setCompiledVersion(short compiledVersion) {
		this.compiledVersion = compiledVersion;
	}
	
	public void setFlags(int flags) {
		this.flags = flags;
	}
	
	public void setMinimumVersion(short minimumVersion) {
		this.minimumVersion = minimumVersion;
	}

	@Override
	public void read(InputStream stream) throws IOException {
		stream.skip(11);
		byte[] verBytes = {0, 0, 0};
		stream.read(verBytes);
		compiledVersion = Short.parseShort(new String(verBytes));
		stream.skip(20);
		verBytes = new byte[3];
		stream.read(verBytes);
		minimumVersion = Short.parseShort(new String(verBytes));
		stream.skip(5);
		verBytes = new byte[4];
		stream.read(verBytes);
		ByteBuffer buffer = ByteBuffer.wrap(verBytes);
		flags = buffer.getInt();
	}
}
