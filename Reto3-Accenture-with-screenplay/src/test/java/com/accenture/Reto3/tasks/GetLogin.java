package com.accenture.Reto3.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import com.accenture.Reto3.models.User;
import com.accenture.Reto3.ui.GmailPage;

public class GetLogin implements Task {

    private final User user;

    protected GetLogin(User user) {
        this.user = user;
    }

    @Step("Search for #searchTerm")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user.getEmail())
                     .into(GmailPage.FIELD_EMAIL)
                     .thenHit(ENTER),
                Enter.theValue(user.getPassword())
                     .into(GmailPage.FIELD_PASSWORD)
                     .thenHit(ENTER)  
        );
    }

    public static GetLogin withTheCredentialsOf(User user) {
        return instrumented(GetLogin.class, user);
    }

}
