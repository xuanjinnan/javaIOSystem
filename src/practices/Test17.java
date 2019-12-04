package practices;

import java.util.Hashtable;
import java.util.Map;

import examples.TextFile;

public class Test17 {

	public Test17() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		char[] charArray2 = TextFile.read("F:\\think_in_java_git\\java_io_system\\src\\practices\\Test17.java").toCharArray();
		
		//TextFile textFile = new TextFile("F:\\think_in_java_git\\java_io_system\\src\\practices\\Test17.java","\\W+");
		Map<Character,Integer> map = new Hashtable<Character,Integer>();
			for (Character c : charArray2) {
				/*if(map.containsKey(c)){
					map.put(c, map.get(c) +1);
				}else{
					 map.put(c, 1);
				}*/
				Integer a = map.containsKey(c) ? map.put(c, map.get(c) +1) : map.put(c, 1);
				 
		}
		System.out.println(map);
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			System.out.println(entry);
		}
	}
	

}
