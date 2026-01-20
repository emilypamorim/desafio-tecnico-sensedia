package emily.amorim.desafio_tecnico.service;

import emily.amorim.desafio_tecnico.entity.Usuario;
import emily.amorim.desafio_tecnico.repository.UsuarioRepository;
import emily.amorim.desafio_tecnico.service.exception.EntityNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;
    public Usuario create (Usuario obj){
        if(!obj.isConcordaCadastro()){
        throw new EntityNotFound("É necesárrio concordar com o cadastro para proseguir.");
        }
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Usuario getId(Long id){
        Optional <Usuario> obj = repository.findById(id);
        if(obj.isEmpty()){
            throw new EntityNotFound("Usuario de id "+id+" não encontrado");
        }
        return obj.get();
    }

    public List<Usuario> getAll(){
        return repository.findAll();
    }

    public Usuario update (Usuario obj){
        Optional <Usuario> newObj = repository.findById(obj.getId());
        updateUsuario(newObj, obj);
        return repository.save(newObj.get());
    }

    private void updateUsuario(Optional<Usuario> newObj, Usuario obj) {
        newObj.get().setNome(obj.getNome());
        newObj.get().setTelefone(obj.getTelefone());
        newObj.get().setDataNascimento(obj.getDataNascimento());



    }

}
