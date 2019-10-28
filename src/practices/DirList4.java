package practices;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

import net.mindview.util.TextFile;

public class DirList4 {
	public static void main(String[] args) {
		File path = new File(".");
		String[] list;
		if(args.length == 0)
			list = path.list();
		else{
			list= path.list(new FilenameFilter() {
				private Pattern pattern = Pattern.compile(args[0]);
				@Override
				public boolean accept(File dir, String name) {
					return pattern.matcher(name).matches();
				}
			});	
		}
		int totalFile = 0;
		for(String s : list){
			File file = new File(s);
			totalFile += file.length();
		}
		System.out.println(totalFile);
		
	}
}
