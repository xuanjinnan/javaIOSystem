package examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
	//Throw exceptions to console
	public static String read(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		while((s=in.readLine()) != null) {
			sb.append(s + "\n");
		}
		in.close();
		return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		String read = read("E:\\学习\\thinkInJava_at_git\\javaIOSystem\\src\\examples\\BufferedInputFile.java");
		System.out.println(read);
	}
}
