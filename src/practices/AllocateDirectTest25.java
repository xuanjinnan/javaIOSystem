package practices;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class AllocateDirectTest25 {

	// Method to copy file,replace allocate()
	// with allocateDirect(), and rename fileDirect:
	@SuppressWarnings("resource")
	public static File toDirect(File f) throws IOException{
		FileChannel fcIn = new FileInputStream(f).getChannel();
		ByteBuffer b = ByteBuffer.allocateDirect((int) f.length());
		fcIn.read(b);
		b.flip();
		Charset cs = Charset.defaultCharset();
		CharBuffer cb = cs.decode(b);
		String cbD1 = cb.toString().replace(".allocate(", ".allocateDirect(");
		String cbD = cbD1.replace(f.getName().split("\\.")[0], f.getName().split("\\.")[0] + "Direct");
		CharBuffer cbNew = CharBuffer.wrap(cbD);
		String ext = f.getName().split("\\.")[1];
		String outFile = f.getName().split("\\.")[0] + "Direct." + ext;
		FileChannel fcOut = new FileOutputStream(new File(outFile)).getChannel();
		fcOut.write(cs.encode(cbNew));
		//FcIn transferTo(o,f.length(),fcOut);
		fcIn.close();
		fcOut.close();
		return new File(outFile);
	}
	// Methods to test performance
	public static void Tester(String s) {
		try {
			Class<?> c = Class.forName(s);
			String name = c.getSimpleName();
			System.out.println("Testing:" + name);
			Method m = c.getMethod("main", String[].class);
			// To test ChannelCopy.class
			//(otherwise (String)null OK for second argument
			String[] sa = new String[]{"ChannelCopy.java","Test.txt"};
			long startRun = System.nanoTime();
			m.invoke(c.newInstance(),(Object)sa);
			long duration = System.nanoTime() - startRun;
			System.out.println("\nTime to run" + name + " = " + duration + " nanoseconds");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static long allocationTime(int i){
		long start = System.nanoTime();
		ByteBuffer bb = ByteBuffer.allocate(i);
		return System.nanoTime() - start;
	}
	public static long directAllocationTime(int i){
		long start = System.nanoTime();
		ByteBuffer bb = ByteBuffer.allocate(i);
		return System.nanoTime() - start;
	}
	public static void main(String[] args) throws Exception {
		// allcation time replated to statup time:
		
		System.out.println("Time to allocate 1024 bytes = " + allocationTime(1024) + "nanoseconds");
		System.out.println("Time to allocateDirect 1024 bytes = " + directAllocationTime(1024) + "nanoseconds");
		System.out.println("Time to allocate 48 bytes = " + allocationTime(48) + "nanoseconds");
		System.out.println("Time to allocateDirect 48 bytes = " + directAllocationTime(48) + "nanoseconds");
		System.out.println("Time to allocate 1 bytes = " + allocationTime(1) + "nanoseconds");
		System.out.println("Time to allocateDirect 1 bytes = " + directAllocationTime(1) + "nanoseconds");
		Tester("examples.GetChannel");
		toDirect(new File("F:\\think_in_java_git\\java_io_system\\src\\examples\\GetChannel.java"));
		//after compiling GetChannelDirect:
		Tester("examples.GetChannelDirect");
		Tester("examples.BufferToText");
		toDirect(new File("F:\\think_in_java_git\\java_io_system\\src\\examples\\BufferToText.java"));
		// after compliling BufferToText.java
		Tester("examples.BufferToTextDirect");
		Tester("examples.ChannelCopy");
		toDirect(new File("F:\\think_in_java_git\\java_io_system\\src\\examples\\ChannelCopy.java"));
		// after compliling ChannelCopy.java
		Tester("examples.ChannelCopyDirect");
		Tester("examples.GetData");
		toDirect(new File("F:\\think_in_java_git\\java_io_system\\src\\examples\\GetData.java"));
		Tester("examples.GetDataDirect");
		Tester("examples.IntBufferDemo");
		toDirect(new File("F:\\think_in_java_git\\java_io_system\\src\\examples\\IntBufferDemo.java"));
		Tester("examples.IntBufferDemoDirect");
		Tester("examples.UsingBuffers");
		toDirect(new File("F:\\think_in_java_git\\java_io_system\\src\\examples\\UsingBuffers.java"));
		Tester("examples.UsingBuffersDirect");
		Tester("practices.JGrep");
		Tester("practices.JGrpTest26");
		
	}
}
