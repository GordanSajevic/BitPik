package controllers;

import helpers.HashHelper;
import models.*;
import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;

/**
 * 
 * @author Nermin Graca & Nedzad Hamzic & Neldin Dzekovic
 *
 */
public class UserController extends Controller {

	static Form<User> newUser = new Form<User>(User.class);
	

	/**
	 * Either directs to the index.html with the session name already logged in
	 * or directs to the index.html page with "Unknown" as username;
	 * 
	 * @return
	 */
	public static Result index() {
		String usernameSes = session("username");
		if (usernameSes == null) {
			usernameSes = "";
			return ok(index.render("Welcome to BitPik", usernameSes));
		} else {
			return ok(index.render("Welcome to BitPik", usernameSes));
		}
	}

	/**
	 * Renders the registration.html page;
	 * 
	 * @return
	 */
	public static Result registration() {
		String usernameSes = session("username");
		if (usernameSes == null) {
			usernameSes = "";
			return ok(registration.render(usernameSes, "", ""));
		} else {
			return ok(registration.render(usernameSes, "", ""));
		}
	}

	/**
	 * Renders the login.html page;
	 * 
	 * @return
	 */
	public static Result login() {
		String usernameSes = session("username");
		if (usernameSes == null) {
			usernameSes = "";
			return ok(login.render(usernameSes, "", ""));
		} else {
			return ok(login.render(usernameSes, "", ""));
		}
	}

	/**
	 * 1. Gets the username, password and email from the form from the
	 * Registration.html page; 2. If the username or email is already in our
	 * database, we redirect to the "/registration.html" 3. Creates the User
	 * using the User.create() method; 4. And redirects to the index.html page;
	 * 
	 * @return
	 */
	public static Result addUser() {
		String username = newUser.bindFromRequest().get().username;
		String password = newUser.bindFromRequest().get().password;
		String email = newUser.bindFromRequest().get().email;
		// Unique 'username' verification
		if (User.finder(username) != null) {
			return ok(registration.render("",
					"Username already taken, please choose another one", ""));
		}
		// Unique 'email' verification
		if (User.emailFinder(email)) {
			return ok(registration.render("", "",
					"Email already in use, please choose another one"));
		}
		User.createSaveUser(username, password, email);
		// automatically puts the 'username' created into the session variable;
		session("username", username);
		return redirect("/success");

	}

	/**
	 * 1. Gets the username and password from the form from the Login.html page;
	 * 2. The finder() method finds the User with the entered username; assigns
	 * to the User u; 3. If no User has been found, - redirecting to Failed.html
	 * page; 4. If the User has been found - Checks whether the password is
	 * correct; 5. If the password is wrong - redirecting to Failed.html page;
	 * 6. If the password is correct - redirecting to Success.html page; Note*
	 * Store the username in session variable if the Login is successful;
	 * 
	 * @return
	 */
	public static Result findUser() {
		String hashPass;
		String username = newUser.bindFromRequest().get().username;
		String password = newUser.bindFromRequest().get().password;
		User u = User.finder(username);
		if (u == null) {
			return ok(login.render("", "Username nonexisting", ""));
		} else {
			hashPass = u.password;
		}
		boolean userExists = HashHelper.checkPassword(password, hashPass);
		if (userExists == true) {
			// the username put in the session variable under the key
			// "username";
			session("username", username);
			return redirect("/success");
		} else {
			return ok(login.render("", "", "Password is wrong"));
		}
	}

	/**
	 * Redirects to the Success.html page with the session variables sent as
	 * parameters;
	 * 
	 * @return
	 */
	public static Result success() {
		String usernameSes = session("username");
		if (usernameSes == null) {
			usernameSes = "";
		}
		return ok(success.render(usernameSes));
	}

	/**
	 * @author Sanela Grcic & Nermin Graca Method Logout - clears current
	 *         session and redirects to index.html
	 * @return redirect to index.html
	 */
	public static Result logout() {
		session().clear();
		return redirect(routes.UserController.index());
	}

	
	public static Result profile(){
		String usernameSes = session("username");
		return ok(profile.render(usernameSes));		
	}
	
}
