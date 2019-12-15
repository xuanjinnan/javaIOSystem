package examples;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {
	
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("file.txt");
		FileLock fl = fos.getChannel().lock(1,4,false);
		System.out.println(fl.isShared());
		if(fl != null){
			System.out.println("Locked File");
			TimeUnit.MILLISECONDS.sleep(1000000);
			System.out.println("Released Lock");
		}
		fos.close();
		
		
	}

}
