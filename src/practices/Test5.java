package practices;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import net.mindview.util.Directory;

public class Test5 {
	public interface Strategy{
		void process(File file);
	}
	private String regex;
	private Strategy strategy;
	public Test5(String regex, Strategy strategy) {
		super();
		this.regex = regex;
		this.strategy = strategy;
	}
	public void start(String[] args){
		try {
			if(args.length == 0)
				processDirectoryTree(new File("."));
			else
				for(String arg : args){
					File file = new File(arg);
					if(file.isDirectory())
						processDirectoryTree(file);
					else{
						Pattern pattern = Pattern.compile(regex);
						if(pattern.matcher(arg).matches())
							strategy.process(new File(arg).getCanonicalFile());
					}
				}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public void processDirectoryTree(File file) {
		for(File f : Directory.walk(file, regex).files){
			strategy.process(f);
		}
	}
	public static void main(String[] args) {
		new Test5(".*D.*",new Strategy(){
				@Override
				public void process(File file) {
					System.out.println(file);
				}}).start(args);;
	}
}
