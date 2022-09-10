package br.edu.utfpr.service;

import br.edu.utfpr.entity.Cargo;
import br.edu.utfpr.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CargoService {

    @Autowired
    private CargoRepository repository;

    public void salvar(Cargo cargo){
        repository.save(cargo);
    }

    //Chamada da Query em FuncionarioService:
    public List<Map<Cargo,String>> getCargosAndFuncionarios(){
        return repository.getCargosAndFuncionarios();
    }

    public void deleteById(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
        } else {
            System.err.println("Cargo não encontrado.");
        }
    }
}
