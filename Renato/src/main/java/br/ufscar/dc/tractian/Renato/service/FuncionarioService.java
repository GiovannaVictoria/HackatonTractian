package br.ufscar.dc.tractian.Renato.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.ufscar.dc.tractian.Renato.dao.IFuncionarioDAO;
import br.ufscar.dc.tractian.Renato.domain.Funcionario;

public class FuncionarioService implements IFuncionarioService {
	
	@Autowired
	IFuncionarioDAO dao;
	
	public Optional<Funcionario> buscarPorId(Integer id) {
		return dao.findById(id);
	}
	
	public List<Funcionario> buscarPorHabilidade(Integer habilidade) {
		return dao.findByHabilidade(habilidade);
	}

	public List<Funcionario> buscarTodos() {
		return dao.findAll();
	}

	public void salvar(Funcionario funcionario) {
		dao.save(funcionario);
	}

}
