package Model;

public class Comment {
	private String userName;
	private String comment;
	private String dateOfcomment;

	public String getUserName() {
		return userName;
	}

	public void setUser(String userName) {
		this.userName = userName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDateOfcomment() {
		return dateOfcomment;
	}

	public void setDateOfcomment(String dateOfcomment) {
		this.dateOfcomment = dateOfcomment;
	}

	public Comment(String userName, String comment, String dateOfcomment) {
		this.userName = userName;
		this.comment = comment;
		this.dateOfcomment = dateOfcomment;
	}

	@Override
	public String toString() {
		return userName + "*" + comment + "*" + dateOfcomment;
	}

}
