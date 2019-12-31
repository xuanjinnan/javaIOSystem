package examples;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.TreeMap;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

public class Test32 {

	public static void main(String[] args) throws IOException {
		TreeMap<String,Integer> map = new TreeMap<String,Integer>();
		TextFile words = new TextFile("src\\examples\\Test32.java","\\W+");
		words.add("packet");
		words.add("public");
		for (String word : words) {
			if( map.containsKey(word)){
				map.put(word, map.get(word) + 1);
			}else{
				map.put(word, 1);
			}
		}
		System.out.println(map);
		FileOutputStream out = new FileOutputStream("test32.xml");
		Element root = new Element("root");
		for(String word : map.keySet()){
			Element wordCount = new Element("wordCount");
			Element word_ = new Element("word");
			word_.appendChild(word);
			Element count = new Element("count");
			count.appendChild(String.valueOf(map.get(word)));
			wordCount.appendChild(word_);
			wordCount.appendChild(count);
			root.appendChild(wordCount);
		}
		Document doc = new Document(root);
		Serializer serializer = new Serializer(out,"ISO-8859-1");
		serializer.setIndent(4);
		serializer.setMaxLength(60);
		serializer.write(doc);
		serializer.flush();
		out.close();
	}

}
