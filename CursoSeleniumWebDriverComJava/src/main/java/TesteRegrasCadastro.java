import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class TesteRegrasCadastro {
	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;

	@Parameter
	public String nome;
	@Parameter(value = 1)
	public String sobrenome;
	@Parameter(value = 2)
	public String sexo;
	@Parameter(value = 3)
	public List<String> comidas;
	@Parameter(value = 4)
	public String[] esportes;
	@Parameter(value = 5)
	public String msg;

	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);
	}

	@After
	public void finaliza() {
		driver.quit();
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

	@Test
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
	}
}
