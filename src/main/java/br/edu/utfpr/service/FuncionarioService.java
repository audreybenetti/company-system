package br.edu.utfpr.service;

import br.edu.utfpr.entity.Funcionario;
import br.edu.utfpr.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public void salvar (Funcionario funcionario){
        repository.save(funcionario);
    }

    public List<Funcionario> findAll(){
        return repository.findAll();
    }

    public Long countFuncionarios(){
        return repository.count();
    }

    public List<Funcionario> getAllFuncionariosAndCargos(){
        return repository.getAllFuncionariosAndCargos();
    }

    public List<String> findAllByNomeAsc(){
        return repository.findAllOrderByNomeAsc();
    }

    public void deleteById(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
        } else {
            System.err.println("Funcionário não encontrado.");
        }
    }
}
