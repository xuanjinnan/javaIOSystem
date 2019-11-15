package practices;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class Test3 {
	private File[] files;
	//初始化
	public void initFile(File file,String name){
		files = file.listFiles(new FileFilter(){

			@Override
			public boolean accept(File pathname) {
				return pathname.getPath().indexOf(name) != -1;
			}

		});
	}
	//计算总和
	public int fileTotalSize(){
		int i = 0;
		for (File file2 : files) {
			i += file2.length();
		}
		return i;
	}
	//测试
	public static void main(String[] args) {
		Test3 test3 = new Test3();
		test3.initFile(new File("F:\\think_in_java_git\\java_io_system\\src\\practices"), "Dir");
		for(File file : test3.files)
			System.out.println(file);
		int fileTotalSize = test3.fileTotalSize();
		System.out.println("====result====");
		System.out.println(fileTotalSize);
	}
}
