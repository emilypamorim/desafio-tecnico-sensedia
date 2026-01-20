package emily.amorim.desafio_tecnico.controller;

import emily.amorim.desafio_tecnico.entity.Projeto;
import emily.amorim.desafio_tecnico.service.ProjetoService;
import emily.amorim.desafio_tecnico.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("projeto")
public class ProjetoViewController {

    @Autowired
    private ProjetoService service;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/cadastro")
    public String cadastroProjeto(org.springframework.ui.Model model){
        model.addAttribute("projeto", new Projeto());
        model.addAttribute("usuarios", usuarioService.getAll());
        return "projeto/create";
    }

    @PostMapping("/enviar")
    public String enviaForm(Projeto Projeto){
        service.create(Projeto);
        return "redirect:/projeto/listar";
    }

    @GetMapping("/listar")
    public String listaProjeto(org.springframework.ui.Model model){
        model.addAttribute("Projetos", service.getAll());
        return "projeto/list";
    }

}
