package examples;

import java.io.File;
import java.util.ArrayList;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Elements;

public class People extends ArrayList<Person> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public People(String fileName) throws Exception{
		Document doc = new Builder().build(new File("E:\\学习\\thinkInJava_at_git\\javaIOSystem\\People.xml"));
		Elements elements = doc.getRootElement().getChildElements();
		for(int i = 0; i < elements.size(); i++)
			add(new Person(elements.get(i)));
	}
	public static void main(String[] args) throws Exception {
		People p = new People("People.xml");
		System.out.println(p);
	}
}
