package DataGet;

public class GeneralLanguageFacade {
	public void writeLanguage(String language) {
		WriteToFile wr = new WriteToFile();
		try {
			wr.writeLanguage(language);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean readLanguage(){
		//if english true
		ReadFromFile read = new ReadFromFile();
		String file=read.readAllText("C:/eclipseworkspace/SEN302/src/Datalar/Language.txt");
		if(file.startsWith("E"))
		return true;
		else
		return false;
	}

}
