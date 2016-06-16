package DataGet;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import Model.Word;

public class GeneralWordFacade {
	GeneralLanguageFacade generalLanguageFacade;
	Word word;
	String FILE_NAME = "";
	ReadFromFile read = new ReadFromFile();
	String fileContent = "";

	public GeneralWordFacade() {
		generalLanguageFacade = new GeneralLanguageFacade();
		boolean language = generalLanguageFacade.readLanguage();
		if (language) {
			FILE_NAME = "C:/eclipseworkspace/SEN302/src/Datalar/EnglishWord.txt";
		} else {
			FILE_NAME = "C:/eclipseworkspace/SEN302/src/Datalar/FrenchWord.txt";
		}
		fileContent = read.readAllText(FILE_NAME);
	}

	public Word getWord(int indexOfWord) throws Exception {
		String[] lines = fileContent.split("\\n");
		String[] line = lines[indexOfWord].split(Pattern.quote("*"));
		return word = new Word(line[0], line[1], line[2], line[3], line[4]);
	}

	public List<Word> getWordsByLevel(String level) throws Exception {
		List<Word> resultList = new ArrayList<Word>();
		switch (Integer.parseInt(level)) {
		case 1:
			for (int i = 0; i < 6; i++) {
				Word word = getWord(i);
				resultList.add(word);
			}
			break;
		case 2:
			for (int i = 5; i < 11; i++) {
				Word word = getWord(i);
				resultList.add(word);
			}
			break;
		case 3:
			for (int i = 10; i < 16; i++) {
				Word word = getWord(i);
				resultList.add(word);
			}
			break;
		case 4:
			for (int i = 15; i < 21; i++) {
				Word word = getWord(i);
				resultList.add(word);
			}
			break;
		case 5:
			for (int i = 20; i < 26; i++) {
				Word word = getWord(i);
				resultList.add(word);
			}
			break;
		}

		return resultList;
	}

}
