package practices;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Test10 {
	public static void main(String[] args) throws IOException {
		args = new String[] {"E:\\\\学习\\\\thinkInJava_at_git\\\\javaIOSystem\\\\src\\\\practices\\\\Test10.java","str"};
		/*if(args.length == 0) {
			System.out.println("pelease print your file of you want");
			return;
		}*/
		Pattern pattern = Pattern.compile(".*" + args[1] + ".*");
		BufferedReader in = new BufferedReader(new FileReader(args[0]));;
		String s ;
		StringBuilder sb = new StringBuilder();
		while((s = in.readLine()) != null) {
			if(pattern.matcher(s).matches()) {
				System.out.println(s);
				sb.append(s);
			}
		}
		in.close();
		System.out.println(sb);
		/*LinkedList<String> ll = Test7.read(args[0]);
		while(ll.peekLast() != null) {
			String string = ll.pollLast();
			if(pattern.matcher(string).matches())
				System.out.println(string);
		}*/
	}
}
