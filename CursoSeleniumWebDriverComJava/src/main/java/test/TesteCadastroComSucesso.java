package test;
import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import page.CampoTreinamentoPage;

public class TesteCadastroComSucesso {
	
	private CampoTreinamentoPage page;

	@Before
	public void inicializa(){
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}
	
	@After
	public void finaliza(){
		killDriver();
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
