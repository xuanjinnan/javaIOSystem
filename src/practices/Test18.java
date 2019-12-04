package practices;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

public class Test18 extends ArrayList<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Test18() {
	}

	public Test18(int initialCapacity) {
		super(initialCapacity);
	}

	public Test18(Collection<? extends String> c) {
		super(c);
	}

	//read file as a single string
	public static String read(String fileName) throws IOException{
		StringBuilder sb = new StringBuilder();
			BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
			try {
				String s;
				while((s = in.readLine()) != null)
					sb.append(s + "\n");
			}finally {
				in.close();
			}
		return sb.toString();
	}
	//write a single file in one method call;
	public static void write(String fileName,String text) throws IOException{
			BufferedWriter out = new BufferedWriter(new FileWriter(new File(fileName).getAbsoluteFile()));
			try {
				out.write(text);
			}finally {
				out.close();
			}
	}
	//Read a file ,split by any regular expression;
	public Test18(String fileName,String splitter) throws IOException{
		super(Arrays.asList(read(fileName).split(splitter)));
		//Regular expression split() often leaves an empty String at the first position:
		if(get(0).equals(""))
			remove(0);
	}
	//Normally read by lines:
	public Test18(String fileName) throws IOException{
		this(fileName,"\n");
	}
	public void write(String fileName) throws IOException{
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try {
				for(String string : this)
					out.println(string);
			}finally {
				out.close();
			}
	}
	//Simple Test
	public static void main(String[] args) throws IOException {
		String file = read("F:\\think_in_java_git\\java_io_system\\src\\examples\\TextFile.java");
		write("test.txt",file);
		Test18 text = new Test18("test.txt");
		text.write("test2.txt");
		// Break into unique sorted list of wordsL
		TreeSet<String> words = new TreeSet<String>(new Test18("F:\\think_in_java_git\\java_io_system\\src\\examples\\TextFile.java","\\W+"));
		// Display the capitalized words:
		System.out.println(words);
		System.out.println(words.headSet("a"));
	}
}
