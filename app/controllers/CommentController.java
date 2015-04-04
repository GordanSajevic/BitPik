package controllers;

import helpers.SessionHelper;

import java.util.Date;

import models.Comment;
import models.User;
import play.data.Form;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;

public class CommentController extends Controller{

	static Form<Comment> postComment = new Form<Comment>(Comment.class);
	static String usernameSes;
	private static final String SESSION_USERNAME = "username";
	
	/**
	 * @param args
	 */
	public static Result addComment(int id)
	{
		User u = SessionHelper.getCurrentUser(ctx());
		usernameSes = session(SESSION_USERNAME);
		if(u.equals(null))
		{
			return redirect(routes.Application.index());
		}
		String content;
		Date date;
		try {
			content = postComment.bindFromRequest().get().content;
			date = postComment.bindFromRequest().get().createdAt;
		} catch (Exception e) {
			flash("add_comment_fail", Messages.get("Greška. Niste postavili komentar."));
			return redirect(routes.ProductController.showProduct(id));
		}
		Comment newComment = Comment.create(content, date, u);
		newComment.save();
		flash("add_comment_success", Messages.get("Uspješno ste dodali komentar."));
		return redirect(routes.ProductController.showProduct(id));
	}
	
	public static Result editComment(int idComment, int idProduct)
	{
		User u = SessionHelper.getCurrentUser(ctx());
		usernameSes = session(SESSION_USERNAME);
		Comment comment = Comment.find(idComment);
		if(!comment.author.equals(u))
		{
			return redirect(routes.Application.index());
		}
		String content;
		Date date;
		
		try {
			content = postComment.bindFromRequest().get().content;
			date = postComment.bindFromRequest().get().createdAt;
		} catch (Exception e) {
			flash("update_comment_fail", Messages.get("Greška. Niste izmijenili komentar."));
			return redirect(routes.ProductController.showProduct(idProduct));
		}
		comment.setContent(content);
		comment.setCreatedAt(date);
		flash("update_comment_success", Messages.get("Uspješno ste izmijenili komentar."));
		
		return redirect(routes.ProductController.showProduct(idProduct));
	}
	
	public static Result deleteComment(int idComment, int idProduct)
	{
		User u = SessionHelper.getCurrentUser(ctx());
		usernameSes = session(SESSION_USERNAME);
		Comment comment = Comment.find(idComment);
		if(!comment.author.equals(u))
		{
			return redirect(routes.Application.index());
		}
		Comment.delete(idComment);
		flash("delete_comment", Messages.get("Uspješno ste obrisali komentar."));
		return redirect(routes.ProductController.showProduct(idProduct));
	}
	

}
