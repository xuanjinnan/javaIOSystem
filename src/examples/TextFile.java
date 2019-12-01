package examples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

public class TextFile extends ArrayList<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TextFile() {
	}

	public TextFile(int initialCapacity) {
		super(initialCapacity);
	}

	public TextFile(Collection<? extends String> c) {
		super(c);
	}

	//read file as a single string
	public static String read(String fileName){
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
			try {
				String s;
				while((s = in.readLine()) != null)
					sb.append(s + "\n");
			}finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return sb.toString();
	}
	//write a single file in one method call;
	public static void write(String fileName,String text){
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(new File(fileName).getAbsoluteFile()));
			try {
				out.write(text);
			}finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	//Read a file ,split by any regular expression;
	public TextFile(String fileName,String splitter){
		super(Arrays.asList(read(fileName).split(splitter)));
		//Regular expression split() often leaves an empty String at the first position:
		if(get(0).equals(""))
			remove(0);
	}
	//Normally read by lines:
	public TextFile(String fileName){
		this(fileName,"\n");
	}
	public void write(String fileName){
		try {
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try {
				for(String string : this)
					out.println(string);
			}finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	//Simple Test
	public static void main(String[] args) {
		String file = read("F:\\think_in_java_git\\java_io_system\\src\\examples\\TextFile.java");
		write("test.txt",file);
		TextFile text = new TextFile("test.txt");
		text.write("test2.txt");
		// Break into unique sorted list of wordsL
		TreeSet<String> words = new TreeSet<String>(new TextFile("F:\\think_in_java_git\\java_io_system\\src\\examples\\TextFile.java","\\W+"));
		// Display the capitalized words:
		System.out.println(words);
		System.out.println(words.headSet("a"));
	}
}
