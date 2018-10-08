package core.questions;

import java.util.ArrayList;
import java.util.List;

import core.ui.WriteEmailPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;

public class VerifyEmailSend implements Question<List<String>>{

	public List<String> list;
	
	@Step("Check if the emails were sent")
	public List<String> answeredBy(Actor actor) {
	
		List<String> aux = Text.of(WriteEmailPage.ITEMS_EMAIL_SEND)                  
	            .viewedBy(actor)                        
	            .asList().subList(0, 2);
		
		List<String> listEnd = new ArrayList<>();
		
		for(int i = 0; i < aux.size() ; i++) {
			listEnd.add(aux.get(i).substring(0, aux.get(i).length() - 4));
		}
		
		list = listEnd;
		return listEnd;
	}

	public static VerifyEmailSend verified() {
		return new VerifyEmailSend();
	}
	
}
