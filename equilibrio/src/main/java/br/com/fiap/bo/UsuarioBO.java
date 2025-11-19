package br.com.fiap.bo;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.model.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class UsuarioBO {

    @Inject
    UsuarioDAO dao;

    public List<Usuario> listar() {
        return dao.listAll();
    }

    public Usuario buscar(Long id) {
        return dao.findById(id);
    }

    @Transactional
    public Usuario salvarOuAtualizar(Usuario u) {
        if (u.getIdUsuario() == null) {
            dao.persist(u); // novo usuário
        } else {
            dao.getEntityManager().merge(u); // atualizar usuário existente
        }
        return u;
    }

    @Transactional
    public boolean deletar(Long id) {
        return dao.deleteById(id);
    }
}
