package br.edu.utfpr.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cargos")
public class Cargo extends AbstractPersistable<Long> {
    @Column(name = "Cargo", length = 64, nullable = false)
    private String cargo;

    @OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios;

    public Cargo(){

    }

    public Cargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Cargo{" + cargo + '\'' +
                '}';
    }
}
