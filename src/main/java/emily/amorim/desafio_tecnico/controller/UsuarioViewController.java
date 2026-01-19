package emily.amorim.desafio_tecnico.controller;

import emily.amorim.desafio_tecnico.entity.Usuario;
import emily.amorim.desafio_tecnico.repository.UsuarioRepository;
import emily.amorim.desafio_tecnico.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioViewController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/cadastro")
    public String cadastroUsuario(Usuario usuario){
        return "usuario/create";
    }

    @PostMapping("/enviar")
    public String enviaForm(Usuario usuario){
        service.create(usuario);
        return "redirect:/usuario/listar";
    }

    @GetMapping("/listar")
    public String listaUsuario(org.springframework.ui.Model model){
        model.addAttribute("usuarios", service.getAll());
        return "usuario/list";
    }

}
