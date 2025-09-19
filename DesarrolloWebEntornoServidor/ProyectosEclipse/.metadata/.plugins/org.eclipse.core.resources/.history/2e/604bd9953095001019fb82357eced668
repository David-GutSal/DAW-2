package p01.entities;

public class Cuenta {
	private double saldo; // Saldo actual
	private int numeroCuenta; // Numero de cuenta

	public Cuenta(int a, double saldo) {
		saldo = 0.0;
		numeroCuenta = a;
	}

	public void ingresarDinero(double sum) {
		if (sum > 0)
			saldo += sum;
		else
			System.err.println("No se puede ingresar una cantidad negativa");
	}

	public void sacarDinero(double sum) {
		if (sum > 0)
			saldo -= sum;
		else
			System.err.println("Cuenta.sacarDinero(...): " + "no se puede sacar una suma negativa");
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public double getCuentaNumber() {
		return numeroCuenta;
	}

	public String toString() {
		return "Numero de cuenta " + numeroCuenta + ": " + "saldo = " + saldo;
	}
}
