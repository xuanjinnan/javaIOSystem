package examples;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class FormattedMemoryInput {
	public static void main(String[] args) throws IOException {
		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(
		BufferedInputFile.read("E:\\学习\\thinkInJava_at_git\\javaIOSystem\\src\\examples\\FormattedMemoryInput.java").getBytes()));
		while(true)
			System.out.print((char)inputStream.readByte());
	}
}
