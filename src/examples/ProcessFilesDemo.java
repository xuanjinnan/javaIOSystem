package examples;

import java.io.File;
import java.io.IOException;

public class ProcessFilesDemo {
	public interface Strategy{
		void process(File file);
	}
	private Strategy strategy;
	private String ext;
	public ProcessFilesDemo(Strategy strategy, String ext) {
		super();
		this.strategy = strategy;
		this.ext = ext;
	}
	public void start(String[] args){
		if(args.length == 0)
			processDirectoryTree(new File("."));
		else
			for(String arg : args){
				File fileArg = new File(arg);
				if(fileArg.isDirectory())
					processDirectoryTree(fileArg);
				else{
					if(!arg.endsWith(ext))
						arg += "." + ext;
					strategy.process(new File(arg).getAbsoluteFile());
				}
			}
	}
	public void processDirectoryTree(File root){
		for(File file :Directory.walk(root.getAbsolutePath(), ext))
			strategy.process(file);
	}
	public static void main(String[] args) throws IOException {
		new ProcessFilesDemo(new Strategy() {
			
			@Override
			public void process(File file) {
				System.out.println(file.getAbsolutePath());
			}
		}, ".*.java").start(args);
	}
}
