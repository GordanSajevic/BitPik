import java.io.File;

import models.Blogger;
import models.FAQ;
import models.ImgPath;
import models.MainCategory;
import models.Product;
import models.SubCategory;
import models.User;
import play.Application;
import play.GlobalSettings;
import play.Logger;

public class Global extends GlobalSettings {

	@Override
	public void onStart(Application app) {
		Logger.info("Application start");
		if (User.finder("admin") == null) {
			// Administrator entry
			User ad = User
					.createAdmin("admin", "admin", "admin@admin.ba", true);
			ad.verified = true;
			ad.imagePath = "images/profilePicture/adminpic.png";
			ad.save();
			
			//Seller entry
			User seller = User.create("seller", "seller", "seller@seller.com");
			seller.verified = true;
			seller.imagePath = "images/profilePicture/sherlock.png";
			seller.save();
			
			//Buyer entry
			User buyer = User.create("buyer", "buyer", "buyer@buyer.com");
			buyer.verified = true;
			buyer.imagePath = "images/profilePicture/rust.png";
			buyer.save();
			
			//Blogger entry
			User blogger = User.create("blogger", "blogger", "blogger@blogger.com");
			blogger.verified = true;
			blogger.save();

			//Main Categories entry
			String[] categoryArray = {"Vozila", "Odjeća i obuća", "Kompjuteri", "Biznis i industrija",
					"Mobilni uređaji", "Moj dom", "Nekretnine", "Literatura", "Tehnika", "Sportska oprema",
					"Nakit i satovi", "Kolekcionarstvo", "Ljepota i zdravlje", "Životinje", "Video igre", "Ostalo"};
			
			for (int i = 0; i < categoryArray.length; i++) {
				MainCategory.createMainCategory(categoryArray[i]);
			}
			
			String[] vozilaSubCats = {"Dijelovi i oprema", "Automobili", "Motocikli", "Bicikli",
					"Teretna vozila", "Prikolice", "Nautika", "Autobusi i minibusi", "Kamperi", "Ostalo"};
			MainCategory mc1 = MainCategory.findMainCategory(1);
			for (int i = 0; i < vozilaSubCats.length; i++) {
				SubCategory.createSubCategory(vozilaSubCats[i], mc1);
			}
			
			String[] odjecaSubCats = {"Žene", "Muškarci", "Djevojčice", "Dječaci", "Unisex", "Ostalo"};
			MainCategory mc2 = MainCategory.findMainCategory(2);
			for (int i = 0; i < odjecaSubCats.length; i++) {
				SubCategory.createSubCategory(odjecaSubCats[i], mc2);
			}
			
			String[] kompSubCats = {"Kompjuterska oprema", "Laptopi", "Desktop računari", "Mreže i Komunikacije",
					"Softver", "Serveri", "Ostalo"};
			MainCategory mc3 = MainCategory.findMainCategory(3);
			for (int i = 0; i < kompSubCats.length; i++) {
				SubCategory.createSubCategory(kompSubCats[i], mc3);
			}
			
			String[] biznisSubCats = {"Mašine i alati", "Poljoprivreda", "Građevinarstvo", "Ugostiteljska oprema",
					"Servisi i usluge", "Trgovačka oprema", "Materijali, dijelovi i oprema", "Kancelarijski materijal",
					"Biznis i web stranice", "Oprema za zaštitu na radu", "Ostalo"};
			MainCategory mc4 = MainCategory.findMainCategory(4);
			for (int i = 0; i < biznisSubCats.length; i++) {
				SubCategory.createSubCategory(biznisSubCats[i], mc4);
			}
			
			String[] mobitelSubCats = {"Mobiteli", "Dijelovi i oprema", "Tablet PCs", "Bluetooth uređaji",
					"PDA i Pocket PCs", "Smartwatch (pametni satovi)", "Ostalo" };
			MainCategory mc5 = MainCategory.findMainCategory(5);
			for (int i = 0; i < mobitelSubCats.length; i++) {
				SubCategory.createSubCategory(mobitelSubCats[i], mc5);
			}
			
			String[] domSubCats = {"Namještaj", "Vrt biljke i vrtlarstvo", "Grijanje i hlađenje", "Dekoracije",
					"Prehrana i pića", "Stolarija", "Lampe i rasvjeta", "Kuhinja", "Sigurnosni uređaji", "Kupatilo",
					"Ćilimi, tepisi, etisoni i ostalo", "Sredstva i uređaji za čišćenje", "Tekstilni proizvodi",
					"Vodoistalacije i oprema", "Ostalo"};
			MainCategory mc6 = MainCategory.findMainCategory(6);
			for (int i = 0; i < domSubCats.length; i++) {
				SubCategory.createSubCategory(domSubCats[i], mc6);
			}
			
			String[] nekretnineSubCats = {"Stanovi", "Kuće", "Zemljišta", "Poslovni prostori", "Vikendice",
					"Apartmani", "Sobe", "Garaže", "Turistički smještaj", "Montažni objekti", "Ostalo"};
			MainCategory mc7 = MainCategory.findMainCategory(7);
			for (int i = 0; i < nekretnineSubCats.length; i++) {
				SubCategory.createSubCategory(nekretnineSubCats[i], mc7);
			}
			
			String[] literaturaSubCats = {"Knjige", "Stripovi", "E-Knjige", "Magazini", "Školski pribor",
					"Audioknjige", "Katalozi", "Ostalo"};
			MainCategory mc8 = MainCategory.findMainCategory(8);
			for (int i = 0; i < literaturaSubCats.length; i++) {
				SubCategory.createSubCategory(literaturaSubCats[i], mc8);
			}
			
			String[] tehnikaSubCats = {"Kamere i foto aparati", "Bijela tehnika", "TV (Televizori)", "Multimedija",
					"Mjerno-regulacioni instrumenti", "Medicinska oprema", "Satelitska oprema", "Video iPod i mp3 playeri",
					"Telekomunikacije", "Elektromaterijal", "Radio i walkman uređaji", "Kućna kina", "Radio amaterski uređaji",
					"DVD/Blu-ray player", "Ostalo"};
			MainCategory mc9 = MainCategory.findMainCategory(9);
			for (int i = 0; i < tehnikaSubCats.length; i++) {
				SubCategory.createSubCategory(tehnikaSubCats[i], mc9);
			}
			
			String[] sportSubCats = {"Vanjski sportovi", "Timski sportovi", "Fitness i trening", "Zimski sportovi",
					"Borilački sportovi", "Tenis", "Planinarenje i alpinizam", "Vodeni sportovi", "Ekstremni sportovi", "Ostalo"};
			MainCategory mc10 = MainCategory.findMainCategory(10);
			for (int i = 0; i < sportSubCats.length; i++) {
				SubCategory.createSubCategory(sportSubCats[i], mc10);
			}
			
			String[] nakitSubCats = {"Ručni satovi", "Lančići i ogrlice", "Naušnice", "Narukvice", "Prstenje", "Zlato i srebro",
					"Repromaterijal", "Privjesci", "Piercing nakit", "Džepni satovi", "Ostalo"};
			MainCategory mc11 = MainCategory.findMainCategory(11);
			for (int i = 0; i < nakitSubCats.length; i++) {
				SubCategory.createSubCategory(nakitSubCats[i], mc11);
			}
			
			String[] kolekcSubCats = {"Numizmatika", "Militarija", "Značke", "Filatelija", "Sličice i albumi", "Maketarstvo/modelarstvo",
					"Suveniri", "Razglednice", "Stare ulaznice", "Zastave", "Figurice", "Religija", "Salvete", "Telefonske kartice", "Ostalo"};
			MainCategory mc12 = MainCategory.findMainCategory(12);
			for (int i = 0; i < kolekcSubCats.length; i++) {
				SubCategory.createSubCategory(kolekcSubCats[i], mc12);
			}
			
			String[] ljepotaSubCats = {"Parfemi", "Njega noktiju", "Zdravlje", "Koža i tijelo", "Šminka", "Njega kose i brade",
					"Naočale", "Oralna higijena", "Ostalo"};
			MainCategory mc13 = MainCategory.findMainCategory(13);
			for (int i = 0; i < ljepotaSubCats.length; i++) {
				SubCategory.createSubCategory(ljepotaSubCats[i], mc13);
			}
			
			String[] zivotinjeSubCats = {"Kućni ljubimci", "Domaće životinje", "Oprema", "Ostalo"};
			MainCategory mc14 = MainCategory.findMainCategory(14);
			for (int i = 0; i < zivotinjeSubCats.length; i++) {
				SubCategory.createSubCategory(zivotinjeSubCats[i], mc14);
			}
			
			String[] videoIgreSubCats = {"Igre", "Konzole", "Dijelovi i oprema", "Internet/browser igre", "Ostalo"};
			MainCategory mc15 = MainCategory.findMainCategory(15);
			for (int i = 0; i < videoIgreSubCats.length; i++) {
				SubCategory.createSubCategory(videoIgreSubCats[i], mc15);
			}
			
			MainCategory mc16 = MainCategory.findMainCategory(16);
			SubCategory.createSubCategory("Ostalo", mc16);
			
			// FAQ Entries;
			// the list of questions
			String[] questions = new String[] { 
					"Kako se registrovati?",
					"Kako objaviti proizvod?",
					"Kako obrisati proizvod?",
					"Kako editovati proizvod?",
					"Kako da vidim svoje podatke i gdje mogu vidjeti svoje proizvode?" };
			String[] answers = new String[] {
			// the list of adequate answers;
					"Kliknite na REGISTRACIJA, nakon toga popunite formular sa Vašim podacima i kliknite REGISTRUJ. Tad vam je proslijeđen mail sa konfirmacijskim linkom, kojeg kliknete, i time ste se registrovali.",
					"Nakon registracije, kliknete na dugme OBJAVITE OGLAS. Zatim popunite podatke o Vašem proizvodu kojeg objavljujete i kliknete na dugme OBJAVI. Te ste time uspješno objavili proizvod.",
					"Kliknite na artikl koji želite obrisati, i na desnoj strani će biti prikazano dugme IZBRIŠI PROIZVOD.",
					"Kliknite na artikl koji želite editovati, i na desnoj strani će biti prikazano dugme IZMIJENI ARTIKL. Popunite formular sa novim podacima i kliknite na dugme SPASI IZMJENE.",
					"Nakon što ste se registrovali i logovali na naš website, u gornjem desnom uglu će biti prikazano dugme KORISNIK i Vaš username. Kliknite na to dugme i to će vas odvesti na stranicu sa Vašim podacima i listom Vaših objavljenih proizvoda."
					};
			for (int i = 0; i < questions.length; i++) {
				FAQ.create(questions[i], answers[i]);
			}
			// Seller vec objavio WhiteChair product;
			MainCategory mc = MainCategory.findMainCategoryByName("Moj dom");
			SubCategory sc = SubCategory.findSubCategoryByName("Namještaj");
			Product p1 = Product.create("Stolica", "Stolica Bijela Nova", "Nova Stolica kupljena 2013, Savršena!", 70.00, seller, mc, sc, "Sarajevo","Novo","Da");
			p1.productImagePath = "images/productPicture/whitechair.jpg";
			p1.save();
			
			// Seller vec objavio MacBookPro product;
			MainCategory mcw2 = MainCategory.findMainCategoryByName("Kompjuteri");
			SubCategory scw2 = SubCategory.findSubCategoryByName("Laptopi");
			Product p2 = Product.create("Mac Book Pro 13", "Nov Mac Book Pro 13", "Savršen, Prelijep, Nov Mac Book Pro 13!", 3500.00, seller, mcw2, scw2, "Sarajevo","Novo","Ne");
			p2.productImagePath = "images/productPicture/macbookpro.jpg";
			p2.save();
			
			// Seller vec objavio Parfem product;
			MainCategory mcw3 = MainCategory.findMainCategoryByName("Ljepota i zdravlje");
			SubCategory scw3 = SubCategory.findSubCategoryByName("Parfemi");
			Product p3 = Product.create("Gucci Parfem", "Nov Gucci Parfem", "Nov Gucci Parfem, Pour Home", 120.00, seller, mcw3, scw3, "Sarajevo","Novo","Ne");
			p3.productImagePath = "images/productPicture/gucciperfume.jpg";
			p3.save();
			
			// Seller vec objavio MacBookPro product;
			MainCategory mcw4 = MainCategory.findMainCategoryByName("Mobilni uređaji");
			SubCategory scw4 = SubCategory.findSubCategoryByName("Mobiteli");
			Product p4 = Product.create("iPhone 6", "iPhone 6", "iPhone 6 - Dual-core 1.4 GHz Cyclone", 900.00, seller, mcw4, scw4, "Sarajevo","Korišteno","Da");
			p4.productImagePath = "images/productPicture/iphone6.jpg";
			p4.save();
			
			// Prodavac published the ikea Lamp product;
			SubCategory lamps = SubCategory.findSubCategoryByName("Lampe i rasvjeta");
			Product p5 = Product.create("Ikea Lampa", "Ikea Lampa 2013", "Nova Ikea Lampa - Proizvodnja 2013 godina", 60.00, seller, mc, lamps, "Mostar","Novo","Da");
			p5.productImagePath = "images/productPicture/ikealamp.jpg";
			p5.save();
			
			// Prodavac published the headphones product;	
			MainCategory tehnika = MainCategory.findMainCategoryByName("Tehnika");
			SubCategory multimedija = SubCategory.findSubCategoryByName("Multimedija");
			Product p6 = Product.create("Slušalice", "Crne slušalice", "Bass slušalice, Sensibilitet: 95 -3dB, Frek.: 20-2000Hz ", 50.00, seller, tehnika, multimedija, "Mostar","Korišteno","Ne");
			p6.productImagePath = "images/productPicture/headphones.jpg";
			p6.save();
			
			// Prodavac published the tires and rims product;	
			MainCategory vozilad = MainCategory.findMainCategoryByName("Vozila");
			SubCategory doo = SubCategory.findReturnSubCategoryByNameAndMainCategory("Dijelovi i oprema", vozilad);
			Product p7 = Product.create("Felge i Gume", "Felge 19 incha i Gume", "Rally Gume, Širina: 30mm, Heksagonalna dužina: 12mm, Težina: 139g/4komada", 450.00, seller, vozilad, doo, "Mostar","Korišteno","Da");
			p7.productImagePath = "images/productPicture/rims.jpg";
			p7.save();
			
			// Prodavac published the red car toy product;	
			MainCategory sportsub = MainCategory.findMainCategoryByName("Sportska oprema");
			SubCategory wintersports = SubCategory.findReturnSubCategoryByNameAndMainCategory("Zimski sportovi", sportsub);
			Product p8 = Product.create("Snowboard", "Snow board 2012", "Snow board 2012 - Lijep dizajn od drveta", 250.00, seller, sportsub, wintersports, "Mostar","Novo","Ne");
			p8.productImagePath = "images/productPicture/snowboard.jpg";
			p8.save();
			
			MainCategory mainCat = MainCategory.findMainCategoryByName("Nekretnine");
			User realestate = User.createPikStore("Real Estate", "realestate", "realestate@realestate.com", "Real Estate Company d.o.o.", "Ferhadija 55", "Sarajevo",mainCat);
			realestate.isPikStore = true;
			realestate.verified = true;
			realestate.imagePath = "images/profilePicture/realestate.png";
			realestate.save();
			
			MainCategory mainCat2 = MainCategory.findMainCategoryByName("Sportska oprema");
			User sportshop = User.createPikStore("Sport Shop", "sportshop", "sportshop@sportshop.com", "Sport Shop Company d.o.o.", "Titova 33", "Sarajevo",mainCat2);
			sportshop.isPikStore = true;
			sportshop.verified = true;
			sportshop.imagePath = "images/profilePicture/sportshop.jpg";
			sportshop.save();
			
			User addidasShop = User.createPikStore("Addidas Sport Shop", "addidassportshop", "addidassportshop@addidassportshop.com", "Addidas Sport Shop d.o.o.", "Džemala Bijedića 18", "Sarajevo",mainCat2);
			addidasShop.isPikStore = true;
			addidasShop.verified = true;
			addidasShop.imagePath =  "images/profilePicture/adidasshop.jpg";
			addidasShop.save();
			
			MainCategory mainCat3 = MainCategory.findMainCategoryByName("Biznis i industrija");
			User eslc = User.createPikStore("Eslc", "eslc", "eslc@eslc.com", "English Skills Learning Center", "Safeta B. Bašagića 32", "Sarajevo", mainCat3);
			eslc.isPikStore = true;
			eslc.verified = true;
			eslc.imagePath = "images/profilePicture/ecls.jpg";
			eslc.save();

			Blogger b = new Blogger("BitPik Stranica", "Pokrenuta je BitPik stranica", "Nakon dugih 5 mjeseci, konacno, pokrenuta je Bitpik web stranica. Napravili su je skupina sjajnih Java Developera sa ciljem da prekinu dominaciju i monopol pik.ba sadasnjeg olx.ba, koja je kao sto znate veoma popularna bh. stranica. Skupina pomenutih Java Developera cine : Mirza Becic, Hikmet Durgutovic, Selma Tabakovic, Adnan Spahic, Gordan Sajevic i Nedzad Hamzic. ","BitCamp");

			b.setBlogImagePath("images/blogPicture/blogone.png");
			b.publishedDate = Blogger.getDate();
			b.save();
			
		}
		
	
		

	}
}