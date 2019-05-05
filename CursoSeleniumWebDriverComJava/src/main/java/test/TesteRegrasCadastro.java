package test;
import static core.DriverFactory.getDriver;

import java.util.Arrays;
import java.util.Collection;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import core.BaseTest;
import core.DSL;
import page.CampoTreinamentoPage;

//@RunWith(Parameterized.class)
public class TesteRegrasCadastro extends BaseTest{
	private DSL dsl;
	private CampoTreinamentoPage page;
/*
	@Parameter
	public String nome;
	@Parameter(value = 1)P
	public String sobrenome;
	@Parameter(value = 2)
	public String sexo;
	@Parameter(value = 3)
	public List<String> comidas;
	@Parameter(value = 4)
	public String[] esportes;
	@Parameter(value = 5)
	public String msg;
*/
	@BeforeClass
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
		page = new CampoTreinamentoPage();
	}

	@Parameters
	public static Collection<Object[]> getCollection() {
		return Arrays.asList(new Object[][] { { "", "", "", Arrays.asList(), new String[] {}, "Nome eh obrigatorio" },
				{ "Wagner", "", "", Arrays.asList(), new String[] {}, "Sobrenome eh obrigatorio" },
				{ "Wagner", "Costa", "", Arrays.asList(), new String[] {}, "Sexo eh obrigatorio" },
				{ "Wagner", "Costa", "Masculino", Arrays.asList("Carne", "Vegetariano"), new String[] {},
						"Tem certeza que voce eh vegetariano?" },
				{ "Wagner", "Costa", "Masculino", Arrays.asList("Carne"),
						new String[] { "Karate", "O que eh esporte?" }, "Voce faz esporte ou nao?" } });
	}

	/*@Test
	public void deveValidarRegras() {
		page.setNome(nome);
		page.setSobrenome(sobrenome);
		if (sexo.equals("Masculino")) {
			page.setSexoMasculino();
		}
		if (sexo.equals("Feminino")) {
			page.setSexoFeminino();
		}
		if (comidas.contains("Carne"))
			page.setComidaFavCarne();
		if (comidas.contains("Frango"))
			page.setComidaFavFrango();
		if (comidas.contains("Pizza"))
			page.setComidaFavPizza();
		if (comidas.contains("Vegetariano"))
			page.setComidaFavVegetariano();

		page.setEsportes(esportes);
		page.cadastrar();
		Assert.assertEquals(msg, dsl.alertaObterTextoEAceita());
	}*/
}
