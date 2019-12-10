package examples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TransferTo {

	public static void main(String[] args) throws IOException {
		args = new String[]{"F:\\think_in_java_git\\java_io_system\\src\\examples\\TransferTo.java","channelCopy.data"};
		if(args.length != 2){
			System.out.println("argments : sourcefile destfile");
			return;
		}
		FileInputStream inputStream = new FileInputStream(args[0]);
		FileChannel in = inputStream.getChannel();
		FileOutputStream outputStream = new FileOutputStream(args[1]);
		FileChannel out = outputStream.getChannel();
		in.transferTo(0, in.size(), out);
		out.transferFrom(in, 0, in.size());
		inputStream.close();
		outputStream.close();
		
	}

}
