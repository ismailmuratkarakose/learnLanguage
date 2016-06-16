package Beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import DataGet.GeneralAppointmentFacade;
import DataGet.GeneralUsersFacade;
import Model.Appointment;
import Model.User;
import PageHandler.PageHandlerFacade;

@ManagedBean(name = "appoitnmentBean")
@SessionScoped
public class AppoitnmentBean {
	private Date appointmentDate;
	private Date maxDate;
	private Date appointmentStartTime;
	private User user;
	private Date appointmentEndTime;
	private String studentName, studentLevel, selectedTeacher, date, start;
	private List<String> teacherList;
	GeneralUsersFacade generalUsersFacade = new GeneralUsersFacade();
	PageHandlerFacade pageHandlerFacade = new PageHandlerFacade();
	GeneralAppointmentFacade generalAppointmentFacade = new GeneralAppointmentFacade();

	public AppoitnmentBean() {

	}

	@PostConstruct
	public void initialize() {
		try {
			getUserLevel();
			teacherList = generalUsersFacade.getAllTeachers();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getUserLevel() throws Exception {
		user = generalUsersFacade.getLoggedUser();
		setStudentName(user.getUserName().toUpperCase());
		setStudentLevel(user.getLevel().toUpperCase());
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentLevel() {
		return studentLevel;
	}

	public void setStudentLevel(String studentLevel) {
		this.studentLevel = studentLevel;
	}

	public void testAppointmentDate(SelectEvent event) {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Randevu gunu:", format.format(event.getObject())));

	}

	public void testAppointmentStartTime(SelectEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Baslama Saati", format.format(event.getObject())));
	}

	public void testAppointmentEndTime(SelectEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Bitis Saati", format.format(event.getObject())));
	}

	public void continueButton() {
		pageHandlerFacade.goToProfilePage();

	}

	public void createAppointment() {
		try {
			generalAppointmentFacade.getAllAppointment();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm");
		Appointment appointment = new Appointment(format.format(appointmentDate).toString(),
				format2.format(appointmentStartTime).toString(), format2.format(appointmentEndTime).toString(),
				user.getUserName(), selectedTeacher);
		boolean event = generalAppointmentFacade.createAppointment(appointment);
		if (event) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Randevu Detaylari", " Randevu olusturuldu."));
			RequestContext.getCurrentInstance().update("form:randevuDialog");
			RequestContext.getCurrentInstance().execute("PF('randevuDialog').show()");
		} else
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Randevu detaylari!", "Baska bir saat secin"));
		setStart(appointment.getStart());
		setDate(appointment.getDay());
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Date getAppointmentStartTime() {
		return appointmentStartTime;
	}

	public void setAppointmentStartTime(Date appointmentStartTime) {
		this.appointmentStartTime = appointmentStartTime;
	}

	public Date getAppointmentEndTime() {
		return appointmentEndTime;
	}

	public void setAppointmentEndTime(Date appointmentEndTime) {
		this.appointmentEndTime = appointmentEndTime;
	}

	public Date getMaxDate() {
		return maxDate;
	}

	public List<String> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<String> teacherList) {
		this.teacherList = teacherList;
	}

	public String getSelectedTeacher() {
		return selectedTeacher;
	}

	public void setSelectedTeacher(String selectedTeacher) {
		this.selectedTeacher = selectedTeacher;
	}

	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

}
