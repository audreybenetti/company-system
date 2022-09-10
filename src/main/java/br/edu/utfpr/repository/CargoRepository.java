package br.edu.utfpr.repository;

import br.edu.utfpr.entity.Cargo;
import br.edu.utfpr.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
//    @Query(value = "SELECT c.cargo, STRING_AGG(f.nome, ', ') FROM Cargos c JOIN Funcionarios f GROUP BY c.cargo", nativeQuery = true)
//    Map<Cargo, String> findAllWithFuncionarios();
}
