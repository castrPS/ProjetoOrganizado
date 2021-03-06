package dados;
import classesbasicas.Funcionario;
import exceptions.*;

public class RepositorioFuncionariosArray implements RepositorioFuncionarios {
	private Funcionario[] funcionarios;
	private int indice;
	private int maximo;
	
	public RepositorioFuncionariosArray(){
		maximo = 10;
		funcionarios = new Funcionario[maximo];
		indice = 0;
	}
	
	public void inserir(Funcionario funcionario){
		if (indice >= maximo){ //se o indice for maior que a capacidade do array, tenho que aumentar o array
			Funcionario[] aux = new Funcionario[maximo+1]; // para isso, crio um novo array
			for(int i = 0; i < maximo; i++){
				aux[i] = funcionarios[i]; // insiro todos os funcionarios que ja existiam do array antigo no array novo
			}
			funcionarios = aux; 
			maximo = maximo++;
		}
		funcionarios[indice] = funcionario;
		indice++;
	}
	
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException{
		int i = this.getIndice(funcionario.getCPF());
		if (i == this.indice){
			//posicao indice nao tem funcionario armazenado, se i igual ao indice entao nao ha o funcionario procurado
			throw new FuncionarioNaoEncontradoException();
		} else {
			this.funcionarios[i] = funcionario;
		}
	}
	
	public void remover(String CPF) throws FuncionarioNaoEncontradoException{
		int i = this.getIndice(CPF);
		if (i == this.indice){
			//ja que nao tem nenhum funcionario na posicao indice do array
			throw new FuncionarioNaoEncontradoException();
		} else {
			this.indice = this.indice - 1;
			this.funcionarios[i] = this.funcionarios[this.indice];
			//coloco o ultimo funcionario na posicao que era do funcionario removido
			this.funcionarios[this.indice] = null;
		}
	}
	
	public int getIndice(String CPF){
		//encontrar indice onde esta o funcionario com esse CPF
		String n;
		boolean achou = false;
		int i = 0;
		while((!achou) && (i < this.indice)){
			n = funcionarios[i].getCPF();
			if (n.equals(CPF)){
				achou = true;
			} else {
				i = i + 1;
			}
		}
		// se nao existir retorna o indice (indica q n tem nenhum funcionario)
		return i;
	}
	
	public Funcionario procurar(String CPF) throws FuncionarioNaoEncontradoException{
		Funcionario encontrado = null;
		int i = this.getIndice(CPF);
		if (i == this.indice){
			throw new FuncionarioNaoEncontradoException();
		} else {
			encontrado = this.funcionarios[i];
		}
		return encontrado;
	}
	
	public boolean existe (String CPF){
		int i = this.getIndice(CPF);
		// se nao existir, a posicao retornada pelo getIndice eh o indice
		return (i != this.indice);
		//se for diferente entao existe e retorna true, se for igual entao nao existe esse funcionario
	}
}
