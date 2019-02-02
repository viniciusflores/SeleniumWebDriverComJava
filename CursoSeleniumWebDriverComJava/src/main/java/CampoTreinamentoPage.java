import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.DSL;

public class CampoTreinamentoPage {
	private DSL dsl;
	
	public CampoTreinamentoPage(){
		dsl = new DSL();
	}

	public void setNome(String nome) {
		dsl.escrever("elementosForm:nome", nome);
	}

	public void setSobrenome(String sobrenome) {
		dsl.escrever("elementosForm:sobrenome", sobrenome);
	}
	
	public void setSexoMasculino() {
		dsl.clicarRadio("elementosForm:sexo:0");
	}
	
	public void setSexoFeminino() {
		dsl.clicarRadio("elementosForm:sexo:1");
	}
	
	public void setComidaFavCarne() {
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
	}
	public void setComidaFavFrango() {
		dsl.clicarRadio("elementosForm:comidaFavorita:1");
	}
	public void setComidaFavPizza() {
		dsl.clicarRadio("elementosForm:comidaFavorita:2");
	}
	public void setComidaFavVegetariano() {
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
	}
	
	public void setEscolaridade(String escolaridade) {
		dsl.selecionarCombo("elementosForm:escolaridade", escolaridade);
	}
	
	public void setEsportes(String... valores) {
		for (String valor: valores)
			dsl.selecionarCombo("elementosForm:esportes", valor);
	}
	
	public void cadastrar() {
		dsl.clicarBotao("elementosForm:cadastrar");
	}
	
	public String obterResultadoCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='resultado']/span"));
	}
	
	public String obterResultadoNome() {
		return dsl.obterTexto(By.xpath("//*[@id='descNome']/span"));
	}
	
	public String obterResultadoSobrenome() {
		return dsl.obterTexto(By.xpath("//*[@id='descSobrenome']/span"));
	}
	
	public String obterResultadoSexo() {
		return dsl.obterTexto(By.xpath("//*[@id='descSexo']/span"));
	}
	
	public String obterResultadoComida() {
		return dsl.obterTexto(By.xpath("//*[@id='descComida']/span"));
	}
	
	public String obterResultadoEscolaridade() {
		return dsl.obterTexto(By.xpath("//*[@id='descEscolaridade']/span"));
	}
	
	public String obterResultadoEsportes() {
		return dsl.obterTexto(By.xpath("//*[@id='descEsportes']/span"));
	}

	
}
