package practices;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class Test30_ {
	public static void main(String[] args) throws Exception{
		ObjectInputStream in =  new ObjectInputStream(new FileInputStream("CADState.out"));
		// Read in the same order they were written:
		Circle.deserializeStaticState(in);
		Square.deserializeStaticState(in);
		Line.deserializeStaticState(in);
		List<Shape> shapes = (List<Shape>) in.readObject();
		System.out.println(shapes);
	}
}
