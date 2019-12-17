package examples;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class UsingBuffersDirect {
	private static void symmertryScrable(CharBuffer buffer){
		buffer.mark();
		char c1 = buffer.get();
		char c2 = buffer.get();
		buffer.reset();
		buffer.put(c2).put(c1);
	}
	public static void main(String[] args) {
		char[] data = "UsingBuffersDirect".toCharArray();
		ByteBuffer bb = ByteBuffer.allocateDirect(data.length * 2);
		CharBuffer cb = bb.asCharBuffer();
		cb.put(data);
		System.out.println(cb.rewind());
		symmertryScrable(cb);
		System.out.println(cb.rewind());
		symmertryScrable(cb);
		System.out.println(cb.rewind());
	}
}
