package examples;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Logon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date = new Date();
	private String username;
	private transient String password;
	public Logon( String username, String password) {
		this.username = username;
		this.password = password;
	}
	public String toString() {
		return "Logon [date=" + date + ", username=" + username + ", password=" + password+"]";
	}
	public static void main(String[] args) throws Exception{
		Logon a = new Logon("Hulk","myLittlePony");
		System.out.println("Logon a = " + a);
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Logon.out"));
		o.writeObject(a);
		o.close();
		TimeUnit.SECONDS.sleep(1);//Delay
		// Now get them back
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Logon.out"));
		Logon b = (Logon) in.readObject();
		System.out.println(b);
		in.close();
	}

	public Logon() {
	}

}
