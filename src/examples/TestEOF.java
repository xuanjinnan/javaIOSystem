package examples;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {

	public TestEOF() {
	}
	public static void main(String[] args) throws IOException {
		DataInputStream out = new DataInputStream(
		new BufferedInputStream(new FileInputStream("F:\\think_in_java_git\\java_io_system\\src\\examples\\TestEOF.java")));
		while(out.available() != 0)
			System.out.print((char)out.read());
		out.close();
	}
}
