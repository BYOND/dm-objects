package com.byond.dm.model.types;

/**
 * A basic definition of a compound type within user-written code. Compound
 * types can be specialisations of other compound types, forming a type
 * hierarchy.
 * 
 * @author Stephen001 [stephen.badger@gmail.com]
 * @since 1.0.0
 */
public class CompoundType extends Type {
	private final CompoundType parent;
	
	/**
	 * Constructs a compound type, with the provided name and no parent type.
	 * 
	 * @param name The printable name for this type.
	 */
	public CompoundType(String name) {
		this(name, null);
	}
	
	/**
	 * Constructs a compound type, with the provided name and parent type.
	 * 
	 * @param name The printable name for this type.
	 * @param parent The parent type of this type.
	 */
	public CompoundType(String name, CompoundType parent) {
		super(name);
		this.parent = parent;
	}

	/* (non-Javadoc)
	 * @see com.byond.dm.model.types.Type#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		CompoundType other = (CompoundType) obj;
		if (this.parent == null) {
			if (other.parent != null) {
				return false;
			}
		} else if (!this.parent.equals(other.parent)) {
			return false;
		}
		return true;
	}

	/**
	 * Gets the parent type of this type. This type is considered a specialisation of
	 * the type returned.
	 * 
	 * @return The parent type, or null if this type has no parent.
	 */
	public CompoundType getParentType() {
		return this.parent;
	}

	/* (non-Javadoc)
	 * @see com.byond.dm.model.types.Type#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.byond.dm.model.types.Type#toString()
	 */
	@Override
	public String toString() {
		if (this.parent == null) {
			return "/" + this.getName();
		} else {
			return this.parent.toString() + "/" + this.getName();
		}
	}
}
