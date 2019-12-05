package practices;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.mindview.util.BinaryFile;

public class Test19 {
	public static void main(String[] args) throws IOException {
		byte[] read = BinaryFile.read("E:\\学习\\thinkInJava_at_git\\javaIOSystem\\src\\practices\\Test19.java");
		Map<Byte,Integer> map = new HashMap<Byte,Integer>();
		for (byte b : read) {
			Integer a = map.containsKey(b) ? map.put(b, map.get(b) + 1) : map.put(b, 1);
		}
		System.out.println(map);
		
	}
}
