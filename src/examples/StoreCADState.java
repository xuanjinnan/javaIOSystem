package examples;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class Shape implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int RED = 1,BULUE = 2,GREEN = 3;
	private int xPos,yPos,dimension;
	private static Random ran = new Random(47);
	private static int counter = 0;
	public abstract void setColor(int newColor);
	public abstract int getColor();
	public Shape(int xVal,int yVal,int dim) {
		this.xPos = xVal;
		this.yPos = yVal;
		this.dimension = dim;
	}
	public String toString() {
		return this.getClass() + "color[" + getColor() + "] xPos[" + xPos + "] yPos[" + yPos + "] dim[" + dimension + "]\n";
	}
	public static Shape randomFactory() {
		int xVal = ran.nextInt(100);
		int yVal = ran.nextInt(100);
		int dim = ran.nextInt(100);
		switch(counter ++ %3) {
			default:
			case 0:return new Circle(xVal,yVal,dim);
			case 1:return new Square(xVal,yVal,dim);
			case 2:return new Line(xVal,yVal,dim);
		}
	}
}
class Circle extends Shape{
	private static int color = RED;
	public Circle(int xVal, int yVal, int dim) {
		super(xVal, yVal, dim);
	}
	private static final long serialVersionUID = 1L;
	public void setColor(int newColor) {
		color = newColor;
	}
	public int getColor() {
		return color;
	}
	
}
class Square extends Shape{
	private static int color;
	public Square(int xVal, int yVal, int dim) {
		super(xVal, yVal, dim);
		color = RED;
	}
	private static final long serialVersionUID = 1L;
	public void setColor(int newColor) {
		color = newColor;
	}
	public int getColor() {
		return color;
	}
}
class Line extends Shape{
	private static int color = RED;
	public static void serializeStaticState(ObjectOutputStream os) throws IOException{os.writeInt(color);}
	public static void deserializeStaticState(ObjectInputStream os) throws IOException{color = os.readInt();}
	public Line(int xVal, int yVal, int dim) {
		super(xVal, yVal, dim);
	}
	private static final long serialVersionUID = 1L;
	public void setColor(int newColor) {
		color = newColor;
	}
	public int getColor() {
		return color;
	}
}
public class StoreCADState {
	public static void main(String[] args) throws Exception{
		List<Class<? extends Shape>> shapeTypes = new ArrayList<Class<? extends Shape>>();
		// Add references to the class objects:
		shapeTypes.add(Circle.class);
		shapeTypes.add(Square.class);
		shapeTypes.add(Line.class);
		List<Shape> shapes = new ArrayList<Shape>();
		// Make some shapes
		for(int i = 0; i< 10; i++)
			shapes.add(Shape.randomFactory());
		// Set all the static colors to GREEN:
		for(int i = 0; i < 10; i++)
			shapes.get(i).setColor(Shape.GREEN);
		//Save the state vector
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState.out"));
		out.writeObject(shapeTypes);
		Line.serializeStaticState(out);
		out.writeObject(shapes);
		// Display the shapes
		System.out.println(shapes);
	}
}
