package br.edu.utfpr;

import br.edu.utfpr.entity.Cargo;
import br.edu.utfpr.entity.Funcionario;
import br.edu.utfpr.service.CargoService;
import br.edu.utfpr.service.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@SpringBootApplication
public class CompanyApplication {
    private static final Logger log = LoggerFactory.getLogger(CompanyApplication.class);
    public static void main( String[] args ){
        SpringApplication.run(CompanyApplication.class, args);
    }

    @Bean
    public CommandLineRunner logging (FuncionarioService funcionarioService, CargoService cargoService) {
        return args -> {
            Cargo c1 = new Cargo("Desenvolvedor Back-end");
            Cargo c2 = new Cargo("Arquiteto de Software");
            Cargo c3 = new Cargo("Engenheiro de Dados");

            Funcionario f1 = new Funcionario("Audrey Sestari", "Feminino", 44999123456L);
            f1.setCargo(c1);

            Funcionario f2 = new Funcionario("Joana Almeida", "Feminino", 44987146126L);
            f2.setCargo(c1);

            Funcionario f3 = new Funcionario("Pedro Albuquerque", "Masculino", 44986541301L);
            f3.setCargo(c2);

            Funcionario f4 = new Funcionario("Mariana Pereira", "Feminino", 44979165421L);
            f4.setCargo(c3);

            cargoService.salvar(c1);
            cargoService.salvar(c2);
            cargoService.salvar(c3);
            funcionarioService.salvar(f1);
            funcionarioService.salvar(f2);
            funcionarioService.salvar(f3);
            funcionarioService.salvar(f4);

            cargoService.deleteById(2L);
            funcionarioService.deleteById(2L);

            log.info("Listar funcionários com os seus respectivos cargos utilizando @Query:");
            funcionarioService.getAllFuncionariosAndCargos().forEach(funcionario -> log.info(String.valueOf(funcionario)));

            log.info("Listar o nome dos funcionários em ordem alfabética: ");
            funcionarioService.findAllByNomeAsc().forEach(log::info);

            log.info("Número de funcionários cadastrados: " + funcionarioService.countFuncionarios());

            log.info("Listar todos os cargos com seus respectivos funcionários: ");
            cargoService.getCargosAndFuncionarios().stream()
                    .map(Map::entrySet)
                    .forEach(c -> log.info(String.valueOf(c)));

        };
    }
}
