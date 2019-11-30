package practices;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import examples.BufferedInputFile;

public class Test142 {
	static String file = "BasicFileOutput14.out";
	static String file2 = "BasicFileOutput142.out";
	public static void main(String[] args) throws IOException {
		BufferedReader in2 = new BufferedReader(
				new StringReader(
						BufferedInputFile.read("F:\\think_in_java_git\\java_io_system\\src\\practices\\Test142.java")));
		// Unbuffered writer:
		PrintWriter out2 = new PrintWriter(new FileWriter(file2));
		int lineCount2 = 1;
		String s2;
		long start2 = System.nanoTime();
		while((s2 = in2.readLine()) != null )
			out2.println(lineCount2++ + ": " + s2);
		long duration2 = System.nanoTime() - start2;
		out2.close();
		System.out.println("Unbuffered write: " + duration2 + " nanoseconds");
		BufferedReader in = new BufferedReader(
			new StringReader(
				BufferedInputFile.read("F:\\think_in_java_git\\java_io_system\\src\\practices\\Test142.java")));
		// Buffered writer:
		PrintWriter out = new PrintWriter(
			new BufferedWriter(new FileWriter(file)));
		int lineCount = 1;
		String s;
		long start = System.nanoTime();
		while((s = in.readLine()) != null )
			out.println(lineCount++ + ": " + s);
		long duration = System.nanoTime() - start;
		out.close();
		System.out.println("Buffered write:   " + duration + " nanoseconds");
		// Show the stored files:
		//System.out.println("file: " + BufferedInputFile.read(file));
		//System.out.println("file2: " + BufferedInputFile.read(file2));
	}
}
