package com.byond.dm.model.dmb;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class MapMetadata implements DMBReadable {
	private int maxX;
	private int maxY;
	private int maxZ;

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public int getMaxZ() {
		return maxZ;
	}

	public void setMaxZ(int maxZ) {
		this.maxZ = maxZ;
	}

	/* (non-Javadoc) 
	 * @see com.byond.dm.model.dmb.DMBReadable#read(java.io.InputStream)
	 */
	@Override
	public void read(InputStream stream) throws IOException {
		maxX = readUnsignedShort(stream);
		maxY = readUnsignedShort(stream);
		maxZ = readUnsignedShort(stream);
	}

	private int readUnsignedShort(InputStream stream) throws IOException {
		byte[] verBytes = {0, 0};
		stream.read(verBytes);
		ByteBuffer buffer = ByteBuffer.wrap(verBytes);
		short i = buffer.getShort();
		return i >= 0 ? i : 0x10000 + i;
	}
}
