package com.example.JiamiApp.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by VennUser on 2015/8/11.
 */
public class XorInputStream extends FilterInputStream {

	private int xorKey;

	protected XorInputStream(InputStream in, int xorKey) {
		super(in);
		this.xorKey = xorKey;
	}

	public int read() throws IOException {

		int length = in.read() ^ xorKey;
		return length;
	}

	public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {

		int length = in.read(buffer, byteOffset, byteCount);
		for (int i = 0; i < length; i++) {
			buffer[i + byteOffset] ^= xorKey;
		}

		return length;
	}
}
