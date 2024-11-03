package ood2.io.exercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class IOExercise2and3 implements ReadFile {
	String fileName = "User_registration";
	List<String> lines = new ArrayList<>();

	@Override
	public List<String> read() {
		try {
			int countE = 0;
			Reader reader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = bufferedReader.readLine();
			System.out.println(line);

			while (line != null) {
				lines.add(line);
				line = bufferedReader.readLine();
				System.out.println(line);
			}
			for (int i = 0; i < lines.size(); i++) {
				char[] temp = lines.get(i).toCharArray();
				for (int j = 0; j < temp.length; j++) {
					if (temp[j] == 'e') {
						countE += 1;
					}
				}
			}
			bufferedReader.close();
			System.out.println(countE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void write(String line) {
		try {
			Writer writer = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write(line);
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
