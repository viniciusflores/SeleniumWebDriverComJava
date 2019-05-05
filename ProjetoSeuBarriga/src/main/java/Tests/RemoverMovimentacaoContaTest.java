package Tests;

import static Core.Propiedades.NOME_CONTA_ALTERADA;

import org.testng.Assert;
import org.testng.annotations.Test;

import Core.BaseTest;
import Pages.ContasPage;
import Pages.MenuPage;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RemoverMovimentacaoContaTest extends BaseTest {
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void test7_ExcluirContaComMovimentacao(){
		menuPage.acessarTelaListarConta();
		contasPage.clicarExcluirConta(NOME_CONTA_ALTERADA);	
		
		Assert.assertEquals("Conta em uso na movimenta��es", contasPage.obterMensagemErro());
	}
}
