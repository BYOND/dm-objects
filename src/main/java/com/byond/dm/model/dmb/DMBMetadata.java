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

	/* (non-Javadoc)
	 * @see com.byond.dm.model.dmb.DMBReadable#read(java.io.InputStream)
	 */
	@Override
	public void read(InputStream stream) throws IOException {
		if (stream.skip(11) < 11) {
			throw new IOException("Could not skip to position, DMB is corrupt.");
		}
		compiledVersion = readStringShort(stream);
		if (stream.skip(20) < 20) {
			throw new IOException("Could not skip to position, DMB is corrupt.");
		}
		minimumVersion = readStringShort(stream);
		if (stream.skip(5) < 5) {
			throw new IOException("Could not skip to position, DMB is corrupt.");
		}
		byte[] verBytes = {0, 0, 0, 0};
		stream.read(verBytes);
		ByteBuffer buffer = ByteBuffer.wrap(verBytes);
		flags = buffer.getInt();
	}

	private short readStringShort(InputStream stream) throws IOException {
		byte[] verBytes = {0, 0, 0};
		stream.read(verBytes);
		return Short.parseShort(new String(verBytes));
	}
}
