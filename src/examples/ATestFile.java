package examples;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.mindview.util.Print;



public class ATestFile {
	static List<File> dir = new ArrayList<File>();
	static List<File> list = new ArrayList<File>();
	public static void getPath(File file){
		File[] listFiles = file.listFiles();
		for (File file2 : listFiles) {
			if(file2.isDirectory()){
				dir.add(file2);
				getPath(file2);
			}else{
				list.add(file2);
			}
		}
	}
	public static void main(String[] args) {
		getPath(new File("."));
		System.out.println(dir);
		System.out.println(list);
		PPrint.pprint(Arrays.asList(1));
		PPrint.pprint(Arrays.asList(new String[]{"1","2"}));
		String[] strs = new String[dir.size()];
		for(int i = 0; i < strs.length; i++){
			strs[i] = dir.get(i).toString();
		}
		PPrint.pprint(strs);
		Print.print("a");
	}
}
