package practices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import examples.OSExcuteException;

public class Test22 {
	public static List<String> command(String command){
		boolean err = false;
		List<String> list = new ArrayList<String>();
		try {
			String[] commands = command.split(" ");
			System.out.println(Arrays.toString(commands));
			Process process = new ProcessBuilder((commands)).start();
			BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String s;
			while((s = results.readLine()) != null)
				list.add(s);
			BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			//report errors and return nonzero value to calling process if there are problems
			while((s = errors.readLine()) != null){
				System.err.println(s);
				err = true;
			}
		} catch (Exception e) {
			//Compensate for Windows 2000,which throws an exception for the default command line:
			if(command.startsWith("CMD /C"))
				command("CMD /C" + command);
			else
				throw new RuntimeException(e);
		};
		if(err)
			throw new OSExcuteException("Errors excuting " + command);
		return list;
	}
	public static void main(String[] args) {
		for(String str : command("javap F:\\think_in_java_git\\java_io_system\\bin\\practices\\Test22.class"))
			System.out.println(str);
	}
}
