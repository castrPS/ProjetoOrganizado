package classesbasicas;
import exceptions.*;

public abstract class QuartoAbstrato {
	//O numero do quarto servirá como identificador do mesmo
	private String numero;
	private Cliente hospede;
	private double valorDiaria;
	private double total;
	private boolean limpo;
	
	public QuartoAbstrato(String numero, double valorDiaria) {
		this.numero = numero;
		this.valorDiaria = valorDiaria;
		this.hospede = null;
		this.total = 0;
		this.limpo = true;
	}
	
	public abstract void pedido(double valor);
	
	public void checkin(Cliente cliente, int dias) throws QuartoOcupadoException {
		if (this.hospede == null) {
			this.hospede = cliente;
			this.total = this.valorDiaria*dias;
		} else {
			throw new QuartoOcupadoException(this.numero, this.hospede);
		}
	}
	
	public double checkout() throws QuartoVazioException {
		if (this.hospede != null) {
			this.hospede = null;
			double total = this.total;
			this.total = 0;
			return total;
		} else {
			throw new QuartoVazioException(this.numero);
		}
	}
	
	public void limpar() throws QuartoLimpoException {
		if (!limpo) {
			limpo = true;
		} else {
			throw new QuartoLimpoException(this.numero);
		}
	}
	
	public Cliente getCliente() throws QuartoVazioException {
		if (this.hospede != null) {
			return this.hospede;
		} else {
			throw new QuartoVazioException(this.numero);
		}
	}
	public String getNumero() {
		return numero;
	}
	public double getDiaria() {
		return valorDiaria;
	}
	protected void setTotal(double total) {
		this.total = total;
	}
	public double getTotal() {
		return total;
	}
	public boolean getLimpo() {
		return limpo;
	}
	
}
