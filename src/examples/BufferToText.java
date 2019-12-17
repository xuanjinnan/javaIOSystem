package examples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {

	private static final int BSIZE = 1024;
	public static void main(String[] args) throws IOException {
		FileOutputStream out = new FileOutputStream("data2.txt");
		FileChannel fc = out.getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes()));
		fc.close();
		FileInputStream in = new FileInputStream("data2.txt");
		fc = in.getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip();
		// Doesn't work:
		System.out.println(buff.asCharBuffer());
		// Decode using this system's default Charset
		buff.rewind();
		String encoding = System.getProperty("file.encoding");
		System.out.println(encoding);
		System.out.println("Decoded using " + encoding + ": " + Charset.forName(encoding).decode(buff));
		in.close();
		out.close();
		// Or, wh could encode with something that will print:
		FileOutputStream out2 = new FileOutputStream("data2.txt");
		fc = out2.getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
		fc.close();
		// Now try read again
		FileInputStream in2 = new FileInputStream("data2.txt");
		fc = in2.getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
		in2.close();
		out2.close();
		// Use a CharBUffer to write through:
		FileOutputStream out3 = new FileOutputStream("data2.txt");
		fc = out3.getChannel();
		buff = ByteBuffer.allocate(24);
		buff.asCharBuffer().put("Some text");
		fc.write(buff);
		fc.close();
		// Read and display
		FileInputStream in3 = new FileInputStream("data2.txt");
		fc = in3.getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
		in3.close();
		out3.close();
	}
}
