package examples;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

class DirFilter implements FilenameFilter{
	private Pattern pattern;
	
	public DirFilter(String  regex) {
		super();
		this.pattern = Pattern.compile(regex);
	}

	@Override
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}}
public class DirList {
	public static void main(String[] args) {
		args = new String[1];
		args[0] = "src";
		File path = new File(".");
		String[] list;
		if(args.length == 0)
			list = path.list();
		else
			list = path.list(new DirFilter(args[0]));
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list) {
			System.out.println(dirItem);
			
		}
	}
}
