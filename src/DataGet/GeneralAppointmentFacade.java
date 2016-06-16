package DataGet;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import Model.Appointment;

public class GeneralAppointmentFacade {
	WriteToFile wr = new WriteToFile();
	private String FILE_NAME = "C:/eclipseworkspace/SEN302/src/Datalar/Appointment.txt";
	ReadFromFile read = new ReadFromFile();
	List<Appointment> appointmentList;
	public String fileContent = read.readAllText(FILE_NAME);
	Appointment appointment;

	public boolean createAppointment(Appointment appointment) {
		boolean res = false;
		for (Appointment temp : appointmentList) {
			if (!(temp.getDay().equals(appointment.getDay()) && temp.getStart().equals(appointment.getStart()))) {
				saveAppointment(appointment);
				res = true;
			} else
				res = false;
		}
		return res;
	}

	public void getAllAppointment() throws Exception {
		appointmentList = new ArrayList<Appointment>();
		String[] lines = fileContent.split("\\n");
		for (int i = 0; i < lines.length; i++) {
			String[] line = lines[i].split(Pattern.quote("*"));
			appointment = new Appointment(line[0], line[1], line[2], line[3], line[4]);
			appointmentList.add(appointment);
		}
	}

	public void saveAppointment(Appointment app) {
		try {
			wr.writeAppointment(app);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
