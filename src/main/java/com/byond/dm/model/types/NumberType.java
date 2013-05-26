package com.byond.dm.model.types;

/**
 * A basic definition of the built-in numeric type.
 * 
 * @author Stephen001 [stephen.badger@gmail.com]
 * @since 1.0.0
 */
public final class NumberType extends Type {

	/**
	 * Constructs a new number type.
	 */
	public NumberType() {
		super("num");
	}

	/* (non-Javadoc)
	 * @see com.byond.dm.model.types.Type#isPrimitive()
	 */
	@Override
	public boolean isPrimitive() {
		return true;
	}
}
