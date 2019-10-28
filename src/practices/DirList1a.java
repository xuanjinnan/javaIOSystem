package practices;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

import net.mindview.util.TextFile;

public class DirList1a {
	public static void main(String[] args) {
		File path = new File(".");
		final String[] list;
		if(args.length <2){
			list = path.list();
			System.out.println("Usage: enter filtering regex");
			System.out.println("followed by words,one or more of which each file must contain");
		}else{
			list = path.list(new FilenameFilter(){
				private Pattern pattern = Pattern.compile(args[0]);
				@Override
				public boolean accept(File dir, String name) {
					return pattern.matcher(name).matches() &&
							!Collections.disjoint(Arrays.asList(args).subList(1, args.length), new TextFile(name,"\\W+"));
				}});
		}
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list) {
			System.out.println(dirItem);
		}
	}
}
