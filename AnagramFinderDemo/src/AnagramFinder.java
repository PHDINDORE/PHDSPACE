import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class AnagramFinder {
private HashMap<String , List<String>> anagramMap;
AnagramFinder()
{
	anagramMap = new HashMap<String, List<String>>();
}
public void angramFinder(String line){
	String[] sentences = new String[20];
	String[] words = new String [50];
	String[] commaSplit = new String[50];
		if(line!=null){
			sentences = line.split("\\.");
			for(int i=0;i<sentences.length;i++)
			{
				commaSplit = sentences[i].split(",");
				for(int j=0;j<commaSplit.length;j++)
				{
					words = commaSplit[j].split(" ");
					sorting(words);
				}
			}
		}
		
	
}

public void sorting(String[] words){
	for(int i=0;i<words.length;i++)
	{
		char[] charArrayForWord = words[i].toCharArray();
		Arrays.sort(charArrayForWord);
		String word = new String(charArrayForWord);
		if(!anagramMap.containsKey(word))
			anagramMap.put(word, new ArrayList<String>());
		anagramMap.get(word).add(words[i]);
	}
}
public HashMap<String, List<String>> getAnagramMap() {
	return anagramMap;
}

public void setAnagramMap(HashMap<String, List<String>> anagramMap) {
	this.anagramMap = anagramMap;
}

}
