package core.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class WriteEmailPage {
	
	public static Target WRITE_EMAIL = Target.the("write email").located(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']"));
	public static Target FIELD_EMAIL = Target.the("field email").located(By.xpath("//textarea[@name='to']"));
	public static Target FIELD_SUBJECT = Target.the("field subject").located(By.xpath("//input[@name='subjectbox']"));
	public static Target FIELD_NOTE = Target.the("field note").located(By.xpath("//div[@class='Am Al editable LW-avf']"));
	public static Target SEND = Target.the("send email").located(By.xpath("//div[text()='Enviar']"));
	public static Target EMAILS_SEND = Target.the("email send").located(By.xpath("//a[@title='Enviados' and text()='Enviados']"));
	public static Target ITEMS_EMAIL_SEND = Target.the("item emails send").located(By.xpath("//div[@class='yW' and text()='Para: ']"));
}
