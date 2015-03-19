package models;

import helpers.HashHelper;

import java.util.List;

import models.*;

import org.junit.*;

import controllers.FAQController;
import controllers.UserController;
import play.test.WithApplication;
import static org.junit.Assert.*;
import static play.test.Helpers.*;

public class ModelsTest extends WithApplication {
	@Before
	public void setUp() {
		fakeApplication(inMemoryDatabase());
	}
	
//	@Test
//	public void testCreateUser() {
//		User.createSaveUser("neko", "12345","neko@gmail.com");
//		User u = User.find(2);
//		String hashedPass=HashHelper.createPassword("12345");
//		assertNotNull(u);
//		assertEquals(u.username, "neko");
//		assertEquals(u.password, hashedPass);
//		assertEquals(u.email, "neko@gmail.com");
//
//	}
	/*
	@Test
	public void testFindNonExistingUser() {
		User u = User.find(1000);
		
		assertNull(u);
	}
	
	@Test
	public void testDeleteUser() {
		User.createSaveUser("neko", "12345","neko@gmail.com");
		User.delete(2);
		User b = User.find(2);
		assertNull(b);
	}
	
	@Test
	public void testCreateProduct() {
		User.createSaveUser("neko", "12345","neko@gmail.com");
		User u = User.find(2);
		Product.create("product1", "product1 description", 100.00, "kompjuteri", "sarajevo", u);
		Product p=Product.find.byId(1);
		assertNotNull(p);
		assertEquals(p.name, "product1");
		assertEquals(p.desc, "product1 description");
		assertEquals(p.price, 100,00);
		assertEquals(p.category, "kompjuteri");
		assertEquals(p.availability, "sarajevo");
	}
	
	@Test
	public void testFindNonExistingProduct() {
		Product p = Product.find.byId(100);
		assertNull(p);
	}
	
	@Test
	public void testDeleteProduct() {
		User.createSaveUser("neko", "12345","neko@gmail.com");
		User u = User.find(2);
		Product.create("product1", "product1 description", 100.00, "kompjuteri", "sarajevo", u);
		Product.delete(1);
		Product p=Product.find.byId(1);
		assertNull(p);
	}
	
//	
//	
//	@Test
//	public void testIsNotAdmin() {
//		User.createSaveUser("neko", "12345","neko@gmail.com");
//		User u = User.find(2);
//		//String hashedPass=HashHelper.createPassword("12345");
//		assertNotNull(u);
//		//assertEquals(u.username, "neko");
//		assertEquals(u.isAdmin, false);
//		//UserController.changeAdmin(2);
//		//assertEquals(u.isAdmin, true);
//	//	assertEquals(u.email, "neko@gmail.com");
//
//	}
//	*/
	/*
	@Test
	public void testIsAdmin() {
		User.createSaveUser("neko", "12345","neko@gmail.com");
		User u = User.find(2);
		//String hashedPass=HashHelper.createPassword("12345");
		assertNotNull(u);
		Product.create("product1", "product1 description", 100.00, "kompjuteri", "sarajevo", u);
		Product p=Product.find.byId(1);
		assertNotNull(p);
	//	assertEquals(u.username, "neko");
		assertEquals(u.isAdmin, false);
		u.setAdmin(true);
		assertEquals(u.isAdmin, true);
	//	assertEquals(u.email, "neko@gmail.com");
	
	public void testEditUser(){
		User.createSaveUser("neko", "12345","neko@gmail.com");
		User u = User.find(2);
		assertNotNull(u);
		UserController.editUser(u.id);
		UserController.saveEditedUser(u.id);
		assertEquals(u.username, "JohnDoe");
		assertEquals(u.email, "johndoe@example.com");
		assertEquals(u.password, "johndoe");
		assertEquals(u.isAdmin, false);
	}
	
	public void testMailVerification(){
		User.createSaveUser("neko", "12345","neko@gmail.com");
		User u = User.find(2);
		assertNotNull(u);
		UserController.confirmEmail(u.confirmation);
		assertEquals(u.verified, true);
	}
	
	
	public void testChangePassword(){
		User.createSaveUser("neko", "12345","neko@gmail.com");
		User u = User.find(2);
		assertNotNull(u);
		UserController.changePassword(u.id);
		assertEquals(u.password, "johndoe");
	}
	
	
	
	public void testDeleteFaq(){
		FAQ.create("pitanje", "odgovor");
		FAQ f = FAQ.finder(6);
		assertNotNull(f);
		FAQController.deleteFaq(6);
		assertNull(f);
	}
	*/
}
