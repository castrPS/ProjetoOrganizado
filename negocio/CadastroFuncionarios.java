package negocio;
import classesbasicas.Funcionario;
import dados.RepositorioFuncionarios;
import exceptions.*;

public class CadastroFuncionarios {
	private RepositorioFuncionarios repositorio;
	
	public CadastroFuncionarios(RepositorioFuncionarios repositorio){
		this.repositorio = repositorio;
	}
	
	public void cadastrar(Funcionario funcionario) throws FuncionarioJaCadastradoException{
		if (!repositorio.existe(funcionario.getCPF())) {
			repositorio.inserir(funcionario);
		} else {
			throw new FuncionarioJaCadastradoException();
		}
	}

}
