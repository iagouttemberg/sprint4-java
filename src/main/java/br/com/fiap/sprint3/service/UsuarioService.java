package br.com.fiap.sprint3.service;

import br.com.fiap.sprint3.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario save(Usuario e);

    void delete(Usuario e);

    void deleteById(long id);

    List<Usuario> findAllUsuarios();

}
