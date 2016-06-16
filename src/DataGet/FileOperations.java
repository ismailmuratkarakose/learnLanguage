package DataGet;

import java.io.File;
import java.util.Scanner;

public class FileOperations {
	Scanner inputFile;
	File myFile;
	private String[] lines;

	public String[] read(File myFile) throws Exception {
		lines = null;
		inputFile = new Scanner(myFile);
		while (inputFile.hasNext()) {
			int i = 0;
			lines[i] = inputFile.nextLine();
			i++;
		}
		inputFile.close();
		return lines;
	}

}
