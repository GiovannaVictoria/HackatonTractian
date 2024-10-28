package br.ufscar.dc.tractian.Renato.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufscar.dc.tractian.Renato.domain.Funcionario;
import br.ufscar.dc.tractian.Renato.service.IFuncionarioService;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioControllerREST {

    @Autowired
    private IFuncionarioService service;

    // GET: Buscar todos os funcionários que possuem uma habilidade específica
    @GetMapping("/habilidade/{habilidadeId}")
    public ResponseEntity<List<Funcionario>> getFuncionariosByHabilidade(
            @PathVariable("habilidadeId") Integer habilidadeId) {

    	Boolean funcionarioApto;
        List<Funcionario> funcionarios = service.buscarTodos();
        List<Funcionario> funcionariosAptos = new ArrayList<>();
        List<Integer> habilidadesNecessarias = new ArrayList<>();
        List<Integer> habilidadesFuncionario = new ArrayList<>();
        
        if (funcionarios.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content se não houver resultado
        }
        
        habilidadesNecessarias = extrairDigitos(habilidadeId);
        for (Funcionario f : funcionarios) {
        	funcionarioApto = true;
        	habilidadesFuncionario = extrairDigitos(f.getHabilidade());
        	for (int i = 0; i < habilidadesNecessarias.size() && funcionarioApto; i++) {
        		if (!habilidadesFuncionario.contains(habilidadesNecessarias.get(i))) {
        			funcionarioApto = false;
        		}
        	}
        	if (funcionarioApto) {
        		funcionariosAptos.add(f);
        	}
        	habilidadesFuncionario.clear();
        }
        
        return ResponseEntity.ok(funcionariosAptos); // 200 OK com a lista de funcionários
    }
    
    public List<Integer> extrairDigitos(Integer numero) {
    	List<Integer> digitos = new ArrayList<>();
        while (numero > 0) {
        	int digito = numero % 10;
        	digitos.add(digito);
        	numero /= 10;
        }
        return digitos;
    }
}