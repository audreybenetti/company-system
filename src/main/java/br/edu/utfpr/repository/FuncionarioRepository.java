package br.edu.utfpr.repository;

import br.edu.utfpr.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findAll();

    @Query(value = "SELECT f.nome FROM Funcionario f ORDER BY f.nome ASC")
    List<String> findAllOrderByNomeAsc();

    @Query(value = "SELECT f.*, c.cargo FROM Funcionarios f JOIN Cargos c ON c.id = f.cargo_id", nativeQuery = true)
    List<Funcionario> getAllFuncionariosAndCargos();

}
