package practices;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class Test16 {
	static String file = "rtest.dat";
	public static void main(String[] args) throws IOException {
		RandomAccessFile rf = new RandomAccessFile(file,"rw");
		byte[] ba = {1,2,3,4};
		rf.write(ba);
		rf.write(0);
		rf.write(ba, 0, 3);
		rf.writeBoolean(true);
		rf.writeByte(1);
		rf.writeBytes("abc");
		rf.writeChar(2);
		rf.writeChars("def");
		rf.writeDouble(3.141592);
		rf.writeFloat(1.111f);
		rf.writeInt(3);
		rf.writeLong(4l);
		rf.writeShort(5);
		rf.writeUTF("ghi");
		rf.close();
		
		rf = new RandomAccessFile(file,"r");
		byte[] ba1 = new byte[4];
		System.out.println(Arrays.toString(ba1));
		System.out.println(rf.readInt());
		System.out.println(rf.read());
		rf.read(ba1,0,3);
		System.out.println(Arrays.toString(ba1));
		System.out.println(rf.readBoolean());
		System.out.println(rf.readByte());
		System.out.println(rf.readByte());
		System.out.println(rf.readByte());
		System.out.println(rf.readByte());
		System.out.println(rf.readChar());
		System.out.println(rf.readChar());
		System.out.println(rf.readChar());
		System.out.println(rf.readChar());
		System.out.println(rf.readDouble());
		System.out.println(rf.readFloat());
		System.out.println(rf.readInt());
		System.out.println(rf.readLong());
		System.out.println(rf.readShort());
		System.out.println(rf.readUTF());
		rf.close();
	}
}
