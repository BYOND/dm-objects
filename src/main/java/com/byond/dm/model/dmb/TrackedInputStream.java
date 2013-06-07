package com.byond.dm.model.dmb;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;

public class TrackedInputStream extends InputStream {
	private final InputStream stream;
	private final AtomicLong readBytes = new AtomicLong(0);
	
	public TrackedInputStream(InputStream stream) {
		this.stream = stream;
	}
	
	@Override
	public int read() throws IOException {
		readBytes.incrementAndGet();
		return stream.read();
	}
	
	public long getNumberOfReadBytes() {
		return readBytes.get();
	}
}
