/**
 * 
 */
package dados;
import classesbasicas.Funcionario;
import exceptions.*;

/**
 * @author lmmc2
 *
 */
public interface RepositorioFuncionarios {
	
	public void inserir (Funcionario funcionario);
	public void atualizar (Funcionario funcionario) throws FuncionarioNaoEncontradoException;
	public void remover (String CPF) throws FuncionarioNaoEncontradoException;
	public Funcionario procurar (String CPF) throws FuncionarioNaoEncontradoException;
	public boolean existe (String CPF);
	
}
