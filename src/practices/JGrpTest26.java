package practices;

import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrpTest26 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
	    /*if(args.length < 2) {
	      System.out.println("Usage: java JGrep file regex");
	      System.exit(0);
	    }*/
		args = new String[]{"F:\\think_in_java_git\\java_io_system\\src\\practices\\JGrpTest26.java","\\b[Ssct]\\w+"};
	    Pattern p = Pattern.compile(args[1]);
	    // Iterate through the lines of the input file:
	    FileChannel fc = new FileInputStream(args[0]).getChannel();
	    MappedByteBuffer in = fc.map(MapMode.READ_ONLY, 0, fc.size());
	    String string = Charset.forName(System.getProperty("file.encoding")).decode(in).toString();
	    String[] sa = string.split("\n");
	    
	    int index = 0;
	    Matcher m = p.matcher("");
	    for(String line : sa) {
	      m.reset(line);
	      while(m.find())
	        System.out.print(index++ + ": " +
	          m.group() + ": " + m.start());
	    }
	  }
}
