package practices;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Test7 {
	public static LinkedList<String> read(String flepath) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(flepath));
		LinkedList<String> ll = new LinkedList<String>();
		String s ;
		/*while((s = in.readLine()) != null)
			ll.push(s);
		in.close();
		for(String str : ll)
			System.out.println(str);*/
		while((s = in.readLine()) != null)
			ll.add(s);
		in.close();
		return ll;
		
	}
	public static void main(String[] args) throws IOException {
		String filepath = "E:\\\\学习\\\\thinkInJava_at_git\\\\javaIOSystem\\\\src\\\\examples\\\\BufferedInputFile.java";
		LinkedList<String> read = read(filepath);
		while(read.peekLast() != null)
			System.out.println(read.pollLast());
	}
}
