package DataGet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import Model.Appointment;
import Model.Comment;

public class WriteToFile {

	FileWriter fileWriter;
	BufferedWriter bWriter;
	File file;

	public void writeToFile(String FILE_NAME, String write) throws Exception {
		file = new File(FILE_NAME);
		if (!file.exists())
			file.createNewFile();
		fileWriter = new FileWriter(file, true);
		bWriter = new BufferedWriter(fileWriter);
		bWriter.write('\n');
		bWriter.write(write);
		bWriter.close();
	}
	public void writeToLoggedUserFile(String FILE_NAME, String write) throws Exception {
		file = new File(FILE_NAME);
		file.createNewFile();
		fileWriter = new FileWriter(file, false);
		bWriter = new BufferedWriter(fileWriter);
		bWriter.write(write);
		bWriter.close();
	}
	public void writeLanguage(String write) throws Exception{
		file = new File("C:/eclipseworkspace/SEN302/src/Datalar/Language.txt");
		file.createNewFile();
		fileWriter = new FileWriter(file, false);
		bWriter = new BufferedWriter(fileWriter);
		bWriter.write(write);
		bWriter.close();
	}
	public void writeAppointment(Appointment app) throws Exception{
		file = new File("C:/eclipseworkspace/SEN302/src/Datalar/Appointment.txt");
		if (!file.exists())
			file.createNewFile();
		fileWriter = new FileWriter(file, true);
		bWriter = new BufferedWriter(fileWriter);
		bWriter.write('\n');
		bWriter.write(app.toString());
		bWriter.close();
	}
	public void writeComment(Comment app) throws Exception{
		file = new File("C:/eclipseworkspace/SEN302/src/Datalar/Comment.txt");
		if (!file.exists())
			file.createNewFile();
		fileWriter = new FileWriter(file, true);
		bWriter = new BufferedWriter(fileWriter);
		bWriter.write('\n');
		bWriter.write(app.toString());
		bWriter.close();
	}
}
