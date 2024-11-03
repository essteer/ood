package ood2.io.io;

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

public class UserProfile implements iInterface{
	String file_name="user_data.txt";
	List<String> lines=new ArrayList<>();
	
	@Override
	public List<String> read() {
		
		try {
			Reader reader=new FileReader(file_name);
			BufferedReader bufferedReader=new BufferedReader(reader);
			String line=bufferedReader.readLine();
			while(line!=null) {
				lines.add(line);
				line= bufferedReader.readLine();
				System.out.println(line);
			}
			bufferedReader.close();
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	@Override
	public void write(String line) {
		try {
			Writer writer=new FileWriter(file_name, true); //true to enable editing and enabling changes
			BufferedWriter bufferedWriter=new BufferedWriter(writer);
			bufferedWriter.write(line);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			bufferedWriter.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
