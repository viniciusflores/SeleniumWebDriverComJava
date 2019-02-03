package Core;

public class Propiedades {
	// manter false para não fechar o navegador a cada test
	public static boolean FECHAR_BROWSER = false;
	
	public static Browsers browser = Browsers.CHROME;
	
	public static String NOME_CONTA_ALTERADA = "Conta Alterada " + System.nanoTime();
	
	public enum Browsers {
		CHROME,
		FIREFOX
	}
}
