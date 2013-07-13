package com.byond.dm.model.dmb;

import java.io.IOException;

import com.byond.dm.model.dmb.utils.ByteUtils;

public class AtomPrototype implements DMBReadable {
	private int typePathIndex;
	private int parentTypeReferenceIndex;
	private int typeNameIndex;
	private int descriptionIndex;
	private int iconIndex;
	private int iconStateIndex;
	private byte direction;

	@Override
	public void read(TrackedInputStream stream) throws IOException {
		typePathIndex = ByteUtils.readUnsignedShort(stream);
		parentTypeReferenceIndex = ByteUtils.readUnsignedShort(stream);
		typeNameIndex = ByteUtils.readUnsignedShort(stream);
		descriptionIndex = ByteUtils.readUnsignedShort(stream);
		iconIndex = ByteUtils.readUnsignedShort(stream);
		iconStateIndex = ByteUtils.readUnsignedShort(stream);
		direction = (byte) stream.read();
		// TODO: Implement reading this dynamic information.
		if (stream.skip(25) < 25) {
			throw new IOException("Could not skip stream, data may be corrupted.");
		}
	}

	public int getTypePathIndex() {
		return typePathIndex;
	}

	public int getParentTypeReferenceIndex() {
		return parentTypeReferenceIndex;
	}

	public int getTypeNameIndex() {
		return typeNameIndex;
	}

	public int getDescriptionIndex() {
		return descriptionIndex;
	}

	public int getIconIndex() {
		return iconIndex;
	}

	public int getIconStateIndex() {
		return iconStateIndex;
	}

	public byte getDirection() {
		return direction;
	}

	public void setTypePathIndex(int typePathIndex) {
		this.typePathIndex = typePathIndex;
	}

	public void setParentTypeReferenceIndex(int parentTypeReferenceIndex) {
		this.parentTypeReferenceIndex = parentTypeReferenceIndex;
	}

	public void setTypeNameIndex(int typeNameIndex) {
		this.typeNameIndex = typeNameIndex;
	}

	public void setDescriptionIndex(int descriptionIndex) {
		this.descriptionIndex = descriptionIndex;
	}

	public void setIconIndex(int iconIndex) {
		this.iconIndex = iconIndex;
	}

	public void setIconStateIndex(int iconStateIndex) {
		this.iconStateIndex = iconStateIndex;
	}

	public void setDirection(byte direction) {
		this.direction = direction;
	}
}
