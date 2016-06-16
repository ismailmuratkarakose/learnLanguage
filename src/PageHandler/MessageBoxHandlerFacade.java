package PageHandler;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class MessageBoxHandlerFacade {

	public void showErrorMessage(boolean event, String path, String message) {
		if (event) {
			ExternalContext context1 = FacesContext.getCurrentInstance().getExternalContext();
			try {
				context1.redirect(context1.getRequestContextPath() + path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			FacesContext.getCurrentInstance().addMessage("MessageId",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", message));
		}
	}

	public void succesfulMessage(String firstname, String lastname) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(firstname + " " + lastname + "Welcome to Learn Language  "));
	}

}
