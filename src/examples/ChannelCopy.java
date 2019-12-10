package examples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {

	public static final int BSIZE = 1024;
	
	public static void main(String[] args) throws IOException {
		args = new String[]{"F:\\think_in_java_git\\java_io_system\\src\\examples\\ChannelCopy.java","channelCopy.data"};
		if(args.length != 2){
			System.out.println("argments : sourcefile destfile");
			return;
		}
		FileInputStream inputStream = new FileInputStream(args[0]);
		FileChannel in = inputStream.getChannel();
		FileOutputStream outputStream = new FileOutputStream(args[1]);
		FileChannel out = outputStream.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		while(in.read(buffer) != -1){
			buffer.flip(); // Prepare for writing
			out.write(buffer);
			buffer.clear();// Prepare for reading
		}
		inputStream.close();
		outputStream.close();
	}

}
