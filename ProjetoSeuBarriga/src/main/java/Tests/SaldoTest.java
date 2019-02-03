package Tests;

import org.junit.Assert;
import org.junit.Test;

import Core.BaseTest;
import Pages.HomePage;

public class SaldoTest extends BaseTest {
	HomePage page = new HomePage();

	@Test
	public void testSaldoConta(){
		Assert.assertEquals("123.00", page.obterSaldoConta("Conta 1"));
	}
}
