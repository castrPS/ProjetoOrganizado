package negocio;

import classesbasicas.*;
import dados.*;
import exceptions.*;

public class Hotel {
	private CadastroQuartos cadQuartos;
	//private CadastroProdutos cadProdutos;
	private CadastroClientes cadClientes;
	private CadastroFuncionarios cadFuncionarios;
	
	public Hotel(RepositorioQuartos rep) {
		cadQuartos = new CadastroQuartos((RepositorioQuartos)rep);
		//cadProdutos = new CadastroProdutos(rep);
		cadClientes = new CadastroClientes((RepositorioClientes) rep);
		cadFuncionarios = new CadastroFuncionarios((RepositorioFuncionarios) rep);
	}
	
	public void cadastrarQuarto(QuartoAbstrato quarto) throws QuartoJaCadastradoException {
		cadQuartos.cadastrar(quarto);
	}
	public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaCadastradoException {
		cadFuncionarios.cadastrar(funcionario);
	}
	public void cadastrarCliente(Cliente cliente) throws ClienteJaCadastradoException{
		cadClientes.cadastrarCliente(cliente);
	}
}
