package practices;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.StringReader;

import examples.BufferedInputFile;

public class Test13 {
	static String readFile = "F:\\think_in_java_git\\java_io_system\\src\\practices\\DirList1a.java";
	static String outFile = "F:\\think_in_java_git\\java_io_system\\src\\practices\\Test13file";
	public static void main(String[] args) throws IOException {
		LineNumberReader in = new LineNumberReader(new StringReader(BufferedInputFile.read(readFile)));
		PrintWriter out = new PrintWriter(outFile);
		String s;
		while((s = in.readLine()) != null)
			out.println(in.getLineNumber() + ":" + s);
		in.close();
		out.close();
		System.out.println(BufferedInputFile.read(outFile));
	}
}
