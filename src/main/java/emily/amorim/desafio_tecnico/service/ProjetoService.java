package emily.amorim.desafio_tecnico.service;

import emily.amorim.desafio_tecnico.entity.Projeto;
import emily.amorim.desafio_tecnico.entity.Usuario;
import emily.amorim.desafio_tecnico.repository.ProjetoRepository;
import emily.amorim.desafio_tecnico.repository.UsuarioRepository;
import emily.amorim.desafio_tecnico.service.exception.EntityNotFound;
import jakarta.transaction.Transactional;
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
                    .orElseThrow(() -> new EntityNotFound("Usuário não encontrado"));
            obj.setUsuario(usuario);
        }
        return repository.save(obj);
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

    public Projeto getId(Long id){
        Optional <Projeto> obj = repository.findById(id);
        if(obj.isEmpty()){
            throw new EntityNotFound("Projeto com id "+id+" não foi encontrado");
        }
        return obj.get();
    }

    public List<Projeto> getAll(){
        return repository.findAll();
    }

    public Projeto update (Projeto obj){
        Optional <Projeto> newObj = repository.findById(obj.getId());
        if(newObj.isEmpty()){
            throw new RuntimeException("Não foi possivel atualiar: projeto de "+obj.getId()+" não encontrado");
        }
        updateProjeto(newObj, obj);
        return repository.save(newObj.get());
    }

    private void updateProjeto(Optional<Projeto> newObj, Projeto obj) {
        if(newObj !=null) {
            newObj.get().setNome(obj.getNome());
            newObj.get().setDataInicio(obj.getDataInicio());
            newObj.get().setDataFim(obj.getDataFim());
            newObj.get().setUsuario(obj.getUsuario());
        }
    }

}
