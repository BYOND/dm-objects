package com.byond.dm.model.dmb;

import java.io.IOException;
import java.io.InputStream;

/**
 * An interface for objects which can be initialised off a DMB I/O stream.
 * 
 * @author Stephen001 [stephen.badger@gmail.com]
 */
public interface DMBReadable {
	/**
	 * Attempts to read the implementor of this interface from the stream, initialising it's values.
	 * 
	 * @param stream The DMB stream to read from.
	 * @throws IOException If the object could not be initialised from the stream.
	 */
	void read(final InputStream stream) throws IOException;
}
