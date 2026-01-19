package emily.amorim.desafio_tecnico.service;

import emily.amorim.desafio_tecnico.entity.Projeto;
import emily.amorim.desafio_tecnico.entity.Usuario;
import emily.amorim.desafio_tecnico.repository.ProjetoRepository;
import emily.amorim.desafio_tecnico.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Projeto create (Projeto obj){
        if (obj.getUsuario() != null && obj.getUsuario().getId() != null) {
            Usuario usuario = usuarioRepository.findById(obj.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            obj.setUsuario(usuario);
        }
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Projeto getId(Long id){
        Optional <Projeto> obj = repository.findById(id);
        return obj.get();
    }

    public List<Projeto> getAll(){
        return repository.findAll();
    }

    public Projeto update (Projeto obj){
        Optional <Projeto> newObj = repository.findById(obj.getId());
        updateProjeto(newObj, obj);
        return repository.save(newObj.get());
    }

    private void updateProjeto(Optional<Projeto> newObj, Projeto obj) {
        newObj.get().setNome(obj.getNome());
        newObj.get().setDataInicio(obj.getDataInicio());
        newObj.get().setDataFim(obj.getDataFim());
        newObj.get().setUsuario(obj.getUsuario());



    }

}
