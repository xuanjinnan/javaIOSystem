package examples;

import java.io.File;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirectoryDemo {
	public static void main(String[] args) {
		// All directories
		//PPrint.pprint(Directory.walk(".").dirs);
		// All files beginning with 'T'
		/*PPrint.pprint(Directory.local(".", ".*"));
		PPrint.pprint(Directory.local(".", "\\.\\\\[^\\.]\\w+"));*/
		String[] strs = {
				 ".\\.classpath",
				 ".\\.git",
				 ".\\.gitignore",
				 ".\\.project",
				 ".\\.settings",
				 ".\\bin",
				 ".\\src"
		};
		Pattern pattern = Pattern.compile("\\.\\\\[^\\.]+");
		for (String string : strs) {
			if(pattern.matcher(string).matches())
				System.out.println(string);
		}
		System.out.println(Arrays.toString(strs));
		System.out.println("-----------------------");
		//PPrint.pprint(Directory.local(".", ".*\\\\.*+"));
		// All java files beginning with 'T':
		/*for(File file : Directory.walk(".","T.*\\.java"))
			System.out.println(file);
		System.out.println("=====================");
		// Class files containing "Z" or "z"
		for(File file : Directory.walk(".", ".*[Zz].*\\.java"))
			System.out.println(file);*/
	}
}
