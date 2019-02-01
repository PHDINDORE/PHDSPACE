import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileInputStream inputStream  = new FileInputStream("src/test_file.txt");
			BufferedReader buf = new BufferedReader(new InputStreamReader(inputStream));
			String word=null;
			AnagramFinder finder = new AnagramFinder();
			Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();
			do{
				word=buf.readLine();
				finder.angramFinder(word);
			}while(word!=null);
			anagramMap = finder.getAnagramMap();
			for(String key: anagramMap.keySet())
			{
				List<String> anagramList = new ArrayList<String>();
				anagramList = anagramMap.get(key);
				for(String anagram : anagramList)
					System.out.print(anagram+",");
				System.out.print(anagramList.size()+"\n");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
