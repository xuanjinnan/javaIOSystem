package practices;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import examples.BinaryFile;
import net.mindview.util.Directory;
import net.mindview.util.Directory.TreeInfo;

public class Test20 {
	public static void main(String[] args) throws IOException {
		TreeInfo walk = Directory.walk("E:\\学习\\thinkInJava_at_git\\javaIOSystem\\bin\\examples");
		List<File> files = walk.files;
		int size = files.size();
		/*System.out.println(size);
		String hex = "CAFEBABE";
		for (File file : files) {
			byte[] read = BinaryFile.read(file);
			for(int i = 0; i < 4; i++) {
				//System.out.print((Integer.toHexString(read[i] & 0xff).toUpperCase()));
				System.out.print(Integer.toHexString(read[i]));
			}
			System.out.println();
		}*/
		System.out.println((BinaryFile.read(files.get(0))[0]));
		System.out.println((Integer.toHexString(BinaryFile.read(files.get(0))[0] & 0xff)));
	}
}
