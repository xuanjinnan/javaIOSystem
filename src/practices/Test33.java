package practices;

import java.util.prefs.Preferences;

public class Test33 {
	
	public static void main(String[] args) {
		Preferences refs = Preferences.userNodeForPackage(Test33.class);
		String base_directory = refs.get("abase_directory", null);
		base_directory += base_directory;
		refs.put("abase_directory", base_directory);
		System.out.println(refs.get("abase_directory", null));
	}
}
