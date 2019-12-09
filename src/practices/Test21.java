package practices;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test21 {
	public static void toUpperCase(InputStream in) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String s;
		while((s = br.readLine()) != null)
			System.out.println(s.toUpperCase());
		br.close();
	}
	public static void main(String[] args) throws IOException {
		FileInputStream in = new FileInputStream("F:\\think_in_java_git\\java_io_system\\src\\practices\\Test21.java");
		toUpperCase(in);
		in.close();
		toUpperCase(System.in);
	}
}
