package core.ui;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("http://www.gmail.com")
public class GmailPage extends PageObject{
	public static Target FIELD_EMAIL = Target.the("field email").located(By.xpath("//input[@type='email' and @name='identifier']"));
	public static Target FIELD_PASSWORD = Target.the("field password").located(By.xpath("//input[@type='password' and @name='password']"));
	public static Target CLICK = Target.the("search field").located(By.name("q"));
}
