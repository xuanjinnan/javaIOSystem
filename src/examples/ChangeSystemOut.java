package examples;

import java.io.PrintWriter;

public class ChangeSystemOut {
	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out,true);
		pw.println("hello standard outputStream!");
		pw.close();
	}
}
