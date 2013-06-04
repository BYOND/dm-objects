package com.byond.dm.model.dmb;

import java.io.IOException;
import java.io.InputStream;

public interface DMBReadable {
	public void read(final InputStream stream) throws IOException;
}
