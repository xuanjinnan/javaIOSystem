package examples;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInputDemo {
	public static void main(String[] args) throws IOException {
		String read = BufferedInputFile.read("E:\\学习\\thinkInJava_at_git\\javaIOSystem\\src\\examples\\ATestFile.java");
		System.out.println(read);
		StringReader sr = new StringReader(read);
		int s;
		while((s = sr.read()) != -1) {
			System.out.print((char)s);
		}
	}
	
}
