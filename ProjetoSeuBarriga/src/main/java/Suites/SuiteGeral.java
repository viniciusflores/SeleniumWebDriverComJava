/*package Suites;

import static Core.DriverFactory.killDriver;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import Core.DriverFactory;
import Pages.LoginPage;
import Tests.ContaTest;
import Tests.MovimentacaoTest;
import Tests.RemoverMovimenta��oContaTest;
import Tests.ResumoTest;
import Tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimenta��oContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})
public class SuiteGeral {
	private static LoginPage page = new LoginPage();

	@BeforeClass
	public static void inicializa() {
		page.acessarTelaInicial();
		page.logarNoSistema("testeselenium@udemy.com", "helloworld");
	}
	
	@BeforeClass
	public static void finalizaSuite() {
		killDriver();
	}
}
*/