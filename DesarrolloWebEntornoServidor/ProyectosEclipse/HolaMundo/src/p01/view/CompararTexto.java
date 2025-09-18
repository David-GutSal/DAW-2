package p01.view;

import p01.utils.TerminalUtils;

public class CompararTexto {
	public static void compararTexto() {
		TerminalUtils.output("Escribe algo");
		String text1 = TerminalUtils.inputText();
		TerminalUtils.output("Escribe algo otra vez");
		String text2 = TerminalUtils.inputText();
		
		if(text1.equals(text2)) {
			TerminalUtils.output("¡¡Son iguales!!");
		}else {
			TerminalUtils.output("¡¡NO Son iguales!!");
		}
	}
}
