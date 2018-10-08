package com.accenture.Reto3.main;

import net.serenitybdd.junit.runners.SerenityRunner;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.accenture.Reto3.models.Person;
import com.accenture.Reto3.models.User;
import com.accenture.Reto3.questions.VerifyEmailSend;
import com.accenture.Reto3.tasks.GetLogin;
import com.accenture.Reto3.tasks.ListSendEmail;
import com.accenture.Reto3.tasks.OpenTheApplication;
import com.accenture.Reto3.tasks.SendEmail;
import com.accenture.Reto3.util.ReaderExcel;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.*;
 

@RunWith(SerenityRunner.class)
public class RunTestChallengeThree {

	private Actor ariel = Actor.named("Ariel");
	private final User user;
	private ReaderExcel reader;
	
	public RunTestChallengeThree() {
		this.user = new User();
		try {
			this.reader = new ReaderExcel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Error al leer archivo excel");
			System.exit(0);
		}
	}
	
	@Managed(driver = "chrome")
	public WebDriver hirBrowser;
	
	@Steps
	OpenTheApplication openTheApplication;
	
	@Before
    public void arielCanBrowseTheWeb() {
		ariel.can(BrowseTheWeb.with(hirBrowser));
    }
	
	
	@Test
    public void open_page_and_get_login() {
		givenThat(ariel).wasAbleTo(openTheApplication);
		
		when(ariel).attemptsTo(GetLogin.withTheCredentialsOf(user));
		
//		for(Person person : reader.getData()) {
//			when(ariel).attemptsTo(SendEmail.sendEmailToPerson(person));
//		}
		
		when(ariel).attemptsTo(ListSendEmail.clickOnSendEmail());
		
		VerifyEmailSend ve = VerifyEmailSend.verified();
		
		
		then(ariel).should(seeThat(ve, contains("Para: nilson.nieto", "Para: ricardo.diaz")));
		
		for(String p : ve.list) {
			System.out.println(p);
		}
	}
}
