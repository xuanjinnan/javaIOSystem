package practices;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class SortedDirList2a {
	private String path;
	public SortedDirList2a(String path){
		this.path = path;
	}
	public String[] list(){
		String[] list = new File(path).list();
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		return list;
	}
	public String[] list(String regex){
		
		String[] list = new File(path).list(new FilenameFilter(){
			Pattern pattern = Pattern.compile(regex);
			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}});
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		return list;
	}
	public static void main(String[] args) {
		SortedDirList2a dirList = new SortedDirList2a(".");
		for(String s : dirList.list())
			System.out.println(s);
		System.out.println("==========");
		for(String s : dirList.list("\\.git"))
			System.out.println(s);
	}
}
