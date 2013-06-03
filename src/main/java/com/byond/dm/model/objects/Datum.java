package com.byond.dm.model.objects;

/**
 * The base-class for all "user-code" classes in BYOND, the datum.
 * This class implements a few basic things that all objects in DM
 * will need.
 * 
 * @author Stephen001 [stephen.badger@gmail.com]
 * @since 1.0.0
 */
public class Datum {
	private String tag;
	private String type;

	/**
	 * Construct a datum of a given type.
	 * 
	 * @param type The textual type path for this datum.
	 */
	public Datum(String type) {
		this.type = type;
	}

	public String getParentType() {
		int index = type.lastIndexOf('/');
		if (index < 1) {
			return null;
		} else {
			return type.substring(0, index);
		}
	}
	
	public String getTag() {
		return tag;
	}
	
	public String getType() {
		return type;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getType();
	}
}
