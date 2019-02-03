package Core;

public class Propiedades {
	// manter false para fechar o navegador a cada test
	public static boolean FECHAR_BROWSER = true;
	
	public static Browsers browser = Browsers.CHROME;
	
	public enum Browsers {
		CHROME,
		FIREFOX
	}
}
