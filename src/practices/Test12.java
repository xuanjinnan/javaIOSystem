package practices;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import examples.BufferedInputFile;

public class Test12 {
	public static void main(String[] args) throws IOException {
		args = new String[]{"F:\\think_in_java_git\\java_io_system\\src\\practices\\Test12.java","F:\\think_in_java_git\\java_io_system\\src\\practices\\Test12file"};
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		LinkedList<String> ll = new LinkedList<String>();
		String s;
		int lineCount = 1;
		while((s = in.readLine()) != null)
			ll.add(lineCount++ + ":" +s);
		in.close();
		PrintWriter out = new PrintWriter(args[1]);
		for (String string : ll) {
			out.println(string);
		}
		out.close();
		System.out.println(BufferedInputFile.read(args[1]));
	}
}
