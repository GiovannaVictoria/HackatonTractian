package br.ufscar.dc.tractian.Renato.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "habilidade")
    private Integer habilidade;

    @Column(name = "ultimo_turno_indesejado")
    private String ultimoTurnoIndesejado;

    // Construtor padrão
    public Funcionario() {
    }

    // Construtor com argumentos
    public Funcionario(String nome, Integer habilidade, String ultimoTurnoIndesejado) {
        this.nome = nome;
        this.habilidade = habilidade;
        this.ultimoTurnoIndesejado = ultimoTurnoIndesejado;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(Integer habilidade) {
        this.habilidade = habilidade;
    }

    public String getUltimoTurnoIndesejado() {
        return ultimoTurnoIndesejado;
    }

    public void setUltimoTurnoIndesejado(String ultimoTurnoIndesejado) {
        this.ultimoTurnoIndesejado = ultimoTurnoIndesejado;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", habilidade=" + habilidade +
                ", ultimoTurnoIndesejado=" + ultimoTurnoIndesejado +
                '}';
    }
}