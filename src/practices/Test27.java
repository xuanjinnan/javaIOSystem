package practices;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class OneObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String a = "OneObject";
	@Override
	public String toString() {
		return "OneObject [a=" + a + "]";
	}
	
}
public class Test27 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OneObject oneObject = new OneObject();
	@Override
	public String toString() {
		return "Test27 [oneObject=" + oneObject + "]";
	}

	public static void main(String[] args) throws Exception, IOException {
		Test27 test27 = new Test27();
		System.out.println(test27);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Test27.txt"));
		out.writeObject(test27);
		out.close();
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Test27.txt"));
		Test27 restore = (Test27) in.readObject();
		System.out.println(restore);
		in.close();
	}
	
}
