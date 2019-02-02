package test;
import static core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import core.BaseTest;
import page.CampoTreinamentoPage;

public class TesteCadastroComSucesso extends BaseTest{
	
	private CampoTreinamentoPage page;

	@Before
	public void inicializa(){
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}
	
	@Test
	public void deveRealizarCadastroComSucesso(){
		page.setNome("Wagner");
		page.setSobrenome("Costa");
		page.setSexoMasculino();
		page.setComidaFavPizza();
		page.setEscolaridade("Mestrado");
		page.setEsportes("Natacao");
		page.cadastrar();
		
		Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
		Assert.assertEquals("Wagner", page.obterResultadoNome());
		Assert.assertEquals("Costa", page.obterResultadoSobrenome());
		Assert.assertEquals("Masculino", page.obterResultadoSexo());
		Assert.assertEquals("Pizza", page.obterResultadoComida());
		Assert.assertEquals("mestrado", page.obterResultadoEscolaridade());
		Assert.assertEquals("Natacao", page.obterResultadoEsportes());
	}
	
}
