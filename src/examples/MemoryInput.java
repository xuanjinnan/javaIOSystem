package examples;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;

public class MemoryInput {
	public static void main(String[] args) throws IOException {
		StringReader in = new StringReader(BufferedInputFile.read("E:\\学习\\thinkInJava_at_git\\javaIOSystem\\src\\examples\\MemoryInput.java"));
		char[] chars = new char[(int) new File("E:\\\\学习\\\\thinkInJava_at_git\\\\javaIOSystem\\\\src\\\\examples\\\\MemoryInput.java").length()];
		in.read(chars);
		System.out.println(Arrays.toString(chars));
		/*int c;
		while((c = in.read()) != -1) {
			System.out.println((char)c);
		}*/
	}
}
