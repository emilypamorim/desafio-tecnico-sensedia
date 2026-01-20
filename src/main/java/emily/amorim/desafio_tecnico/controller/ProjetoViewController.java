package emily.amorim.desafio_tecnico.controller;

import emily.amorim.desafio_tecnico.entity.Projeto;
import emily.amorim.desafio_tecnico.service.ProjetoService;
import emily.amorim.desafio_tecnico.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ProjetoViewController {

    @Autowired
    private ProjetoService service;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/projeto/cadastro")
    public String cadastroProjeto(org.springframework.ui.Model model){
        if(usuarioService.getAll().isEmpty()){
            return "redirect:usuario/cadastro";
        }
        model.addAttribute("projeto", new Projeto());
        model.addAttribute("usuarios", usuarioService.getAll());
        return "projeto/create";
    }

    @PostMapping("/projeto/enviar")
    public String enviaForm(Projeto Projeto){
        service.create(Projeto);
        return "redirect:/projeto/listar";
    }

    @GetMapping("/projeto/listar")
    public String listaProjeto(org.springframework.ui.Model model){
        model.addAttribute("projetos", service.getAll());
        return "projeto/list";
    }

    @GetMapping
    public String index(org.springframework.ui.Model model){
        model.addAttribute("projetos", service.getAll());
        return "projeto/list";
    }

    @GetMapping("/projeto/excluir/{id}")
    public String excluirProjeto(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/projeto/listar";
    }


}
