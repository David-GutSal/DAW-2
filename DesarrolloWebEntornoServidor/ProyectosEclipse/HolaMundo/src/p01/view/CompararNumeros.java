package p01.view;

public class CompararNumeros {
	
	public static void compNum() {
		int numero = (int) (Math.random() * 10 + 1);
		for(int i = 0;i<=20;i++){
		int numComp = (int) (Math.random() * 10 + 1);
		if (numero < numComp) {
			System.out.println("El primer numero " + numero + " es Menor que " + numComp);
		} else if (numero == numComp) {
			System.out.println("El primer numero " + numero + " es Igual " + numComp);
		} else {
			System.out.println("El primer numero " + numero + " es Mayor " + numComp);
		}
	}
	}
}

