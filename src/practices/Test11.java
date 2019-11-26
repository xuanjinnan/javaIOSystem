package practices;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import innerclasses.GreenhouseControls;
import innerclasses.controller.Event;

public class Test11 {
	// To read events from text file and add to HashMap<String,Long>:
	public static Map<String,Long> readEvents(String fileName) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String s;
		Map<String,Long> map = new HashMap<String,Long>();
		while((s = in.readLine()) != null) {
			String[] split = s.split("[()]");
			map.put(split[0], new Long(split[1]));
		}
		in.close();
		return map;
	}
	// To build Event objects from Map.Entry objects
	private static Event makeEvent(GreenhouseControls gc,Map.Entry<String, Long> me) {
		String key = me.getKey();
		Long value = me.getValue();
		if("Bell".equals(key))
			return gc.new Bell(value);
		if("LightOn".equals(key))
			return gc.new LightOn(value);
		if("LightOff".equals(key))
			return gc.new LightOff(value);
		if("WaterOn".equals(key))
			return gc.new WaterOn(value);
		if("WaterOff".equals(key))
			return gc.new WaterOff(value);
		if("ThermostatDay".equals(key))
			return gc.new ThermostatDay(value);
		if("ThermostatNight".equals(key))
			return gc.new ThermostatNight(value);
		return null;
	}
	public static void main(String[] args) {
		args = new String[] {"200000000"};
		GreenhouseControls gc = new GreenhouseControls();
		//Instead of hard-writing,you could parse configuration information from a text file here:
		try {
			//Read text and convert lines to map entries:
			Map<String,Long> map = readEvents("E:\\学习\\thinkInJava_at_git\\javaIOSystem\\src\\practices\\Events.txt");
			Event[] eventList = new Event[map.size()];
			int i = 0;
			//Make evnets from map and add to Event array:
			for(Map.Entry<String, Long> me : map.entrySet()) {
				eventList[i++] = makeEvent(gc,me);
			}
			gc.addEvent(gc.new Restart(2000,eventList));
			if(args.length != 1) {
				System.out.println("Usage: enter integer terminate time");
				System.exit(0);
			}
			if(args.length == 1)
				gc.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
			gc.run();
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}
