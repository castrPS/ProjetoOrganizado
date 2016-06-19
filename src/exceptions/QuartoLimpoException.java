package exceptions;

public class QuartoLimpoException extends Exception {
	private String numero;
	public QuartoLimpoException(String numero) {
		super("Quarto j� est� limpo.");
		this.numero = numero;
	}
	public String getNumero() {
		return numero;
	}
}
