package com.byond.dm.model.dmb;

import java.io.IOException;
import java.nio.ByteBuffer;

import com.byond.dm.model.dmb.utils.ByteUtils;

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
	public void read(TrackedInputStream stream) throws IOException {
		if (stream.skip(11) < 11) {
			throw new IOException("Could not skip to position, DMB is corrupt.");
		}
		compiledVersion = ByteUtils.readStringShort(stream);
		if (stream.skip(20) < 20) {
			throw new IOException("Could not skip to position, DMB is corrupt.");
		}
		minimumVersion = ByteUtils.readStringShort(stream);
		if (stream.skip(5) < 5) {
			throw new IOException("Could not skip to position, DMB is corrupt.");
		}
		byte[] verBytes = {0, 0, 0, 0};
		stream.read(verBytes);
		ByteBuffer buffer = ByteBuffer.wrap(verBytes);
		flags = buffer.getInt();
	}
}
