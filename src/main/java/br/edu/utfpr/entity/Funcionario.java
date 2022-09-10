package br.edu.utfpr.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.*;

@Entity
@Table(name = "Funcionarios")
public class Funcionario extends AbstractPersistable<Long> {
    @Column(name = "Nome", length = 64, nullable = false)
    private String nome;
    @Column(name = "Sexo", length = 32, nullable = false)
    private String sexo;
    @Column(name = "Telefone", length = 11, nullable = false)
    private Long telefone;

    @ManyToOne
    @JoinColumn(name = "cargo_id", nullable = false)
    private Cargo cargo;

    public Funcionario(){

    }

    public Funcionario(String nome, String sexo, Long telefone) {
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", telefone=" + telefone +
                ", cargo=" + cargo +
                '}';
    }
}
