package practices;

import java.io.File;
import java.util.Date;

import examples.ProcessFilesDemo;

public class Test6 {
	public static void main(String[] args) {
		new ProcessFilesDemo(new ProcessFilesDemo.Strategy(){

			@Override
			public void process(File file) {
				long lastModified = file.lastModified();
				long time = new Date(119,10,23).getTime();
				if(time < lastModified)
					System.out.println(file);
			}}, ".*.java").start(args);;
	}

}
