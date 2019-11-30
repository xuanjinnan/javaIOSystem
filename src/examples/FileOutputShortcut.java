package examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class FileOutputShortcut {
	static String file = "FileOutputShortcut.cout";
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new StringReader( BufferedInputFile.read("F:\\think_in_java_git\\java_io_system\\src\\examples\\FileOutputShortcut.java")));
		PrintWriter out = new PrintWriter(file);
		String s;
		int lineCount = 1;
		while((s = in.readLine()) != null)
			out.println(lineCount++ + ":" + s);
		System.out.println(out.checkError());
		out.close();
		System.out.println(BufferedInputFile.read(file));
	}
}
