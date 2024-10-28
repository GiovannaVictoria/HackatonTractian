package br.ufscar.dc.tractian.Renato.service;

import java.util.List;
import java.util.Optional;

import br.ufscar.dc.tractian.Renato.domain.Funcionario;

public interface IFuncionarioService {
	
	public Optional<Funcionario> buscarPorId(Integer id);
	
	public List<Funcionario> buscarPorHabilidade(Integer habilidade);

	public List<Funcionario> buscarTodos();

	public void salvar(Funcionario funcionario);

}
