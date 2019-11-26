package practices;

import java.io.IOException;
import java.util.LinkedList;

public class Test8 {
	public static void main(String[] args) throws IOException {
		args = new String[] {"E:\\\\学习\\\\thinkInJava_at_git\\\\javaIOSystem\\\\src\\\\examples\\\\BufferedInputFile.java"};
		if(args.length == 0) {
			System.out.println("pelease print your file of you want");
			return;
		}
		for(String arg : args) {
			LinkedList<String> ll = Test7.read(arg);
			while(ll.peekLast() != null)
				System.out.println(ll.pollLast().toUpperCase()	);
		}
	}
}
