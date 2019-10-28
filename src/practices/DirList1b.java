package practices;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;

import net.mindview.util.TextFile;

public class DirList1b {
	public static void main(String[] args) {
		File path = new File(".");
		String[]	 list = null;
		if(args.length == 0){
			list = path.list();
			System.out.println("Usage: enter workds,one or more of which each file must contain		");
		}else{
			path.list(new FilenameFilter(){

				@Override
				public boolean accept(File dir, String name) {
					return !Collections.disjoint(Arrays.asList(args), new TextFile(name,"\\W+"));
				}

			});
		}
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list) {
			System.out.println(dirItem);

		}
	}
}
