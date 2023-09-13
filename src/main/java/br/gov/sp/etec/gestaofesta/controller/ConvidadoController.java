package br.gov.sp.etec.gestaofesta.controller;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.gov.sp.etec.gestaofesta.model.Convidado;
import br.gov.sp.etec.gestaofesta.repository.ConvidadoRepository;



@Controller
@RequestMapping("convidado")
public class ConvidadoController {
	
	@Autowired
	private ConvidadoRepository repo;
	
	@GetMapping("home")
	public String abrirTelaCadastro() {
		return "convidado";
	}
	
	@PostMapping("salvar")
	public ModelAndView salvarConvidado(Convidado convidado) {
					
		repo.save(convidado);	
		 
		List<Convidado> listaConvidados = repo.findAll();
		
		ModelAndView view = new ModelAndView("lista-convidado");
		
		view.addObject("convidados", listaConvidados);
		
		return view;
	}
	
	@GetMapping("lista-convidados")
	public ModelAndView listaConvidado() {
		List<Convidado> listaConvidados = repo.findAll();
		
		ModelAndView view = new ModelAndView("lista-convidado");
		
		view.addObject("convidados", listaConvidados);
		
		return view;
	}
	@GetMapping("excluir/{id}")
	public ModelAndView excluirConvidado(@PathVariable Long id) {
	    
		repo.deleteById(id);
	    
	    List<Convidado> listaConvidados = repo.findAll();
		
		ModelAndView view = new ModelAndView("lista-convidado");
		
		view.addObject("convidados", listaConvidados);
		
		return view;
	    
	}

}
