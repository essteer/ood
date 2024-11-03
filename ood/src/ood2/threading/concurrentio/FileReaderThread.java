package ood2.threading.concurrentio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderThread extends Thread {
	
	private AverageCalculator averageCalculator;
	private String fileName;
	
	public FileReaderThread(AverageCalculator averageCalculator, String fileName) {
		this.averageCalculator = averageCalculator;
		this.fileName = fileName;
	}
	
	@Override
	public void run() {
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(this.fileName));
     		String line = bufferedReader.readLine();
     		
     		while (line != null) {
     			String[] values = line.split(",");
     			for (String value : values) {
     				int numericValue = Integer.valueOf(value);
     				this.averageCalculator.addToTotal(numericValue);
     			}
     			line = bufferedReader.readLine();
     		}
     		bufferedReader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
