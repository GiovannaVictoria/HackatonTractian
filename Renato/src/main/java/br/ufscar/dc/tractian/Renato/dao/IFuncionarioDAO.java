package br.ufscar.dc.tractian.Renato.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.tractian.Renato.domain.Funcionario;

public interface IFuncionarioDAO extends CrudRepository<Funcionario, Integer> {

    // 1. Buscar funcionário por ID
    Optional<Funcionario> findById(Integer id);

    // 2. Buscar funcionários que possuem uma habilidade específica
    List<Funcionario> findByHabilidade(Integer habilidade);

    // 3. Buscar todos os funcionários
    List<Funcionario> findAll();

    // 4. Salvar ou atualizar um funcionário
    <S extends Funcionario> S save(S funcionario);
}
