package Funtec.gerenciadorFuncionario.model.repositorio;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import Funtec.gerenciadorFuncionario.model.Funcionario;
import Funtec.gerenciadorFuncionario.model.FuncionarioSetor;


public interface IFuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    List<Funcionario> findBySetor(FuncionarioSetor funcionarioSetor);

}
