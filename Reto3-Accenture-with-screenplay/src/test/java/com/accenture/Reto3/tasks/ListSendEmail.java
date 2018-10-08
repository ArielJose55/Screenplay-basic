package com.accenture.Reto3.tasks;

import com.accenture.Reto3.ui.WriteEmailPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class ListSendEmail implements Task{

	@Step("Open view of sent emails")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(WriteEmailPage.EMAILS_SEND));
	}
	
	public static ListSendEmail clickOnSendEmail() {
		return new ListSendEmail();
	}
}
