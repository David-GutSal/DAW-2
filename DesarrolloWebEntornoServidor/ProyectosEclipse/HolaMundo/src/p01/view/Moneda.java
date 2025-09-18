package p01.view;

import p01.utils.TerminalUtils;

public class Moneda {
	public static void lanzarMoneda() {
		int cara = 0;
		int cruz = 0;
		for(int i = 0; i< 1000000; i++) {
			int moneda = (int) (Math.random()*2+1);
			if(moneda == 1) {
				cara++;
			}else {
				cruz++;
			}
		}
		TerminalUtils.output("Cara: " + cara + " | " + "Cruz: " + cruz );
	}
}
