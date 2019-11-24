package practices;

import java.io.File;

import examples.Directory;
import examples.ProcessFilesDemo;

public class Test4 {
	public static void main(String[] args) {
		ProcessFilesDemo processFiles = new ProcessFilesDemo(new ProcessFilesDemo.Strategy() {
			long size = 0;
			@Override
			public void process(File file) {
				System.out.println(file.getAbsolutePath());
				size += file.length();
				System.out.println(size);
			}
			
		}, ".*.java");
		processFiles.start(args);
	}
}
class Test4b{
	public interface Strategy{
		long process(File file);
	}
	private Strategy strategy;
	private String ext;
	private long size = 0;
	
	
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public Test4b(Strategy strategy, String ext) {
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
			setSize(getSize() + strategy.process(file));
	}
	public static void main(String[] args) {
		Test4b test4b = new Test4b(new Strategy(){
			
			@Override
			public long process(File file) {
				return file.length();
			}}, ".*.java");
		test4b.start(args);
		System.out.println(test4b.getSize());
	}
}
class Test4C{
	public static void main(String[] args) {
		int total = 0;
		if(args.length == 0){
			for(File file : Directory.walk(".",".*.java").files){
				System.out.println(file);
				total += file.length();
			}
		}else{
			for (String string : args) {
				for(File file : Directory.walk(".",string).files){
					System.out.println(file);
					total += file.length();
				}
			}
		}
		System.out.println();
		System.out.println("total:" + total);
	}
}