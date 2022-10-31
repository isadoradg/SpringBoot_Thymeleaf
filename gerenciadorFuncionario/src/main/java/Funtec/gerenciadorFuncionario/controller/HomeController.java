package Funtec.gerenciadorFuncionario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Funtec.gerenciadorFuncionario.model.Funcionario;
import Funtec.gerenciadorFuncionario.model.FuncionarioSetor;
import Funtec.gerenciadorFuncionario.model.repositorio.IFuncionarioRepository;

@Controller
public class HomeController {
	
	@Autowired
	private IFuncionarioRepository funcionarioRepository;

	@GetMapping("/home")
    public String home(Model model) {
    	
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
	    	
        model.addAttribute("funcionarios", funcionarios);

        return "home";
    }
	
	@GetMapping
    public String setor(@RequestParam String setor, Model model) {
    	FuncionarioSetor funcionarioSetor = FuncionarioSetor.valueOf(setor.toUpperCase());
        List<Funcionario> funcionarios = funcionarioRepository.findBySetor(funcionarioSetor);
       
        model.addAttribute("funcionarios", funcionarios);
        return "home";
    }
	
	
	
	
}
