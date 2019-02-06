package com.TL.Utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;


public class CsvReader {
	
	public String path;
	public File inputFile;
	
	public CsvReader(String path){
		this.path = path; 
		 inputFile = new File(path);
		
		
	}
	
		public static String name;
		
		//scan file data
		public static String Scanner1(String path) throws FileNotFoundException {
		
			  int index = 0;
				Scanner dataScanner = null;
				Scanner scanner = new Scanner(new File(path));	
			while (scanner.hasNextLine()) {
				dataScanner = new Scanner(scanner.nextLine());
				dataScanner.useDelimiter(",");

				while (dataScanner.hasNext()) {
					String data = dataScanner.next();
					System.out.println(data);
					
					if (index == 0)
						System.out.println(data);
					else
						System.out.println("invalid data::" + data);
					index++;  
				}				

			scanner.close();	
			}
			return name;
		}
		
		
		public String read_csv(int row, int col)throws IOException {
						 
			// Read existing file 
			CSVReader reader = new CSVReader(new FileReader(path));
			//String[] res = reader.readNext();
			List<String[]> csvBody = reader.readAll();
		
			// get CSV row column  and replace with by using row and column
			String name = csvBody.get(row)[col];		
		
		reader.close();
		return name;
		
		}
		
		
		
		public void update_csv(int row, int col, String replace) throws IOException {
			
			// Read existing file 
			CSVReader reader = new CSVReader(new FileReader(path));
			//String[] res = reader.readNext();
			List<String[]> csvBody = reader.readAll();
		
			// get CSV row column  and replace with by using row and column
			csvBody.get(row)[col]  = replace;
			
			
		reader.close();

			// Write to CSV file which is open
			CSVWriter writer = new CSVWriter(new FileWriter(path), CSVWriter.DEFAULT_SEPARATOR,
				    CSVWriter.NO_QUOTE_CHARACTER,
				    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
				    CSVWriter.RFC4180_LINE_END);
			
			writer.writeAll(csvBody);
			writer.flush();
			writer.close();
			
										 				
		}
		
		public static String[] parseCSVLine(String line) {
		    // Create a pattern to match breaks
		    Pattern p =
		        Pattern.compile(",(?=([^\"]*\"[^\"]*\")*(?![^\"]*\"))");
		    // Split input with the pattern
		    String[] fields = p.split(line);
		    for (int i = 0; i < fields.length; i++) {
		        // Get rid of residual double quotes
		        fields[i] = fields[i].replace("\"", "");
		    }
		    return fields;
		}
		
		
}
