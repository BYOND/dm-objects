package com.byond.dm.model.types;

/**
 * A basic definition of a type within user-written code.
 * 
 * @author Stephen001 [stephen.badger@gmail.com]
 * @since 1.0.0
 */
public abstract class Type {
	/**
	 * A printable name for the type.
	 */
	private final String name;
	
	/**
	 * Constructs a type.
	 * 
	 * @param name The printable name for the type.
	 * @throws IllegalArgumentException If the name provided is null.
	 */
	public Type(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Cannot construct a type with a null name.");
		}
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Type other = (Type) obj;
		if (!this.name.equals(other.name)) {
			return false;
		}
		return true;
	}
	
	/**
	 * Gets the printable name for this type.
	 * 
	 * @return The printable name for this type.
	 */
	public String getName() {
		return this.name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return 31 + this.name.hashCode();
	}

	/**
	 * Denotes whether or not the type is one of the primitive types.
	 * Primitive types denote numbers and text strings.
	 * 
	 * @return True of the type is a primitive type, false otherwise.
	 */
	public boolean isPrimitive() {
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.name;
	}
}
