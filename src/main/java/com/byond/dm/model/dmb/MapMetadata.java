package com.byond.dm.model.dmb;

import java.io.IOException;

import com.byond.dm.model.dmb.utils.ByteUtils;

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
	public void read(TrackedInputStream stream) throws IOException {
		maxX = ByteUtils.readUnsignedShort(stream);
		maxY = ByteUtils.readUnsignedShort(stream);
		maxZ = ByteUtils.readUnsignedShort(stream);
	}
}
