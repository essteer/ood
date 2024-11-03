package ood2.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CharacterCounter {
	
	
	private int countCharacterOccurrences(String character, List<String> linesList) {
		int numberOfOccurrences = 0;
		
		for (String line : linesList) {
			char[] lineArray = line.toLowerCase().toCharArray();
			for (int i=0; i<lineArray.length; i++) {
				if ((lineArray[i] + "").equals(character)) {
					numberOfOccurrences ++;
				}
			}
		}
		return numberOfOccurrences;
	}
	
	
	public int countCharacterInFile(String character, String filepath) throws FileNotFoundException, IOException {
		
		int characterCount = 0;
		try {
			List<String> fileLines = new ArrayList<>();
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
     		String line = bufferedReader.readLine();
     		
     		while (line != null) {
     			fileLines.add(line);
     			line = bufferedReader.readLine();
     		}
     		bufferedReader.close();
     		
     		characterCount = countCharacterOccurrences(character, fileLines);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return characterCount;
	}

}
