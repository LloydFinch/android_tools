package com.example.JiamiApp.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by VennUser on 2015/8/11.
 */

//形成一个封装流,每一个字节都要异或
public class XorOutputStream extends FilterOutputStream {

	//进行异或的异或码
	private int xorKey;

	//要求封装一个其他的输出流
	public XorOutputStream(OutputStream out, int xorKey) {
		super(out);
		this.xorKey = xorKey;
	}

	public void write(int oneByte) throws IOException {
		out.write(oneByte ^ xorKey);
	}

	public void write(byte[] buffer, int offset, int length) throws IOException {
		if (buffer != null) {
			if (offset > -1) {
				if (offset + length <= buffer.length) {
					for (int i = offset; i < length; i++) {
						out.write(buffer[i + 1] ^ xorKey);
					}
				}
			}
		}
	}
}
