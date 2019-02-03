package Pages;

import org.openqa.selenium.By;

import Core.BasePage;
import Core.DriverFactory;

public class LoginPage extends BasePage{

	public void acessarTelaInicial() {
		DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/login");
	}

	public void setEmail(String email) {
		escrever("email", email);
	}
	
	
	public void setSenha(String senha) {
		escrever("senha", senha);
	}
	
	public void entrar() {
		clicarBotao(By.xpath("//button[contains(.,'Entrar')]"));
	}

	public void logarNoSistema(String email, String senha) {
		setEmail(email);
		setSenha(senha);
		entrar();
	}
	
}
