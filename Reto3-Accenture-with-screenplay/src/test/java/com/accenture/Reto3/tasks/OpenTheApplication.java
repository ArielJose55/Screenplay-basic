package com.accenture.Reto3.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import com.accenture.Reto3.ui.GmailPage;

public class OpenTheApplication implements Task {


	private GmailPage youtubePage;
	
    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(youtubePage)
        );
    }
}
