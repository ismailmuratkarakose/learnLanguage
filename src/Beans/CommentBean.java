package Beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import DataGet.GeneralUsersFacade;
import DataGet.ReadFromFile;
import DataGet.WriteToFile;
import Model.Comment;
import Model.User;

@ManagedBean(name = "commentBean")
@ViewScoped
public class CommentBean {
	private String commentStr, tarih;
	private Comment comment;
	private List<Comment> commentList;
	private Date tar;

	private String FILE_NAME = "C:/eclipseworkspace/SEN302/src/Datalar/Comment.txt";
	ReadFromFile read = new ReadFromFile();
	public String fileContent = read.readAllText(FILE_NAME);

	GeneralUsersFacade generalUsersFacade = new GeneralUsersFacade();
	WriteToFile wr = new WriteToFile();
	private User currentUser;

	@PostConstruct
	public void init() {
		try {
			currentUser = generalUsersFacade.getLoggedUser();
			getAllComments();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void createComment() {

		tar = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		tarih = format.format(tar).toString();
		comment = new Comment(currentUser.getUserName(), commentStr, tarih);
		commentList.add(comment);
		try {
			wr.writeComment(comment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		commentStr = "";
		RequestContext.getCurrentInstance().update("form:comment");
		RequestContext.getCurrentInstance().update("form:list");
	}

	public void getAllComments() throws Exception {
		commentList = new ArrayList<Comment>();
		String[] lines = fileContent.split("\\n");
		for (int i = 0; i < lines.length; i++) {
			String[] line = lines[i].split(Pattern.quote("*"));
			comment = new Comment(line[0], line[1], line[2]);
			commentList.add(comment);
		}
	}

	public String getCommentStr() {
		return commentStr;
	}

	public void setCommentStr(String commentStr) {
		this.commentStr = commentStr;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public String getComment() {
		return commentStr;
	}

	public void setComment(String comment) {
		this.commentStr = comment;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

	public Comment getCmt() {
		return comment;
	}

	public void setCmt(Comment cmt) {
		this.comment = cmt;
	}

	public Date getTar() {
		return tar;
	}

	public void setTar(Date tar) {
		this.tar = tar;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

}
