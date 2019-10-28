package practices;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class SortedDirList2b {
	private String[] list;
	public SortedDirList2b(File file){
		list = file.list();
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
	}
	public String toString(){
		return "SortedDirList2b" + Arrays.toString(list);
	}
	public String[]	list(){
		return list;
	}
	public String[] list(String regex){
		Pattern pattern = Pattern.compile(regex);
		ArrayList<String> al = new ArrayList<String>();
		int count = 0;
		for(String s : list){
			if(pattern.matcher(s).matches()){
				al.add(s);
				count ++;
			}
		}
		return al.toArray(new String[count]);
	}
	public static void main(String[] args) {
		SortedDirList2b sd2b = new SortedDirList2b(new File("."));
		System.out.println(sd2b);
		for(String s : sd2b.list())
			System.out.println(s);
		System.out.println("==========");
		for(String s : sd2b.list("\\.git"))
			System.out.println(s);
	}
}
