package dados;

import classesbasicas.Cliente;
import classesbasicas.Produto;
import exceptions.*;

public class RepositorioClientesLista implements RepositorioClientes {
	// atributos
	private Cliente cliente;
	private RepositorioClientesLista next;

	// construtor
	public RepositorioClientesLista() {
		this.cliente = null;
		this.next = null;
	}

	public void inserirCliente(Cliente cliente) {
		if (this.cliente == null) { // caso n�o haja um cliente naquela posicao,
									// o novo cliente eh inserido la
			this.cliente = cliente;
			this.next = new RepositorioClientesLista();
		} else {
			this.next.inserirCliente(cliente); // caso haja, chama o metodo recursivo
										// no proximo item da lsita
		}
	}

	public void removerCliente(String CPF){ //metodo recursivo de remocao
		if(this.cliente !=null){
			if(this.cliente.getCPF().equals(CPF)){ //quando encontro o cpf igual, faco a substituicao
				this.cliente = this.next.cliente; //faco o ponteiro desse cliente apontar para o proximo
				this.next = this.next.next; //e assim sucessivamente
			}
			else{
				this.next.removerCliente(CPF); //se n�o encontro, chamo o metodo recursivamente
			}
		}
			
	}

	public Cliente procurarCliente(String CPF) {
		Cliente encontrado = null;
		if(this.cliente!=null || encontrado != null) {	
			if (this.cliente.getCPF().equals(CPF)) { //quando encontra um cliente com o CPF igual ao procurado
				encontrado = this.cliente;	
			}
			else{ //se nao for encontrado, chama o metodo recursivamente com o proximo elemento
				encontrado = this.next.procurarCliente(CPF);
			}	
		}
		return encontrado; //retorna o objeto encontrado
	}

	public void atualizarCliente(Cliente clienteAtualizado) {
		boolean achou = false;
		while (!achou || this.cliente != null) {
			if (this.cliente.getCPF().equals(clienteAtualizado.getCPF())) {
				this.cliente = clienteAtualizado;
				achou = true;
			}
			this.cliente = this.next.cliente;
		}
		
	}
	
	public boolean existeCliente(String CPF){
		boolean existe = false;
		while(this.cliente != null){
			if(this.cliente.getCPF().equals(CPF)){
				existe = true;
				return existe;
			}
			this.cliente = this.next.cliente;
		}
		return existe;
	}
	
	public void zerarGastosCliente(String CPF) {
		if(this.cliente!=null){
			if(this.cliente.getCPF().equals(CPF)){	
				this.cliente.zerarGastosCliente();
			}
		}
	}
	
	public void checkoutCliente(String CPF){
		boolean achou = false;
		while(this.cliente != null){
			if(this.cliente.getCPF().equals(CPF)){
				this.cliente.zerarGastosCliente();
				achou = true;
			}
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public RepositorioClientesLista getNext() {
		return next;
	}

	public void setNext(RepositorioClientesLista next) {
		this.next = next;
	}

	

}
