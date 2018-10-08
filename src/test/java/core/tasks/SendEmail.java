package core.tasks;

import static org.openqa.selenium.Keys.ENTER;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import core.models.Person;
import core.ui.WriteEmailPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class SendEmail implements Task{

	private final Person person;
	
	public SendEmail(Person person) {
		this.person = person;
	}
	
	
	@Step("Send email for #person")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Click.on(WriteEmailPage.WRITE_EMAIL),
				
                Enter.theValue(person.getEmail())
                     .into(WriteEmailPage.FIELD_EMAIL)
                     .thenHit(ENTER),
                Enter.theValue(person.getSubject().concat(" Para: ").concat(person.getName()))
                     .into(WriteEmailPage.FIELD_SUBJECT)
                     .thenHit(ENTER),
                Enter.theValue(person.getNote())
                     .into(WriteEmailPage.FIELD_NOTE)
                     .thenHit(ENTER),
                     
                Click.on(WriteEmailPage.SEND)
        );		
	}
	
	public static SendEmail sendEmailToPerson(Person person) {
		return instrumented(SendEmail.class, person);
	}
}
