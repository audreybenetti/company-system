package br.edu.utfpr.repository;

import br.edu.utfpr.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
    //Query na interface FuncionarioRepository:
    @Query(value = "SELECT c.cargo, STRING_AGG(f.nome, ', ') AS Funcionarios FROM Cargos c JOIN Funcionarios f ON f.cargo_id = c.id GROUP BY c.cargo",
            nativeQuery = true)
    List<Map<Cargo,String>> getCargosAndFuncionarios();
}
