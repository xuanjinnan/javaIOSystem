package practices;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import examples.BufferedInputFile;

public class Test14 {
	static String readFile = "";
	static String outFile1 = "";
	static String outFile2 = "";
	public static BufferedReader getBufferedReader() throws IOException{
		return new BufferedReader(new StringReader(BufferedInputFile.read(readFile)));
	}
	public static  long costWithBuffered() throws IOException{
		BufferedReader in = getBufferedReader();
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outFile1)));
		long timeStart = System.nanoTime();
		String s;
		while((s = in.readLine()) != null)
			out.write(s + "\n");
		out.close();
		long timeEnd = System.nanoTime();
		return timeEnd - timeStart;
	};
	public static long costWithNoBuffered() throws IOException{
		BufferedReader in = getBufferedReader();
		PrintWriter out = new PrintWriter(new FileWriter(outFile2));
		long timeStart = System.nanoTime();
		String s;
		while((s = in.readLine()) != null)
			out.write(s + "\n");
		out.close();
		long timeEnd = System.nanoTime();
		return timeEnd - timeStart;
	};
	public static void main(String[] args) throws IOException {
		Test14.readFile = "F:\\think_in_java_git\\java_io_system\\src\\practices\\DirList1a.java";
		Test14.outFile1 = "F:\\think_in_java_git\\java_io_system\\src\\practices\\Test14file1";
		Test14.outFile2 = "F:\\think_in_java_git\\java_io_system\\src\\practices\\Test14file2";
		BufferedReader in1 = getBufferedReader();
		PrintWriter out1 = new PrintWriter(new FileWriter(outFile2));
		long timeStart1 = System.nanoTime();
		String s1;
		while((s1 = in1.readLine()) != null)
			out1.println(s1 + "\n");
		out1.close();
		long timeEnd1 = System.nanoTime();
		System.out.println("noBuffered:" + (timeEnd1 - timeStart1));
		BufferedReader in = getBufferedReader();
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outFile1)));
		long timeStart = System.nanoTime();
		String s;
		while((s = in.readLine()) != null)
			out.println(s + "\n");

		out.close();
		long timeEnd = System.nanoTime();
		System.out.println("bufferd:   " + (timeEnd - timeStart));
	}
}
