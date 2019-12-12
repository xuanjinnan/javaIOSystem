package practices;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

public class Test24 {
	private static final int  BSIZE = 1024;
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		DoubleBuffer db = bb.asDoubleBuffer();
		db.put(new double[]{11,42,47,99,143,811,1016});
		// Absolute location read and write
		System.out.println(db.get(3));
		db.put(3,1811);
		// Seeting a new limit before rewinding the buffer.
		db.flip();
		while(db.hasRemaining()) {
			double d = db.get();
			System.out.println(d);
		}
	}
}
