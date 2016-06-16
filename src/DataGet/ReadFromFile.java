package DataGet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFromFile {
	File f;
	FileInputStream input;

	public String readAllText(String FILE_NAME) {
		String fileContent = "";
		try {
			f = new File(FILE_NAME);
			input = new FileInputStream(f);
			byte[] bf = new byte[(int) f.length()];
			input.read(bf);
			fileContent = new String(bf, "UTF-8");
		} catch (FileNotFoundException e) {
			System.out.println("not found");
		} catch (IOException e) {
			System.out.println("baska");
		}
		return fileContent;
	}

}
