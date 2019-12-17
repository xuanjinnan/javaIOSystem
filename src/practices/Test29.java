package practices;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Test29 implements Externalizable {
	private int i;
	private String s;
	public Test29() {
		System.out.println("Blip3 Constructor");
		// s, i not initialized
	}
	public Test29(int i, String s) {
		super();
		this.i = i;
		this.s = s;
		// s & i initialized only in non-default constructor
	}
	public String toString(){
		return s + i;
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip3.writeExternal");
		//you must do this:
		/*out.writeObject(s);
		out.writeInt(i);*/
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Blip3.readExternal");
		//you must do this
		/*s = (String) in.readObject();
		System.out.println(s);
		i = in.readInt();*/
	}
	public static void main(String[] args) throws Exception{
		System.out.println("Constructing objects : ");
		Test29 b3 = new Test29(47,"A String");
		System.out.println(b3);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Blip3.out"));
		out.writeObject(b3);
		out.close();
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip3.out"));
		Test29 recoverb3 = (Test29) in.readObject();
		System.out.println(recoverb3);
		in.close();
	}
}
