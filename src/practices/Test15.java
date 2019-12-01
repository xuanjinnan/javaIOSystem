package practices;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test15 {
	public static void main(String[] args) throws IOException {
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.txt")));
		byte[] ba = new byte[]{1,2,3,4};
		out.write(ba);
		out.write(0);
		out.write(ba, 0, 3);
		out.writeBoolean(true);
		out.writeByte(1);
		out.writeBytes((String)"abc");
		out.writeChar(2);
		out.writeChars("def");
		out.writeDouble(3.1415926d);
		out.writeFloat(1.2345f);
		out.writeInt(3);
		out.writeLong(4l);
		out.writeShort(5);
		out.writeUTF("ghi");
		out.close();
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("Data.txt")));
		
		System.out.println(in.readByte());
		System.out.println(in.readByte());
		System.out.println(in.readByte());
		System.out.println(in.readByte());
		System.out.println(in.read());
		System.out.println(in.readByte());
		System.out.println(in.readByte());
		System.out.println(in.readByte());
		System.out.println(in.readBoolean());
		System.out.println(in.readByte());
		System.out.println(in.readByte());
		System.out.println(in.readByte());
		System.out.println(in.readByte());
		System.out.println(in.readChar());
		System.out.println(in.readChar());
		System.out.println(in.readChar());
		System.out.println(in.readChar());
		System.out.println(in.readDouble());
		System.out.println(in.readFloat());
		System.out.println(in.readInt());
		System.out.println(in.readLong());
		System.out.println(in.readShort());
		System.out.println(in.readUTF());
		in.close();
	}

}
