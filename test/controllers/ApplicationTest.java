package controllers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import models.MainCategory;
import models.Product;
import models.User;

import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

public class ApplicationTest {
	
	@Before
	public void setUp() {
		fakeApplication(inMemoryDatabase());
	}	
    
    @Test
	public void test() {
		running(testServer(3333, fakeApplication(inMemoryDatabase())),
				HTMLUNIT, new Callback<TestBrowser>() {
					public void invoke(TestBrowser browser) {
						browser.goTo("http://localhost:3333");
						assertThat(browser.pageSource()).contains("BitPik");
						assertThat(browser.pageSource()).contains("Login");
						assertThat(browser.pageSource()).contains("Registracija");

					}
				});
	}
    
	@Test
	public void testRegistration() {
		running(testServer(3333, fakeApplication(inMemoryDatabase())),
				HTMLUNIT, new Callback<TestBrowser>() {
					public void invoke(TestBrowser browser) {
						browser.goTo("http://localhost:3333/registration");
						browser.fill("#username").with("test");
						browser.fill("#password").with("testPass");
						browser.fill("#email").with("test@test.ba");
						browser.submit("#nameForm");
						User user = User.finder("test");
						user.verified = true;
						assertThat(browser.pageSource()).contains("BitPik");
						assertThat(browser.pageSource()).contains("mail");						
					}
				});
	}
	
	@Test
	public void testLogin() {
		running(testServer(3333, fakeApplication(inMemoryDatabase())),
				HTMLUNIT, new Callback<TestBrowser>() {
					public void invoke(TestBrowser browser) {
						browser.goTo("http://localhost:3333/login");
						browser.fill("#username").with("admin");
						browser.fill("#password").with("admin");
						browser.submit("#nameForm");
						assertThat(browser.pageSource()).contains("BitPik");
						assertThat(browser.pageSource()).contains("Objavite oglas");
						assertThat(browser.pageSource()).contains("Korisnik");
						assertThat(browser.pageSource()).contains("Logout");
						
					}
				});
	}
	
	@Test
	public void testLogout() {
		running(testServer(3333, fakeApplication(inMemoryDatabase())),
				HTMLUNIT, new Callback<TestBrowser>() {
					public void invoke(TestBrowser browser) {
						browser.goTo("http://localhost:3333/login");
						browser.fill("#username").with("admin");
						browser.fill("#password").with("admin");
						browser.submit("#nameForm");
						browser.goTo("http://localhost:3333/logout");
						assertThat(browser.pageSource()).contains("BitPik");
						assertThat(browser.pageSource()).contains("Login");
						assertThat(browser.pageSource()).contains("Registracija");
						
					}
				});
	}
	
}
