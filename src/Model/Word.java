package Model;

public class Word {
	private String ID;
	private String word;
	private String mean;
	private String imagePath;
	private String sentence;
	
	public Word() {
	}
	public Word(String ID,String word, String mean, String imagePath,String sentence) {
		this.ID=ID;
		this.word = word;
		this.mean = mean;
		this.imagePath = imagePath;
		this.sentence=sentence;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMean() {
		return mean;
	}
	public void setMean(String mean) {
		this.mean = mean;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	@Override
	public String toString() {
		return "Word [ID=" + ID + ", word=" + word + ", mean=" + mean + ", imagePath=" + imagePath + ", sentence="
				+ sentence + "]";
	}
}
