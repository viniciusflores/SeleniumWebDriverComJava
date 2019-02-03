package Pages;

import Core.BasePage;

public class MenuPage extends BasePage{
	public void acessarTelaInserirConta(){
		clicarLink("Contas");
		clicarLink("Adicionar");
	}
	
	public void acessarTelaListarConta(){
		clicarLink("Contas");
		clicarLink("Listar");
	}
	
	public void acessarTelaInserirMovimentacao(){
		clicarLink("Criar Movimenta��o");
	}
	
	public void acessarTelaResumo(){
		clicarLink("Resumo Mensal");
	}
	
	public void acessarTelaPrincipal(){
		clicarLink("Home");
	}
}
