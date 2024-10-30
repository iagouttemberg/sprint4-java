package br.com.fiap.sprint3.service;

import br.com.fiap.sprint3.datasource.UsuarioRepository;
import br.com.fiap.sprint3.model.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Usuario save(Usuario e){
        return this.repository.save( e );
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(final Usuario e){
        this.repository.delete( e );
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(final long id){
        this.repository.deleteById( id );
    }

    @Transactional(propagation = Propagation.NEVER)
    public Optional<Usuario> findById(final long id){
        return this.repository.findById( id );
    }

    @Transactional(propagation = Propagation.NEVER)
    public List<Usuario> findAllUsuarios(){
        return this.repository.findAll();
    }

}
