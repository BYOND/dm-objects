package com.byond.dm.model.types;

/**
 * A basic definition of the built-in text type.
 * 
 * @author Stephen001 [stephen.badger@gmail.com]
 * @since 1.0.0
 */
public final class TextType extends Type {

	/**
	 * Constructs a new text type.
	 */
	public TextType() {
		super("text");
	}

	/* (non-Javadoc)
	 * @see com.byond.dm.model.types.Type#isPrimitive()
	 */
	@Override
	public boolean isPrimitive() {
		return true;
	}
}
