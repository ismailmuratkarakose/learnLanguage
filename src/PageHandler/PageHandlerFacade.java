package PageHandler;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class PageHandlerFacade {

	public void goToLanguageEducationPage() {
		ExternalContext context1 = FacesContext.getCurrentInstance().getExternalContext();

		try {
			context1.redirect(context1.getRequestContextPath() + "/LanguageEducation.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void goToProfilePage() {
		ExternalContext context1 = FacesContext.getCurrentInstance().getExternalContext();

		try {
			context1.redirect(context1.getRequestContextPath() + "/Profile.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void goToIndexPage() {
		ExternalContext context1 = FacesContext.getCurrentInstance().getExternalContext();

		try {
			context1.redirect(context1.getRequestContextPath() + "/index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void goToRegisterPage() {
		ExternalContext context1 = FacesContext.getCurrentInstance().getExternalContext();

		try {
			context1.redirect(context1.getRequestContextPath() + "/register.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void gotoTheTestPage() {
		ExternalContext context1 = FacesContext.getCurrentInstance().getExternalContext();

		try {
			context1.redirect(context1.getRequestContextPath() + "/TestQuestions.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void gotoTheLanguagePage() {
		ExternalContext context1 = FacesContext.getCurrentInstance().getExternalContext();

		try {
			context1.redirect(context1.getRequestContextPath() + "/language.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
