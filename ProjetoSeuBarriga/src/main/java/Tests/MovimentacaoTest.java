package Tests;

import static Core.Propiedades.NOME_CONTA_ALTERADA;
import static Utils.DataUtils.obterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import Core.BaseTest;
import Pages.MenuPage;
import Pages.MovimentacaoPage;
import Utils.DataUtils;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();

	@Test
	public void test4_InserirMovimentacao(){
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movPage.setDataPagamento(obterDataFormatada(new Date()));
		movPage.setDescricao("Movimentação do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta(NOME_CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
	}
	
	@Test
	public void test5_CamposObrigatorios(){
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.salvar();
		List<String> erros = movPage.obterErros();
//		Assert.assertEquals("Data da Movimenta��o � obrigat�rio", erros.get(0));
//		Assert.assertTrue(erros.contains("Data da Movimenta��o � obrigat�rio"));
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório", "Data do pagamento é obrigatório",
				"Descrição é obrigatório", "Interessado é obrigatório", 
				"Valor é obrigatório", "Valor deve ser um número")));
		Assert.assertEquals(6, erros.size());
	}
	
	@Test
	public void test6_InserirMovimentacaoFutura(){
		menuPage.acessarTelaInserirMovimentacao();
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		
		movPage.setDataMovimentacao(obterDataFormatada(dataFutura));
		movPage.setDataPagamento(obterDataFormatada(dataFutura));
		movPage.setDescricao("Movimentação do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta(NOME_CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();
		
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(
				erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
		Assert.assertEquals(1, erros.size());
	}
}
