package examples;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Blip1 implements Externalizable {

	public Blip1() {
		System.out.println("Blip1.Blip1()");
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip1.writeExternal()");
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Blip1.readExternal()");
	}

}
class Blip2 implements Externalizable{
	Blip2(){
		System.out.println("Blip2.Blip2()");
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip2.writeExternal()");
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Blip2.readExternal()");
	}
	
}
public class Blips{
	public static void main(String[] args) throws Exception{
		System.out.println("Constructing objects:");
		Blip1 b1 = new Blip1();
		Blip2 b2 = new Blip2();
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Blips.out"));
		out.writeObject(b1);
		out.writeObject(b2);
		out.close();
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
		Blip1 recoverb1= (Blip1) in.readObject();
		System.out.println(recoverb1);
		Blip2 recoverb2 = (Blip2) in.readObject();
		System.out.println(recoverb2);
		in.close();
	}
}