package Tests;

import static Core.Propiedades.NOME_CONTA_ALTERADA;

import org.testng.Assert;
import org.testng.annotations.Test;

import Core.BaseTest;
import Pages.HomePage;
import Pages.MenuPage;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaldoTest extends BaseTest {
	HomePage page = new HomePage();
	MenuPage menu = new MenuPage();
	
	@Test
	public void test8_SaldoConta(){
		menu.acessarTelaPrincipal();
		Assert.assertEquals("500.00", page.obterSaldoConta(NOME_CONTA_ALTERADA));
	}
}
